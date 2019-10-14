class ReverseString {

    String reverse(String inputString) {
        return inputString.chars()
            .mapToObj(a -> Character.toString((char) a))
            .reduce("", (a, b) -> b + a);
    }
}