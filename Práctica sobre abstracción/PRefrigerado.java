class PRefrigerado extends Producto
{
	private long Codigo;
	private String Organismo;

	PRefrigerado()
	{
		super(); //Llama al construcor de la clase madre.
		Codigo = 0;
		Organismo = null;
	}

	public void SetCodigo(long Code)
	{
		Codigo = Code;
	}

	public void SetOrganismo(String Label)
	{
		Organismo = Label;
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
		System.out.println("Codigo de supervisión alimentaria: "+Codigo);
		System.out.println("Nombre del organismo que lo avala: "+Organismo);	
	}

}