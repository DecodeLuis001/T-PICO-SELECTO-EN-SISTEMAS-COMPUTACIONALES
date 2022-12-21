class ProducCongelado extends Producto
{
	private float Temperatura;

	ProducCongelado()
	{
		super(); //Llama al construcor de la clase madre.
		Temperatura =- 1;
	}

	public void SetTemperatura(float temp)
	{
		Temperatura = temp;
	}

	public void ShowProducCongelado()
	{
		System.out.println("Identificador del prodcuto: "+GetId());
		showInfo();
		System.out.println("Temperatura de congelación recomendada: "+Temperatura+"ºC");
	}

}