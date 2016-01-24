package de.htw_berlin.ai_bachelor.kbe.checklistkbe8.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyIntervalConstraint.class)
public @interface MyInterval {
	String message() default "{de.htw_berlin.ai_bachelor.kbe.checklistkbe8.validation.MyInterval}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

	/**
	 * EL Expression which acts as  reference to
	 * a <code>Interval</code>-Object Getter.
	 *
	 * @return the el expression to an Interval
	 * getter.
     */
	String interval();
}
