package com.web.model;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, METHOD, FIELD })
@Retention(RUNTIME)
public @interface SequenceGenerator {
	String name();

	String sequenceName() default "OID";

	int initialValue() default 0;

	int allocationSize() default 50;
}
