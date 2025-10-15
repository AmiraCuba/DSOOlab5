
public class Doctor {
    
    private int codigo;
    private String nombre;
    private String especialidad;
    private String horario;
    
    public Doctor(int codigo, String nombre, String especialidad, String horario){
        this.codigo=codigo;
        this.especialidad=especialidad;
        this.horario=horario;
        this.nombre=nombre;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getEspecialidad(){
        return especialidad;
    }
    
    public String getHorario(){
        return horario;
    }
    
    public void setCodigo(int codigo){
        this.codigo=codigo;
    }

    public void setHorario(String horario) {
        this.horario=horario;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setEspecialidad(String especialidad){
        this.especialidad=especialidad;
    }
    
    public String toString(){
        return "Nombre: "+nombre+"\nEspecialidad: "+especialidad+"\nCodigo: "+codigo+"\nHorario: "+horario;
    }
}
