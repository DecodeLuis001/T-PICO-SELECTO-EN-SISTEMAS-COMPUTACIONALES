//clase creada para el manejo de productos.
//Herencia: concepto de abstractaccion.

import java.util.Scanner;

//abstract hace que la clase sea tratada como persona.
//public dado que ShowPersona sera programado por alguien mas.
public abstract class Producto
{
	private int 	Id;
	private String 	Caducidad;

	Producto() //Constructor.
	{
		Caducidad = null;
	}

	public void SetId(int Number)
	{
		Id = Number;
	}

	public void SetCaducidad(String Label)
	{
		Caducidad = Label;
	}

	//Abstraccion de un metodo que debe existir pero no se debe programar.
	public abstract void ShowInfo();

	//Metodos que permiten recuperar la informacion de los datos.
	public String GetCaducidad()
	{
		return Caducidad;
	}

	public int GetId()
	{
		return Id;
	}
}
