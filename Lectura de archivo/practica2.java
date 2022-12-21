import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.FileNotFoundException;

class practica2//ContadorLineasPalabras 
{
    static int palabrasTotales;
    static int lineasTotales;

    public static void main(String[] args) throws FileNotFoundException
    {
        String Cadena;
        int i, j;
        // VARIABLE PARA LLEVAR EL CONTADOR DE PALABRAS
        palabrasTotales = 0;
        
        // VARIABLE PARA LLEVAR EL CONTADOR DE LINEAS
        lineasTotales = 0;
        
        // OBJETO ARCHIVO CON LA RUTA DEL ARCHIVO A LEER
        //File archivo = new File("lista.txt");
        File archivo;

        archivo = new File("lista.txt"); //se abre y se genera el nuevo archivo.
        
        // LLAMADA AL METODO PARA CONTAR LAS PALABRAS Y LAS LINEAS
        contarPalabrasLineas(archivo);
    }
    
    // METODO QUE LEE EL ARCHIVO Y CUENTA LAS PALABRAS Y LAS LINEAS
    public static void contarPalabrasLineas(File archivo)
    {   
        String Cadena;
        int i, contador=0;
        FileReader fr = null;
        BufferedReader br;

        try 
        {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // SI EXISTE EL ARCHIVO
            if(archivo.exists())
            {
                // ABRE LECTURA
                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
                
                //Declaracion de variables de ayuda.
                String lineaLeida;
                int caracter = fr.read();
                
                // MIENTRAS LA LINEA LEIDA NO SEA NULL
                while((lineaLeida = archivoLeer.readLine()) != null) 
                {
                    System.out.println(lineaLeida);
                    
                    // CONTAMOS LAS PALABRAS DE LA LINEA
                    StringTokenizer st = new StringTokenizer(lineaLeida);
                    
                    // AUMENTA EL CONTADOR DE LINEAS Y DE PALABRAS
                    lineasTotales = lineasTotales + 1;
                    palabrasTotales = palabrasTotales + st.countTokens();

                    //Aqui se cuentan todos los caracteres.
                    while(caracter != -1)
                    {
                        if((caracter != '\n') && (caracter != '\t') && (caracter != ' ') && (caracter != '.') && (caracter != ',') && (caracter != '\r'))
                        {
                            contador++;
                        }
                        caracter = fr.read();
                    }

                    //Para imprimir las cadenas.
                    String[] words = lineaLeida.split("\\s+");
                    for (i = 0; i < words.length; i++) 
                    {
                        words[i] = words[i].replaceAll("[^\\w]", "");
                        System.out.println(words[i].length()+"\t"+words[i]);   
                    }
                    System.out.println(" ");
                }
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Numero de palabras: " + palabrasTotales);
                System.out.println("Lineas totales: " + lineasTotales);
                System.out.println("El numero de carcateres de la cadena es: " + contador);
                System.out.println("-------------------------------------------------------------------------");
                
                // CIERRA LA LECTURA
                archivoLeer.close();
            } 
            else 
            {
                System.out.println("NO EXISTE EL ARCHIVO");
            }
        } 
        catch(Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
}