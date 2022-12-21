class PCongelado extends Producto
{
	private float Temperatura;

	PCongelado()
	{
		super(); //Llama al construcor de la clase madre.
		Temperatura =- 1;
	}

	public void SetTemperatura(float temp)
	{
		Temperatura = temp;
	}

	//Declaramos el metodo que esta en la clase Producto
	//Este metodo es el metodo abstracto.
	//Este metodo es general, pero la informacion es personalizada para cada clase.
	public void ShowInfo()
	{
		System.out.println("Identificador de producto: "+GetId());
		//Aqui empieza lo que imprimia la clase producto.
		//Se invocan a los metodos que regresan la informacion.
		System.out.print("Fecha de caducidad: ");
		System.out.println(GetCaducidad());
		//Aqui termina 
		System.out.println("Temperatura de congelación recomendada: "+Temperatura+"ºC");	
	}
}