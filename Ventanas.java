
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Ventanas extends JFrame{

    private Hospital hospital;
    private JButton bAgregarDoctor;
    private JButton bEliminarDoctor;
    private JButton bMostrarDoctoresEnfermeros;
    private JButton bAsignarEnfermero;
    private JButton bDesasignarEnfermero;
    private JButton bAgregarEnfermero;
    private JButton bEliminarEnfermero;
    private JButton bAgregarTurno;
    private JButton bEliminarTurno;
    private JButton bModificarTurno;
    private JButton bMostrarEnfermeros;



    public Ventanas(Hospital hospital){

        this.hospital = hospital;
        setTitle("Menú de manejo del Hospital San José");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 1));// 10 opciones, 1 columna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarBotones();
    }
    private void inicializarBotones(){

        bAgregarDoctor = new JButton("Agregar Doctor");
        bAgregarDoctor.addActionListener(e -> {
            cuadroAgregarDoctor();
        });
        add(bAgregarDoctor);

        bEliminarDoctor = new JButton("Eliminar Doctor");
        bEliminarDoctor.addActionListener(e -> {
            cuadroEliminarDoctor();
        });
        add(bEliminarDoctor);

        bMostrarDoctoresEnfermeros = new JButton("Mostrar Doctores y Enfermeros");
        bMostrarDoctoresEnfermeros.addActionListener(e -> {
            cuadroMostrarDoctoresEnfermeros();
        });
        add(bMostrarDoctoresEnfermeros);

        bAsignarEnfermero = new JButton("Asignar Enfermero a Doctor");
        bAsignarEnfermero.addActionListener(e -> {
            hospital.mostrarEnfermeros();
        });
        add(bAsignarEnfermero);

        bDesasignarEnfermero = new JButton("Desasignar Enfermero a Doctor");
        bDesasignarEnfermero.addActionListener(e -> {
            try {
                hospital.buscarEnfermero();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        add(bDesasignarEnfermero);

        bAgregarEnfermero = new JButton("Agregar Enfermero");
        bAgregarEnfermero.addActionListener(e -> {
            try {
                hospital.agregarEnfermeroAlSistema();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        add(bAgregarEnfermero);

        bEliminarEnfermero = new JButton("Eliminar Enfermero");
        bEliminarEnfermero.addActionListener(e -> {
            try {
                hospital.eliminarEnfermeroDelSistema();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        add(bEliminarEnfermero);

        bAgregarTurno = new JButton("Agregar Turno");
        bAgregarTurno.addActionListener(e -> {
            try {
                hospital.agregarTurnoAEnfermero();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        add(bAgregarTurno);

        bEliminarTurno = new JButton("Eliminar Turno");
        bEliminarTurno.addActionListener(e -> {
            try {
                hospital.eliminarTurno();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        add(bEliminarTurno);

        bModificarTurno = new JButton("Modificar Turno");
        bModificarTurno.addActionListener(e -> {
            try {
                hospital.modificarTurno();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        add(bModificarTurno);

        bMostrarEnfermeros = new JButton("Mostrar Enfermeros");
        bMostrarEnfermeros.addActionListener(e -> {
            hospital.mostrarEnfermeros();
        });
        add(bMostrarEnfermeros);


    }
    private void cuadroAgregarDoctor() {

        JTextField tfNombre = new JTextField();
        JTextField tfRut = new JTextField();
        JTextField tfEspecialidad = new JTextField();
        Object[] message = {
                "Nombre:", tfNombre,
                "RUT:", tfRut,
                "Especialidad:", tfEspecialidad,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Agregar Doctor", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                hospital.agregarDoctorAlSistema(tfNombre.getText(), tfRut.getText(), tfEspecialidad.getText());
                JOptionPane.showMessageDialog(this, "Doctor agregado exitosamente!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al agregar doctor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void cuadroEliminarDoctor(){

    }
    private void cuadroMostrarDoctoresEnfermeros() {

    }
}
