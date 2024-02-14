package m03.view.actionListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import m03.uf4.p4.p4.objects.Encarregat;
import m03.uf4.p4.p4.objects.Treballador;

public class verTrabajadores extends JFrame {
    private JFrame ventana;

    public verTrabajadores(Encarregat encarregat) {
        System.err.println(encarregat.toString());
    }
}
