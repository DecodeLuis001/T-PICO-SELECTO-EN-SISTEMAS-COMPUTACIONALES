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
		System.out.print("real = \t\t");
		real = Scanf.nextFloat();
		System.out.print("imaginario = \t");
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

class MATRIZCOMPLEJA
{
	private COMPLEJO [][]Mx; //Variable de referencia.
	private int M;	//Filas
	private int N; //Columnas

	MATRIZCOMPLEJA() //Metodo constructor.
	{
		M = 0;
		N = 0;
		Mx = null;
	}

	//Constructor con parametros
	MATRIZCOMPLEJA(int Filas, int Columnas)
	{
		int i, j;
		M = Filas;
		N = Columnas;
		Mx = new COMPLEJO[M][N];

		for(i=0; i<M; i++)
		{
			for(j=0; j<N; j++)
			{
				Mx[i][j] = new COMPLEJO();
			}
		}
	}

	public void CrearMatrizCompleja(int Filas, int Columnas)
	{
		int i, j;
		M = Filas;
		N = Columnas;
		Mx = new COMPLEJO[M][N];

		for(i=0; i<M; i++)
		{
			for(j=0; j<N; j++)
			{
				Mx[i][j] = new COMPLEJO();
			}
		}
	}

	//
	public void IniciarMatrizCompleja(float real, float imaginario)
	{
		int i, j;

		if(Mx != null)
		{
			for(i=0; i<M; i++)
			{
				for(j=0; j<N; j++)
				{
					Mx[i][j].SetComplejo(real, imaginario);
				}
			}
		}
		else
		{
			System.out.println("No se puede iniciar la matriz\n");
		}
	}

	public void showMatrizCompleja()
	{
		int i, j;

		if(Mx != null)
		{
			for(i=0; i<M; i++)
			{
				System.out.println(" ");
				for(j=0; j<N; j++)
				{
					Mx[i][j].showComplejo();
					if(j != (N-1)) //Evita que la coma se imprima al final
					{
						System.out.print(" \t, ");
					}
				}
			}
		}
		else
		{
			System.out.println("No se puede mostrar la matriz\n");
		}
	}

	public void CapturaMatrizCompleja()
	{
		int i, j;

		if(Mx != null)
		{
			for(i=0; i<M; i++)
			{
				System.out.println(" ");
				for(j=0; j<N; j++)
				{
					System.out.println(" ");
					System.out.print("\t Mx["+i+"]["+j+"]: ");
					Mx[i][j].CapturaComplejo();
				}
			}
		}
		else
		{
			System.out.println("No se puede crear la matriz\n");
		}
	}

	//¿saber que funcion tiene prioridad en el programa?
	//por el numero de parametros o el tipo de ellos
	//Los parametros definen cual de las funciones se van a ejecutar.
	//La forma en hacer la llamada es como se decide.
	//Niveles para evitar confusion:
	//-->Numero de parametros.
	//-->

	//Mx[i][j]: actua como numero complejo, es el objeto complejo de la clase matriz.
	//Mx[][].suma: nvoca las funciones de la clase compleja.
    public void SumarMatrizCompleja(MATRIZCOMPLEJA A, MATRIZCOMPLEJA B) 
    {
    	int i, j;

		if( (A.M == B.M) && (A.N == B.N))
		{
	        if(Mx == null)
	        {
	        	CrearMatrizCompleja(A.M, A.N); //Si no se tiene memoria para crear la matriz. 
		    }
		    else
		    {
		    	if( (M!=A.M) && (N!=A.N))
		    	{
		    		System.out.println("No se puede alamcenar el resultado, son de dimensiones diferentes.\n");
		    		return;
		    	}
		    }

		    //Aqui se empieza con la operacion.
		    for(i = 0; i < M; i++) 
		    {
		        for(j = 0; j < N; j++) 
		        {
		            Mx[i][j].Suma(A.Mx[i][j], B.Mx[i][j]);
		        	//SUma: alamcena el resultado.
		        }
		    }  
		}
	    else
		{
			System.out.println("No se puede realizar la suma: Las dimensiones de las matrices no coincide.\n");
		}	
    }

