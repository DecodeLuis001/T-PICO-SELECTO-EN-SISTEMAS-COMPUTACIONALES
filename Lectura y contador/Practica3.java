import java.io.File; //
import java.io.FileWriter; //
import java.io.PrintWriter;
import java.io.BufferedReader; //
import java.io.FileReader;
import java.io.IOException; //
import java.util.HashMap; //
import java.util.Map;//
import java.util.Arrays; //Solo es necesaria para la funcion de mostrar resultado.

//Explicacion del porque trycatch en las funciones de orden, mostrar original, mostrar, resultado
//por experiencia personal al momento de que el programa leia el txt se paraba o iteraba al infiito
//Solo con el try-catch se resolvio el problema para que compilara bien.

class Practica3
{	
	public static void Orden(String[] palabras, int[] apariciones) throws IOException 
	{
		//Los auxiliares:
		//entero: sirve para contar el numero de veces que se repite la palabra.
		//String: sirve para almacenar las cadenas que son iguales.
		int i, j, auxiliarConteo;
		String auxiliarCadena;

		try
		{
			for(i=0; i<palabras.length; i++) 
        	{
	            for(j=0; j<i; j++) 
	            {
	                if( (j + 1) <= i && apariciones[j] < apariciones[j + 1]) //Se hace la comparativa de cuntas veces aparecio una palabra.
	                {
	                    auxiliarCadena = palabras[j];
	                    auxiliarConteo = apariciones[j];
	                    palabras[j] = palabras[j + 1];
	                    apariciones[j] = apariciones[j + 1];
	                    palabras[j + 1] = auxiliarCadena;
	                    apariciones[j + 1] = auxiliarConteo;
	                }
	            }
        	}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		System.out.println(" ");
    }

    //Esta funcion es completamente opcional y solo la puse porque en su momento me sirvio de guia.
    public static void MostrarOriginal(String archivoLista) throws IOException 
	{
        String Original;
        FileReader fr = new FileReader(archivoLista); //Lectura del archivo
        BufferedReader br = new BufferedReader(fr);  //Evita que se pierdan los datos una vez que se esta leyendo.

        try
        {
	        while((Original = br.readLine())!=null) 
	        {
	            System.out.println(Original);
	        }
	        br.close();
	    }
	   	catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		System.out.println(" ");
    }

    public static void MostrarResultado(String[] cadenas, int[] repeticiones) throws IOException
    {
    	int i;
    	//Se imprimen los reulstados para el insiso A y B respectivamente.
    	try
    	{
 			System.out.println("------------------------------------------------------------");
 			System.out.println(" ");	
            System.out.println("Las palabras que solo se reptien una vez son: ");
            for(i = 0; i < repeticiones.length; i++) 
            {
            	if(repeticiones[i] == 1)
            	{
            		System.out.println(repeticiones[i] + "\t" + cadenas[i]);	
            	}
            }
            System.out.println("------------------------------------------------------------");

            System.out.println(" ");
            System.out.println("Las palabras con dos o mas repeticiones son: ");
            Arrays.sort(repeticiones); //Para ordenar de menor a mayor.
            for(i = 0; i < repeticiones.length; i++)
            {
            	if(repeticiones[i] >= 2)
            	{
  					System.out.println(repeticiones[i] + "\t" + cadenas[i]);
            	}
            }
        }
        catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
    }

	public static void main(String arg[]) throws IOException
	{
		int i;
		File Archivo1;
		FileReader fr = null;
        BufferedReader br;

        //Se hace un mapeo donde se vinucla la cadena con el numero de repeticiones.
        Map<String, Integer> palabras = new HashMap<String, Integer>();
        //------->NO PONER EL NOMPRE DEL MAPA CON MAYUSCULAS ORIGINA FALLO DE MEMORIA.

		try
		{
			Archivo1 = new File("lista.txt"); //se abre y se genera el nuevo archivo.

			fr = new FileReader(Archivo1);
            br = new BufferedReader(fr);

            
        	String linea; //será utilizada para leer el contenido del archivo linea a linea
            while((linea = br.readLine()) != null) 
            {
                //Como se esta recorriendo linea por linea eliminamos las posibilidades de que haya un salto de linea o un tabulador.
                //Esto con el fin de evitar que el programa considere el espacio vacio como un fallo de codigo y no muestre nada.
                for(String Palabra : linea.replace("\n", "").replace("\t", "").split(" "))
                	//forma especial de concatenacion, esto se puede considerar un filto.
                	//String Palabra funciona como una capsula cuya funcion es encapsular UNA SOLA PALABRA, mientras se va recorriendo el archivo de texto linea a linea.
                {
                	//Cada palabra debe ser registrada, este registro ira incrementando de uno en uno cada vez que se vuelva a encontrar la plabra. 
                    palabras.put(Palabra, palabras.containsKey(Palabra) ? palabras.get(Palabra) + 1 : 1); //palabras.get(Palabra) + 1 : 1 actua como un contador 1 a 1 en el registro que esta creando el mapeo.
                    //put: Inserta un par clave/valor = (Palabra / palabras) en el mapa utilizando los valores pasados como parámetros.
                    //constainskey: Método que comprueba si una clave está dada de alta en el mapa.
                    	//Debe tener un parametro de llave en este caso: "Palabra"
                    //get: muestra el valor de un atributo
                    //?: operador ternario = if{} then{} else{}
                    	//En este caso su funcionamiento es el comparar que si ya hay una clave ya existente que coincida con un atributo ambos en "Palabra", incremente en 1 en el mapeo de datos.
                }
            }

            //Se declaran dos arreglos para tener un control del orden que se esta siguiendo en base al mapeo de datos.
            //Aqui se almacenan las palabras.
        	String Palabras[];
        	Palabras = new String[palabras.size()];
        	//Aqui se cuentan las repeticiones.
        	int Repeticiones[];
        	Repeticiones = new int[palabras.size()];

        	//-------->.size(): Para saber el tamaño de una lista utilizamos este metodo.

        	//Aqui se busca en el mapeo de "palabras" un conjunto de llaves primarias (Numero de palabras que se reptien) para despues convertirlas a una lista.
        	//keySet: Devuelve un conjunto con las claves que hay en el HashMap.
        	//toArray: convierte una lista en un arreglo.
            palabras.keySet().toArray(Palabras);
            for(i = 0; i < Palabras.length; i++) 
            {
                Repeticiones[i] = palabras.get(Palabras[i]);
            }

            //Aqui se muestra la lista original.
            System.out.println(" ");
			System.out.println("La lista ingresada es: ");
			System.out.println("---------------------------------------------");
            MostrarOriginal("lista.txt");

            //Aqui se hace el orden, teniendo en cuenta que YA SE RECORRIO EL ARCHIVO.
            Orden(Palabras, Repeticiones);

            //Muestra los datos al usuario.
            MostrarResultado(Palabras, Repeticiones);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		System.out.println(" ");
	}
}