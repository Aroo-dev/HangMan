package pl.edu.agh.mwo.java1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class WordReader {

    private final ArrayList<String> uppercaseWords = new ArrayList<>();

    public ArrayList<String> getUppercaseWords() {
        return uppercaseWords;
    }

    public void readFile() {
        File file = new File("src/main/resources/slowa.txt");
        String line;

        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            while ((line = reader.readLine()) != null)
                uppercaseWords.add(line.toUpperCase());
        } catch (IOException x) {
            System.err.format("IOException: %s", x);
        }

    }

    public List<String> getUppercaseWordWithSpecificAmountOFLetters(int digit){
      return   uppercaseWords.stream().filter(s -> s.length() == digit).collect(Collectors.toList());
    }
}
