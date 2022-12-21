class PFresco extends Producto
{
	private String Envasado;
	private String Pais;

	PFresco()
	{
		super(); //Llama al construcor de la clase madre.
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

	//Declaramos el metodo que esta en la clase Producto
	//Este metodo es el metodo abstracto.
	//Este metodo es general, pero la informacion es personalizada para cada clase.
	public void ShowInfo()
	{
		System.out.println("Identificador de producto: "+GetId());
		//Aqui empieza lo que imprimia la clase persona.
		//Se invocan a los metodos que regresan la informacion.
		System.out.print("Fecha de caducidad: ");
		System.out.println(GetCaducidad());
		//Aqui termina 
		System.out.println("Fecha de envasado: "+Envasado);
		System.out.println("Lugar de origen: "+Pais);
	}

}