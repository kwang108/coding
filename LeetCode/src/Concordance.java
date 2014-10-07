import java.util.*;

/**
 * Created by kkwang on 8/9/2014.
 *
 * Given an arbitrary text document written in English, write a program that will generate a
 * concordance, i.e. an alphabetical list of all word occurrences, labeled with word frequencies.
 * Bonus: label each word with the sentence numbers in which each occurrence appeared.
 *
 * Some assumptions:
 * 1. There is at least one white space between two sentences.
 * 2. If '.' appears inside a word but doesn't end a sentence, it is only used in "i.e." and "e.g.".
 * 3. The text document doesn't contain extra white spaces at the end.
 */
public class Concordance {
    Map<String, List<Integer>> dictionary = new HashMap<>(); //First number in the list is the total number of occurrences of the word, subsequent
                                                             //numbers are the indices of sentences in which it appears.
    PriorityQueue<String> alphabeticalHeap = new PriorityQueue<>(); //Used to keep alphabetical order

    /**
     * Helper function that updates the stats of a word when it's identified.
     * @param wordBuilder StringBuilder containing the word
     * @param sentenceCount Index of the sentence the word appears in
     */
    private void recordWord(StringBuilder wordBuilder, int sentenceCount) {
        String word = wordBuilder.toString().toLowerCase();
        List<Integer> stats;
        if(dictionary.containsKey(word)) { //word has been encountered
            stats = dictionary.get(word);
            int count = stats.remove(0);
            stats.add(0, count+1);
        } else { //first occurrence of this word
            stats = new LinkedList<>();
            stats.add(1);
            dictionary.put(word, stats);
            alphabeticalHeap.offer(word);
        }
        wordBuilder.setLength(0); //reset
        stats.add(sentenceCount);
    }

    /**
     * Given an English text, build a concordance for it.
     * @param text
     */
    private void buildConcordance(String text) {
        if(text == null || text.isEmpty()) return;

        int index = 0, sentenceCount = 0;
        StringBuilder wordBuilder = new StringBuilder();
        String word = null;
        for(; index < text.length(); index++) {
            char c = text.charAt(index);
            if(c == ' ' || c==',' || c==';' || c==':') { //These characters can mark the end of a word
                if(wordBuilder.length() > 0) { //We have a word, avoid multiple white spaces.
                    recordWord(wordBuilder, sentenceCount+1);
                }
            } else if(c == '.') { //Possible mark for the end of a sentence
                if(((index+1 < text.length() && text.charAt(index+1)==' ') //period followed by a space indicating end of sentence
                        ||
                        (index==text.length()-1)) //period is the last character, which also marks end of sentence
                    &&
                        !wordBuilder.toString().equalsIgnoreCase("i.e") && !wordBuilder.toString().equalsIgnoreCase("e.g")) { //exclude "i.e." and "e.g."
                    sentenceCount++; //we have identified a sentence
                } else { //period is part of a word
                    wordBuilder.append(c);
                }
            } else if(c=='?' || c=='!') { //we have a sentence
                if(wordBuilder.length() > 0) {//avoid repeated ? and !
                    sentenceCount++;
                    recordWord(wordBuilder, sentenceCount);
                }
            } else if(c == '\n' || c== '\r') { //skip line breaks
                continue;
            } else {
                wordBuilder.append(c); //keep building current word
            }
        }

        if(wordBuilder.length() > 0) { //We have a last word
            recordWord(wordBuilder, sentenceCount);
        }
    }

    /**
     * Helper function that prints the contents of the concordance.
     */
    private void printConcordance() {
        String word = null;
        while(!alphabeticalHeap.isEmpty()) {
            word = alphabeticalHeap.poll();
            List<Integer> stats = dictionary.get(word);
            System.out.print(word);
            System.out.print(" {");
            if(stats != null) {
                System.out.print(stats.get(0));
                System.out.print(":");
                System.out.print(stats.get(1));
                for(int i = 2; i < stats.size(); i++) {
                    System.out.print(",");
                    System.out.print(stats.get(i));
                }
            }
            System.out.println("}");
        }
    }
    private char toLower(char c) {
        if(c - 'a' < 0 || c-'a' > 26) return (char)((c-'A') + 'a');
        return c;
    }
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        else if(s.isEmpty()) return true;

        int i = 0, j = s.length()-1;
        while(i < j) {
            if(!((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <='Z') ||
                    (s.charAt(i) >= '0' && s.charAt(i) < '9'))) {
                i++;
                continue;
            }
            if(!((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 'A' && s.charAt(j) <='Z') ||
                    (s.charAt(j) >= '0' && s.charAt(j) < '9'))) {
                j--;
                continue;
            }
            if(toLower(s.charAt(i)) != toLower(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String text = "Bang! Given an arbitrary text document written in English, write a program that will generate a \n" +
                "\n" +
                "concordance, i.e. an alphabetical list of all word occurrences, labeled with word frequencies. \n" +
                "\n" +
                "Bonus: label each word with the sentence numbers in which each occurrence appeared.";
        Concordance concordance = new Concordance();
        System.out.println(concordance.isPalindrome("ab2a"));
//        concordance.buildConcordance(text);
//        concordance.printConcordance();
    }
}
