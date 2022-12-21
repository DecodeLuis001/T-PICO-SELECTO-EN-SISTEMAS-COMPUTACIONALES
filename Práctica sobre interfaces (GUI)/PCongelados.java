//implements: hace una instancia de la clase ESTUDIANTE.
import java.util.Scanner;

class PCongelados implements Producto
{
	//Atrubutos que estan en persona.
	private int 	Id;
	private String 	Caducidad;
	private float Temperatura;

	PCongelados()
	{
		//Inicializar parametros:
		Id=0;
		Caducidad=null;
		Temperatura =- 1;
	}

	public void SetTemperatura(float temp)
	{
		Temperatura = temp;
	}


	public void ShowInfo()
	{
		System.out.println("Identificador de producto: "+GetId());
		//Aqui empieza lo que imprimia la clase persona.
		//Se invocan a los metodos que regresan la informacion.
		System.out.print("Caducidad: ");
		System.out.println(Caducidad);
		//Aqui termina 
		System.out.println("Temperatura de congelación recomendada: "+Temperatura+"ºC");
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