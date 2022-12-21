//Se declara como abstracta para poder usar la herencia de Persona.
abstract class EMPLEADO extends PERSONA
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

	//Retornar la informacion por medio de abstraccion
	public String GetGrado()
	{
		return Grado;
	}

	public String GetDepartamento()
	{
		return Departamento;
	}

	public String GetTipo()
	{
		return Tipo;
	}

	//No se requiere de la funcion de ShowInfo pues esa es una funcion personalizable para cada clase.
}