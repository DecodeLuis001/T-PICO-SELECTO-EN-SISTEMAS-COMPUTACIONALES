public class Principal
{
	public static void main(String arg[])
	{
		ProducFresco F = new ProducFresco();
		ProducRefrigerado R = new ProducRefrigerado();
		ProducCongelado C = new ProducCongelado();

		//Se invocan a los metodos de la clase producto.
			//Se invoca la subclase producto fresco.
		F.SetId(390893);
		F.SetCaducidad("21/12/2021");
		F.SetEnvasado("21/09/2021");
		F.SetPais("Japon");
		System.out.println("\n");
		System.out.println("-----------------------------");
		System.out.println("Registro producto fresco: ");
		F.ShowProducFresco();

			//se invoca la subclase de producto refrigerado.
		R.SetId(390893);
		R.SetCaducidad("21/12/2021");
		R.SetCodigo(03455607650564L);
		R.SetOrganismo("UNISEF");
		System.out.println("\n");
		System.out.println("-----------------------------");
		System.out.println("Registro producto refrigerado: ");
		R.ShowProducRefrigerado();

			//se invoca la subclase de producto congelado.
		C.SetId(390893);
		C.SetCaducidad("21/12/2021");
		C.SetTemperatura(45.5f);
		System.out.println("\n");
		System.out.println("-----------------------------");
		System.out.println("Registro producto congelado: ");
		C.ShowProducCongelado();
		System.out.println("\n");
	}	
}