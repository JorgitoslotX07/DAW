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

public class verTrabajadores extends JFrame {
    private JFrame ventana;

    public verTrabajadores(Encarregat encarregat) {
        super("Tabla Trabajadores");

        ArrayList<Object[]> lista = getListaTra(encarregat.getLlistaTreballadors());
        String[] columnNames = {"Nom", "Cognom", "DNI", "DataNaixement", "SalariBase"};

        DefaultTableModel model = new DefaultTableModel(lista.toArray(new Object[0][]), columnNames);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());

        JButton b1 = new JButton("Atras");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Ventana ventana = new Ventana(encarregat);
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

    private ArrayList<Object[]> getListaTra(Treballador[] lt) {
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
