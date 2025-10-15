import java.util.ArrayList;

public class Gestor_General {

    private ArrayList<Doctor> doctores;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Cita> citas;

    // Constructor
    public Gestor_General() {
        doctores = new ArrayList<>();
        pacientes = new ArrayList<>();
        citas = new ArrayList<>();
    }

    // Métodos de existencia
    public boolean codigoExistenteDoctor(int codigo) {
        for (Doctor d : doctores) {
            if (d.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean codigoDoblePaciente(int codigo) {
        for (Paciente p : pacientes) {
            if (p.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean codigoDobleCita(int codigo) {
        for (Cita c : citas) {
            if (c.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean existenteDni(String dni) {
        for (Paciente p : pacientes) {
            if (p.getDni().equalsIgnoreCase(dni)) {
                return true;
            }
        }
        return false;
    }

    public boolean existenteCita(Doctor doctor, String hora, String fecha) {
        for (Cita c : citas) {
            if (c.getDoctor().equals(doctor)
                    && c.getHora().equalsIgnoreCase(hora)
                    && c.getFecha().equalsIgnoreCase(fecha)) {
                return true;
            }
        }
        return false;
    }

    // Métodos de validación
    public boolean validarHora(String hora) {
        // Formato HH:MM (24 horas)
        return hora.matches("([01]?\\d|2[0-3]):[0-5]\\d");
    }

    public boolean validarFecha(String fecha) {
        // Formato DD/MM/AAAA
        return fecha.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public boolean validarDni(String dni) {
        // DNI con 8 dígitos
        return dni.matches("\\d{8}");
    }

    public boolean validarEstado(String estado) {
        return estado.equalsIgnoreCase("pendiente")
                || estado.equalsIgnoreCase("atendida")
                || estado.equalsIgnoreCase("cancelada");
    }

    // Método para cambiar estado
    public void cambiarEstado(String estado) {
        if (!validarEstado(estado)) {
            System.out.println("Estado no válido.");
            return;
        }
        for (Cita c : citas) {
            c.setEstado(estado);
        }
        System.out.println("Estado actualizado para todas las citas a: " + estado);
    }

    // Métodos de mostrar
    public void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }
        for (Cita c : citas) {
            System.out.println(c);
            System.out.println("---------------------");
        }
    }

    public void mostrarCitasDoctor() {
        if (doctores.isEmpty()) {
            System.out.println("No hay doctores registrados.");
            return;
        }
        for (Doctor d : doctores) {
            System.out.println("Citas del doctor: " + d.getNombre());
            for (Cita c : citas) {
                if (c.getDoctor().equals(d)) {
                    System.out.println(c);
                    System.out.println("---------------------");
                }
            }
        }
    }

    public void mostrarCitasPaciente() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        for (Paciente p : pacientes) {
            System.out.println("Citas del paciente: " + p.getNombre());
            for (Cita c : citas) {
                if (c.getPaciente().equals(p)) {
                    System.out.println(c);
                    System.out.println("---------------------");
                }
            }
        }
    }

    public void mostrarNumeroCitas() {
        System.out.println("Número total de citas registradas: " + citas.size());
    }

    // Método getters
    public ArrayList<Doctor> getDoctores() {
        return doctores;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    // Métodos de agregar
    public void agregarDoctor(int codigo, String nombre, String especialidad, String[] horario) {
        if (codigoExistenteDoctor(codigo)) {
            System.out.println("Ya existe un doctor con ese código.");
            return;
        }
        String horarioStr = String.join(", ", horario);
        Doctor nuevo = new Doctor(codigo, nombre, especialidad, horarioStr);
        doctores.add(nuevo);
        System.out.println("Doctor agregado correctamente.");
    }

    public void agregarPaciente(int dni, int codigo, String nombre, int edad) {
        String dniStr = String.valueOf(dni);
        if (codigoDoblePaciente(codigo)) {
            System.out.println("Ya existe un paciente con ese código.");
            return;
        }
        if (existenteDni(dniStr)) {
            System.out.println("El DNI ya está registrado.");
            return;
        }
        if (!validarDni(dniStr)) {
            System.out.println("DNI no válido. Debe contener 8 dígitos.");
            return;
        }
        Paciente nuevo = new Paciente(codigo, nombre, edad, dniStr);
        pacientes.add(nuevo);
        System.out.println("Paciente agregado correctamente.");
    }

    public void agregarCita(int codigo, Paciente paciente, Doctor doctor, String fecha, String hora, String estado) {
        if (codigoDobleCita(codigo)) {
            System.out.println("Ya existe una cita con ese código.");
            return;
        }
        if (existenteCita(doctor, hora, fecha)) {
            System.out.println("Ya existe una cita para ese doctor en esa fecha y hora.");
            return;
        }
        if (!validarFecha(fecha) || !validarHora(hora)) {
            System.out.println("Fecha u hora con formato incorrecto.");
            return;
        }
        if (!validarEstado(estado)) {
            System.out.println("Estado inválido (use: pendiente, atendida o cancelada).");
            return;
        }
        Cita nueva = new Cita(codigo, paciente, doctor, estado, fecha, hora);
        citas.add(nueva);
        System.out.println("Cita agregada correctamente.");
    }
}
