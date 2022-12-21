public class Principal
{
	public static void main(String arg[])
	{
		PFresco F = new PFresco();
		PRefrigerados R = new PRefrigerados();
		PCongelados C = new PCongelados();

		//Se invocan a los metodos de la clase persona.
			//Se invocan los metodos de la subclase PFresco.
		F.SetId(390893);
		F.SetCaducidad("11/12/2023");
		F.SetEnvasado("21/09/2021");
		F.SetPais("Rumania");
		System.out.println("\n");
		System.out.println("-----------------------------");
		System.out.println("Registro producto fresco: ");
		F.ShowInfo();

			//Se invoca a los elementos de la subclase PRefrigerado
		R.SetId(390893);
		R.SetCaducidad("21/12/2021");
		R.SetCodigo(03455607650564L);
		R.SetOrganismo("UNISEF");
		System.out.println("\n");
		System.out.println("-----------------------------");
		System.out.println("Registro producto refrigerado: ");
		R.ShowInfo();	

			//se invoca la subclase de producto congelado.
		C.SetId(390893);
		C.SetCaducidad("21/12/2021");
		C.SetTemperatura(45.5f);
		System.out.println("\n");
		System.out.println("-----------------------------");
		System.out.println("Registro producto congelado: ");
		C.ShowInfo();
		System.out.println("\n");	
	}	
}