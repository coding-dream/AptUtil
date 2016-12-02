package com.ruoxu.apt.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/**
 * Created by wangli on 16/12/2.
 */

public class AptProcessor extends AbstractProcessor{


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        return false;
    }
}
