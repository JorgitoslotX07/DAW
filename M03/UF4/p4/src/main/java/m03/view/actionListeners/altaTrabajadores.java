package m03.view.actionListeners;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.elasticsearch.client.RestClient;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

import m03.controllers.TreballadorController;
import m03.repositories.repositoriesImpl.XMLFileTreballadorRepository;
import m03.services.TreballadorService;
import m03.objects.Encarregat;
import m03.objects.Treballador;
import m03.view.Ventana;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class altaTrabajadores extends JFrame {
    private JTextField tNom;
    private JTextField tCognoms;
    private JTextField tDni;
    private JTextField tDataNaixement;
    private JTextField tDataIniciContracte;
    private JTextField tSalariBase;
    private JCheckBox cbEncarregat;

    public altaTrabajadores() {
        super("Agregar Trabajador");

        XMLFileTreballadorRepository XMLFileTreballadorRepository = new XMLFileTreballadorRepository();
        TreballadorService treballadorService = new TreballadorService(XMLFileTreballadorRepository);
        TreballadorController TreballadorController = new TreballadorController(treballadorService);

        List<Treballador> lis = TreballadorController.getLlistaTreballadors();

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
                XMLFileTreballadorRepository XMLFileTreballadorRepository = new XMLFileTreballadorRepository();
                TreballadorService treballadorService = new TreballadorService(XMLFileTreballadorRepository);
                TreballadorController TreballadorController = new TreballadorController(treballadorService);

                String fechaString = tDataNaixement.getText();
                LocalDate fechaNacimiento = LocalDate.parse(fechaString,
                        DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                TreballadorController.addTreballador(
                        tNom.getText(),
                        tCognoms.getText(),
                        tDni.getText(),
                        String.valueOf(fechaNacimiento.getDayOfMonth()),
                        String.valueOf(fechaNacimiento.getMonthValue()),
                        String.valueOf(fechaNacimiento.getYear()),
                        tSalariBase.getText(),
                        "0",
                        cbEncarregat.isSelected());

                dispose();
                Ventana ventana = new Ventana();
                ventana.setVisible(true);

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
