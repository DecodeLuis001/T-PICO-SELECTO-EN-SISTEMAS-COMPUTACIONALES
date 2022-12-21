//Para poder leer el archivo
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
//Para poder generar el archivo.
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//Para poder separar los reales de imaginarios desde el txt.
import java.util.Arrays;
//Para la lectura de archivos.
import java.util.Scanner;

class COMPLEJO
{
	//Declaracion de atributos
	private float real;
	private float imaginario;

	//Metodo constructor
	public COMPLEJO() //Constructor por default.
	{
		real = 0f;
		imaginario = 0f;

		//System.out.println("Se ha ejecutado el contrsuctor por defecto");
	}
	
	//Constructor con parametros: Sirve para el metodo de comlejo multipliacion de un solo parametro.
	public COMPLEJO(float real, float imaginario)
	{
		real = real;
		imaginario = imaginario;
	}

	public void CapturaCOMPLEJOS(String Cadena)
	{
		String[] Parejas = Cadena.split("\\+"); //Aqui se busca cada una de las parejas que conforman un numero complejo.
		try 
		{
			real = Float.parseFloat(Parejas[0]);
			imaginario = Float.parseFloat(Parejas[1]);
		}
		catch(Exception ex) 
		{
			System.out.println("Error capturando la pareja compleja: " + Cadena + "en el archivo\n");
		}
	}

	//Para convertir la cadena a flotantes y posteriormente a complejos.
	@Override
	public String toString() 
	{
		if(imaginario < 0)
		{
			return String.format(real+" "+imaginario+"i"); //"%.5f+%.5fi", real, imaginario
		}
		else
		{
			return String.format(real+"+"+imaginario+"i");
		}
	}

	//Aqui se muestran los numeros complejos mostrados en la consola, en las funciones de suma, resta, multiplicacion.
	public void showComplejo()
	{
		if(imaginario < 0)
			System.out.print(real+" "+imaginario+"i");
		else
			System.out.print(real+"+"+imaginario+"i");
	}

	public COMPLEJO(String cadena) throws Exception 
	{
	    String[] tmp;
	    tmp = cadena.split("\\+");
	    this.real = Float.parseFloat(tmp[0]);
	    this.imaginario = Float.parseFloat(tmp[1]);
	}

	public void Suma(COMPLEJO w)
	{
		real = real + w.real;
		imaginario = imaginario + w.imaginario;
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
}//Fin de la clase complejo

class MATRIZCOMPLEJA
{
	private COMPLEJO [][]Mx; //Variable de referencia.
	private int M;	//Filas
	private int N; //Columnas
	private int T; //Esta variable se usara para generar el txt.
	private Scanner Lectura1;
	private COMPLEJO [][]ResultadoTXT;

	
	public MATRIZCOMPLEJA() //Metodo constructor.
	{
		M = 0;
		N = 0;
		Mx = null;
	}
	
	//Constructor con parametros
	public MATRIZCOMPLEJA(int Filas, int Columnas)
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

	public void GenerarMatriz(String archivoTXT)
	{
		int i,j;

		try
		{
			Lectura1 = new Scanner(new File(archivoTXT));

			//Lectura de filas y columnas de los archivos de texto.
			//Los dos primeros numeros deben ser las dimensiones de la matriz en formato entero.
			System.out.println("Numero de filas: ");
			M = Lectura1.nextInt();
			System.out.println(M);
			System.out.println("Numero de columnas: ");
			N = Lectura1.nextInt();
			System.out.println(N);

			//Creamos una nueva matriz con las filas y columnas capturadas
			Mx = new COMPLEJO[M][N];
			for (i = 0; i < M; i++)
			{
				for (j = 0; j < N; j++)
				{
					Mx[i][j] = new COMPLEJO();
				}
			}

			//-->Aqui se vuelve a leer el archivo para generar las matrices internamente en el programa.
			BufferedReader br = new BufferedReader(new FileReader(archivoTXT));
			//Leemos los dos primero enteros del archivo.
				//Aqui se toma el valor de referencia para las filas.
			String linea = br.readLine();
			int M = Integer.parseInt(linea);
			//System.out.println(M);
				//Aqui se toma el valor de referencia para las columnas.
			linea = br.readLine();
			int N = Integer.parseInt(linea);

			for(i = 0; i < M; i++)
			{
				linea = br.readLine();
				if (linea == null) 
				{
					System.out.println("Error: El archivo no contiene suficientes líneas para llenar la matriz con números complejos");
					break;
				}
				else
				{
					//Cada linea se compone de grupos de dos numeros flotanes.
					//El espacio en blanco es quien separa cada pareja de numeros.
					//Por lo tanto al separar mediante espacios almacenamos en un arreglo para utilizar cada pareja individualemnte.
					String[] Parejas = linea.split(" ");
					//Cada pareja sirve para construir un numero complejo por fila, pero...
					//Si hubieran menos parejas (numeros complejos) que columnas, no se contruir la matriz, por lo que queda incompleta.
					if(Parejas.length < N)
					{
						System.out.println("Error: Esta línea no contiene suficientes valores, la matriz no se puede generar.");
						break;
					}

					/*
					Se crean numeros complejos con los datos de las parejas obtenidas.
					Sin embargo se pone un alto al programa si los limites de las columnas o filas de una u otra matriz no coinciden, pues de esta forma no se puede realizar la multipliacion.
					*/
					int limite = Parejas.length<=N?Parejas.length:N;
						
					for(j = 0; j < limite; j++)
					{
						Mx[i][j].CapturaCOMPLEJOS(Parejas[j]);
					}
				}
			}
		}
		catch(NumberFormatException nfe) 
		{
			System.out.println("Error no se puede convertir de Cadena a entero correctamente; un valor en el arhcivo es incompatible.\n");
			System.out.println(nfe.getLocalizedMessage());
		}
		catch(Exception ex) 
		{
			System.out.println("Error leyendo archivo: " + archivoTXT);
			System.out.println(ex.getLocalizedMessage());
		}
	}

