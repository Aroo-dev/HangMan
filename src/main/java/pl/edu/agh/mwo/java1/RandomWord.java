package pl.edu.agh.mwo.java1;

import java.util.List;
import java.util.Random;

public class RandomWord {
    private final List<String> words;

    public RandomWord(List<String> wordList) {
        this.words = wordList;
    }

    public String getRandomWord() {

        if (words == null || words.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(words.size());

        return words.get(randomIndex);
    }
}
