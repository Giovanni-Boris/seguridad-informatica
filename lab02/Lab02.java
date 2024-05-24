import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lab02 {
    public static void main(String[] args) throws IOException {
        
        // Algoritmo Cesar
        var resultado = CifradoCesar.algoritmoCesar(readFileAsString("./tests/CesarText.txt"));
        System.out.println("Cifrado Cesar");
        System.out.println("Resultado de cifrado Cesar " + resultado);
        System.out.println("Comparando resultado con el software");
        var resultadoEsperado = "ÑDSHUIHFFLPVHÑRJUDPRFXDPGRPRKDBPDGDOVTXHDQDGLUVLPRFXDPGRPRKDBPDGDOVTXHTXLWDU";
        System.out.println("Resultado es " +  (resultado.equals(resultadoEsperado) ? "correcto" : "incorrecto"));
        System.out.println();
        System.out.println("Frecuencias");
        Frecuencias.countCharacterFrequencies(resultado);
        System.out.println();
        
        // Algoritmo Vignere 27
        System.out.println("Cifrado Vignere modulo 27");
        var cifradoVignere = Vignere.algoritmoVignere(readFileAsString("./tests/VignereText.txt"), 
            readFileAsString("./tests/Clave.txt") );
        System.out.println("Resultado de cifrado Vignere " + cifradoVignere);
        System.out.println("Comparando resultado con el software");
        resultadoEsperado = "WEOGCFHQTTSMUOLRUJMQÑEFAPRGYSGCJNDRRXERSFEDCROMQUSNRQMMQCQXOKOPYECCWAVFMPUTKEAU";
        System.out.println("Resultado es " +  (cifradoVignere.equals(resultadoEsperado) ? "correcto" : "incorrecto"));
        System.out.println();

        
        // Algoritmo Vignere 191
        System.out.println("Cifrado Vignere modulo 191");
        cifradoVignere = Vignere.algoritmoVignere(readFileAsString("./tests/VignereText.txt"), 
            readFileAsString("./tests/Clave.txt") );
        System.out.println("Resultado de cifrado Vignere " + cifradoVignere);
        System.out.println("Comparando resultado con el software");
            resultadoEsperado = "x¥É§½¦¨±´µ8Çµ°¬²µÃ­²È¥À¡±²Àº³Á£Ä®¤²²¹&Ì³À¥¤@²°­ËN¾©±½´Á¥Ç¦º®²¶²Å²º¦¬­%ÁÂÁ©Ê·´´¤À";
        System.out.println("Resultado es " +  (cifradoVignere.equals(resultadoEsperado) ? "correcto" : "incorrecto"));
        System.out.println();
        
        // Descifrado Vignere 27
        System.out.println("Descifrado Vignere modulo 27");
        var descifradoVignere = Vignere.decifrarVignere(readFileAsString("./tests/ClaveDescifrado.txt"), 
            readFileAsString("./tests/DescifradoText.txt"));
        System.out.println("Resultado de descifrado Vignere " + descifradoVignere);
        System.out.println("Comparando resultado con el software");
        resultadoEsperado = "QUISIERAESTATARDEDIVINADEOCTUBREPASEARPORLAORILLALEJANADELMARQUELAARENADEOROYLASAGUASVERDESYLOSCIELOSPUROSMEVIERANPASAR";
        System.out.println("Resultado es " +  (descifradoVignere.equals(resultadoEsperado) ? "correcto" : "incorrecto"));
        System.out.println(); 

        // Descifrado Autoclave 27
        System.out.println("Descifrado Autoclave modulo 27");
        CifradoAutoclave candado = new CifradoAutoclave();
        var descifradoAutoclave = candado.descifradoAutoclave(readFileAsString("./tests/AutoclaveKey.txt"), readFileAsString("./tests/AutoclaveText.txt"), 27);
        System.out.println("Resultado de descifrado Vignere " + descifradoAutoclave);
        System.out.println();
    }
    public static String readFileAsString(String filePath) {
        Path path = Paths.get(filePath);
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }   
 
}
