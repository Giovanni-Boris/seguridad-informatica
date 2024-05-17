import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Lab01 {
    public static void main(String[] args) {
        String mensaje = """
                  A Silvia           
          Bien puede el mundo entero conjurarse 
          contra mi dulce amor y mi ternura, 
          y el odio infame y tiranía dura 
          de todo su rigor contra mí armarse. 
                                             
          Bien puede el tiempo rápido cebarse 
          en la gracia y primor de su hermosura, 
          para que cual si fuese llama impura 
          pueda el fuego de amor en mí acabarse. 

          Bien puede en fin la suerte vacilante, 
          que eleva, abate, ensalza y atropella, 
          alzarme o abatirme en un instante; 
          
          Que el mundo, al tiempo y a mi varia estrella, 
          más fino cada vez y más constante, 
          les diré: «Silvia es mía y yo soy de ella». 
                                                Mariano Melgar
        """;

        // Codificar el mensaje utilizando la clase Encoder
        // Realizar las siguientes sustituciones: axu, hxt, ñxe, kxl, vxf, wxb, zxy, rxp 
        //(tanto mayúsculas como minúsculas)
        String mensajeSustituido = Encoder.preprocesadoSustitucion(mensaje);
        System.out.println("Mensaje sustituido: \n" + mensajeSustituido);
        
        // Elimine las tildes 
        String mensajeSinTildes = Encoder.preprocesadoEliminarTildes(mensajeSustituido);
        System.out.println("\nMensaje sin tildes: \n" + mensajeSinTildes);
        
        //Convierta todas las letras a mayúsculas
        String mensajeMayusculas = Encoder.preprocesadoMayusculas(mensajeSinTildes);
        System.out.println("\nMensaje mayusculas: \n" + mensajeMayusculas);

        // Elimine los espacios en blanco y los signos de puntuación Indique cuál sería 
        // el alfabeto resultante y cuál su longitud
        String mensajeSinSignosPuntuacion= Encoder.preprocesadoSignosPuntuacion(mensajeMayusculas);
        System.out.println("\nMensaje sin signos de puntuacion y espacios en blanco: \n" + mensajeSinSignosPuntuacion);
        System.out.println("\nTamaño de mensaje: " + mensajeSinSignosPuntuacion.length());
        guardarArchivo(mensajeSinSignosPuntuacion);
        
        // Abra el archivo generado e implementar una función que calcule una tabla de 
        // frecuencias para cada letra de la ’A’ a ’Z’. 
        String mensajeArchivo = leerArchivo();
        var frecuenciasMensaje = Encoder.frecuencias(mensajeArchivo);
        System.out.println("\nFrecuencias:");
        printHashMap(frecuenciasMensaje);

        // Reconozca en el resultado obtenido los cinco caracteres de mayor frecuencia
        Encoder.frecuenciasMasGrankes(5, frecuenciasMensaje);

        // El método Kasiski requiere para implementar un ataque
        System.out.println("\nEl método Kasiski Trigramas - Indices:");
        Encoder.trigramasDistancia(mensajeArchivo);

        // Volver a preprocesar el archivo cambiando cada carácter según UNICODE-8
        System.out.println("\nMensaje to Unicode-8:");
        System.out.println(Encoder.toUnicode8(mensajeArchivo));

        //Volver a preprocesar el archivo cambiando cada carácter según alfabeto de su elección
        System.out.println("\nMensaje to mi alfabeto:");
        System.out.println(Encoder.cambiarMyAlfabeto(mensajeArchivo));

        /*
         * Volver a preprocesar el archivo insertando la cadena EPIS cada 15 caracteres, el texto resultante deberá
            contener un número de caracteres que sea múltiplo de 7, si es necesario rellenar (padding) al final con
            caracteres Z según se necesite
         */
        System.out.println("\nAñadiendo EPIS y padding:");
        System.out.println(Encoder.insertEPISandPadding(mensajeArchivo));
  
    }
    public static void printHashMap(Map<Character, Integer> hashMap) {
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            System.out.println("letra: " + entry.getKey() + ", frecuencia: " + entry.getValue());
        }
    }

    public static void guardarArchivo(String message) {
        try (FileWriter writer = new FileWriter("PRACTICA1_PRE.TXT")) {
            writer.write(message);
            System.out.println("Message saved to PRACTICA1_PRE.TXT");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static String leerArchivo() {
        StringBuilder message = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("PRACTICA1_PRE.TXT"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                message.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return message.toString().trim();
    }
 
}
