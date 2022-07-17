package com.nourish1709.magic.annotation;

import com.nourish1709.magic.config.StringTrimmingConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(StringTrimmingConfiguration.class)
public @interface EnableStringTrimming {
}
