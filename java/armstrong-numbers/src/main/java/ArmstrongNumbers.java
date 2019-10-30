class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		String numberAsString = Integer.toString(numberToCheck);
		double sum = numberAsString.chars()
			.mapToDouble(i -> Math.pow(Character.getNumericValue(i), numberAsString.length()))
			.sum();
		return numberToCheck == sum;
	}

}
