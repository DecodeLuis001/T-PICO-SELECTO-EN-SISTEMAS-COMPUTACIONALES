class ProducRefrigerado extends Producto
{
	private long Codigo;
	private String Organismo;

	ProducRefrigerado()
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

	public void ShowProducRefrigerado()
	{
		System.out.println("Identificador del prodcuto: "+GetId());
		showInfo();
		System.out.println("Codigo de supervisión alimentaria: "+Codigo);
		System.out.println("Nombre del organismo que lo avala "+Organismo);	
	}

}