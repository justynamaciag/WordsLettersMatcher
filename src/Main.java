import java.util.*;

class WordsLetterIndexer {

    private Map<String, SortedSet<String>> map;

    WordsLetterIndexer(){
        this.map = new TreeMap<>();
    }

    void parseInput(String input){
        input = input.replaceAll("[^a-zA-Z\\s+]", "");

        for (String word : input.toLowerCase().split("\\s+")) {
            for (String letter : word.split("")){
                if (this.map.containsKey(letter))
                    this.map.get(letter).add(word);
                else
                    this.map.put(letter, new TreeSet<>(Arrays.asList(word)));
            }
        }
    }

    void printIndexMap() {
        this.map.forEach((key, value) -> System.out.println(key + ": " + String.join(", ", value)));
    }

}

class Main{

    public static void main(String[] args) {

        String input;
        if(args.length == 0)
        {
            input = "ala ma kota, kot koduje w Javie Kota";
            System.out.println("Using default input: " + input);
        }
        else
            input = args[0];

        WordsLetterIndexer wordsLetterIndexer = new WordsLetterIndexer();
        wordsLetterIndexer.parseInput(input);
        wordsLetterIndexer.printIndexMap();

    }

}