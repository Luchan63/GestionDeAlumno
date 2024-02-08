public class Alumno
{
    private int id;
    private String nombre;
    private String apellido;
    private int numeroTelefono;
    private String email;
    private double nota1,nota2,nota3;
    private double asistencia;
    private double examenFinal;
    private double notaTotal;
    private String notaCualitativa;

    private enum califixacionCualitativa {SUSPENDIDO,APROBADO,NOTABLE,SOBRESALIENTE}

    // contructor
    public Alumno(String nombre, String apellido, int numeroTelefono,String email, double nota1, double nota2, double nota3, double asistencia, double examenFinal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefono = numeroTelefono;
        this.email = email;

        //validamos notas, asistencia y examenFinal
        if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10 || nota3 < 0 || nota3 > 10)
        {
            throw new IllegalArgumentException("Nota fuera de rango debe ser > 0 & <2");
        }

        if (asistencia < 0 || asistencia > 10)
        {
            throw new IllegalArgumentException("Asistencia fuera de rango debe ser > 0 & <2");
        }

        if (examenFinal < 0 || examenFinal > 10)
        {
            throw new IllegalArgumentException("Examen final fuera de rango debe ser > 0 & <2");
        }
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.asistencia = asistencia;
        this.examenFinal = examenFinal;
        calcularNotaFinal();
        calcularNotaCualitativa();
    }
    // get y set para el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // get y set para el apellido

    public String getApellido() {
        return apellido;
    }

    // set y get de id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // get y set de numero de telefono
    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    // get y set para el email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    // get y set para la nota1
    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        if (nota1 < 0 || nota1 > 10)
        {
            throw new IllegalArgumentException("Nota fuera de rango debe ser > 0 & <2");
        }
        this.nota1 = nota1;
        calcularNotaFinal();
        calcularNotaCualitativa();
    }

    // get y set para la nota2
    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        if (nota1 < 0 || nota1 > 10)
        {
            throw new IllegalArgumentException("Nota fuera de rango debe ser > 0 & <2");
        }
        this.nota2 = nota2;
        calcularNotaFinal();
        calcularNotaCualitativa();
    }

    // get y set para la nota3
    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
       if (nota1 < 0 || nota1 > 10)
        {
            throw new IllegalArgumentException("Nota fuera de rango debe ser > 0 & <2");
        }
        this.nota3 = nota3;
        calcularNotaFinal();
        calcularNotaCualitativa();
    }

    // set y get la asistencia
    public double getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
       if (asistencia < 0 || asistencia > 10)
        {
            throw new IllegalArgumentException("Asistencia fuera de rango debe ser > 0 & <2");
        }
        this.asistencia = asistencia;
        calcularNotaFinal();
        calcularNotaCualitativa();
    }

    // get y set para el Notasfinales
    public double getExamenFinal() {
        return examenFinal;
    }

    public void setExamenFinal(double examenFinal) {
        if (examenFinal < 0 || examenFinal >10)
        {
            throw new IllegalArgumentException("Examen final fuera de rango debe ser > 0 & <2");
        }
        this.examenFinal = examenFinal;
        calcularNotaFinal();
        calcularNotaCualitativa();
    }

    // get y set para el notaTotal
    public double getNotaTotal() {
        return notaTotal;
    }

    public void calcularNotaFinal()
    {
        this.notaTotal = (getNota1() * 0.2) + (getNota2() * 0.2) + (getNota3() * 0.2) + (getAsistencia() * 0.1) + (getExamenFinal() * 0.3);
    }

    // set y get nota cualitativa
    public String getNotaCualitativa() {
        return notaCualitativa;
    }

    public void setNotaCualitativa(String notaCualitativa) {
        this.notaCualitativa = notaCualitativa;
    }

    public void calcularNotaCualitativa()
    {
        if (this.getNotaTotal() >= 5.0 == this.getNotaTotal() < 7)
        {
            this.setNotaCualitativa("Aprobado");
        } else if (this.getNotaTotal() >= 7.0 && this.getNotaTotal() < 9.0)
        {
            this.setNotaCualitativa("Notable");
        } else if (this.getNotaTotal() >= 9 && this.getNotaTotal() <= 10)
        {
            this.setNotaCualitativa("Sobresaliente");
        } else
        {
            this.setNotaCualitativa("Suspenso");
        }
    }

    @Override
    public String toString() {
        return String.format("%-3d %-21s %-19s %-28d %-28s %-9.2f  %-9.2f %-8.2f  %-8.2f  %-15.2f  %-15.2f %s ",getId(),
                getNombre(),getApellido(),getNumeroTelefono(),getEmail(),getNota1(),getNota2(),
                getNota3(),getAsistencia(),getExamenFinal(),getNotaTotal(),getNotaCualitativa());
    }

    public String toAlumno()
    {
        return String.format(" %s %s %d %s %.2f %.2f %.2f %.2f %.2f",
                getNombre(),getApellido(),getNumeroTelefono(),getEmail(),getNota1(),getNota2(),
                getNota3(),getAsistencia(),getExamenFinal());
    }
}