	//Aqui se lee la matriz compleja.
	public void LecturaTXT(String archivoTXT)
	{
		int i,j;

		try
		{
			BufferedReader br = new BufferedReader(new FileReader(archivoTXT));
			//Leemos los dos primero enteros del archivo.
				//Aqui se toma el valor de referencia para las filas.
			String linea = br.readLine();
			int filas = Integer.parseInt(linea);
				//Aqui se toma el valor de referencia para las columnas.
			linea = br.readLine();
			int columnas = Integer.parseInt(linea);

			//Creamos una nueva matriz con las filas y columnas capturadas
			Mx = new COMPLEJO[filas][columnas];
			for (i = 0; i < filas; i++)
			{
				for (j = 0; j < columnas; j++)
				{
					Mx[i][j] = new COMPLEJO();
				}
			}

			for(i = 0; i < filas; i++)
			{
				linea = br.readLine();
				if (linea == null) 
				{
					System.out.println("Error: El archivo no contiene suficientes líneas para llenar la matriz con números complejos");
					break;
				}
				else
				{
					//Cada linea se compone de grupos de dos numeros flotanes.
					//El espacio en blanco es quien separa cada pareja de numeros.
					//Por lo tanto al separar mediante espacios almacenamos en un arreglo para utilizar cada pareja individualemnte.
					String[] Parejas = linea.split(" ");
					//Cada pareja sirve para construir un numero complejo por fila, pero...
					//Si hubieran menos parejas (numeros complejos) que columnas, no se contruir la matriz, por lo que queda incompleta.
					if(Parejas.length < columnas)
					{
						System.out.println("Error: Esta línea no contiene suficientes valores, la matriz no se puede generar.");
						break;
					}

					/*
					Se crean numeros complejos con los datos de las parejas obtenidas.
					Sin embargo se pone un alto al programa si los limites de las columnas o filas de una u otra matriz no coinciden, pues de esta forma no se puede realizar la multipliacion.
					*/
					int limite = Parejas.length<=columnas?Parejas.length:columnas;
						
					for(j = 0; j < limite; j++)
					{
						Mx[i][j].CapturaCOMPLEJOS(Parejas[j]);
					}
				}
			}
			//Cerramos el archivo, para evitar inconvenientes de memoria.
			br.close(); 

		}
		catch(NumberFormatException nfe) 
		{
			System.out.println("Error no se puede convertir de Cadena a entero correctamente; un valor en el arhcivo es incompatible.\n");
			System.out.println(nfe.getLocalizedMessage());
		}
		catch(Exception ex) 
		{
			System.out.println("Error leyendo archivo: " + archivoTXT);
			System.out.println(ex.getLocalizedMessage());
		}
	}

	@Override
	public String toString() 
	{
		if (Mx == null)
		{
			return "Matriz nula";
		}
		else 
		{
			StringBuilder texto = new StringBuilder();
			for (int f = 0; f < Mx.length; f++)
			{
				texto.append(Arrays.toString(Mx[f]) + "\n");
			}
 
			return texto.toString();
		}
	}

