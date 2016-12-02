package com.ruoxu.apt;

import com.google.auto.service.AutoService;
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

/**
 * Created by wangli on 16/12/2.
 */

@AutoService(Processor.class)
public class AfterProcessor extends AbstractProcessor{

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> sets = new HashSet<>();
        sets.add(OnClick.class.getCanonicalName());
        return sets;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        // TODO: make code
        MethodSpec main = MethodSpec.methodBuilder("sayHello")
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addParameter(String.class, "str")

                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!"+annotations.toString())
                .build();
        TypeSpec helloWorld = TypeSpec.classBuilder("After")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(main)
                .build();
        JavaFile javaFile = JavaFile.builder("com.example.after", helloWorld)
                .build();

        try {
            javaFile.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
