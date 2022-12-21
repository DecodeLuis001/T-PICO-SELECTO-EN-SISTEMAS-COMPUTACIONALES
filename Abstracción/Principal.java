//Si una clase esta definicda como abstracta se debe usar la herencia
//Si no se quiere programar los metodos, se le agregan los datos corresponientes 
public class Principal
{
	public static void main(String arg[])
	{
		//Inicio de uso de la clase abstracta.
		//Una clase abstracta no permite la creacion de objetos.

		ESTUDIANTE E = new ESTUDIANTE();
		DOCENTE D = new DOCENTE();
		ADMINISTRATIVO A = new ADMINISTRATIVO();

		//Se invocan a los metodos de la clase persona.
		E.SetId(390893);
		E.SetNombres("\t Luis \t Prueba 1");
		E.SetA_Paterno("Arroyo");
		E.SetA_Materno("Nuñez");
		E.SetEdad((byte)22);
		E.SetDireccion("Flores Norte #3");
		E.SetCorreo("jl.arroyonunez@ugto.mx");
		E.SetCelular(4641196932L);
		E.SetCalificaciones(9.0f, 10.0f, 8.0f);
		E.SetPE("Ingenieria en sistemas computaciones");
		System.out.println("Registro de Estudiante: ");
		E.ShowInfo();

		D.SetId(401050);
		D.SetNombres("Mario \t Prueba 2");
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
		D.ShowInfo();

		A.SetId(505050);
		A.SetNombres("Alvaro \t Prueba 3");
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
		A.ShowInfo();
	}	
}