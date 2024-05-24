
import java.util.Scanner;

public class CifradoCesar {

    public static String algoritmoCesar(String mensaje){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el desplazamiento: ");
        int desplazamiento = scanner.nextInt();
  
        return cifradoCesar(desplazamiento, mensaje);
    }
 
    
    public static  String cifradoCesar(int desplazamiento, String mensaje){
      Alfabetos alfabeto = new Alfabetos(27);
      mensaje = procesarTexto(mensaje);
      StringBuilder textoCifrado = new StringBuilder();
      for(char token: mensaje.toCharArray()){
        if(!alfabeto.contains(token)) continue;
        int position = alfabeto.indexOf(token);
        int realPosition = (position + desplazamiento) % 27;
        textoCifrado.append( alfabeto.get(realPosition));
      }
      return textoCifrado.toString();
    }
    private static String procesarTexto(String texto) {
      texto = eliminacionCarNoVisibles(texto);
      texto = texto.toUpperCase();
      return texto;
    }
    private static String eliminacionCarNoVisibles(String texto) {
      String aux = texto.replaceAll(" ", "");
      aux = aux.replaceAll("\n", "");
      aux = aux.replaceAll("\t", "");
      aux = aux.replaceAll("\r", "");
      aux = aux.replaceAll("\b", "");
      return aux;
    }
}