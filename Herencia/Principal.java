public class Principal
{
	public static void main(String arg[])
	{
		ESTUDIANTE E = new ESTUDIANTE();
		EMPLEADO Emp = new EMPLEADO();
		DOCENTE D = new DOCENTE();
		ADMINISTRATIVO A = new ADMINISTRATIVO();

		//Se invocan a los metodos de la clase persona.
		E.SetId(390893);
		E.SetNombres("Luis");
		E.SetA_Paterno("Arroyo");
		E.SetA_Materno("Nuñez");
		E.SetEdad((byte)22);
		E.SetDireccion("Flores Norte #3");
		E.SetCorreo("jl.arroyonunez@ugto.mx");
		E.SetCelular(4641196932L);
		E.SetCalificaciones(9.0f, 10.0f, 8.0f);
		E.SetPE("Ingenieria en sistemas computaciones");
		System.out.println("Registro de Estudiante: ");
		E.ShowEstudiante();

		Emp.SetId(20100);
		Emp.SetNombres("Mario");
		Emp.SetA_Paterno("Espinoza");
		Emp.SetA_Materno("Moncada");
		Emp.SetEdad((byte)40);
		Emp.SetDireccion("Desconocida");
		Emp.SetCorreo("m.ezpinozamoncada@ugto.mx");
		Emp.SetCelular(4641102032L);
		Emp.SetTipo("Docente");
		Emp.SetGrado("Ing.");
		Emp.SetDepartamento("Electronica");
		System.out.println("\nRegistro de empleado: ");
		Emp.showEmpleado();

		D.SetId(401050);
		D.SetNombres("Mario");
		D.SetA_Paterno("Piña");
		D.SetA_Materno("Moncada");
		D.SetEdad((byte)45);
		D.SetDireccion("Desconocida");
		D.SetCorreo("m.pinamoncada@ugto.mx");
		D.SetCelular(4640009012L);
		D.SetTipo("Docente");
		D.SetGrado("Dr.");
		D.SetDepartamento("Sistemas");
		D.SetCursos("Informatica", "Java");
		System.out.println("\nRegistro de docente:");
		D.ShowDocente();

		A.SetId(505050);
		A.SetNombres("Alvaro");
		A.SetA_Paterno("Garcia");
		A.SetA_Materno("Perez");
		A.SetEdad((byte)35);
		A.SetDireccion("Desconocida");
		A.SetCorreo("a.graciaperez@ugto.mx");
		A.SetCelular(4619200394L);
		A.SetTipo("ADMINISTRATIVO");
		A.SetGrado("Lic.");
		A.SetDepartamento("Inscripciones");
		System.out.println("\nRegistro de administrador:");
		A.showAdministrativo();
	}	
}