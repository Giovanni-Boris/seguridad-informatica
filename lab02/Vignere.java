import java.util.Scanner;

public class Vignere {

    public static String algoritmoVignere(String mensaje, String clave){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el modulo opciones 1: modulo 27  2: modulo 191 ");
        int modulo = scanner.nextInt();
  
        return cifradoVignere(clave, mensaje, modulo == 1 ? 27: 191);
    }
    public static String decifrarVignere(String mensaje, String clave){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Introduce el modulo opciones 1: modulo 27  2: modulo 191 ");
      int modulo = scanner.nextInt();

      return descifradoVignere(clave, mensaje, modulo == 1 ? 27: 191);
  }
 
    public static  String cifradoVignere(String clave, String mensaje, int modulo){
      Alfabetos alfabeto = new Alfabetos(modulo);
      mensaje = procesarTexto(mensaje,modulo);
      StringBuilder textoCifrado = new StringBuilder();
      int i = 0;
      for(char token: mensaje.toCharArray()){
        if(!alfabeto.contains(token)) continue;
        int position = alfabeto.indexOf(token);
        int positionKey = alfabeto.indexOf(clave.charAt( i % clave.length()));
        int realPosition = (position + positionKey) % modulo;
        textoCifrado.append( alfabeto.get(realPosition));
        i++;
      }
      return textoCifrado.toString();
    }
    public static  String descifradoVignere(String mensaje, String clave, int modulo){
      Alfabetos alfabeto = new Alfabetos(modulo);
      mensaje = procesarTexto(mensaje,modulo);
      StringBuilder textoCifrado = new StringBuilder();

      int i = 0;
      for(char token: mensaje.toCharArray()){
        if(!alfabeto.contains(token)) continue;
        int position = alfabeto.indexOf(token);
        int positionKey = alfabeto.indexOf(clave.charAt( i % clave.length()));
        int realPosition = (position - positionKey) % modulo;
        if (realPosition < 0) realPosition += modulo;

        textoCifrado.append( alfabeto.get(realPosition));
        i++;
      }
      return textoCifrado.toString();
    }
    private static String procesarTexto(String texto, int module) {
      texto = eliminacionCarNoVisibles(texto);
      if (module == 191) return texto;
      texto = texto.toUpperCase();
      String aux = texto.replaceAll("[Á|À|Ä|Â]", "A");
      aux = aux.replaceAll("[É|È|Ë|Ê]", "E");
      aux = aux.replaceAll("[Í|Ì|Ï|Î]", "I");
      aux = aux.replaceAll("[Ó|Ò|Ö|Ô]", "O");
      aux = aux.replaceAll("[Ú|Ù|Ü|Û]", "U");
      aux = aux.replaceAll("[Ý|ÿ]", "Y");
      return aux;
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