import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
public class ContadorPalabras {
 
    public static void ordenamientoArreglos(String[] palabras, int[] apariciones) {
        for (int i = palabras.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (j + 1 <= i && apariciones[j] < apariciones[j + 1]) {
                    String aux = palabras[j];
                    int iux = apariciones[j];
                    palabras[j] = palabras[j + 1];
                    apariciones[j] = apariciones[j + 1];
                    palabras[j + 1] = aux;
                    apariciones[j + 1] = iux;
                }
            }
        }
    }
 
    public static void main(String[] arg) {
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        Map<String, Integer> palabras = new HashMap();
 
        try {
            archivo = new File("C:\\lorem_ipsum.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
 
            //La variable linea será utilizada para leer el contenido del archivo linea a linea
            String linea;
            while ((linea = br.readLine()) != null) {
                //por cada linea quitamos las comas, los puntos, puntos y comas y dos puntos
                //también generamos un String [] para delimitar las palabras
                for (String palabra : linea.replace(",", "").replace(".", "").replace(";", "").replace(":", "").split(" ")) {
                    //registramos cada palabra en un mapa en donde sumamos 1 cada vez que se repite
                    palabras.put(palabra, palabras.containsKey(palabra) ? palabras.get(palabra) + 1 : 1);
                }
            }
 
            //Creamos dos arreglos para ordenarlos
            String[] arreglo_palabras = new String[palabras.size()];
            int[] arreglo_repeticiones = new int[palabras.size()];
            palabras.keySet().toArray(arreglo_palabras);
            for (int i = 0; i < arreglo_palabras.length; i++) {
                arreglo_repeticiones[i] = palabras.get(arreglo_palabras[i]);
            }
            //ordenamos los arreglos de forma desendente en base a la repetición
            //El ordenamiento responde al algoritmo de ordenamiento por burbuja
            ordenamientoArreglos(arreglo_palabras, arreglo_repeticiones);
 
            //Imprimimos el resultado
            for (int i = 0; i < arreglo_repeticiones.length; i++) {
                System.out.println(arreglo_repeticiones[i] + " " + arreglo_palabras[i]);
            }
            System.out.println("Para este archivo de entrada, la palabra " + arreglo_palabras[0] + " ocurrió " + arreglo_repeticiones[0] + " veces, " + arreglo_palabras[1] + " " + arreglo_repeticiones[1] + " veces, etc.");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace(System.out);
            }
        }
    }
}