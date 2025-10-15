import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gestor_General gestor = new Gestor_General();
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE CITAS MÉDICAS =====");
            System.out.println("1. Registrar doctor");
            System.out.println("2. Registrar paciente");
            System.out.println("3. Registrar cita");
            System.out.println("4. Mostrar todas las citas");
            System.out.println("5. Mostrar citas por doctor");
            System.out.println("6. Mostrar citas por paciente");
            System.out.println("7. Cambiar estado de todas las citas");
            System.out.println("8. Mostrar número total de citas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Código del doctor: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre del doctor: ");
                    String nombre = sc.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = sc.nextLine();
                    System.out.print("Hora de entrada: ");
                    String horaEntrada = sc.next();
                    System.out.print("Hora de salida: ");
                    String horaSalida = sc.next();
                    gestor.agregarDoctor(codigo, nombre, especialidad, horaEntrada, horaSalida);
                }
                case 2 -> {
                    System.out.print("Código del paciente: ");
                    int codigo = sc.nextInt();
                    System.out.print("DNI del paciente (8 dígitos): ");
                    String dni = sc.next();
                    System.out.print("Edad del paciente: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre del paciente: ");
                    String nombre = sc.nextLine();
                    gestor.agregarPaciente(dni, codigo, nombre, edad);
                }
                case 3 -> {
                    if (gestor == null) break;
                    System.out.print("Código de la cita: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Código del paciente: ");
                    int codigoPac = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Código del doctor: ");
                    int codigoDoc = sc.nextInt();
                    sc.nextLine();

                    // Buscar doctor y paciente
                    Doctor doctorEncontrado = null;
                    Paciente pacienteEncontrado = null;

                    for (Doctor d : gestor.getDoctores()) {
                        if (d.getCodigo() == codigoDoc) {
                            doctorEncontrado = d;
                            break;
                        }
                    }

                    for (Paciente p : gestor.getPacientes()) {
                        if (p.getCodigo() == codigoPac) {
                            pacienteEncontrado = p;
                            break;
                        }
                    }

                    if (doctorEncontrado == null || pacienteEncontrado == null) {
                        System.out.println("Doctor o paciente no encontrado.");
                        break;
                    }

                    System.out.print("Fecha (DD/MM/AAAA): ");
                    String fecha = sc.nextLine();
                    System.out.print("Hora (HH:MM): ");
                    String hora = sc.nextLine();
                    System.out.print("Estado (pendiente / atendida / cancelada): ");
                    String estado = sc.nextLine();

                    gestor.agregarCita(codigo, pacienteEncontrado, doctorEncontrado, fecha, hora, estado);
                }
                case 4 -> gestor.mostrarCitas();
                case 5 -> gestor.mostrarCitasDoctor();
                case 6 -> gestor.mostrarCitasPaciente();
                case 7 -> {
                    System.out.print("Nuevo estado (pendiente / atendida / cancelada): ");
                    String estado = sc.nextLine();
                    gestor.cambiarEstado(estado);
                }
                case 8 -> gestor.mostrarNumeroCitas();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (opcion != 0);
    }
}
