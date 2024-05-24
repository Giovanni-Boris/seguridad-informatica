public class CifradoAutoclave {

  
  public  String descifradoAutoclave(String clave, String mensaje, int modulo){
    Alfabetos alfabeto = new Alfabetos(modulo);
    mensaje = procesarTexto(mensaje);
    StringBuilder textodescifrado = new StringBuilder();
    int i = 0;
    boolean isUsignMessage = false;
    for(char token: mensaje.toCharArray()){
      if(!alfabeto.contains(token)) continue;
      int position = alfabeto.indexOf(token);
      //Usar el mensaje como clave
      boolean useMessage = i >= clave.length();
      if(!isUsignMessage && useMessage){
        clave = mensaje;
        i = 0;
        isUsignMessage = false;
      }
      int positionKey = alfabeto.indexOf(clave.charAt( i % clave.length()));
      int realPosition = (position - positionKey) % modulo;
      if (realPosition < 0) realPosition += modulo;

      textodescifrado.append( alfabeto.get(realPosition));
      i++;
    }
    return textodescifrado.toString();
  }
  private String procesarTexto(String texto) {
    texto = eliminacionCarNoVisibles(texto);
    texto = texto.toUpperCase();
    return texto;
  }
  private String eliminacionCarNoVisibles(String texto) {
    String aux = texto.replaceAll(" ", "");
    aux = aux.replaceAll("\n", "");
    aux = aux.replaceAll("\t", "");
    aux = aux.replaceAll("\r", "");
    aux = aux.replaceAll("\b", "");
    return aux;
  }
}
