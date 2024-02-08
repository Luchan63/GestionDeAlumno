import java.util.Locale;
import java.util.Scanner;

public class Main
{
    private static Scanner scanString = new Scanner(System.in);
    private static Scanner scanNumero= new Scanner(System.in).useLocale(Locale.US);
    private static GestorAlumno gestorAlumno = new GestorAlumno();

    public static void main(String[] args)
    {
    try
    {

        boolean salir = false;
        int opcion;
        do {
            menu();
            opcion = scanNumero.nextInt();

            switch (opcion)
            {
                case 1:
                    agregarAlumno();
                    break;
                case 2:
                    listarAlumnos();
                    break;
                case 3:
                    actualizarAlumno();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    buscarAlumno();
                case 9:
                    agregarEjemploAlumno();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            } //fin switch
        } while (!salir); // fin doWhile
    }// fin try
    catch (IllegalArgumentException e)
    {
        System.out.println(e.getMessage());
    } // fin catch
    }
    private static void menu()
    {
        System.out.println("Bienvenido a la base de datos de Ilerna");
        System.out.println("Que consulta desea realizar");
        System.out.println("1- Agregar alumno");
        System.out.println("2- Listar alumno");
        System.out.println("3- Actualizar alumno");
        System.out.println("4- Borrar alumno");
        System.out.println("5- Buscar alumno por id");
        System.out.println("9- Agregar ejemplo de alumnos");
        System.out.println("0- Salir");
    }
    private static void agregarAlumno()
    {
        System.out.println("========== Formulario de alumno ==========");
        System.out.println("Nombre: ");
        String nombre = scanString.nextLine();
        System.out.println("Apellido: ");
        String apellido = scanString.nextLine();
        System.out.println("Numero de telefono: ");
        int numeroTelefono = scanNumero.nextInt();
        System.out.println("Email: ");
        String email = scanString.nextLine();
        System.out.println("nota1: ");
        double nota1 = scanNumero.nextDouble();
        System.out.println("Nota2: ");
        double nota2 = scanNumero.nextDouble();
        System.out.println("Nota3");
        double nota3 = scanNumero.nextDouble();
        System.out.println("Asistencia");
        double asistencia = scanNumero.nextDouble();
        System.out.println("Finales: ");
        double finales = scanNumero.nextDouble();
        gestorAlumno.agregarAlumno(new Alumno(nombre,apellido,numeroTelefono,email,nota1,nota2,nota3,asistencia,finales));
        pausa();
    }

    private  static void listarAlumnos()
    {
        // Salida de datos con variable local
        System.out.println("\n\n          Listado de Coches");
        System.out.println("=================================================================================================================================================================================================");
        System.out.println("ID  Nombre                 Apellido           Telefono                     Email                        nota1    nota2     nota3    asistencia   examen final     Nota Final     Nota Cualitativa");
        System.out.println("=================================================================================================================================================================================================");
        for (Alumno alumno : gestorAlumno.listarPersonas())
        {
            System.out.println(alumno);
        }
        pausa();
    }

    private static void agregarEjemploAlumno()
    {
        gestorAlumno.agregarAlumno(new Alumno("Omar","Henriquez",624235698,
                "omarhenriquez@gmail.com",7,8,10,10,10));

        gestorAlumno.agregarAlumno(new Alumno("Luis","Figuereo",624235698,
                "luisfiguereo@gmail.com",7,8,10,5,5));

        gestorAlumno.agregarAlumno(new Alumno("Victoria","Leon",624235698,
                "victorialeon@gmail.com",9,8,7,4,10));

        gestorAlumno.agregarAlumno(new Alumno("Laurent","Henriquez",624235698,
                "laurenthenriquez@gmail.com",7,8,10,3,9));

        gestorAlumno.agregarAlumno(new Alumno("Ruben","Mendoza",624235698,
                "rubenmendoza@gmail.com",3,9,5,7,9));

        gestorAlumno.agregarAlumno(new Alumno("Yendi","Jael",624235698,
                "yendijael@gmail.com",8,7,10,8,6));

        gestorAlumno.agregarAlumno(new Alumno("Juan","Herrea",624235698,
                "juanherrera@gmail.com",4.3,9,3.5,4,5.5));

        gestorAlumno.agregarAlumno(new Alumno("Vitaliy","Ali",624235698,
                "vitaliyali@gmail.com",9,10,8,7,10));

        gestorAlumno.agregarAlumno(new Alumno("Gabriela","Beltramino",624235698,
                "gabrielabeltramino@gmail.com",7,5,9,6,8));

        gestorAlumno.agregarAlumno(new Alumno("Fernando","Perez",624235698,
                "fernandoperez@gmail.com",4.99,5,6.7,8,4.8));

pausa();

    }

