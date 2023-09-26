import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Ventanas extends JFrame{

    private Hospital hospital;
    private JButton bAgregarEnfermero;
    private JButton bEliminarEnfermero;
    private JButton bMostrarEnfermeros;
    private JButton bBuscarEnfermero;
    private JButton bAgregarTurno;
    private JButton bModificarTurno;
    private JButton bEliminarTurno;
    private JButton bImportarDatos;
    private JButton bGuardarDatos;

    public Ventanas(Hospital control){

        this.hospital = hospital;
        setTitle("Menú de Enfermeros");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 1));// 10 opciones, 1 columna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bAgregarEnfermero = new JButton("Agregar enfermero");
        bEliminarEnfermero = new JButton("Eliminar enfermero");
        bMostrarEnfermeros = new JButton("Mostrar enfermeros");
        bBuscarEnfermero = new JButton("Buscar enfermero");
        bAgregarTurno = new JButton("Agregar turno");
        bModificarTurno = new JButton("Modificar turno");
        bEliminarTurno = new JButton("Eliminar turno");
        bImportarDatos = new JButton("Importar datos");
        bGuardarDatos = new JButton("Guardar datos");

        bAgregarEnfermero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    control.agregarEnfermero();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        add(bAgregarEnfermero);
    }
}