    public void RestarMatrizCompleja(MATRIZCOMPLEJA A, MATRIZCOMPLEJA B) 
    {
    	int i, j;

		if( (A.M == B.M) && (A.N == B.N))
		{
	        if(Mx == null)
	        {
	        	CrearMatrizCompleja(A.M, A.N); //Si no se tiene memoria para crear la matriz. 
		    }
		    else
		    {
		    	if( (M!=A.M) && (N!=A.N))
		    	{
		    		System.out.println("No se puede alamcenar el resultado, son de dimensiones diferentes.\n");
		    		return;
		    	}
		    }

		    //Aqui se empieza con la operacion.
		    for(i = 0; i < M; i++) 
		    {
		        for(j = 0; j < N; j++) 
		        {
		            Mx[i][j].Resta(A.Mx[i][j], B.Mx[i][j]);
		        }
		    }
		}
	    else
		{
			System.out.println("No se puede realizar la resta: Las dimensiones de las matrices no coincide.\n");
		}	
    }

    public void MultiplicarMatrizCompleja(MATRIZCOMPLEJA A, MATRIZCOMPLEJA B) 
    {
    	int i, j, k;
    	COMPLEJO auxiliar = new COMPLEJO();

		if(A.N == B.M)
		{
	        if(Mx == null)
	        {
	        	CrearMatrizCompleja(A.M, A.N); //Si no se tiene memoria para crear la matriz. 
		    }
		    else
		    {
		    	if((M!=A.M) && (N!=B.N))
		    	{
		    		System.out.println("No se puede alamcenar el resultado, son de dimensiones diferentes.\n");
		    		return;
		    	}
		    }

		    //Aqui se empieza la multiplicacion
			for(i = 0; i < M; i++) 
			{
			    for(j = 0; j < N; j++) 
			    {
			    	for(k=0; k < A.N; k++)//Para el elemento (0,0) se debe recorrer toda la fila y toda la columna.
			    	{ 
			    		//Como el numero de columnas de a bede ser igual al numero de filas de B no importa cual colocar en el recorrido de K.
			    		//recorre columnas de A y filas de B.
			    		auxiliar.Multiplicar(A.Mx[i][k], B.Mx[k][j]);
				        Mx[i][j].Suma(auxiliar);
				        //Mx[i][j].Suma //Se encargara de hacer de acumulador.
			    	}
			    }
			}
		}
	    else
		{
			System.out.println("No se puede realizar el producto: Las dimensiones de las matrices no coincide.\n");
		}	
    }
}//Fin de clase matriz compleja

class programa7
{
	public static void main(String arg[])
	{
		Scanner Scanf = new Scanner(System.in);
		int M, N;

		//Se crea la matriz compleja
		MATRIZCOMPLEJA A; //Variable de referencia
		A = new MATRIZCOMPLEJA(); //Se asigna una nueva variable
		MATRIZCOMPLEJA B; //Variable de referencia
		B = new MATRIZCOMPLEJA();
		MATRIZCOMPLEJA C; //Variable de referencia
		C = new MATRIZCOMPLEJA();
		MATRIZCOMPLEJA P;
		P = new MATRIZCOMPLEJA();

		System.out.println("Numero de filas de la matriz A: ");
		M = Scanf.nextInt();
		System.out.println("Numero de columnas de la matriz A: ");
		N = Scanf.nextInt();

		System.out.println("");
		System.out.println("Numero de filas de la matriz B: ");
		M = Scanf.nextInt();
		System.out.println("Numero de columnas de la matriz B: ");
		N = Scanf.nextInt();

		A.CrearMatrizCompleja(M, N);
		//A.IniciarMatrizCompleja(-3,3);
		A.CapturaMatrizCompleja();
		System.out.println("");
		System.out.print("La matriz A capturada es: ");
		A.showMatrizCompleja();
		System.out.println("");

		B.CrearMatrizCompleja(M, N);
		B.CapturaMatrizCompleja();
		System.out.println("");
		System.out.print("La matriz B capturada es: ");
		B.showMatrizCompleja();
		System.out.println("");


		System.out.println("---------------------------------------------------");
		System.out.print("La suma de las matrices es: \n");
		C.SumarMatrizCompleja(A, B); //Invoca el metodo de la clase MatrizcOMPLEJA.
		C.showMatrizCompleja();
		System.out.println("");
		
		System.out.println("---------------------------------------------------");
		System.out.print("La resta de las matrices es: \n");
		C.RestarMatrizCompleja(A, B);
		C.showMatrizCompleja();
		System.out.println("");

		System.out.println("---------------------------------------------------");
		System.out.print("El producto de las matrices es: \n");
		P.MultiplicarMatrizCompleja(A, B);
		P.showMatrizCompleja();
		System.out.println("");
		
		System.out.println("");
	}
}