class EMPLEADO extends PERSONA
{
	private String Grado;
	private String Departamento;
	private String Tipo;

	public EMPLEADO()
	{
		super();
		Grado = null;
		Departamento = null;
		Tipo = null;
	}

	public void SetNUE(int Num)
	{
		SetId(Num);
	}

	public void SetGrado(String Label)
	{
		Grado = Label;
	}

	public void SetDepartamento(String Label)
	{
		Departamento = Label;
	}

	public void SetTipo(String Label)
	{
		Tipo = Label;
	}

	public void showEmpleado()
	{
		System.out.println("ID: "+GetId());
		System.out.println("Tipo: "+Tipo);
		System.out.println("Grado: "+Grado);
		showPersona();
		System.out.println("Departamento: "+Departamento);
	}
}