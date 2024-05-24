
/*     */ import java.util.ArrayList;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class Alfabetos {
/*     */   protected ArrayList<Character> alfabeto;
/*     */   
/*     */   private int z;
/*     */   
/*     */   private double[] tabla;
/*     */   
/*     */   private final double[] rawFrecuenciasEN;
/*     */   
/*     */   private final double[] rawFrecuenciasES;
/*     */   
/*     */   public Alfabetos(int z) {
/*     */     int i;
/*  17 */     this.alfabeto = new ArrayList<>();
/*  20 */     this.rawFrecuenciasEN = new double[] { 
/*  20 */         8.167D, 1.492D, 2.782D, 4.253D, 12.702D, 2.228D, 2.015D, 6.094D, 6.966D, 0.153D, 
/*  20 */         0.772D, 4.025D, 2.406D, 6.749D, 7.507D, 1.929D, 0.095D, 5.987D, 6.327D, 9.056D, 
/*  20 */         2.758D, 0.978D, 2.36D, 0.15D, 1.974D, 0.074D };
/*  21 */     this.rawFrecuenciasES = new double[] { 
/*  21 */         12.53D, 1.42D, 5.68D, 5.86D, 13.68D, 0.69D, 1.01D, 0.7D, 6.25D, 0.44D, 
/*  21 */         0.01D, 4.97D, 3.15D, 6.71D, 0.074D, 8.68D, 2.51D, 0.88D, 6.87D, 7.98D, 
/*  21 */         4.63D, 3.93D, 0.9D, 0.02D, 0.22D, 0.9D, 0.52D };
/*  24 */     this.z = z;
/*  25 */     switch (z) {
/*     */       case 26:
/*  27 */         for (i = 65; i < 91; i++)
/*  28 */           this.alfabeto.add(Character.valueOf((char)i)); 
/*  30 */         this.tabla = this.rawFrecuenciasEN;
/*     */         break;
/*     */       case 27:
/*  33 */         for (i = 65; i < 91; i++) {
/*  34 */           if (i == 79)
/*  35 */             this.alfabeto.add(Character.valueOf('Ñ')); 
/*  37 */           this.alfabeto.add(Character.valueOf((char)i));
/*     */         } 
/*  39 */         this.tabla = this.rawFrecuenciasES;
/*     */         break;
/*     */       case 36:
/*  42 */         for (i = 65; i < 91; i++)
/*  43 */           this.alfabeto.add(Character.valueOf((char)i)); 
/*  45 */         for (i = 48; i < 58; i++)
/*  46 */           this.alfabeto.add(Character.valueOf((char)i)); 
/*     */         break;
/*     */       case 37:
/*  50 */         for (i = 65; i < 91; i++) {
/*  51 */           if (i == 79)
/*  52 */             this.alfabeto.add(Character.valueOf('Ñ')); 
/*  54 */           this.alfabeto.add(Character.valueOf((char)i));
/*     */         } 
/*  56 */         for (i = 48; i < 58; i++)
/*  57 */           this.alfabeto.add(Character.valueOf((char)i)); 
/*     */         break;
/*     */       case 191:
/*  62 */         for (i = 33; i < 127; i++)
/*  63 */           this.alfabeto.add(Character.valueOf((char)i)); 
/*  65 */         this.alfabeto.add(Character.valueOf('‘'));
/*  66 */         this.alfabeto.add(Character.valueOf('’'));
/*  67 */         this.alfabeto.add(Character.valueOf('¡'));
/*  68 */         this.alfabeto.add(Character.valueOf('¢'));
/*  69 */         this.alfabeto.add(Character.valueOf('£'));
/*  70 */         this.alfabeto.add(Character.valueOf('¤'));
/*  71 */         this.alfabeto.add(Character.valueOf('¥'));
/*  72 */         this.alfabeto.add(Character.valueOf('¦'));
/*  73 */         this.alfabeto.add(Character.valueOf('§'));
/*  74 */         this.alfabeto.add(Character.valueOf('¨'));
/*  75 */         this.alfabeto.add(Character.valueOf('©'));
/*  76 */         this.alfabeto.add(Character.valueOf('ª'));
/*  77 */         this.alfabeto.add(Character.valueOf('«'));
/*  78 */         this.alfabeto.add(Character.valueOf('¬'));
/*  79 */         this.alfabeto.add(Character.valueOf('­'));
/*  80 */         this.alfabeto.add(Character.valueOf('®'));
/*  81 */         this.alfabeto.add(Character.valueOf('¯'));
/*  82 */         this.alfabeto.add(Character.valueOf('°'));
/*  83 */         this.alfabeto.add(Character.valueOf('±'));
/*  84 */         this.alfabeto.add(Character.valueOf('²'));
/*  85 */         this.alfabeto.add(Character.valueOf('³'));
/*  86 */         this.alfabeto.add(Character.valueOf('´'));
/*  87 */         this.alfabeto.add(Character.valueOf('µ'));
/*  88 */         this.alfabeto.add(Character.valueOf('¶'));
/*  89 */         this.alfabeto.add(Character.valueOf('·'));
/*  90 */         this.alfabeto.add(Character.valueOf('¸'));
/*  91 */         this.alfabeto.add(Character.valueOf('¹'));
/*  92 */         this.alfabeto.add(Character.valueOf('º'));
/*  93 */         this.alfabeto.add(Character.valueOf('»'));
/*  94 */         this.alfabeto.add(Character.valueOf('¼'));
/*  95 */         this.alfabeto.add(Character.valueOf('½'));
/*  96 */         this.alfabeto.add(Character.valueOf('¾'));
/*  97 */         this.alfabeto.add(Character.valueOf('¿'));
/*  98 */         this.alfabeto.add(Character.valueOf('À'));
/*  99 */         this.alfabeto.add(Character.valueOf('Á'));
/* 100 */         this.alfabeto.add(Character.valueOf('Â'));
/* 101 */         this.alfabeto.add(Character.valueOf('Ã'));
/* 102 */         this.alfabeto.add(Character.valueOf('Ä'));
/* 103 */         this.alfabeto.add(Character.valueOf('Å'));
/* 104 */         this.alfabeto.add(Character.valueOf('Æ'));
/* 105 */         this.alfabeto.add(Character.valueOf('Ç'));
/* 106 */         this.alfabeto.add(Character.valueOf('È'));
/* 107 */         this.alfabeto.add(Character.valueOf('É'));
/* 108 */         this.alfabeto.add(Character.valueOf('Ê'));
/* 109 */         this.alfabeto.add(Character.valueOf('Ë'));
/* 110 */         this.alfabeto.add(Character.valueOf('Ì'));
/* 111 */         this.alfabeto.add(Character.valueOf('Í'));
/* 112 */         this.alfabeto.add(Character.valueOf('Î'));
/* 113 */         this.alfabeto.add(Character.valueOf('Ï'));
/* 114 */         this.alfabeto.add(Character.valueOf('Ð'));
/* 115 */         this.alfabeto.add(Character.valueOf('Ñ'));
/* 116 */         this.alfabeto.add(Character.valueOf('Ò'));
/* 117 */         this.alfabeto.add(Character.valueOf('Ó'));
/* 118 */         this.alfabeto.add(Character.valueOf('Ô'));
/* 119 */         this.alfabeto.add(Character.valueOf('Õ'));
/* 120 */         this.alfabeto.add(Character.valueOf('Ö'));
/* 121 */         this.alfabeto.add(Character.valueOf('×'));
/* 122 */         this.alfabeto.add(Character.valueOf('Ø'));
/* 123 */         this.alfabeto.add(Character.valueOf('Ù'));
/* 124 */         this.alfabeto.add(Character.valueOf('Ú'));
/* 125 */         this.alfabeto.add(Character.valueOf('Û'));
/* 126 */         this.alfabeto.add(Character.valueOf('Ü'));
/* 127 */         this.alfabeto.add(Character.valueOf('Ý'));
/* 128 */         this.alfabeto.add(Character.valueOf('Þ'));
/* 129 */         this.alfabeto.add(Character.valueOf('ß'));
/* 130 */         this.alfabeto.add(Character.valueOf('à'));
/* 131 */         this.alfabeto.add(Character.valueOf('á'));
/* 132 */         this.alfabeto.add(Character.valueOf('â'));
/* 133 */         this.alfabeto.add(Character.valueOf('ã'));
/* 134 */         this.alfabeto.add(Character.valueOf('ä'));
/* 135 */         this.alfabeto.add(Character.valueOf('å'));
/* 136 */         this.alfabeto.add(Character.valueOf('æ'));
/* 137 */         this.alfabeto.add(Character.valueOf('ç'));
/* 138 */         this.alfabeto.add(Character.valueOf('è'));
/* 139 */         this.alfabeto.add(Character.valueOf('é'));
/* 140 */         this.alfabeto.add(Character.valueOf('ê'));
/* 141 */         this.alfabeto.add(Character.valueOf('ë'));
/* 142 */         this.alfabeto.add(Character.valueOf('ì'));
/* 143 */         this.alfabeto.add(Character.valueOf('í'));
/* 144 */         this.alfabeto.add(Character.valueOf('î'));
/* 145 */         this.alfabeto.add(Character.valueOf('ï'));
/* 146 */         this.alfabeto.add(Character.valueOf('ð'));
/* 147 */         this.alfabeto.add(Character.valueOf('ñ'));
/* 148 */         this.alfabeto.add(Character.valueOf('ò'));
/* 149 */         this.alfabeto.add(Character.valueOf('ó'));
/* 150 */         this.alfabeto.add(Character.valueOf('ô'));
/* 151 */         this.alfabeto.add(Character.valueOf('õ'));
/* 152 */         this.alfabeto.add(Character.valueOf('ö'));
/* 153 */         this.alfabeto.add(Character.valueOf('÷'));
/* 154 */         this.alfabeto.add(Character.valueOf('ø'));
/* 155 */         this.alfabeto.add(Character.valueOf('ù'));
/* 156 */         this.alfabeto.add(Character.valueOf('ú'));
/* 157 */         this.alfabeto.add(Character.valueOf('û'));
/* 158 */         this.alfabeto.add(Character.valueOf('ü'));
/* 159 */         this.alfabeto.add(Character.valueOf('ý'));
/* 160 */         this.alfabeto.add(Character.valueOf('þ'));
/* 161 */         this.alfabeto.add(Character.valueOf('ÿ'));
/*     */         break;
/*     */       case 255:
/* 165 */         for (i = 32; i < 127; i++)
/* 166 */           this.alfabeto.add(Character.valueOf((char)i)); 
/* 168 */         this.alfabeto.add(Character.valueOf('⌂'));
/* 169 */         this.alfabeto.add(Character.valueOf('Ç'));
/* 170 */         this.alfabeto.add(Character.valueOf('ü'));
/* 171 */         this.alfabeto.add(Character.valueOf('é'));
/* 172 */         this.alfabeto.add(Character.valueOf('â'));
/* 173 */         this.alfabeto.add(Character.valueOf('ä'));
/* 174 */         this.alfabeto.add(Character.valueOf('à'));
/* 175 */         this.alfabeto.add(Character.valueOf('å'));
/* 176 */         this.alfabeto.add(Character.valueOf('ç'));
/* 177 */         this.alfabeto.add(Character.valueOf('ê'));
/* 178 */         this.alfabeto.add(Character.valueOf('ë'));
/* 179 */         this.alfabeto.add(Character.valueOf('è'));
/* 180 */         this.alfabeto.add(Character.valueOf('ï'));
/* 181 */         this.alfabeto.add(Character.valueOf('î'));
/* 182 */         this.alfabeto.add(Character.valueOf('ì'));
/* 183 */         this.alfabeto.add(Character.valueOf('Ä'));
/* 184 */         this.alfabeto.add(Character.valueOf('Å'));
/* 185 */         this.alfabeto.add(Character.valueOf('É'));
/* 186 */         this.alfabeto.add(Character.valueOf('æ'));
/* 187 */         this.alfabeto.add(Character.valueOf('Æ'));
/* 188 */         this.alfabeto.add(Character.valueOf('ô'));
/* 189 */         this.alfabeto.add(Character.valueOf('ö'));
/* 190 */         this.alfabeto.add(Character.valueOf('ò'));
/* 191 */         this.alfabeto.add(Character.valueOf('û'));
/* 192 */         this.alfabeto.add(Character.valueOf('ù'));
/* 193 */         this.alfabeto.add(Character.valueOf('ÿ'));
/* 194 */         this.alfabeto.add(Character.valueOf('Ö'));
/* 195 */         this.alfabeto.add(Character.valueOf('Ü'));
/* 196 */         this.alfabeto.add(Character.valueOf('ø'));
/* 197 */         this.alfabeto.add(Character.valueOf('£'));
/* 198 */         this.alfabeto.add(Character.valueOf('Ø'));
/* 199 */         this.alfabeto.add(Character.valueOf('×'));
/* 200 */         this.alfabeto.add(Character.valueOf('ƒ'));
/* 201 */         this.alfabeto.add(Character.valueOf('á'));
/* 202 */         this.alfabeto.add(Character.valueOf('í'));
/* 203 */         this.alfabeto.add(Character.valueOf('ó'));
/* 204 */         this.alfabeto.add(Character.valueOf('ú'));
/* 205 */         this.alfabeto.add(Character.valueOf('ñ'));
/* 206 */         this.alfabeto.add(Character.valueOf('Ñ'));
/* 207 */         this.alfabeto.add(Character.valueOf('ª'));
/* 208 */         this.alfabeto.add(Character.valueOf('º'));
/* 209 */         this.alfabeto.add(Character.valueOf('¿'));
/* 210 */         this.alfabeto.add(Character.valueOf('®'));
/* 211 */         this.alfabeto.add(Character.valueOf('¬'));
/* 212 */         this.alfabeto.add(Character.valueOf('½'));
/* 213 */         this.alfabeto.add(Character.valueOf('¼'));
/* 214 */         this.alfabeto.add(Character.valueOf('¡'));
/* 215 */         this.alfabeto.add(Character.valueOf('«'));
/* 216 */         this.alfabeto.add(Character.valueOf('»'));
/* 217 */         this.alfabeto.add(Character.valueOf('░'));
/* 218 */         this.alfabeto.add(Character.valueOf('▒'));
/* 219 */         this.alfabeto.add(Character.valueOf('▓'));
/* 220 */         this.alfabeto.add(Character.valueOf('│'));
/* 221 */         this.alfabeto.add(Character.valueOf('┤'));
/* 222 */         this.alfabeto.add(Character.valueOf('Á'));
/* 223 */         this.alfabeto.add(Character.valueOf('Â'));
/* 224 */         this.alfabeto.add(Character.valueOf('À'));
/* 225 */         this.alfabeto.add(Character.valueOf('©'));
/* 226 */         this.alfabeto.add(Character.valueOf('╣'));
/* 227 */         this.alfabeto.add(Character.valueOf('║'));
/* 228 */         this.alfabeto.add(Character.valueOf('╗'));
/* 229 */         this.alfabeto.add(Character.valueOf('╝'));
/* 230 */         this.alfabeto.add(Character.valueOf('¢'));
/* 231 */         this.alfabeto.add(Character.valueOf('¥'));
/* 232 */         this.alfabeto.add(Character.valueOf('┐'));
/* 233 */         this.alfabeto.add(Character.valueOf('└'));
/* 234 */         this.alfabeto.add(Character.valueOf('┴'));
/* 235 */         this.alfabeto.add(Character.valueOf('┬'));
/* 236 */         this.alfabeto.add(Character.valueOf('├'));
/* 237 */         this.alfabeto.add(Character.valueOf('─'));
/* 238 */         this.alfabeto.add(Character.valueOf('┼'));
/* 239 */         this.alfabeto.add(Character.valueOf('╞'));
/* 240 */         this.alfabeto.add(Character.valueOf('Ã'));
/* 241 */         this.alfabeto.add(Character.valueOf('╚'));
/* 242 */         this.alfabeto.add(Character.valueOf('╔'));
/* 243 */         this.alfabeto.add(Character.valueOf('╩'));
/* 244 */         this.alfabeto.add(Character.valueOf('╦'));
/* 245 */         this.alfabeto.add(Character.valueOf('╠'));
/* 246 */         this.alfabeto.add(Character.valueOf('═'));
/* 247 */         this.alfabeto.add(Character.valueOf('╬'));
/* 248 */         this.alfabeto.add(Character.valueOf('¤'));
/* 249 */         this.alfabeto.add(Character.valueOf('ð'));
/* 250 */         this.alfabeto.add(Character.valueOf('Ð'));
/* 251 */         this.alfabeto.add(Character.valueOf('Ê'));
/* 252 */         this.alfabeto.add(Character.valueOf('Ë'));
/* 253 */         this.alfabeto.add(Character.valueOf('È'));
/* 254 */         this.alfabeto.add(Character.valueOf('ı'));
/* 255 */         this.alfabeto.add(Character.valueOf('Í'));
/* 256 */         this.alfabeto.add(Character.valueOf('Î'));
/* 257 */         this.alfabeto.add(Character.valueOf('Ï'));
/* 258 */         this.alfabeto.add(Character.valueOf('┘'));
/* 259 */         this.alfabeto.add(Character.valueOf('┌'));
/* 260 */         this.alfabeto.add(Character.valueOf('█'));
/* 261 */         this.alfabeto.add(Character.valueOf('▄'));
/* 262 */         this.alfabeto.add(Character.valueOf('¦'));
/* 263 */         this.alfabeto.add(Character.valueOf('Ì'));
/* 264 */         this.alfabeto.add(Character.valueOf('▀'));
/* 265 */         this.alfabeto.add(Character.valueOf('Ó'));
/* 266 */         this.alfabeto.add(Character.valueOf('ß'));
/* 267 */         this.alfabeto.add(Character.valueOf('Ô'));
/* 268 */         this.alfabeto.add(Character.valueOf('Ò'));
/* 269 */         this.alfabeto.add(Character.valueOf('õ'));
/* 270 */         this.alfabeto.add(Character.valueOf('Õ'));
/* 271 */         this.alfabeto.add(Character.valueOf('µ'));
/* 272 */         this.alfabeto.add(Character.valueOf('þ'));
/* 273 */         this.alfabeto.add(Character.valueOf('Þ'));
/* 274 */         this.alfabeto.add(Character.valueOf('Ú'));
/* 275 */         this.alfabeto.add(Character.valueOf('Û'));
/* 276 */         this.alfabeto.add(Character.valueOf('Ù'));
/* 277 */         this.alfabeto.add(Character.valueOf('ý'));
/* 278 */         this.alfabeto.add(Character.valueOf('Ý'));
/* 279 */         this.alfabeto.add(Character.valueOf('¯'));
/* 280 */         this.alfabeto.add(Character.valueOf('´'));
/* 281 */         this.alfabeto.add(Character.valueOf('­'));
/* 282 */         this.alfabeto.add(Character.valueOf('±'));
/* 283 */         this.alfabeto.add(Character.valueOf('‗'));
/* 284 */         this.alfabeto.add(Character.valueOf('¾'));
/* 285 */         this.alfabeto.add(Character.valueOf('¶'));
/* 286 */         this.alfabeto.add(Character.valueOf('§'));
/* 287 */         this.alfabeto.add(Character.valueOf('÷'));
/* 288 */         this.alfabeto.add(Character.valueOf('¸'));
/* 289 */         this.alfabeto.add(Character.valueOf('°'));
/* 290 */         this.alfabeto.add(Character.valueOf('¨'));
/* 291 */         this.alfabeto.add(Character.valueOf('·'));
/* 292 */         this.alfabeto.add(Character.valueOf('¹'));
/* 293 */         this.alfabeto.add(Character.valueOf('³'));
/* 294 */         this.alfabeto.add(Character.valueOf('²'));
/* 295 */         this.alfabeto.add(Character.valueOf('■'));
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int size() {
/* 301 */     return this.alfabeto.size();
/*     */   }
/*     */   
/*     */   public char get(int i) {
/* 305 */     return ((Character)this.alfabeto.get(i)).charValue();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 310 */     String aux = "";
/* 311 */     for (int i = 0; i < this.alfabeto.size(); i++)
/* 313 */       aux = aux + this.alfabeto.get(i) + "|"; 
/* 315 */     return aux;
/*     */   }
/*     */   
/*     */   public String toRegularExpresion() {
/* 319 */     String aux = "";
/* 320 */     for (int i = 0; i < this.alfabeto.size() - 1; i++)
/* 321 */       aux = aux + this.alfabeto.get(i) + "|"; 
/* 323 */     aux = aux + this.alfabeto.get(this.alfabeto.size() - 1);
/* 324 */     return aux;
/*     */   }
/*     */   
/*     */   public void add(char charAt) {
/* 328 */     this.alfabeto.add(Character.valueOf(charAt));
/*     */   }
/*     */   
/*     */   public int indexOf(char charAt) {
/* 332 */     return this.alfabeto.indexOf(Character.valueOf(charAt));
/*     */   }
/*     */   
/*     */   public ArrayList<Character> toList() {
/* 336 */     ArrayList<Character> lista = new ArrayList<>();
/* 337 */     for (int i = 0; i < this.alfabeto.size(); i++)
/* 338 */       lista.add(this.alfabeto.get(i)); 
/* 340 */     return lista;
/*     */   }
/*     */   
/*     */   public boolean contains(char letra) {
/* 344 */     return this.alfabeto.contains(Character.valueOf(letra));
/*     */   }
/*     */   
/*     */   public String[] toArray() {
/* 348 */     String[] aux = new String[this.z];
/* 349 */     for (int i = 0; i < this.z; i++)
/* 350 */       aux[i] = (new StringBuilder()).append(this.alfabeto.get(i)).append("").toString(); 
/* 352 */     return aux;
/*     */   }
/*     */   
/*     */   public String prepararTexto(String texto) {
/* 357 */     String aux = texto;
/* 358 */     switch (this.z) {
/*     */       case 26:
/*     */       case 27:
/*     */       case 36:
/*     */       case 37:
/* 363 */         aux = aux.toUpperCase();
/* 364 */         correccionVocales(aux);
/*     */         break;
/*     */       case 191:
/* 367 */         aux = texto;
/*     */         break;
/*     */       default:
/* 370 */         aux = texto;
/*     */         break;
/*     */     } 
/* 373 */     aux = eliminacionCarNoVisibles(aux);
/* 375 */     Pattern p = Pattern.compile("[^" + toRegularExpresion() + "]");
/* 376 */     Matcher m = p.matcher(aux);
/* 377 */     if (m.find()) {
/* 378 */       System.err.println("Alfabetos->prepararTexto: no se cumple" + m);
/* 379 */       aux = m.replaceAll("");
/*     */     } 
/* 381 */     return aux;
/*     */   }
/*     */   
/*     */   private String correccionVocales(String texto) {
/* 386 */     String aux = texto.replaceAll("[Á|À|Ä|Â]", "A");
/* 387 */     aux = aux.replaceAll("[É|È|Ë|Ê]", "E");
/* 388 */     aux = aux.replaceAll("[Í|Ì|Ï|Î]", "I");
/* 389 */     aux = aux.replaceAll("[Ó|Ò|Ö|Ô]", "O");
/* 390 */     aux = aux.replaceAll("[Ú|Ù|Ü|Û]", "U");
/* 391 */     aux = aux.replaceAll("[Ý|ÿ]", "Y");
/* 392 */     return aux;
/*     */   }
/*     */   
/*     */   private String eliminacionCarNoVisibles(String texto) {
/* 397 */     String aux = texto.replaceAll(" ", "");
/* 398 */     aux = aux.replaceAll("\n", "");
/* 399 */     aux = aux.replaceAll("\t", "");
/* 400 */     aux = aux.replaceAll("\r", "");
/* 401 */     aux = aux.replaceAll("\b", "");
/* 402 */     return aux;
/*     */   }
/*     */   
/*     */   public int[][] toMatrix(String texto, int numColumnas) {
/* 407 */     int numFilas = (int)Math.ceil((texto.length() / numColumnas));
/* 408 */     int[][] matriz = new int[numFilas][numColumnas];
/* 409 */     int k = 0;
/* 410 */     for (int i = 0; i < numFilas; i++) {
/* 411 */       for (int j = 0; j < numColumnas; j++) {
/*     */         try {
/* 413 */           matriz[i][j] = this.alfabeto.indexOf(Character.valueOf(texto.charAt(k)));
/* 414 */         } catch (IndexOutOfBoundsException e) {
/* 415 */           System.err.println("ToMatrix1: No se puede hacer la matriz cuadrada, sobran/faltan elementos");
/*     */         } 
/* 417 */         k++;
/*     */       } 
/*     */     } 
/* 420 */     return matriz;
/*     */   }
/*     */   
/*     */   public int[][] toMatrix(String texto, int numFilas, int numColumnas) {
/* 425 */     int[][] matriz = new int[numFilas][numColumnas];
/* 426 */     int k = 0;
/* 427 */     if (texto.length() >= numFilas * numColumnas) {
/* 428 */       for (int i = 0; i < numFilas; i++) {
/* 429 */         for (int j = 0; j < numColumnas; j++) {
/* 430 */           matriz[i][j] = this.alfabeto.indexOf(Character.valueOf(texto.charAt(k)));
/* 431 */           k++;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 435 */       System.err.println("no se puede hacer la matriz, la longitud del texto es menor al numero de elementos necesarios para crear la matriz");
/* 436 */       int lText = texto.length();
/* 437 */       for (int i = 0; i < numFilas; i++) {
/* 438 */         for (int j = 0; j < numColumnas; j++) {
/* 439 */           if (k < lText) {
/* 440 */             matriz[i][j] = texto.charAt(k);
/*     */           } else {
/* 442 */             matriz[i][j] = this.alfabeto.indexOf(this.alfabeto.get(0));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 447 */     return matriz;
/*     */   }
/*     */   
/*     */   public char[][] toMatrix1(String texto, int numFilas, int numColumnas) {
/* 452 */     char[][] matriz = new char[numFilas][numColumnas];
/* 453 */     int k = 0;
/* 454 */     if (texto.length() >= numFilas * numColumnas) {
/* 455 */       for (int i = 0; i < numFilas; i++) {
/* 456 */         for (int j = 0; j < numColumnas; j++) {
/* 457 */           matriz[i][j] = texto.charAt(k);
/* 458 */           k++;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 462 */       System.err.println("No se puede hacer la matriz, la longitud del texto es menor al numero de elementos necesarios para crear la matriz.");
/* 464 */       int lText = texto.length();
/* 465 */       for (int i = 0; i < numFilas; i++) {
/* 466 */         for (int j = 0; j < numColumnas; j++) {
/* 467 */           if (k < lText) {
/* 468 */             matriz[i][j] = texto.charAt(k);
/*     */           } else {
/* 470 */             matriz[i][j] = ((Character)this.alfabeto.get(0)).charValue();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 475 */     return matriz;
/*     */   }
/*     */   
/*     */   public char[][] toMatrix1(String texto, int numColumnas) {
/* 479 */     int numFilas = (int)Math.ceil((texto.length() / numColumnas));
/* 480 */     char[][] matriz = new char[numFilas][numColumnas];
/* 481 */     int k = 0;
/* 482 */     if (texto.length() >= numFilas * numColumnas) {
/* 483 */       for (int i = 0; i < numFilas; i++) {
/* 484 */         for (int j = 0; j < numColumnas; j++) {
/* 485 */           matriz[i][j] = texto.charAt(k);
/* 486 */           k++;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 490 */       System.err.println("toMatrix1: ->No se puede generar la matriz, la longitud del texto es menor al numero de elementos necesarios para crear la matriz");
/*     */     } 
/* 492 */     return matriz;
/*     */   }
/*     */   
/*     */   public double getFrecuencia(char car) {
/* 497 */     return this.tabla[indexOf(car)];
/*     */   }
/*     */ }


