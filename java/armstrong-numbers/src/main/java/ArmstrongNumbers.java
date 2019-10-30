class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		String numberAsString = Integer.toString(numberToCheck);
		int numChars = numberAsString.length();
		double sum = numberAsString.chars()
			.mapToDouble(i -> Math.pow(Character.getNumericValue(i), numChars))
			.sum();
		return numberToCheck == sum;
	}

}
