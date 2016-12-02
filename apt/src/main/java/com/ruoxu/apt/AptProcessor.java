package com.ruoxu.apt;

import com.google.auto.service.AutoService;
import com.ruoxu.anotation.BindView;
import com.ruoxu.anotation.OnClick;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;


@AutoService(Processor.class)
public class AptProcessor extends AbstractProcessor {

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> sets = new HashSet<>();
        sets.add(OnClick.class.getCanonicalName());
        sets.add(BindView.class.getCanonicalName());
        return sets;
    }

    /**
     *
     * @param annotations
     * @param roundEnv
     * @return  process 函数返回值表示这组 annotations 是否被这个 Processor 接受，如果接受true, 后续的 processor 不会再对这个 Annotations 进行处理
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {


        // TODO: make code
        MethodSpec main = MethodSpec.methodBuilder("sayHello")
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addParameter(String.class, "str")

                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!" + annotations.toString())
                .build();
        TypeSpec helloWorld = TypeSpec.classBuilder("HelloApt")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(main)
                .build();
        JavaFile javaFile = JavaFile.builder("com.example.apt", helloWorld)
                .build();

        try {
            javaFile.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;
    }

}
