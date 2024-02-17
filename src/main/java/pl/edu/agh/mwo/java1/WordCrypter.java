package pl.edu.agh.mwo.java1;

public class WordCrypter {
    private String randomWord;
    public WordCrypter(String randomWord) {
        this.randomWord = randomWord;
    }

    public String cryptWord() {
        int lengthOfWord = this.randomWord.length();
        String singleFloorSign = "_";
        return new String(new char[lengthOfWord]).replace("\0", singleFloorSign);
    }


}
