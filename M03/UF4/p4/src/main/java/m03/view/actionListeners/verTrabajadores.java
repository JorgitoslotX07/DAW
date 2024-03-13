package m03.view.actionListeners;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.elasticsearch.client.RestClient;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

import m03.controllers.TreballadorController;
import m03.objects.Encarregat;
import m03.objects.Treballador;
import m03.repositories.repositoriesImpl.XMLFileTreballadorRepository;
import m03.services.TreballadorService;
import m03.view.Ventana;

public class verTrabajadores extends JFrame {
    private JFrame ventana;

    public verTrabajadores() {

        super("Tabla Trabajadores");

        XMLFileTreballadorRepository XMLFileTreballadorRepository = new XMLFileTreballadorRepository();
        TreballadorService treballadorService = new TreballadorService(XMLFileTreballadorRepository);
        TreballadorController TreballadorController = new TreballadorController(treballadorService);

        List<Treballador> lis = TreballadorController.getLlistaTreballadors();

        ArrayList<Object[]> lista = getListaTra(lis);
        String[] columnNames = { "Nom", "Cognom", "DNI", "DataNaixement", "SalariBase" };

        DefaultTableModel model = new DefaultTableModel(lista.toArray(new Object[0][]), columnNames);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());

        JButton b1 = new JButton("Atras");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Ventana ventana = new Ventana();
                ventana.setVisible(true);
            }
        });

        p1.add(b1);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(p1, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private ArrayList<Object[]> getListaTra(List<Treballador> lt) {
        ArrayList<Object[]> lista = new ArrayList<>();

        for (Treballador treballador : lt) {
            if (treballador != null) {
                Object[] tra = {
                        treballador.getNom(),
                        treballador.getCognoms(),
                        treballador.getDni(),
                        treballador.getDataNaixement(),
                        treballador.getSalari()
                };
                lista.add(tra);
            }
        }
        return lista;
    }
}
