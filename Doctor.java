public class Doctor {
    private int codigo;
    private String nombre, especialidad, horaEntrada, horaSalida;
    
    /* Constructor general */
    public Doctor(int codigo, String nombre, String especialidad, String horaEntrada, String horaSalida){
        this.codigo=codigo;
        this.especialidad=especialidad;
        this.horaEntrada=horaEntrada;
        this.horaSalida=horaSalida;
        this.nombre=nombre;
    } 
    
    /* Setters y Getters */
    public int getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }   
    public String getEspecialidad(){
        return especialidad;
    } 
    public String getHoraEntrada(){
        return horaEntrada;
    }
    public String getHoraSalida(){
        return horaSalida;
    }    
    public void setCodigo(int codigo){
        this.codigo=codigo;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada=horaEntrada;
    }  
    public void setHoraSalida(String horaSalida) {
        this.horaSalida=horaSalida;
    }  
    public void setEspecialidad(String especialidad){
        this.especialidad=especialidad;
    }
    
    /* to String */
    public String toString(){
        return "Nombre: "+nombre+"\nEspecialidad: "+especialidad+"\nCodigo: "+codigo+"\nHorario: "+horaEntrada+ " - "+ horaSalida;
    }
}
