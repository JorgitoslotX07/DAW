package m03.view.actionListeners;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.elasticsearch.client.RestClient;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import m03.uf4.p4.p4.objects.Encarregat;
import m03.uf4.p4.p4.objects.Treballador;
import m03.view.Ventana;
import java.time.LocalDate;

public class altaTrabajadores extends JFrame {
    private JTextField tNom;
    private JTextField tCognoms;
    private JTextField tDni;
    private JTextField tDataNaixement;
    private JTextField tDataIniciContracte;
    private JTextField tSalariBase;
    private JLabel l3;

    public altaTrabajadores(Encarregat encarregat) {
        super("Agregar Trabajador");

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();

        cp.setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6, 2)); 

        JLabel lNom = new JLabel("Nombre: ");
        tNom = new JTextField();
        p1.add(lNom);
        p1.add(tNom);

        JLabel lCognoms = new JLabel("Apellidos: ");
        tCognoms = new JTextField();
        p1.add(lCognoms);
        p1.add(tCognoms);

        JLabel lDni = new JLabel("DNI: ");
        tDni = new JTextField();
        p1.add(lDni);
        p1.add(tDni);

        JLabel lDataNaixement = new JLabel("Fecha de Nacimiento (YYYY-MM-DD): ");
        tDataNaixement = new JTextField();
        p1.add(lDataNaixement);
        p1.add(tDataNaixement);

        JLabel lDataIniciContracte = new JLabel("Fecha de Inicio de Contrato (YYYY-MM-DD): ");
        tDataIniciContracte = new JTextField();
        p1.add(lDataIniciContracte);
        p1.add(tDataIniciContracte);

        JLabel lSalariBase = new JLabel("Salario Base: ");
        tSalariBase = new JTextField();
        p1.add(lSalariBase);
        p1.add(tSalariBase);

        JButton b1 = new JButton("Aceptar");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = tNom.getText();
                String cognoms = tCognoms.getText();
                String dni = tDni.getText();
                LocalDate dataNaixement = LocalDate.parse(tDataNaixement.getText());
                LocalDate dataIniciContracte = LocalDate.parse(tDataIniciContracte.getText());
                double salariBase = Double.parseDouble(tSalariBase.getText());

                System.out.println("Nombre: " + nom);
                System.out.println("Apellidos: " + cognoms);
                System.out.println("DNI: " + dni);
                System.out.println("Fecha de Nacimiento: " + dataNaixement);
                System.out.println("Fecha de Inicio de Contrato: " + dataIniciContracte);
                System.out.println("Salario Base: " + salariBase);
            }
        });

        cp.add(p1, BorderLayout.NORTH);
        cp.add(b1, BorderLayout.CENTER);

        setVisible(true);
    }
}
