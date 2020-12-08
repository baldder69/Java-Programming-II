package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class SaveableDictionary {

    private HashMap<String, String> words;
    private String file;

    public SaveableDictionary() {
        this.words = new HashMap<>();
    }

    public void add(String words, String translation) {

        if (this.words.containsKey(words) || this.words.containsValue(translation)) {

        } else {
            this.words.put(words, translation);
        }
    }

    public String translate(String word) {

        for (String word1 : this.words.keySet()) {
            if (this.words.get(word1).equals(word)) {
                return word1;
            } else if (this.words.containsKey(word)) {
                return this.words.get(word);
            }
        }

        return null;

                        //ALTERNATE METHOD
        /*String translation = null;

        for (Map.Entry<String, String> e : this.dictionary.entrySet()) {

            if (word.equals(e.getKey())) {

                translation = e.getValue();

            } else if (word.equals(e.getValue())) {

                translation = e.getKey();

            }

        }

        return translation;     */
    }

    public void delete(String word) {

        if (this.words.containsKey(word)) {
            this.words.remove(word);
        }

        if (this.words.containsValue(word)) {
            this.words.remove(translate(word));
        }

        //                             ***USES AN ITERATOR***
        /*Iterator<Map.Entry<String, String>> iterator = this.words.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();

            if (word.equals(entry.getValue())) {
                iterator.remove();
            }
        

        }*/ //This is an alternative method to study 
        //                             ***STEAM METHOD***
        //this.words.entrySet().removeIf(entry -> (word.equals(entry.getValue())));
    }

    public SaveableDictionary(String file) {
        this.file = file;
        this.words = new HashMap<>();
    }

    public boolean load() {
        try (Scanner fileReader = new Scanner(Paths.get(this.file))) {

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] words = line.split(":");   // split the line based on the ':' character

                this.add(words[0], words[1]);
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean save() {

        try (PrintWriter writer = new PrintWriter(this.file)) {

            this.words.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).forEach(words -> writer.println(words));

            return true;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }

    }

}
