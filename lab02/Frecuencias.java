import java.util.HashMap;

public class Frecuencias {
  public static void countCharacterFrequencies(String inputString) {
        HashMap<Character, Integer> charFrequencies = new HashMap<>();
        char[] charArray = inputString.toCharArray();

        for (char c : charArray) {
          charFrequencies.put(c, charFrequencies.getOrDefault(c,0) + 1);
      
        }
        for (HashMap.Entry<Character, Integer> entry : charFrequencies.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }
    }
}
