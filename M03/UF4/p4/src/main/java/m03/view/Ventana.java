package m03.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import m03.objects.Encarregat;
import m03.objects.Treballador;
import m03.view.actionListeners.verTrabajadores;
import m03.view.actionListeners.altaTrabajadores;

public class Ventana extends JFrame {
    private List<Treballador> lista;

    private verTrabajadores vt;
    private altaTrabajadores at;

    ActionListener boton1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            dispose();
            vt = new verTrabajadores();
        }

    };

    ActionListener boton2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            dispose();
            at = new altaTrabajadores();
        }

    };

    public Ventana() {
        super("ventana");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.lista = lista;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // cabecera
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());

        JLabel l1 = new JLabel("Esta es una ventana en java.");
        p1.add(l1);

        // cuerpo
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());

        JButton b1 = new JButton("Veure treballadors");
        b1.addActionListener(boton1);

        JButton b2 = new JButton("Donar d’alta Treballadors");
        b2.addActionListener(boton2);

        JButton b3 = new JButton("Tancar");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);

        cp.add(p1, BorderLayout.NORTH);
        cp.add(p2, BorderLayout.CENTER);

    }
}
