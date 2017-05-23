/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraya;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Rafa
 */
public class TresEnRaya extends JFrame {

    /**
     * @param args the command line arguments
     */
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

    private JTextField areaNombre = new JTextField();

    private JPasswordField areaContraseña = new JPasswordField();

    private JPasswordField areaRepite = new JPasswordField();

    private JTextField areaEdad = new JTextField();

    private JLabel labelNombre;

    private JLabel contraseña;

    private JLabel repite;

    private JLabel labelEdad;

    private JButton guardar;

    private JButton listar;

    private JButton limpiar;

    private Ventana ventana;

    private Container contenedor;

    private GridBagLayout gridbag;

    private GridBagConstraints c;
    
    //CONSTRUCTOR-----------------------------------
    public TresEnRaya() {
        Ventana ventana = new Ventana("Formulario Alta");

        Container contenedor = ventana.getContentPane();

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        contenedor.setLayout(gridbag);

        //---------COMPONENTES---------
        labelNombre = new JLabel("Nombre.......:");
        contraseña = new JLabel("Contraseña:");
        repite = new JLabel("<html><body>Repite<br>contraseña:</body></html>");
        labelEdad = new JLabel("Edad.............:");

        guardar = new JButton("Guardar");
        listar = new JButton("Listar Jugadores");
        limpiar = new JButton("Limpiar");

        colocaComponentes(c, contenedor, labelNombre, contraseña, repite, labelEdad, guardar, listar, limpiar);
        //leerFichero();
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pulsarGuardar();

            }

        });

        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiezaFormulario();

            }
        });

        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                leerFichero();
                /*for (Jugador jugadore : jugadores) {
                    
                    System.out.println(jugadore);
                }*/

            }
        });

        //le creo al campo Edad que con el Intro ejecute el alta
        areaEdad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pulsarGuardar();
            }
        });

        //ventana.setSize(300, 200);
        ventana.pack();
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        TresEnRaya tres = new TresEnRaya();

    }//MAIN-----------------------------------

    private void colocaComponentes(GridBagConstraints c, Container contenedor, JLabel labelNombre, JLabel contraseña, JLabel repite, JLabel labelEdad, JButton guardar, JButton cancelar, JButton limpiar) {
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        //c.anchor = GridBagConstraints.FIRST_LINE_START;

        c.insets = new Insets(5, 0, 5, 10);
        c.anchor = GridBagConstraints.EAST;
        contenedor.add(labelNombre, c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.insets = new Insets(5, 0, 5, 10);
        c.fill = GridBagConstraints.HORIZONTAL;

        contenedor.add(areaNombre, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.FIRST_LINE_START;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(5, 0, 5, 10);
        //c.fill=GridBagConstraints.RELATIVE;
        contenedor.add(contraseña, c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 0, 5, 10);
        //c.fill=GridBagConstraints.REMAINDER;
        contenedor.add(areaContraseña, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.FIRST_LINE_START;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(5, 0, 5, 10);
        //c.fill=GridBagConstraints.RELATIVE;
        contenedor.add(repite, c);

        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 1;
        c.gridwidth = 2;
        c.insets = new Insets(5, 0, 5, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.fill=GridBagConstraints.REMAINDER;

        contenedor.add(areaRepite, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.FIRST_LINE_START;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(5, 0, 5, 10);
        //c.fill=GridBagConstraints.RELATIVE;
        contenedor.add(labelEdad, c);

        c.gridx = 1;
        c.gridy = 3;
        c.weightx = 1;
        c.gridwidth = 2;
        c.insets = new Insets(5, 0, 5, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.fill=GridBagConstraints.REMAINDER;
        contenedor.add(areaEdad, c);

        c.gridx = 0;
        c.gridy = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 5);
        contenedor.add(guardar, c);

        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        //c.gridwidth=GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 0, 5, 5);
        contenedor.add(cancelar, c);

        c.gridx = 2;
        c.gridy = 4;
        c.anchor = GridBagConstraints.WEST;
        contenedor.add(limpiar, c);
    }

    private void limpiezaFormulario() {
        areaNombre.setText("");
        areaEdad.setText("");
        areaContraseña.setText("");
        areaRepite.setText("");
    }

    private void limpiezaContrasenia() {

        areaContraseña.setText("");
        areaRepite.setText("");

    }

    private void guardaFichero(ArrayList<Jugador> listaJugadores) {

        try {

            ObjectOutputStream buferFichero = new ObjectOutputStream(new FileOutputStream("src/pkg3enraya/Jugadores.txt"));
            Iterator<Jugador> iterator = listaJugadores.iterator();
            while (iterator.hasNext()) {
                Jugador pelicula = (Jugador) iterator.next();
                buferFichero.writeObject(pelicula);
            }
            buferFichero.close();

        } catch (IOException ex) {
            Logger.getLogger(TresEnRaya.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void leerFichero() {

        ObjectInputStream ficheroObjetoEntrada = null;
        jugadores = new ArrayList();
        String gamers = "";
        try {
            FileInputStream fileInputStream = new FileInputStream("src/pkg3enraya/Jugadores.txt");
            ficheroObjetoEntrada = new ObjectInputStream(fileInputStream);
            Jugador jugador;
            
            try {
                
                while (true) {
                    jugador = (Jugador) ficheroObjetoEntrada.readObject();
                    añadirJugador(jugador);
                    String nombre = "<html><body>"+"Nombre: "+"<small style='color:blue'>"+jugador.getNombre()+"</small>"+"\t"+"   Edad: "+"<small style='color:blue'>"+jugador.getEdad()+"</small>"+"</body></html>";//"Nombre: "+jugador.getNombre()+"\t"+"Edad: "+jugador.getEdad()+" años";
                    gamers = gamers+nombre+"\n";
//                    JOptionPane.showMessageDialog(null, jugador);
                    //System.out.println(gamers);
                }
               
            } catch (Exception e) {
                try {
                    ficheroObjetoEntrada.close();
                } catch (IOException ex) {
                    Logger.getLogger(TresEnRaya.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            ficheroObjetoEntrada.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TresEnRaya.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TresEnRaya.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, gamers);

    }

    private void pulsarGuardar() {

        try {
            int edad = Integer.parseInt(areaEdad.getText());
            String nombre = areaNombre.getText();
            String contrasenia = String.valueOf(areaContraseña.getPassword());
            String repcontra = String.valueOf(areaRepite.getPassword());

            if (comprobarContraseñas(contrasenia, repcontra)) {
                Jugador jugador = new Jugador(nombre, edad, contrasenia);
                int longitudAntes = jugadores.size();
                añadirJugador(jugador);
                int longitudDespues = jugadores.size();
                if (longitudAntes < longitudDespues) {
                    guardaFichero(jugadores);
                    limpiezaFormulario();
                    JOptionPane.showMessageDialog(null, "Alta creada correctamente");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden...pruebe de nuevo");
                limpiezaContrasenia();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "No es un número válido, inténtelo de nuevo");
        }

    }

    public void añadirJugador(Jugador jugador) {
        if (jugador.getNombre().equals("")) {
            JOptionPane.showMessageDialog(null, "Debes poner un nombre...");
            limpiezaFormulario();
        } else if (jugador.getContrasenia().equals("")) {
            JOptionPane.showMessageDialog(null, "No se permiten contraseñas vacías...");
            limpiezaContrasenia();
        } else {
            if (comprobarExisteJugador(jugador)) {
                JOptionPane.showMessageDialog(null, "El ususario ya existe, elija otro nombre...");
                //System.out.println("Ya existe");
            } else {
                jugadores.add(jugador);
            }

        }
    }

    public boolean comprobarExisteJugador(Jugador jugador) {
        boolean existe = false;
        for (Jugador jugadore : jugadores) {
            if (jugadore.getNombre().equalsIgnoreCase(jugador.getNombre())) {
                existe = true;
            }
        }
        return existe;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public JTextField getAreaNombre() {
        return areaNombre;
    }

    public void setAreaNombre(JTextField areaNombre) {
        this.areaNombre = areaNombre;
    }

    public JPasswordField getAreaContraseña() {
        return areaContraseña;
    }

    public void setAreaContraseña(JPasswordField areaContraseña) {
        this.areaContraseña = areaContraseña;
    }

    public JPasswordField getAreaRepite() {
        return areaRepite;
    }

    public void setAreaRepite(JPasswordField areaRepite) {
        this.areaRepite = areaRepite;
    }

    public JTextField getAreaEdad() {
        return areaEdad;
    }

    public void setAreaEdad(JTextField areaEdad) {
        this.areaEdad = areaEdad;
    }

    public JLabel getLabelNombre() {
        return labelNombre;
    }

    public void setLabelNombre(JLabel labelNombre) {
        this.labelNombre = labelNombre;
    }

    public JLabel getContraseña() {
        return contraseña;
    }

    public void setContraseña(JLabel contraseña) {
        this.contraseña = contraseña;
    }

    public JLabel getRepite() {
        return repite;
    }

    public void setRepite(JLabel repite) {
        this.repite = repite;
    }

    public JLabel getLabelEdad() {
        return labelEdad;
    }

    public void setLabelEdad(JLabel labelEdad) {
        this.labelEdad = labelEdad;
    }

    public JButton getGuardar() {
        return guardar;
    }

    public void setGuardar(JButton guardar) {
        this.guardar = guardar;
    }

    public JButton getListar() {
        return listar;
    }

    public void setListar(JButton listar) {
        this.listar = listar;
    }

    public JButton getLimpiar() {
        return limpiar;
    }

    public void setLimpiar(JButton limpiar) {
        this.limpiar = limpiar;
    }

    public Ventana getVentana() {
        return ventana;
    }

    public void setVentana(Ventana ventana) {
        this.ventana = ventana;
    }

    public Container getContenedor() {
        return contenedor;
    }

    public void setContenedor(Container contenedor) {
        this.contenedor = contenedor;
    }

    public GridBagLayout getGridbag() {
        return gridbag;
    }

    public void setGridbag(GridBagLayout gridbag) {
        this.gridbag = gridbag;
    }

    public GridBagConstraints getC() {
        return c;
    }

    public void setC(GridBagConstraints c) {
        this.c = c;
    }

    private boolean comprobarContraseñas(String contrasenia, String repcontra) {
        return contrasenia.equals(repcontra);
    }

}
