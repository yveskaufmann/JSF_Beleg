package de.htw_berlin.ai_bachelor.kbe.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CreationInfo {
	String author() default "Sascha + Yves";
	String description();
	String[] tags() default {};
	Class<?> superClass() default Object.class;
	Class<?>[] interfaces() default {};
}
