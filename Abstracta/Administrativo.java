class ADMINISTRATIVO extends EMPLEADO
{
	public ADMINISTRATIVO()
	{
		super();
		SetTipo("ADMINISTRATIVO");
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
	}
}