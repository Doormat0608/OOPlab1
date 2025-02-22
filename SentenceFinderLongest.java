public class SentenceFinderLongest extends SentenceFilterLonger {

    public SentenceFinderLongest(String text) {
        super(text);
    }

    public void findLongestSentence() {
        String longestSentence = "";
        int maxLength = 0;
        for (String sentence : sentences) {
            int sentenceLength = sentence.length();
            if (sentenceLength > maxLength) {
                longestSentence = sentence;
                maxLength = sentenceLength;
            }
        }
        System.out.println("Самое длинное предложение: \"" + longestSentence.trim() + "\"");
        System.out.println("Длина: " + maxLength + " символов.");
    }
}
