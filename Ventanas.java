
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
            asignarEnfermeroAdoctor();
        });
        add(bAsignarEnfermero);

        bDesasignarEnfermero = new JButton("Desasignar Enfermero a Doctor");
        bDesasignarEnfermero.addActionListener(e -> {
            desasignarEnfermeroAdoctor();

        });
        add(bDesasignarEnfermero);

        bAgregarEnfermero = new JButton("Agregar Enfermero");
        bAgregarEnfermero.addActionListener(e -> {
            cuadroAgregarEnfermero();
        });
        add(bAgregarEnfermero);

        bEliminarEnfermero = new JButton("Eliminar Enfermero");
        bEliminarEnfermero.addActionListener(e -> {
            cuadroElimianarEnfermero();
        });
        add(bEliminarEnfermero);

        bAgregarTurno = new JButton("Agregar Turno");
        bAgregarTurno.addActionListener(e -> {
            cuadroAgregrarTurno();
        });
        add(bAgregarTurno);

        bEliminarTurno = new JButton("Eliminar Turno");
        bEliminarTurno.addActionListener(e -> {
            cuadroEliminarTurno();
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

                if(hospital.agregarDoctorAlSistema(tfNombre.getText(), tfRut.getText(), tfEspecialidad.getText())){
                    JOptionPane.showMessageDialog(this, "Doctor agregado exitosamente!");
                }else{
                    throw new PersonalExceptions("El doctor ya está en el sistema.");
                };
            } catch (PersonalExceptions e) {
                JOptionPane.showMessageDialog(this, "Error al agregar doctor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void cuadroEliminarDoctor(){
        JTextField tfRut = new JTextField();
        Object[] message = {
                "RUT:", tfRut,
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Eliminar Doctor", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                if(hospital.eliminarDoctor(tfRut.getText())){
                    JOptionPane.showMessageDialog(this, "Doctor eliminado exitosamente!");
                }
                else{
                    throw new PersonalExceptions("El doctor no esta en el sistema.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar doctor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    private void cuadroMostrarDoctoresEnfermeros() {
        JTextArea textArea = new JTextArea(20, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setText(hospital.mostrarDoctoresYEnfermeros());
        JOptionPane.showMessageDialog(null, scrollPane, "Doctores y Enfermeros", JOptionPane.INFORMATION_MESSAGE);

    }
    private void cuadroAgregarEnfermero() {

        JTextField tfNombre = new JTextField();
        JTextField tfRut = new JTextField();

        Object[] message = {
                "Nombre:", tfNombre,
                "RUT:", tfRut

        };

        int option = JOptionPane.showConfirmDialog(null, message, "Agregar Enfermero", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {

                if(hospital.agregarEnfermeroAlSistema(tfNombre.getText(), tfRut.getText())){
                    JOptionPane.showMessageDialog(this, "Enfermero agregado exitosamente!");
                }else{
                    throw new PersonalExceptions("El enfermero ya está en el sistema.");
                };
            } catch (PersonalExceptions e) {
                JOptionPane.showMessageDialog(this, "Error al agregar enfermero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void cuadroElimianarEnfermero(){

        JTextField tfRut = new JTextField();
        Object[] message = {
                "RUT:", tfRut,
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Eliminar Enfermero", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                if(hospital.eliminarEnfermeroDelSistema(tfRut.getText())){
                    JOptionPane.showMessageDialog(this, "Enfermero eliminado exitosamente!");
                }
                else{
                    throw new PersonalExceptions("El enfermero no esta en el sistema.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar enfermero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void cuadroAgregrarTurno(){
        JTextField tfRut = new JTextField();
        JTextField tfDia = new JTextField();
        JTextField tfHoraEntrada = new JTextField();
        JTextField tfHoraSalida = new JTextField();
        Object[] message = {
                "RUT:", tfRut,
                "Dia:", tfDia,
                "Hora de entrada:", tfHoraEntrada,
                "Hora de salida:", tfHoraSalida
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Agregar Turno", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                if(hospital.agregarTurnoAEnfermero(tfRut.getText(), tfDia.getText(), tfHoraEntrada.getText(), tfHoraSalida.getText())){
                    JOptionPane.showMessageDialog(this, "Turno agregado exitosamente!");
                }
                else{
                    throw new PersonalExceptions("El enfermero no esta en el sistema.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al agregar turno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void cuadroEliminarTurno(){
        JTextField tfRut = new JTextField();
        JTextField tfDia = new JTextField();
        JTextField tfHoraEntrada = new JTextField();
        JTextField tfHoraSalida = new JTextField();
        Object[] message = {
                "RUT:", tfRut,
                "Dia:", tfDia,
                "Hora de entrada:", tfHoraEntrada,
                "Hora de salida:", tfHoraSalida
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Eliminar Turno", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                if(hospital.agregarTurnoAEnfermero(tfRut.getText(), tfDia.getText(), tfHoraEntrada.getText(), tfHoraSalida.getText())){
                    JOptionPane.showMessageDialog(this, "Turno eliminado exitosamente!");
                }
                else{
                    throw new PersonalExceptions("El enfermero no esta en el sistema.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar turno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void asignarEnfermeroAdoctor(){
        JTextField tfRutDoctor = new JTextField();
        JTextField tfRutEnfermero = new JTextField();
        Object[] message = {
                "RUT Doctor:", tfRutDoctor,
                "RUT Enfermero:", tfRutEnfermero,
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Asignar Enfermero a Doctor", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                if(hospital.asignarEnfermeroADoctor(tfRutDoctor.getText(), tfRutEnfermero.getText())){
                    JOptionPane.showMessageDialog(this, "Enfermero asignado exitosamente!");
                }
                else{
                    throw new PersonalExceptions("El doctor o enfermero no esta en el sistema.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al asignar enfermero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    public void desasignarEnfermeroAdoctor(){
        JTextField tfRutDoctor = new JTextField();
        JTextField tfRutEnfermero = new JTextField();
        Object[] message = {
                "RUT Doctor:", tfRutDoctor,
                "RUT Enfermero:", tfRutEnfermero,
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Desasignar Enfermero a Doctor", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                if(hospital.desasignarEnfermeroADoctor(tfRutDoctor.getText(), tfRutEnfermero.getText())){
                    JOptionPane.showMessageDialog(this, "Enfermero desasignado exitosamente!");
                }
                else{
                    throw new PersonalExceptions("El doctor o enfermero no esta en el sistema.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al desasignar enfermero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    public void cuadroModificarTurno(){
        JTextField tfRut = new JTextField();
        JTextField tfDia = new JTextField();
        JTextField tfHoraEntrada = new JTextField();
        JTextField tfHoraSalida = new JTextField();
        Object[] message = {
                "RUT:", tfRut,
                "Dia:", tfDia,
                "Hora de entrada:", tfHoraEntrada,
                "Hora de salida:", tfHoraSalida
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Modificar Turno", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                if(hospital.agregarTurnoAEnfermero(tfRut.getText(), tfDia.getText(), tfHoraEntrada.getText(), tfHoraSalida.getText())){
                    JOptionPane.showMessageDialog(this, "Turno modificado exitosamente!");
                }
                else{
                    throw new PersonalExceptions("El enfermero no esta en el sistema.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al modificar turno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }







}

