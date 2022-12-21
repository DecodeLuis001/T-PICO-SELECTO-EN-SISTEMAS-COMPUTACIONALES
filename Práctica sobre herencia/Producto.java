import java.util.Scanner;

class Producto
{
	private int 	IdLote;
	private String 	Caducidad;

	Producto() //Constructor.
	{
		Caducidad = null;
	}

	public void SetId(int Number)
	{
		IdLote = Number;
	}

	public void SetCaducidad(String Label)
	{
		Caducidad = Label;
	}

	public void CapturaInfo()
	{
		Scanner Scanf = new Scanner(System.in);

		System.out.println("Fecha de caducidad: ");
		Caducidad = Scanf.nextLine();
	}

	public void showInfo()
	{
		Scanner Scanf = new Scanner(System.in);

		System.out.print("Fecha de caducidad: ");
		System.out.println(Caducidad);
	}

	public String GetCaducidad()
	{
		return Caducidad;
	}

	public int GetId()
	{
		return IdLote;
	}
}
