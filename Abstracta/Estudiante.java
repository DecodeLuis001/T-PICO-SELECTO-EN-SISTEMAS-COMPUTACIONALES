class ESTUDIANTE extends PERSONA
{
	private float Calificacion1;
	private float Calificacion2;
	private float Calificacion3;
	private float Promedio;
	private String PE;

	ESTUDIANTE()
	{
		super(); //Llama al construcor de la clase madre.
		Calificacion1=-1;
		Calificacion1=-1;
		Calificacion1=-1;
		Promedio=-1;
		PE = null;
	}

	public void SetNUA(int Num)
	{
		SetId(Num);
	}

	public void SetCalificaciones(float c1, float c2, float c3)
	{
		Calificacion1=c1;
		Calificacion1=c2;
		Calificacion1=c3;
		Promedio();
	}

	//Asigna el promedio correspondiente de la suma de califc.
	private void Promedio()
	{
		Promedio = (Calificacion1 + Calificacion2 + Calificacion3)/3.0f;
	}

	public void SetPE(String Label)
	{
		PE = Label;
	}

	//Declaramos el metodo que esta en la clase Persona
	//Este metodo es el metodo abstracto.
	//Este metodo es general, pero la informacion es personalizada para cada clase.
	public void ShowInfo()
	{
		System.out.println("NUA: "+GetId());
		//Aqui empieza lo que imprimia la clase persona.
		//Se invocan a los metodos que regresan la informacion.
		System.out.print("Nombre(s): ");
		System.out.println(GetNombres());
		System.out.print("Primer apellido: ");
		System.out.println(GetA_Paterno());
		System.out.print("Segundo apellido: ");
		System.out.println(GetA_Materno());
		System.out.print("Edad: ");
		System.out.println(GetEdad());
		System.out.print("Direccion: ");
		System.out.println(GetDireccion());
		System.out.print("E-mail: ");
		System.out.println(GetCorreo());
		System.out.print("Celular: ");
		System.out.println(GetCelular());
		//Aqui termina 
		System.out.println("Programa educativo: "+PE);
		System.out.println("Calificaciones: "+Calificacion1 + Calificacion2 + Calificacion3);
		System.out.println("Promedio: "+Promedio);
	}

}