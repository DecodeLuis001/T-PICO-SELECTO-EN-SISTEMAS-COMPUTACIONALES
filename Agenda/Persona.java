public class Persona
{
    private String Name;
    private String LastName1;
    private String LastName2;
    private float Stature;
    private long Phone;
    private String Email;

    public Persona(String Name, String LastName1, String LastName2, float Stature, long Phone, String Email)
    {
        this.Name = Name;
        this.LastName1 = LastName1;
        this.LastName2 = LastName2;
        this.Stature = Stature;
        this.Phone = Phone;
        this.Email = Email;
    }

    //Constructor necesario para el metodo de eliminar registro.
    public Persona(String Name, String LastName1, String LastName2, String Email)
    {
        this.Name = Name;
        this.Stature = 0;
        this.Phone = 0;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public String getLastName1()
    {
        return LastName1;
    }

    public void setLastName1(String LastName1)
    {
        this.LastName1 = LastName1;
    }

    public String getLastName2()
    {
        return LastName2;
    }

    public void setLastName2(String LastName2)
    {
        this.LastName1 = LastName2;
    }

    public float getStature()
    {
        return Stature;
    }

    public void setStature(float Stature)
    {
        this.Stature = Stature;
    }

    public long getPhone()
    {
        return Phone;
    }

    public void setPhone(long Phone)
    {
        this.Phone = Phone;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEMail(String Email)
    {
        this.Email = Email;
    }

    //En caso de que el usuario ya exista.
    public boolean Repticion(Persona Repetido)
    {
        //equalsIgnoreCase: es indistinto si el nombre es mayuscula o minisculas.
        if(this.Name.equalsIgnoreCase(Repetido.getName()))
        {
            return true;
        }

        return false;
    }

    @Override
    public String toString()
    {
        return "Nombre: " +Name+ " Apellido Paterno: " +LastName1+ " Apellido Materno: " +LastName2+ " Estatura: " +Stature+ " Telefono: " +Phone+ " E-mail: " +Email;
    }
}