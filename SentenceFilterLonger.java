public class SentenceFilterLonger implements SentenceFilter {
    String[] sentences;

    public SentenceFilterLonger(String text) {
        this.sentences = text.split("\\.");
    }

    @Override
    public void filterByLength(int length) {
        System.out.println("Предложения длиной больше " + length + " символов:");
        for (String sentence : sentences) {
            if (sentence.length() > length) {
                System.out.println(sentence.trim() + ".");
            }
        }
    }
}