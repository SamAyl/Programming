package CSES;

public class App2 {

    public static void main(String[] args) {
        String[] sentence = {"I","had","apple","pie"};
        int rows = 4;
        int col = 5;

        App2 app = new App2();
        app.wordsTyping(sentence,4,5);
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {

        int count = 0;
        int wordIdx = 0;
        int rdx = 0;
        int cdx = -1;

        while(rdx < rows && cdx < cols) {
            if (wordIdx == sentence.length) {
                count++;
                wordIdx = 0;
            }
            int wordLength = sentence[wordIdx].length();

            if (cdx + wordLength  < cols) {
                cdx = cdx + wordLength;
                if (cdx + 1 < cols) {
                    cdx++;
                } else {
                    cdx = -1;
                }
                wordIdx++;
            } else {
                rdx++;
                cdx = -1;
            }
        }

        return count;
    }
}
