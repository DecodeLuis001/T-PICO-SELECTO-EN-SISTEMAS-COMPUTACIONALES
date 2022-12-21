//implements: hace una instancia de la clase ESTUDIANTE.
import java.util.Scanner;

class PFresco implements Producto
{
	//Atrubutos que estan en persona.
	private int 	Id;
	private String 	Caducidad;
	private String 	Envasado;
	private String 	Pais;

	PFresco()
	{
		//Inicializar parametros:
		Id=0;
		Caducidad=null;
		Envasado = null;
		Pais = null;
	}

	public void SetEnvasado(String Label)
	{
		Envasado = Label;
	}

	public void SetPais(String Label)
	{
		Pais = Label;
	}

	public void ShowInfo()
	{
		System.out.println("Identificador de producto: "+GetId());
		//Aqui empieza lo que imprimia la clase persona.
		//Se invocan a los metodos que regresan la informacion.
		System.out.print("Caducidad: ");
		System.out.println(Caducidad);
		//Aqui termina 
		System.out.println("Fecha de envasado: "+Envasado);
		System.out.println("Lugar de origen: "+Pais);
	}

	public void SetId(int Number)
	{
		Id = Number;
	}

	public void SetCaducidad(String Label)
	{
		Caducidad = Label;
	}

	public void CapturaProducto()
	{
		Scanner Scanf = new Scanner(System.in);

		System.out.println("Fecha de expiración: ");
		Caducidad = Scanf.nextLine();
	}

	public String GetCaducidad()
	{
		return Caducidad;
	}

	public int GetId()
	{
		return Id;
	}

}