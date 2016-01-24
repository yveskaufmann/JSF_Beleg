package de.htw_berlin.ai_bachelor.kbe.checklistkbe8.validation;

import com.sun.org.apache.xpath.internal.SourceTree;
import de.htw_berlin.ai_bachelor.kbe.checklistkbe8.model.Interval;
import org.apache.taglibs.standard.lang.jstl.parser.ELParser;

import javax.el.ELContext;

import javax.el.ELResolver;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyIntervalConstraint implements ConstraintValidator<MyInterval, Long> {

	private Interval interval;

	@Override
	public void initialize(MyInterval myInterval) {

		String intervalSrc = myInterval.interval();
		FacesContext ctx = FacesContext.getCurrentInstance();
		ELContext elContext = ctx.getELContext();
		ELResolver resolver = elContext.getELResolver();

		Object obj = null;
		for (String property : intervalSrc.split("\\.")) {
			obj = resolver.getValue(elContext, obj, property);
		}

		if (obj == null) {
			throw new IllegalArgumentException("interval not found");
		}

		if (!(obj instanceof Interval)) {
			throw new IllegalArgumentException("MyInterval.interval don't reference to a " + Interval.class.getName() + "object");
		}

		interval = (Interval) obj;
	}

	@Override
	public boolean isValid(Long t, ConstraintValidatorContext constraintValidatorContext) {
		return t == null || t.compareTo(interval.getMin()) >= 0 && t.compareTo(interval.getMax()) <= 0;
	}
}
