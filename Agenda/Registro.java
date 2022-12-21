//Para poder mandar los datos a un txt.
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
//Para poder leer los datos desde un txt
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Registro
{
    private Persona[] personas;
    
    //Este construcor se encarga de tener todos los datos registrados en personas.
    public Registro()
    {
        this.personas = new Persona[100];
    }

    //Contructor necesario para poder generar al usuario
        //se encarga de poner un limite a cuantos usuarios se pueden registrar.
    public Registro(int dimension)
    {
        this.personas = new Persona[dimension];
    }

    public void AgregarPersona(Persona Nuevo)
    {
        if(ExistePersonas(Nuevo))
        {
            System.out.println("El usuario ya existe.");
        }
        else if(RegistroLleno())
        {
            System.out.println("El registro esta lleno, no se admiten mas usuarios.");
        }
        else
        {
            boolean encontrado = false;                             //Valida que el nuevo usuario realemnte sea nuevo y no exista.
            for(int i=0; i<personas.length && !encontrado; i++)    //Recorremos el arreglo de las personas, siempre y cuando la persona no se haya registrado previamente.
            {
                if(personas[i] == null)
                {
                    personas[i] = Nuevo;
                    encontrado = true;
                }
            }

            if(encontrado)
            {
                System.out.println("Se ha agregado el nuevo usuario.");
            }
            else
            {
                System.out.println("No se ha agregado el nuevo usuario.");
            }
        }
    }

    public boolean ExistePersonas(Persona Nuevo)
    {
        for(int i=0; i<personas.length; i++)    //Recorremos el arreglo de las personas.
        {
            if(personas[i] == null && Nuevo.equals(personas[i]))
            {
                return true;
            }
        }
        return false;
    }

    public void ListarPersonas()
    {
        if(PosicionesLibres() == 0)
        {
            System.out.println("No hay personas registradas aun.");
        }
        else
        {
            System.out.println("La lista de los usuarios registrados es: \n");
            for(int i=0; i<personas.length; i++)    //Recorremos el arreglo de las personas.
            {
                if(personas[i] != null) //Siempre y cuando el registro no este vacio.
                {
                    System.out.println(personas[i]);
                }
            }
        }
    }

    public void Recover()
    {
        if(PosicionesLibres() == 0)
        {
            System.out.println("No hay personas registradas aun.");
        }
        else
        {   
            try 
            {
                String ruta = "/Users/luisnunez./desktop/Agenda/RegistroRecover.txt";
                File file = new File(ruta);

                // Si el archivo no existe es creado
                if (!file.exists()) 
                {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                for(int i=0; i<personas.length; i++)    //Recorremos el arreglo de las personas.
                {
                    if(personas[i] != null) //Siempre y cuando el registro no este vacio.
                    {
                        System.out.println("El archivo fue creado con exito.");
                        bw.write("--------------------------------------------------------------------------------------------------------------------------------------------------");
                        bw.write("\n");
                        bw.write("Nombre: "+personas[i].getName()+" ");
                        bw.write("Apellido Paterno: "+personas[i].getLastName1()+" ");
                        bw.write("Apellido Materno: "+personas[i].getLastName2()+" ");
                        bw.write("Estatura: "+personas[i].getStature()+" ");
                        bw.write("Celular: "+personas[i].getPhone()+" ");
                        bw.write("E-mail: "+personas[i].getEmail()+" ");
                        bw.write("\n");
                    }
                }

                bw.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }

    public void Restaurar(String archivo) throws FileNotFoundException, IOException
    {
        if(PosicionesLibres() == 0)
        {
            System.out.println("No hay personas registradas aun.");
        }
        else
        {
            String cadena;
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);

            while((cadena = b.readLine()) != null)
            {
                if((cadena = b.readLine()) != null)
                {
                    System.out.println(cadena);
                }
                else
                {
                    System.out.println("No hay datos en el archivo de texto o no ha sido encontrado.");
                }
            }
            b.close();
        }
    }

    public void ListarPersona(String Name)
    {
        if(PosicionesLibres() == 0)
        {
            System.out.println("No hay personas registradas aun.");
        }
        else
        {
            System.out.println("Datos del usuario: ");
            boolean encontrado = false;
            for(int i=0; i<personas.length && !encontrado; i++)    //Recorremos el arreglo de las personas.
            {
                //Para ignorar si el nombre esta escirto en minisuclas o mayusculas.
                if(personas[i] != null && personas[i].getName().equalsIgnoreCase(Name))
                {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Nombre: "+personas[i].getName());
                    System.out.println("Apellido Paterno: "+personas[i].getLastName1());
                    System.out.println("Apellido Materno: "+personas[i].getLastName2());
                    System.out.println("Estatura: "+personas[i].getStature());
                    System.out.println("Celular: "+personas[i].getPhone());
                    System.out.println("E-mail: "+personas[i].getEmail());
                    System.out.println("---------------------------------------------------------");
                    encontrado = true;
                }
            }

            if(!encontrado)
            {
                System.out.println("No se ha encontrado al usuario");
                System.out.println("---------------------------------------------------------");
            }
        }
    }

    public void BuscarPersona(String Name)
    {
        boolean encontrado = false;
        for(int i=0; i<personas.length && !encontrado; i++)    //Recorremos el arreglo de las personas.
        {
            //Para ignorar si el nombre esta escirto en minisuclas o mayusculas.
            if(personas[i] != null && personas[i].getName().equalsIgnoreCase(Name))
            {
                System.out.println("El usuario: "+personas[i].getName()+" se ha encontrado");
                System.out.println("---------------------------------------------------------");
                encontrado = true;
            }
        }

        if(!encontrado)
        {
            System.out.println("No se ha encontrado al usuario");
            System.out.println("---------------------------------------------------------");
        }
    }

    public boolean RegistroLleno()
    {
        for(int i=0; i<personas.length; i++)    //Recorremos el arreglo de las personas.
        {
            if(personas[i] == null)
            {
                return false;
            }
        }
        return true;
    }

    public void EliminarPersona(Persona Nuevo)
    {
        boolean encontrado = false;
        for(int i=0; i<personas.length && !encontrado; i++)    //Recorremos el arreglo de las personas.
        {
            if(personas[i] != null /*&& personas[i].equals(Nuevo)*/)
            {
                personas[i] = null;
                encontrado = true;  //Valida que se elimino el usuario.
                System.out.println("Se ha eliminado el usuario.");
            }
        }
        
        if(!encontrado)
        {
            System.out.println("No se ha encontrado al usuario, no se puede eliminar datos inexistentes.");
        }
    }

    //esta funciuon ayuda a que si hay espacio libres en el arreglo se puedan agregar nuevos usuarios.
    public int PosicionesLibres()
    {
        int Contador=0;
        for(int i=0; i<personas.length; i++)    //Recorremos el arreglo de las personas.
        {
            if(personas[i] == null)
            {
                Contador++;
            }
        }

        return Contador;
    }
}