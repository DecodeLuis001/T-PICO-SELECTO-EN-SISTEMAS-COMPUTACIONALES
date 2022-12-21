/*Se compila usando: 
1) javac programa1.java
2) java Programa1
more: programa1.java muestra el contenido del archivo*/

//Se importa un paquete para que el programa se comunique con el teclado.
import java.util.Scanner;

//Esta es la clase principal.
class Programa1
{

	//Debe contenerse una clase tipo main
	//Siempre se debe tener public, static, void
	//void: no regresa ningun valor.
	public static void main(String argumentos[])
	{
		//creamos un objeto de clase Scanner
		Scanner Scanf = new Scanner(System.in);
		int Opcion, N, Sumatoria=0, F, fn;
		boolean Continuar = true; //Para salir del switch.

		//declaracion del menu
		do
		{
			System.out.println("Menu de opciones: ");
			System.out.println("1) Sumatoria de N numeros naturales: ");
			System.out.println("2) Factorial de un numero usando recursividad: ");
			System.out.println("3) N primeros numeros de la secuencia de Fibonacci: ");
			System.out.println("4) Raices de la ecuacion de segundo grado: ");
			System.out.println("5) Salir.");
			System.out.println("Escriba la opción: ");

			Opcion = Scanf.nextInt();
			switch(Opcion)
			{
				case 1:
					do
					{ 
						System.out.print("Escriba el numero N: ");
						N = Scanf.nextInt();

						if(N<1)
							System.out.println("Debe escribir un numero entero positivo.");
					}
					while(N<1);
					Sumatoria = Sumatoria(N);
					System.out.println("La sumatoria de los primeros: " + N + " numeros naturales es: " + Sumatoria);

					break;
				case 2:	
					do
					{
						System.out.print("Escriba el numero N: ");
						N = Scanf.nextInt();

						if(N<1)
							System.out.println("Debe escribir un numero entero positivo.");
					}
					while(N<1);
					F = Factorial(N);
					System.out.println(N+ " != " +F);
					break;
				case 3: 
					do
					{
						System.out.print("Escriba el numero N: ");
						N = Scanf.nextInt();

						if(N<1)
							System.out.println("Debe escribir un numero entero positivo.");
					}
					while(N<1);
					System.out.println("Los primeros: " +N+ " numeros de la secuencia de fibonnacci son: ");
					for(int i=0; i<N; i++)
					{
						fn = Fibonacci(i);
						System.out.print(fn+ ", ");
						Sumatoria = Sumatoria(N);
					}

					break;
				case 4: 
					double a, b, c, aux, x1, x2, x1r, x1i, x2r, x2i;

					System.out.print("Ingrese el valor de a: ");
					a=Scanf.nextFloat();
					System.out.print("Ingrese el valor de b: ");
					b=Scanf.nextFloat();
					System.out.print("Ingrese el valor de c: ");
					c=Scanf.nextFloat();

					System.out.println(a+"x^2"+b+"x"+c+"=0");

					aux = (b*b) - (4*a*c);
					if(aux < 0) //solucion compleja.
					{
						x1r = (-b) / 2*a ;
						x1i = Math.sqrt(-aux) / 2.0d*a;
						x2r = (-b) / 2*a ;
						x2i = -1*Math.sqrt(-aux) / 2.0d*a;
						System.out.println("Se tiene soluciones complejas: ");
						System.out.println("x_1r= " +x1r+ " x_1i= " +x1i);
						System.out.println("x_2r= " +x2r+ " x_2i= " +x2i);
					}
					else
					{
						x1 = (-b + Math.sqrt(aux) / 2.0d*a);
						x2 = (-b - Math.sqrt(aux) / 2.0d*a);
						System.out.println("Se tiene soluciones reales: ");
						System.out.println("x1= "+x1+"x2= "+x2);
					}
					break;
				case 5: System.out.println("Fue un placer atenderle, vuelva pronto.");
						Continuar = false;
						break;
				default: System.out.println("Opcion no valida.");
			}
		}
		while(Continuar);
	}

	//Si se quiere una funcion propia debe ser dentro de la clase pincipal.
	static int Sumatoria(int N)
	{
		int suma;

		if(N==1) return 1;
		suma = N + Sumatoria(N-1);

		return suma;
	}

	static int Factorial(int N)
	{
		int factorial;

		if(N==1) return 1;
		factorial = N * Factorial(N-1);

		return factorial;
	}

	static int Fibonacci(int N)
	{
		int fn;

		if(N==0) return 0;
		if(N==1) return 1;
		fn = Fibonacci(N-1) + Fibonacci(N-2);

		return fn;
	}
}