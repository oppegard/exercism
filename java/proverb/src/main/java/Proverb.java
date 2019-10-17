class Proverb {

    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        if (words.length == 0) return "";

        StringBuilder proverb = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            proverb
                .append("For want of a ")
                .append(words[i])
                .append(" the ")
                .append(words[i + 1])
                .append(" was lost.\n");
        }
        return proverb + "And all for the want of a " + words[0] + ".";
    }

}
