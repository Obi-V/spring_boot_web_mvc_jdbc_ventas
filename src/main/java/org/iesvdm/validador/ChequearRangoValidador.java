package org.iesvdm.validador;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ChequearRangoValidador implements ConstraintValidator<RangoCategoria, Integer> {

	private int[] valoresValidos;

	@Override
	public void initialize(RangoCategoria constraintAnnotation) {
		this.valoresValidos = constraintAnnotation.valoresValidos();

	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {

		for (int i : valoresValidos) {

			if (value == i) {

				return true;
			}
		}
		return false;
	}

}
