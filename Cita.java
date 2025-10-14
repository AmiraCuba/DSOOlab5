public class Cita {
    private int codigo;
    private Paciente paciente;
    private Doctor doctor;
    private String estado;
    private String fecha;
    private String hora;

    /* Constructor general */    
    public Cita(int codigo, Paciente paciente, Doctor doctor, String estado, String fecha, String hora) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.doctor = doctor;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
    }

    /* Setters y Getters */
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    /* To String */
    @Override
    public String toString() {
        return "Cita: \nCodigo de cita:"+ codigo +"\nPaciente: "+ paciente.getNombre() +"\nDoctor: "+ doctor.getNombre() +"\nEstado de la cita: "+ estado +"\nFecha: "+ fecha +"\nHora: "+ hora;
    }
}

