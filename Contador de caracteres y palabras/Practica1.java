import java.util.Scanner;

class Practica1
{
	public static void main(String arg[])
	{
		Scanner Scanf = new Scanner(System.in);

		String Cadena;
		int i, j;

		System.out.println("Escribir un mensaje: ");
		Cadena = Scanf.nextLine(); //Se captura la cadena.

		//Contador de caracteres.
		int stringLengthWithoutSpaces = Cadena.replace(" ", "").length();

		System.out.println(" ");
		//Para imprimir las cadenas.
		String[] words = Cadena.split("\\s+");
		for (i = 0; i < words.length; i++) 
		{
		    words[i] = words[i].replaceAll("[^\\w]", "");
		    System.out.println(words[i]+"\t"+words[i].length());
		}

		System.out.println(" ");
		//Para contar el total de caracteres sin espacio
        System.out.println("El numero de carcateres de la cadena es: "+stringLengthWithoutSpaces);
		//Para contar el numero de palabras
		System.out.print("El totoal de palabras es: ");
		System.out.println(Cadena.split("\\s+|\n").length);
	}
} 