	//Mx[i][j]: actua como numero complejo, es el objeto complejo de la clase matriz.
	//Mx[][].suma: invoca las funciones de la clase compleja.
    public void SumarMatrizCompleja(MATRIZCOMPLEJA A, MATRIZCOMPLEJA B) 
    {
    	int i, j;

		if( (A.M == B.M) && (A.N == B.N))
		{
	        if(Mx == null)
	        {
				//Inicializamos esta matriz según dimensiones de las matrices que vamos a sumar
				M = A.M;
				N = A.N;
				Mx = new COMPLEJO[M][N];
				for (i = 0; i < M; i++)
				{
					for(j = 0; j < N; j++)
					{
						Mx[i][j] = new COMPLEJO();
					}
				}
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
		            //System.out.println(Mx[i][j]);
		        	//Suma: alamcena el resultado.
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
	        	//Inicializamos esta matriz según dimensiones de las matrices que vamos a sumar
				M = A.M;
				N = A.N;
				Mx = new COMPLEJO[M][N];
				for (i = 0; i < M; i++)
				{
					for(j = 0; j < N; j++)
					{
						Mx[i][j] = new COMPLEJO();
					}
				}
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
	        	//Inicializamos esta matriz según dimensiones de las matrices que vamos a sumar
				M = A.M;
				N = A.N;
				Mx = new COMPLEJO[M][N];
				for (i = 0; i < M; i++)
				{
					for(j = 0; j < N; j++)
					{
						Mx[i][j] = new COMPLEJO();
					}
				}
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

    public void GenerarTXT() 
    {
		try 
		{
			FileWriter w = new FileWriter("ResultadosMatrices.txt");
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);

			for(int i=0; i<M; i++)
			{
				String temLinea = " ";
				for(int j=0; j<N; j++)
				{
					if(j != (N-1)) //Evita que la coma se imprima al final
					{
						temLinea += Mx[i][j] +"\t ";
					}
				}
				wr.println(temLinea);
			}
			
			wr.close();
			bw.close();
		} 
		catch (IOException ex)
		{
			System.out.println("Se ha producido un error que impide generar el archivo\n");
		}
	}
}//Fin de clase matriz compleja

public class practica4
{
	public static void main(String arg[]) throws Exception
	{

		//Se crea la matriz compleja
		MATRIZCOMPLEJA A; //Variable de referencia
		A = new MATRIZCOMPLEJA(); //Se asigna una nueva variable
		MATRIZCOMPLEJA B; //Variable de referencia
		B = new MATRIZCOMPLEJA();
		MATRIZCOMPLEJA S; //Variable de referencia
		S = new MATRIZCOMPLEJA();
		MATRIZCOMPLEJA R; //Variable de referencia
		R = new MATRIZCOMPLEJA();
		MATRIZCOMPLEJA P; //Variable de referencia
		P = new MATRIZCOMPLEJA();

		//Considere que dentro del archivo txt no debe tener un i el numero que es imaginario.
		System.out.println("::::::::::::::::Dimensiones de la matriz A::::::::::::::::::::::::");
		A.GenerarMatriz("matriz1.txt");
		System.out.println("::::::::::::::::Dimensiones de la matriz B::::::::::::::::::::::::");
		B.GenerarMatriz("matriz2.txt");

		//Para mostrar los datos de las matrices en los txt en la consola hacia el usuario.
		A.LecturaTXT("matriz1.txt");
		B.LecturaTXT("matriz2.txt");

 		System.out.println("");
		System.out.println("\t\t\t\t\t ::::::::::::::::Matriz A::::::::::::::::::::::");
		System.out.println(A);
		System.out.println("\t\t\t\t\t ::::::::::::::::Matriz B::::::::::::::::::::::");
		System.out.println(B);

		System.out.println("\t\t\t\t\t -----------------------------------------------------------------------------");
		System.out.print("\t\t\t\t\t\t\t\t\t   La suma de las matrices es: \n");
		S.SumarMatrizCompleja(A, B);
		S.showMatrizCompleja();
		System.out.println();
		System.out.println("");
		
		System.out.println("\t\t\t\t\t -----------------------------------------------------------------------------");
		System.out.print("\t\t\t\t\t\t\t\t\t   La resta de las matrices es: \n");
		R.RestarMatrizCompleja(A, B);
		R.showMatrizCompleja();
		System.out.println("");

		System.out.println("\t\t\t\t\t ---------------------------------------------------------------------------------");
		System.out.print("\t\t\t\t\t\t\t\t\t   El producto de las matrices es: \n");
		P.MultiplicarMatrizCompleja(A, B);
		P.showMatrizCompleja();
		System.out.println("");

		//No usar las tres a la vez o los datos del txt se sobre-escribiran
		//S.GenerarTXT();   //Resultdos de la suma
		//R.GenerarTXT();	//Resultados de la resta.
		P.GenerarTXT();	//Resultado de la multiplicacion.
		
		System.out.println("");
	}
}