//clase creada para el manejo de personas.
//Herencia: concepto de abstractaccion.

import java.util.Scanner;

//abstract hace que la clase sea tratada como persona.
//public dado que ShowPersona sera programado por alguien mas.
public abstract class PERSONA
{
	private int 	Id;
	private String 	Nombres;
	private String 	A_Paterno;
	private String 	A_Materno;
	private byte 	Edad;
	private String 	Direccion;
	private String 	Correo;
	private long 	Celular;

	PERSONA() //Constructor.
	{
		Nombres = null;
		A_Paterno = null;
		A_Materno = null;
		Edad = 0;
		Direccion = null;
		Correo = null;
		Celular = 0;
	}

	public void SetId(int Number)
	{
		Id = Number;
	}

	public void SetNombres(String Label)
	{
		Nombres = Label;
	}

	public void SetA_Paterno(String Label)
	{
		A_Paterno = Label;
	}

	public void SetA_Materno(String Label)
	{
		A_Materno = Label;
	}

	public void SetEdad(byte NumeroAnios)
	{
		Edad = NumeroAnios;
	}

	public void SetDireccion(String Label)
	{
		Direccion = Label;
	}

	public void SetCorreo(String Label)
	{
		Correo = Label;
	}

	public void SetCelular(long Numero)
	{
		Celular = Numero;
	}

	//Captura los datos por medio de la consola o otra clase.
	public void CapturaPersona()
	{
		Scanner Scanf = new Scanner(System.in);

		System.out.println("Nombre(s): ");
		Nombres = Scanf.nextLine();
		System.out.println("Primer apellido: ");
		A_Paterno = Scanf.nextLine(); 
		System.out.println("Segundo apellido: ");
		A_Materno = Scanf.nextLine(); 
		System.out.println("Edad: ");
		Edad = Scanf.nextByte();
		System.out.println("Direccion: ");
		Direccion = Scanf.nextLine();
		Direccion = Scanf.nextLine();
		System.out.println("E-mail: ");
		Correo = Scanf.nextLine();
		System.out.println("Celular: ");
		Celular = Scanf.nextLong();
	}

	//Abstraccion de un metodo que debe existir pero no se debe programar.
	public abstract void ShowInfo();

	//Metodos que permiten recuperar la informacion de los datos.
	public String GetNombres()
	{
		return Nombres;
	}

	public String GetA_Paterno()
	{
		return A_Paterno;
	}

	public String GetA_Materno()
	{
		return A_Materno;
	}

	public byte GetEdad()
	{
		return Edad;
	}

	public String GetDireccion()
	{
		return Direccion;
	}

	public String GetCorreo()
	{
		return Correo;
	}

	public long GetCelular()
	{
		return Celular;
	}

	public int GetId()
	{
		return Id;
	}
}
