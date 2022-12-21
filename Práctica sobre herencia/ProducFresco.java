class ProducFresco extends Producto
{
	private String Envasado;
	private String Pais;

	ProducFresco()
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

	public void ShowProducFresco()
	{
		System.out.println("Identificador del prodcuto: "+GetId());
		showInfo();
		System.out.println("Fecha de envasado: "+Envasado);
		System.out.println("Lugar de origen: "+Pais);
	}

}