    private static void buscarAlumno()
    {
        int numero;
        System.out.println("Que alumno desea buscar?");
        numero = scanNumero.nextInt();
        for (Alumno alumno : gestorAlumno.buscarAlumnoPorId(numero))
        {
            System.out.println("El alumno encontrado por el id es: " + alumno.toAlumno());
        }
        pausa();
    }

    private static void eliminar()
    {
        int numero;
        listarAlumnos();
        System.out.println("Que alumno desea eliminar?");
        numero = scanNumero.nextInt();
//        System.out.println("alumno eliminado con exito");
        for (Alumno alumno : gestorAlumno.buscarAlumnoPorId(numero))
        {
            System.out.println("Has seleccionado al alumno " + alumno.toAlumno());
        }
      gestorAlumno.eliminarAlumno(numero);

        pausa();

    }

    private static void actualizarAlumno()
    {

    int numero;
    listarAlumnos();
    System.out.println("Que alumno desea actualizar?");
    numero = scanNumero.nextInt();

       for (Alumno alumno : gestorAlumno.buscarAlumnoPorId(numero))
       {
           System.out.println("Has seleccionado al alumno " + alumno.toAlumno());

           System.out.println("Que deseas actualizar?");
           System.out.println("1- Nombre");
           System.out.println("2- Apellido");
           System.out.println("3- Telefono");
           System.out.println("4- Email");
           System.out.println("5- Nota1");
           System.out.println("6- Nota2");
           System.out.println("7- Nota3");
           System.out.println("8- Asistencia");
           System.out.println("9- examen final");
           int opcion = scanNumero.nextInt();

           switch (opcion)
           {
               case 1:
                   System.out.println("Cual es el nombre: ");
                   String nombre = scanString.nextLine();
                   alumno.setNombre(nombre);
                   break;
               case 2:
                   System.out.println("Cual es el apellido: ");
                   String apellido = scanString.nextLine();
                   alumno.setApellido(apellido);
                   break;
               case 3:
                   System.out.println("Cual es el numero de telefono: ");
                   int numeroTelefono = scanNumero.nextInt();
                   break;
               case 4:
                   System.out.println("Cual es el Email: ");
                   String email = scanString.nextLine();
                   alumno.setEmail(email);
                   break;
               case 5:
                   System.out.println("Cual es el nota1: ");
                   double nota1 = scanNumero.nextDouble();
                   alumno.setNota1(nota1);
                   break;
               case 6:
                   System.out.println("Cual es el nota2: ");
                   double nota2 = scanNumero.nextDouble();
                   alumno.setNota2(nota2);
                   break;
               case 7:
                   System.out.println("Cual es el nota3: ");
                    double nota3 = scanNumero.nextDouble();
                    break;
               case 8:
                   System.out.println("Cual es el asistencia: ");
                   double asistencia = scanNumero.nextDouble();
                   break;
               case 9:
                   System.out.println("Cual es el examen final: ");
                   double examenfinal = scanNumero.nextDouble();
                   break;
           }

       }

       // gestorAlumno.actualizar(numero);

    }
    private static void pausa()
    {
        System.out.println();
        System.out.println("Presione ENTER para continuar");
        scanString.nextLine();
    }
}

