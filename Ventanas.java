
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

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
    private JButton BcerrarPrograma;
    private JButton BmostrarEnfermerosDeDoctor;
    private JButton BmostrarDoctoresPorEspecialidad;


    public Ventanas(Hospital hospital){

        this.hospital = hospital;
        setTitle("Menú de manejo del Hospital San José");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 1));
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
            cuadroMostrarDoctores();
        });
        add(bMostrarDoctoresEnfermeros);

        BmostrarDoctoresPorEspecialidad = new JButton("Mostrar doctores por especialidad");
        BmostrarDoctoresPorEspecialidad.addActionListener(e -> {
            cuadroMostrarPorEspecialidad();
        });
        add(BmostrarDoctoresPorEspecialidad);


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
            cuadroModificarTurno();
        });
        add(bModificarTurno);

        BmostrarEnfermerosDeDoctor = new JButton("Mostrar Enfermeros de Doctor");
        BmostrarEnfermerosDeDoctor.addActionListener(e -> {
            cuadroMostrarEnfermeros();
        });
        add(BmostrarEnfermerosDeDoctor);

        bMostrarEnfermeros = new JButton("Mostrar Enfermeros");
        bMostrarEnfermeros.addActionListener(e -> {
            cuadroMostrarEnfermeros();
        });
        add(bMostrarEnfermeros);

        BcerrarPrograma = new JButton("Guardar datos y salir del programa");
        BcerrarPrograma.addActionListener(e -> {
            cuadroCerrarPrograma();
        });
        add(BcerrarPrograma);

    }

    private void cuadroMostrarPorEspecialidad(){

        JTextField tfEspecialidad = new JTextField();
        Object[] message = {
                "Especialidad:", tfEspecialidad,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Indique la especialidad", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            JDialog dialog = new JDialog();
            dialog.setTitle("Todos los doctores por "+tfEspecialidad.getText());
            dialog.setSize(500, 400);
            dialog.setLayout(new BorderLayout());

            ArrayList <Doctor> doctores = new ArrayList<>();
            hospital.obtenerDoctores(doctores);

            String[] columnNames = {"Nombre", "Rut", "Especialidad"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            for (Doctor doctor : doctores) {
                if(doctor.getEspecialidad().equals(tfEspecialidad.getText())){
                    Object[] rowData = {doctor.getNombre(), doctor.getRut(), doctor.getEspecialidad()};
                    model.addRow(rowData);
                }
            }

            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);

            JButton btnCerrar = new JButton("Cerrar");
            btnCerrar.addActionListener(e -> dialog.dispose());

            JPanel panelBoton1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panelBoton1.add(btnCerrar);

            dialog.add(scrollPane, BorderLayout.CENTER);
            dialog.add(panelBoton1, BorderLayout.SOUTH);

            dialog.setVisible(true);

        }
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
            } catch (PersonalExceptions e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar doctor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void cuadroMostrarDoctores() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Mostrar Doctores y Enfermeros");
        dialog.setSize(500, 400);
        dialog.setLayout(new BorderLayout());

        ArrayList <Doctor> doctores = new ArrayList<>();
        hospital.obtenerDoctores(doctores);

        String[] columnNames = {"Nombre", "Rut", "Especialidad"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Doctor doctor : doctores) {
            Object[] rowData = {doctor.getNombre(), doctor.getRut(), doctor.getEspecialidad()};
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dialog.dispose());

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(btnCerrar);

        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.add(panelBoton, BorderLayout.SOUTH);

        dialog.setVisible(true);

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
            } catch (PersonalExceptions e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar enfermero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void cuadroAgregrarTurno(){
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

    private void cuadroEliminarTurno(){
        JTextField tfRut = new JTextField();
        JTextField tfDia = new JTextField();
        JTextField tfHoraEntrada = new JTextField();
        JTextField tfHoraSalida = new JTextField();
        Object[] message = {
                "RUT:", tfRut,
                "Dia:", tfDia
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Eliminar Turno de enfermero", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                if(hospital.eliminarTurno(tfRut.getText(), tfDia.getText())==0){
                    JOptionPane.showMessageDialog(this, "Turno eliminado exitosamente!");
                }
                else{
                    if(hospital.eliminarTurno(tfRut.getText(), tfDia.getText())==1) {
                        throw new HorarioExceptions("El turno no esta en el sistema.");
                    }else{
                        throw new PersonalExceptions("El enfermero no esta en el sistema.");
                    }
                }
            } catch (HorarioExceptions e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar turno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (PersonalExceptions e1) {
                JOptionPane.showMessageDialog(this, "Error al eliminar turno: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void asignarEnfermeroAdoctor(){
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
            } catch (PersonalExceptions e) {
                JOptionPane.showMessageDialog(this, "Error al asignar enfermero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void desasignarEnfermeroAdoctor(){
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
            } catch (PersonalExceptions e) {
                JOptionPane.showMessageDialog(this, "Error al desasignar enfermero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void cuadroModificarTurno(){
        JTextField tfRut = new JTextField();
        JTextField tfDia = new JTextField();
        JTextField tfHoraEntrada = new JTextField();
        JTextField tfHoraSalida = new JTextField();
        JTextField tfNuevoDia = new JTextField();
        JTextField tfNuevaHoraEntrada = new JTextField();
        JTextField tfNuevaHoraSalida = new JTextField();
        Object[] message = {
                "RUT:", tfRut,
                "Dia:", tfDia,
                "Hora de entrada:", tfHoraEntrada,
                "Hora de salida:", tfHoraSalida
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Turno original", JOptionPane.OK_CANCEL_OPTION);

        Object[] message1 = {

                "Dia:", tfNuevoDia,
                "Hora de entrada:", tfNuevaHoraEntrada,
                "Hora de salida:", tfNuevaHoraSalida
        };
        int option1 = JOptionPane.showConfirmDialog(null, message1, "Turno nuevo", JOptionPane.OK_CANCEL_OPTION);

        if (option1 == JOptionPane.OK_OPTION) {
            try {
                if(hospital.modificarTurno(tfRut.getText(), tfDia.getText(),tfHoraEntrada.getText(),tfHoraSalida.getText(),tfNuevoDia.getText(),tfNuevaHoraEntrada.getText(),tfNuevaHoraSalida.getText()) == 0){
                    JOptionPane.showMessageDialog(this, "Turno modificado exitosamente!");
                }
                else{
                    if(hospital.modificarTurno(tfRut.getText(), tfDia.getText(),tfHoraEntrada.getText(),tfHoraSalida.getText(),tfNuevoDia.getText(),tfNuevaHoraEntrada.getText(),tfNuevaHoraSalida.getText()) == 1) {
                        throw new HorarioExceptions("El turno no esta en el sistema.");
                    }else{
                        throw new PersonalExceptions("El enfermero no esta en el sistema.");
                    }
                }
            } catch (HorarioExceptions e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar turno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (PersonalExceptions e1) {
                JOptionPane.showMessageDialog(this, "Error al eliminar turno: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cuadroCerrarPrograma(){
        int option = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea cerrar el programa?", "Cerrar Programa", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                hospital.guardarDatosEnfermero();
                hospital.guardarDatosDoctor();
                hospital.generarReporteDeDatos();
                System.exit(0);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar programa: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void cuadroMostrarEnfermeros() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Todos los enfermeros");
        dialog.setSize(500, 400);
        dialog.setLayout(new BorderLayout());

        ArrayList <Enfermero> enfermeros = new ArrayList<>();
        hospital.obtenerEnfermeros(enfermeros);

        String[] columnNames = {"Nombre", "Rut"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Enfermero enfermero : enfermeros) {
            Object[] rowData = {enfermero.getNombre(), enfermero.getRut()};
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dialog.dispose());


        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton btnMostrarTurnos = new JButton("Mostrar turnos de:");
        btnMostrarTurnos.addActionListener(e -> mostrarTurnosDeEnfermero());
        panelBoton.add(btnMostrarTurnos);
        panelBoton.add(btnCerrar);

        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.add(panelBoton, BorderLayout.SOUTH);

        dialog.setVisible(true);

    }

    private void mostrarTurnosDeEnfermero() {
        String rut = JOptionPane.showInputDialog("Ingrese el RUT del enfermero:");
        JDialog dialog = new JDialog();

        try{
            if (rut != null && !rut.trim().isEmpty()) {
                Enfermero enfermero = hospital.buscarEnfermero(rut);
                if (enfermero != null) {
                    dialog.setTitle("Turnos del enfermero " + enfermero.getNombre());
                    dialog.setSize(500, 400);
                    dialog.setLayout(new BorderLayout());
                    ArrayList <Horario> turnos = new ArrayList<>();
                    enfermero.obtenerTurnos(turnos);

                    String[] columnNames = {"Día", "Entrada", "Salida"};
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

                    for (Horario turno : turnos) {
                        Object[] rowData = {turno.getDia(), turno.getEntrada(), turno.getSalida()};
                        model.addRow(rowData);
                    }

                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
                    table.setFillsViewportHeight(true);

                    JButton btnCerrar = new JButton("Cerrar");
                    btnCerrar.addActionListener(e -> dialog.dispose());

                    JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                    panelBoton.add(btnCerrar);

                    dialog.add(scrollPane, BorderLayout.CENTER);
                    dialog.add(panelBoton, BorderLayout.SOUTH);

                    dialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un enfermero con el RUT proporcionado.");
                }
            }else{
                throw new PersonalExceptions("No ha ingresado rut.");
            }
        }catch (PersonalExceptions e){
            JOptionPane.showMessageDialog(this, "Error al mostrar turnos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}

