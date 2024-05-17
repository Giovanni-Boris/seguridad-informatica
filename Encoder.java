import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Encoder{
  public static String preprocesadoSustitucion(String mensaje){
    HashMap<Character, Character> sustituciones = new HashMap<>();
    //Minusculas
    sustituciones.put('a', 'u');
    sustituciones.put('h', 't');
    sustituciones.put('ñ', 'e');
    sustituciones.put('k', 'l');
    sustituciones.put('v', 'f');
    sustituciones.put('w', 'b');
    sustituciones.put('z', 'y');
    sustituciones.put('r', 'p');
    //Mayusculas
    sustituciones.put('A', 'U');
    sustituciones.put('H', 'T');
    sustituciones.put('Ñ', 'E');
    sustituciones.put('K', 'L');
    sustituciones.put('V', 'F');
    sustituciones.put('W', 'B');
    sustituciones.put('Z', 'Y');
    sustituciones.put('R', 'P');
    //Conversion
    StringBuilder codificado = new StringBuilder();
    for( int i = 0; i< mensaje.length(); i++) {
      char caracter = mensaje.charAt(i);
      char caracter_sustituido = sustituciones.containsKey(caracter) ?
        sustituciones.get(caracter) : caracter;

      codificado.append(caracter_sustituido);

    }
    return codificado.toString();
      
  }
  public static String preprocesadoEliminarTildes(String mensaje){
    HashMap<Character, Character> sustituciones = new HashMap<>();
    //Minusculas
    sustituciones.put('á', 'a');
    sustituciones.put('é', 'e');
    sustituciones.put('í', 'i');
    sustituciones.put('ó', 'o');
    sustituciones.put('ú', 'u');
    //Mayusculas
    sustituciones.put('Á', 'A');
    sustituciones.put('É', 'E');
    sustituciones.put('Í', 'I');
    sustituciones.put('Ó', 'O');
    sustituciones.put('Ú', 'U');
    //Conversion
    StringBuilder codificado = new StringBuilder();
    for( int i = 0; i< mensaje.length(); i++) {
      char caracter = mensaje.charAt(i);
      char caracter_sustituido = sustituciones.containsKey(caracter) ?
        sustituciones.get(caracter) : caracter;

      codificado.append(caracter_sustituido);

    }
    return codificado.toString();
      
  }
  public static String preprocesadoMayusculas(String mensaje){
    StringBuilder codificado = new StringBuilder();
        
    for (int i = 0; i < mensaje.length(); i++) {
        char caracter = mensaje.charAt(i);
        
        if (caracter >= 'a' && caracter <= 'z') {
          caracter = (char) (caracter - 'a' + 'A');
        } else if (caracter == 'ñ') {
          caracter = (char) 165; 
        }
        
        codificado.append(caracter);
    }
    return codificado.toString();
      
  }
  public static String preprocesadoSignosPuntuacion(String mensaje){
    StringBuilder codificado = new StringBuilder();
        
    for (int i = 0; i < mensaje.length(); i++) {
        char c = mensaje.charAt(i);
        
        if ((c >= 65 && c <= 90) || c == 165)
          codificado.append(c);
    }
    return codificado.toString();
      
  }
  public static HashMap<Character, Integer> frecuencias(String mensaje){
    HashMap<Character, Integer> frecuencias = new HashMap<>();
    for (int i = 0; i < mensaje.length(); i++) {
      char c = mensaje.charAt(i);
      frecuencias.put(c, frecuencias.getOrDefault(c,0) +1 );
    }
    return frecuencias;
  }
  //Reconozca en el resultado obtenido los cinco caracteres de mayor frecuencia
  public static void frecuenciasMasGrankes(int k, HashMap<Character, Integer> frecuencias){
    PriorityQueue<Tupla> biggers = new PriorityQueue<>();

    for (Map.Entry<Character, Integer> entry : frecuencias.entrySet()) {
      biggers.offer(new Tupla(entry.getValue(), entry.getKey()));
      if(biggers.size() > k){
        biggers.poll();
      }
    }
    System.out.println("5 letras con mayores frecuencias:");
    while (!biggers.isEmpty()) {
      var element = biggers.poll();
      System.out.println("letra: " + element.getValue() + ", frecuencia: " + element.getWeight());
    }

  }
  public static void trigramasDistancia(String mensaje){
    HashMap<String, ArrayList<Integer>> trigramas = new HashMap<>();
    var trigrama = "";
    for(int i=0;i < mensaje.length()-3; i++){
      trigrama = mensaje.substring(i, i+3);
      if(!trigramas.containsKey(trigrama))
        trigramas.put(trigrama, new ArrayList<>());
      trigramas.get(trigrama).add(i);

    }
    for (Map.Entry<String, ArrayList<Integer>> entry : trigramas.entrySet()) {
      // verificar si hay trigramas
      var value = entry.getValue();
      if(value.size() == 1) continue;
      System.out.println("Trigrama " + entry.getKey() + "  Indices donde se encontraron " 
        +entry.getValue().toString()
      );
      distanciaTrigrama(entry.getValue());
    }
    //determinar la distancia 
  }
  public static void distanciaTrigrama(ArrayList<Integer> numbers) {
    System.out.println("Distancias");

    for (int i = 0; i < numbers.size() - 1; i++) {
        // Como son las posiciones  por  ejemplo ABCCDFABC  en este caso para ABC 
        // se tendria la posiciones  0 y 6  la distancia seria 6 - 0 - 3 = 3 por que es distancia entre trigramas resultando CDF
        int difference = numbers.get(i + 1) -  numbers.get(i);
        System.out.println("\tindice2: " + numbers.get(i + 1) + ", indice1:" + numbers.get(i) + " distancia: " + difference);
    }
    System.out.println();
  }
  public static String toUnicode8(String mensaje){
    String[] unicodes = new String[mensaje.length()];
    for (int i = 0; i < mensaje.length(); i++) {
      char c = mensaje.charAt(i);
      unicodes[i] = convertirHexadecimal( (int) c);
    } 
    return String.join(" ", unicodes);
  }

  public static String convertirHexadecimal(int number) {
    if (number == 0) {
        return "0";
    }

    StringBuilder sb = new StringBuilder();
    while (number != 0) {
        int remainder = number % 16;
        char hexDigit = (char) (remainder < 10 ? remainder + '0' : remainder + 'A' - 10);
        sb.insert(0, hexDigit);
        number /= 16;
    }

    return sb.toString();
  }
  public static String cambiarMyAlfabeto(String mensaje){
    HashMap<Character, Character> alfabeto = new HashMap<>();
    //Alfabeto
    alfabeto.put('U', 'A');
    alfabeto.put('L', 'R');
    alfabeto.put('E', 'H');
    alfabeto.put('B', 'X');
    alfabeto.put('Y', 'T');
    alfabeto.put('P', 'R');
    alfabeto.put('J', 'Q');
    alfabeto.put('S', 'P');
    alfabeto.put('O', 'W');

    StringBuilder codificado = new StringBuilder();
    for( int i = 0; i< mensaje.length(); i++) {
      char caracter = mensaje.charAt(i);
      char caracter_sustituido = alfabeto.containsKey(caracter) ?
      alfabeto.get(caracter) : caracter;

      codificado.append(caracter_sustituido);

    }
    return codificado.toString();
  }

  public static String insertEPISandPadding(String mensaje){
    StringBuilder codificado = new StringBuilder();
    //Insertar Epis
    for( int i = 0; i< mensaje.length(); i++) {
      char caracter = mensaje.charAt(i);
      if(i != 0 && i%15==0)
        codificado.append("EPIS");
      codificado.append(caracter);

    }
    var result = codificado.toString();
    //Agregar padding
    if(result.length() %7 ==0)
      return result;

    for(int i=0; i < result.length() %7; i++)
      result += "Z";
    return result;
  }
}

