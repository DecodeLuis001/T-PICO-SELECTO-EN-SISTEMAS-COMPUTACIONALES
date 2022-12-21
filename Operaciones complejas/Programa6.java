/*
Crear una clase para el manejo de los numero complejos que permita realizar las operaciones aritmeticas basicas
*/

import java.util.Scanner;

class COMPLEJO
{
	//Declaracion de atributos
	private float real;
	private float imaginario;

	//Definicion de los metodos:

	//Metodo constructor
	COMPLEJO() //Constructor por default.
	{
		real = 0;
		imaginario = 0;

		System.out.println("Se ha ejecutado el contrsuctor por defecto");
	}

	//Constructor con parametros.
	COMPLEJO(float r, float i)
	{
		real = r;
		imaginario = i;
	}

	COMPLEJO(float r)
	{
		real = r;
		imaginario = 0;
	}

	//Ingresar los datos desde el teclado
	public void CapturaComplejo()
	{
		Scanner Scanf = new Scanner(System.in);

		System.out.println(" ");
		System.out.println("real = ");
		real = Scanf.nextFloat();
		System.out.println("imaginario = ");
		imaginario = Scanf.nextFloat();
	}

	public void SetComplejo(float real_number, float imaginary_number)
	{
		real = real_number;
		imaginario = imaginary_number;
	}

	public void showComplejo()
	{
		if(imaginario < 0)
			System.out.print(real+" "+imaginario+"i");
		else
			System.out.print(real+"+"+imaginario+"i");
	}

	public void Suma(COMPLEJO w)
	{
		real = real + w.real;
		imaginario = imaginario + w.imaginario;
	}

	public void Resta(COMPLEJO w)
	{
		real = real - w.real;
		imaginario = imaginario - w.imaginario;
	}

	//METODOS CON SOBRECARGA.
	public void Suma(COMPLEJO w1, COMPLEJO w2)
	{
		real = w1.real + w2.real;
		imaginario = w1.imaginario + w2.imaginario;
	}

	public void Resta(COMPLEJO w1, COMPLEJO w2)
	{
		real = w1.real - w2.real;
		imaginario = w1.imaginario - w2.imaginario;
	}

	public COMPLEJO SumaRetornaResultado(COMPLEJO w)
	{
		COMPLEJO result = new COMPLEJO();

		real = real + w.real;
		imaginario = imaginario + w.imaginario;

		return result;
	}

	public COMPLEJO RestaRetornaResultado(COMPLEJO w)
	{
		COMPLEJO result = new COMPLEJO();

		real = real - w.real;
		imaginario = imaginario - w.imaginario;

		return result;
	}

	public void Multiplicar(COMPLEJO w) //ERRO
	{
		float aux; 
		aux = (real*w.real) - (imaginario*w.imaginario);
		imaginario = (real*w.imaginario)+(imaginario*w.real);
		real = aux;
	}

	public void Multiplicar(COMPLEJO w, COMPLEJO z)
	{
		real = (z.real*w.real) - (z.imaginario*w.imaginario);
		imaginario = (z.real*w.imaginario)+(z.imaginario*w.real);
	}

	public COMPLEJO MultiplicaRetorna(COMPLEJO w) //ERROR
	{
		COMPLEJO aux = new COMPLEJO();
		aux.real = (real*w.real) - (imaginario*w.imaginario);
		aux.imaginario = (real*w.imaginario)+(imaginario*w.real);
		return aux;
	}

	public void Division(COMPLEJO w, COMPLEJO z)
	{
		COMPLEJO conjugado = new COMPLEJO(z.real,-1*z.imaginario);
		float denominador;

		denominador = (z.real * z.real) + (z.imaginario * z.imaginario);
		conjugado.Multiplicar(w);
		real = conjugado.real / denominador;
		imaginario = conjugado.imaginario / denominador;
	}
}//Fin de la clase complejo

class programa6
{
	//Debe ser publico para poder acceder a el desde cualquier punto del programa
	public static void main(String arg[])
	{
		Scanner Scanf = new Scanner(System.in); //System.in: utiliza como entrada el teclado.

		COMPLEJO z1; //declaracion de la variable de referencia para el maenjo de un objetvo de tipo complejo.
		COMPLEJO z2;
		COMPLEJO z3;
		int Option;
		boolean NoSalir=true;

		z1 = new COMPLEJO(); //se crea el objeto y se le asigna la varibale de referencia.
		z2 = new COMPLEJO();
		z3 = new COMPLEJO();

		//z1.SetComplejo(3,5);
		//z2.SetComplejo(5,-5);

		do
		{
			System.out.println("");	
			System.out.println("Calculadora de numero complejos.\n");
			System.out.println("1) Suma.");
			System.out.println("2) Resta");
			System.out.println("3) Multiplicación");
			System.out.println("4) División");
			System.out.println("5) Salir");
			System.out.println("Operación a realizar: ");
			Option = Scanf.nextInt();

			switch(Option)
			{
				case 1: 
					System.out.println("Capture el primer numero complejo: ");
					z1.CapturaComplejo();
					System.out.println("Capture el segundo numero complejo: ");
					z2.CapturaComplejo();
					System.out.println("La suma de los datos introducidos es: ");
					z3.Suma(z1, z2);
					z3.showComplejo();
					break;
				case 2:
					System.out.println("Capture el primer numero complejo: ");
					z1.CapturaComplejo();
					System.out.println("Capture el segundo numero complejo: ");
					z2.CapturaComplejo();
					System.out.println("La resta de los datos introducidos es: ");
					z3.Resta(z1, z2);
					z3.showComplejo();
					break;
				case 3:
					System.out.println("Capture el primer numero complejo: ");
					z1.CapturaComplejo();
					System.out.println("Capture el segundo numero complejo: ");
					z2.CapturaComplejo();
					System.out.println("La Multiplicación de los datos introducidos es: ");
					z3.Multiplicar(z1, z2);
					z3.showComplejo();
					break;
				case 4:
					System.out.println("Capture el primer numero complejo: ");
					z1.CapturaComplejo();
					System.out.println("Capture el segundo numero complejo: ");
					z2.CapturaComplejo();
					System.out.println("La División de los datos introducidos es: ");
					z3.Division(z1, z2);
					z3.showComplejo();
					break;
				case 5: NoSalir = false;
					break;
				default: System.out.println("Opcion no valida.");
			}
		}while(NoSalir);

		/*
		System.out.print("");
		System.out.print("z1= ");
		z1.showComplejo();
		System.out.println("\n");
		System.out.print("z2= ");
		z2.showComplejo();
		System.out.println("\n");

		//z1.Suma(z2);
		//z3 = z1.SumaRetornaResultado(z2);
		z3.Suma(z1, z2);
		System.out.println("\n");
		System.out.print("z1 + z2 =");
		z3.showComplejo();

		//z1.Resta(z2);
		//z3 = z1.RestaRetornaResultado(z2);
		z3.Resta(z1, z2);
		System.out.println("\n");
		System.out.print("z1 - z2 =");
		z3.showComplejo();
		*/

		System.out.println("");
	}
}