/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraya;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Usuario
 */
public class Ventana extends JFrame implements ItemListener {

    String tipoVista;
    JRadioButtonMenuItem bMotif, bMetal, bWindows, bnimbus;
    ButtonGroup vistas;
    JPanel cpane = (JPanel) this.getContentPane();
    JFrame ventana;

    public Ventana(String titulo) {
        super(titulo);
        ventana = new JFrame(titulo);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //--- Menu Look&Feel con JRadiobutonItemMenu
        bMotif = new JRadioButtonMenuItem("Motif (Unix)", false);
        bMetal = new JRadioButtonMenuItem("Metal (Java)", true);
        bWindows = new JRadioButtonMenuItem("Windows", false);
        bnimbus = new JRadioButtonMenuItem("Bnimbus", false);

        vistas = new ButtonGroup();
        vistas.add(bMotif);
        vistas.add(bMetal);
        vistas.add(bWindows);
        vistas.add(bnimbus);

        bMotif.addItemListener(this);
        bMetal.addItemListener(this);
        bWindows.addItemListener(this);
        bnimbus.addItemListener(this);
        JSeparator separador = new JSeparator();
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(new EscuchaMenu());

        JMenuBar menuP = new JMenuBar();
        JMenu menu = new JMenu("Look&Feel");
        menu.add(bMetal);
        menu.add(bMotif);
        menu.add(bWindows);
        menu.add(bnimbus);
        menu.add(separador);
        menu.add(salir);
        salir.setMnemonic('S');
        salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        menuP.add(menu);
        this.setJMenuBar(menuP);
        listaLFDisponibles();
        System.out.println(" Time = " + Calendar.getInstance().getTime());

        //this.addWindowListener(this);
        // Establecemos una clase interna y anónima "WindowAdapter"--------   
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                salir();
            }
        }
        );

        this.setLocationRelativeTo(null);
    }
    //---------------------------------------------------------------

    @Override
    public void itemStateChanged(ItemEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
        // JPanel cpane =(JPanel) this.getContentPane(); 
        if (e.getItemSelectable() == bMotif) {
            tipoVista = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        } else if (e.getItemSelectable() == bMetal) {
            tipoVista = "javax.swing.plaf.metal.MetalLookAndFeel";
        } else if (e.getItemSelectable() == bWindows) {
            tipoVista = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        } else {
            tipoVista = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        }
        try {
            UIManager.setLookAndFeel(tipoVista);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Error al cambiar de Apariencia :" + e.toString());
        }
        this.repaint();

        //ventana.setVisible(false);
        //ventana.setVisible(true);
    }

    void add(GridBagLayout gridbag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//----------------------------------------------------------------
    class EscuchaMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            salir();

        }

    }

    // Obtener la lista de  LookAndFeelInfo...
    public void listaLFDisponibles() {
        UIManager.LookAndFeelInfo[] lista = UIManager.getInstalledLookAndFeels();
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i].getClassName());
        }
    }
    //--- metodo Salir------------------------------------------------------------------

    public void salir() {
        int res = JOptionPane.showConfirmDialog(null, "Quieres Salir ??...",
                "Cerrando Aplicación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Salida abortada...!!!");
            this.setVisible(true);
        }

    }

}
