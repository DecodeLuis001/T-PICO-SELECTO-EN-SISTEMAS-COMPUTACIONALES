import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class Agenda 
{
    public static void main(String[] args)
    {
        Scanner option = new Scanner(System.in);
        boolean exit = false;
        int inciso;

        Registro RegistroPersonas = new Registro(100);
        String Nombre;
        String APaterno;
        String AMaterno;
        float Estatura;
        long Telefono;
        String Correo;

        Persona Nuevo;

        while(!exit)
        {
            System.out.println("1. Agregar Registro.");
            System.out.println("2. Eliminar Registro.");
            System.out.println("3. Mostrar Registro.");
            System.out.println("4. Mostrar todos los Registro.");
            System.out.println("5. Buscar Registro.");
            System.out.println("6. Imprimir Registro (txt).");
            System.out.println("7. Recuperar Registro (txt).");
            System.out.println("8. Salir.");
            try 
            {
                System.out.println("Escribe la opcion que quieres: \n");
                inciso = option.nextInt();

                switch(inciso)
                {
                    case 1:
                        System.out.println("Agrega al nuevo usuario. \n");

                        System.out.println("Escribe el nombre: ");
                        Nombre = option.next();

                        System.out.println("Escribe el apellido paterno: ");
                        APaterno = option.next();

                        System.out.println("Escribe el apellido materno: ");
                        AMaterno = option.next();

                        System.out.println("Escribe la estatura: ");
                        Estatura = option.nextFloat();

                        System.out.println("Escribe el telefono: ");
                        Telefono = option.nextLong();
                        
                        System.out.println("Escribe el correo electronico: ");
                        Correo= option.next();

                        Nuevo = new Persona(Nombre, APaterno, AMaterno, Estatura, Telefono, Correo);

                        RegistroPersonas.AgregarPersona(Nuevo);
                        break;
                    case 2:
                        System.out.println("Escribe el nombre: ");
                        Nombre = option.next();
                        System.out.println("Escribe el apellido paterno: ");
                        APaterno = option.next();
                        System.out.println("Escribe el apellido materno: ");
                        AMaterno = option.next();
                        System.out.println("Escribe el correo: ");
                        Correo = option.next();

                        Nuevo = new Persona(Nombre, APaterno, AMaterno, 0, 0, Correo);

                        RegistroPersonas.EliminarPersona(Nuevo);
                        break;
                    case 3:
                        System.out.println("Escribe el nombre: ");
                        Nombre = option.next();

                        RegistroPersonas.ListarPersona(Nombre);
                        break;
                    case 4:
                        System.out.println("Desea Restaurar o Listar Registro?: ");
                        System.out.println("-------> L: Listar registro: ");
                        System.out.println("-------> R: Restaurar registro: ");

                        Scanner entrada = new Scanner(System.in);

                        System.out.println("Eliga: L o R para realizar la accion.");
                        String opc = entrada.next();

                        if (opc.equals("R") || opc.equals("r")) 
                        { 
                            RegistroPersonas.Restaurar("/Users/luisnunez./desktop/agenda/RegistroRecover.txt");
                        }
                        else
                        {
                            RegistroPersonas.ListarPersonas();
                        }
                        break;
                    case 5:
                        System.out.println("Escribe el nombre: ");
                        Nombre = option.next();

                        RegistroPersonas.BuscarPersona(Nombre);
                        break;
                    case 6:
                        RegistroPersonas.Recover();
                        break;
                    case 7:
                        System.out.println("Estos son los registros encontrados en el archvio de texto: ");
                        System.out.println("************************************************************");
                        RegistroPersonas.Restaurar("/Users/luisnunez./desktop/agenda/RegistroRecover.txt");
                        System.out.println("************************************************************");
                        break;
                    case 8:
                        exit = true;
                        break;
                    case 9:
                        System.out.println("Las opciones disponibles solo contemplan entre 1 y 8.\n");
                        break;
                }
            } 
            catch (Exception e) 
            {
                System.out.println("Debes insertar un numero: \n");
                option.next();
            }
        }
    } 
}
