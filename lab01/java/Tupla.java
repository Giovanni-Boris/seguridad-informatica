public class Tupla implements Comparable<Tupla> {
  private int weight;
  private char value;

  public Tupla(int weight, char value) {
      this.weight = weight;
      this.value = value;
  }

  public int getWeight() {
      return weight;
  }

  public char getValue() {
      return value;
  }

  @Override
  public int compareTo(Tupla other) {
      return Integer.compare(this.weight, other.weight);
  }
}