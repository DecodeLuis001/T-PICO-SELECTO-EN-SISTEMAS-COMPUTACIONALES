class DOCENTE extends EMPLEADO	//Ejemplo de herencia indirecta.
{
	//Cursos impartidos
	private String Curso1;
	private String Curso2;

	public DOCENTE()
	{
		super();
		Curso1 = null;
		Curso2 = null;
		SetTipo("Docente");
	}

	public void SetCursos(String Label, String Label2)
	{
		Curso1 = Label;
		Curso2 = Label2;
	}

	public void ShowDocente()
	{
		showEmpleado();
		System.out.println("Curso1: "+Curso1);
		System.out.println("Curso2: "+Curso2);
	}

}