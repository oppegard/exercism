class ReverseString {

    String reverse(String inputString) {
        String reversed = "";
        for (Character c : inputString.toCharArray()) reversed = c + reversed;
        return reversed;
    }

}