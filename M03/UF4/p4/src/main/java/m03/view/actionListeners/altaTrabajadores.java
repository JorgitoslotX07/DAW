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
    private JCheckBox cbEncarregat;

    public altaTrabajadores(Encarregat encarregat) {
        super("Agregar Trabajador");

        setSize(600, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();

        cp.setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(7, 2)); // Incrementat per incloure el checkbox

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

        JLabel lEncarregat = new JLabel("Encarregat: ");
        cbEncarregat = new JCheckBox();
        p1.add(lEncarregat);
        p1.add(cbEncarregat);

        JButton b1 = new JButton("Aceptar");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarDades()) {
                    if (cbEncarregat.isSelected()) {
                        Treballador treNew = new Treballador(
                            tNom.getText(),
                            tCognoms.getText(),
                            tDni.getText(),
                            LocalDate.parse(tDataNaixement.getText()),
                            LocalDate.parse(tDataIniciContracte.getText()),
                            Double.parseDouble(tSalariBase.getText())
                        );
                        encarregat.afegirTreballador(treNew);
                    } else {
                        Encarregat encNew = new Encarregat(
                            tNom.getText(),
                            tCognoms.getText(),
                            tDni.getText(),
                            LocalDate.parse(tDataNaixement.getText()),
                            LocalDate.parse(tDataIniciContracte.getText()),
                            Double.parseDouble(tSalariBase.getText()),
                            500
                        );
                        encarregat.afegirTreballador(encNew);
                    }
                    
                    dispose();
                    Ventana ventana = new Ventana(encarregat);
                    ventana.setVisible(true);
                    
                }
            }
        });

        cp.add(p1, BorderLayout.NORTH);
        cp.add(b1, BorderLayout.CENTER);

        setVisible(true);
    }

    private boolean validarDades() {
        if (tNom.getText().isEmpty() || tCognoms.getText().isEmpty() || tDni.getText().isEmpty() ||
            tDataNaixement.getText().isEmpty() || tDataIniciContracte.getText().isEmpty() || 
            tSalariBase.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falten dades");
            return false;
        }
        try {
            LocalDate.parse(tDataNaixement.getText());
            LocalDate.parse(tDataIniciContracte.getText());
            Double.parseDouble(tSalariBase.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Les dates o el salari no son valid");
            return false;
        }
        return true;
    }
}
