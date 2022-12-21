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

	public void ShowInfo()
	{
		//Se requiere programar los campos necesarios.
		System.out.println("NUE: "+GetId());
		System.out.println("Tipo: "+GetTipo());
		System.out.println("Tipo: "+GetGrado());
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
		System.out.println("Departamento: "+GetDepartamento());
		System.out.println("Curso1: "+Curso1);
		System.out.println("Curso2: "+Curso2);
	}

}