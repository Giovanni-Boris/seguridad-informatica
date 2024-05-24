import java.util.HashMap;

public class Encoder{

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
          caracter = 'Ñ'; 
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

}