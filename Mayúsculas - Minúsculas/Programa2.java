import java.util.Scanner;

class Programa2
{
	public static void main(String arg[])
	{
		Scanner Scanf = new Scanner(System.in);

		String Cadena, Mayus, Minus;
		char Caracter;
		int i, contador=0, posicion;

		System.out.println("Escribir un mensaje: ");
		Cadena = Scanf.nextLine(); //Se captura la cadena.

		//ciclo para recorrer la cadena y contar los carcateres.
		//length: regresa la longitud de la cadena.
		System.out.println(" ");
		for(i=0; i<Cadena.length(); i++)
		{
			Caracter = Cadena.charAt(i); //Se lee el siguiente carcater.
			System.out.println(Caracter);
			contador++;
		}
		System.out.println(" ");
		System.out.println("El numero de carcateres de la cadena es: "+contador);
		Mayus = Cadena.toUpperCase();
		System.out.println("La cadena en mayusculas es: ");
		System.out.println(Mayus);
		Minus = Cadena.toLowerCase();
		System.out.println("La cadena en minusculas es: ");
		System.out.println(Minus);

		System.out.println("Escriba un carcater: ");
		Caracter = Scanf.next().charAt(0); //Obtener un carcater desde el teclado.
		posicion = Cadena.indexOf(Caracter);
		System.out.println("La primera aparicion del carcater: "+Caracter+ " es en la posicion: "+posicion);
		posicion = Cadena.lastIndexOf(Caracter);
		System.out.println("La primera aparicion del carcater: "+Caracter+ " es en la posicion: "+posicion);
	}
} 