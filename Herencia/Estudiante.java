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

	public void ShowEstudiante()
	{
		System.out.println("NUA: "+GetId());
		showPersona();
		System.out.println("Programa educativo: "+PE);
		System.out.println("Calificaciones: "+Calificacion1 + Calificacion2 + Calificacion3);
		System.out.println("Promedio: "+Promedio);
	}

}