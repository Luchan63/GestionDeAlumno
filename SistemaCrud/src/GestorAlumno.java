import java.util.ArrayList;

public class GestorAlumno
{
    private ArrayList<Alumno> alumnos = new ArrayList<Alumno>(); //array de objeto alumno

    private int id = 1; // acumulador del id

    // metodo para agregar alumnos
    public void agregarAlumno(Alumno alumno)
    {
        alumno.setId(id++);
        alumnos.add(alumno);
    }

    // metodo para listar a los alumnos
   public ArrayList<Alumno> listarPersonas()
    {
        return alumnos;
    }

    //metodo para buscar
    public ArrayList<Alumno> buscarAlumnoPorId(int id)
    {
        ArrayList<Alumno> listaPorId = new ArrayList<Alumno>();
        for (Alumno alumno : alumnos)
        {
            if (id == alumno.getId())
            {
                listaPorId.add(alumno);
            }
        }
        return listaPorId;
    }

    // metodo para eliminar a un alumno de la base de datos
    public void eliminarAlumno(int id)
    {
        for (int i = 0; i < alumnos.size(); i++) // recorremos el array
        {
            if (alumnos.get(i).getId() == id) // buscamos si coincide el numero id
            {
                alumnos.remove(i);
                return;
            }
        }
    }

    public void actualizar(int id)
    {
        for (int i = 0; i < alumnos.size(); i++)
        {
            if (alumnos.get(i).getId() == id)
            {
                System.out.println("que quedesa actualizar del alumno ");
            }
        }
    }
}
