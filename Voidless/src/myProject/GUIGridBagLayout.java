package myProject;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 *
 * @version v.1.0.0 date:21/11/2021
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 */
public class GUIGridBagLayout extends JFrame {

    private Header headerProject;
    public JPanel biblioteca, noticias, juegos, cabecera, compras, memes, sesionSu, sesionMed, sesionIn, sesion;
    private JPanel j1, j2, j3, j4, j5, j6;
    private JTextArea n1, n2, n3, comunidadLol;
    public JButton bTienda, bBiblioteca, bComunidad, configuracion, ingresar, registrar;
    private ImageIcon imageJ1, imageJ2, imageJ3, imageJ4, imageJ5, imageJ6, imageJ7, imageJ8, logo;
    public JButton juego1, juego2, juego3, juego4, juego5, juego6;
    private JLabel logotipo;
    private ModelBiblioteca objetoModelBiblioteca;
    private Escucha escucha;

    /**
     * Constructor of GUI class
     */
    public GUIGridBagLayout() {
        initGUI();

        //Default JFrame configuration
        this.setTitle("V O I D L E S S");
        //this.setSize(200,100);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object or Control Object
        escucha = new Escucha();
        objetoModelBiblioteca = new ModelBiblioteca();

        sesionSu = new JPanel();
        sesionSu.setPreferredSize(new Dimension(700, 250));
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(sesionSu, constraints);

        logo = new ImageIcon(this.getClass().getResource("/resources/Icono.png"));
        JLabel picLabel = new JLabel(logo);
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.PAGE_START;

        this.add(picLabel, constraints);

        logotipo = new JLabel("                                                                                  V    O    I    D    L    E    S    S");
        logotipo.setPreferredSize(new Dimension(700, 100));
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(logotipo, constraints);

        sesionSu.add(picLabel);
        sesionSu.add(logotipo);

        sesionMed = new JPanel();
        sesionMed.setPreferredSize(new Dimension(700, 50));
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(sesionMed, constraints);

        sesionIn = new JPanel();
        sesionIn.setPreferredSize(new Dimension(700, 50));
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;

        ingresar = new JButton("Ingresar");
        ingresar.addActionListener(escucha);
        registrar = new JButton("Registrarse");
        registrar.addActionListener(escucha);

        sesionIn.add(ingresar);
        sesionIn.add(registrar);

        this.add(sesionIn, constraints);

        sesion = new JPanel();
        sesion.setPreferredSize(new Dimension(700, 400));
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(sesion, constraints);

        sesion.add(sesionSu);
        sesion.add(sesionMed);
        sesion.add(sesionIn);

        configuracion = new JButton("≡");
        configuracion.addActionListener(escucha);

        bBiblioteca = new JButton("B  I  B  L  I  O  T  E  C  A");
        bBiblioteca.setPreferredSize(new Dimension(200, 30));
        bBiblioteca.addActionListener(escucha);

        bTienda = new JButton("T  I  E  N  D  A");
        bTienda.setPreferredSize(new Dimension(200, 30));
        bTienda.addActionListener(escucha);

        bComunidad = new JButton("C  O  M  U  N  I  D  A  D");
        bComunidad.setPreferredSize(new Dimension(200, 30));
        bComunidad.addActionListener(escucha);

        cabecera = new JPanel();
        cabecera.setPreferredSize(new Dimension(700, 50));

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;

        cabecera.add(configuracion);
        cabecera.add(bTienda);
        cabecera.add(bBiblioteca);
        cabecera.add(bComunidad);

        this.add(cabecera, constraints);

        int anchoJuegos = 115;
        int alturaJuegos = 170;

        j1 = new JPanel();
        j1.setPreferredSize(new Dimension(anchoJuegos, alturaJuegos));

        j2 = new JPanel();
        j2.setPreferredSize(new Dimension(anchoJuegos, alturaJuegos));

        j3 = new JPanel();
        j3.setPreferredSize(new Dimension(anchoJuegos, alturaJuegos));

        j4 = new JPanel();
        j4.setPreferredSize(new Dimension(anchoJuegos, alturaJuegos));

        j5 = new JPanel();
        j5.setPreferredSize(new Dimension(anchoJuegos, alturaJuegos));

        j6 = new JPanel();
        j6.setPreferredSize(new Dimension(anchoJuegos, alturaJuegos));

        juegos = new JPanel();
        juegos.setPreferredSize(new Dimension(450, 500));
        juegos.setBorder(BorderFactory.createTitledBorder("TUS JUEGOS"));

        juegos.add(j1);
        juegos.add(j2);

        this.add(juegos, constraints);

        noticias = new JPanel();
        noticias.setPreferredSize(new Dimension(200, 500));
        noticias.setBorder(BorderFactory.createTitledBorder("NOTICIAS"));

        n1 = new JTextArea();
        n1.setPreferredSize(new Dimension(160, 100));
        n1.setText("Riot Games: \n" + "Guía de cosplay de Guardianas Estelares: Parte 1. Más información aquí");
        n1.setEditable(false);
        n1.setLineWrap(true);
        n1.setWrapStyleWord(true);

        n2 = new JTextArea();
        n2.setPreferredSize(new Dimension(160, 100));
        n2.setText("Tienda: \n" + "¡Sekiro: Shadows die twice, ahora está disponible en la tienda!");
        n2.setEditable(false);
        n2.setLineWrap(true);
        n2.setWrapStyleWord(true);

        n3 = new JTextArea();
        n3.setPreferredSize(new Dimension(160, 100));
        n3.setText("Tienda: \n" + "¡Oferta del 30%: Bioshock 2! Consiguelo ya en la tienda");
        n3.setEditable(false);
        n3.setLineWrap(true);
        n3.setWrapStyleWord(true);

        noticias.add(n1);
        noticias.add(n2);
        noticias.add(n3);

        juego1 = new JButton();
        juego1.setName("juego1");
        imageJ1 = new ImageIcon(getClass().getResource("/resources/DantesInferno.jpg"));
        juego1.setIcon(new ImageIcon(imageJ1.getImage().getScaledInstance(anchoJuegos, alturaJuegos, Image.SCALE_DEFAULT)));
        juego1.addActionListener(escucha);

        juego2 = new JButton();
        juego2.setName("juego2");
        imageJ2 = new ImageIcon(getClass().getResource("/resources/GTAV.jpg"));
        juego2.setIcon(new ImageIcon(imageJ2.getImage().getScaledInstance(anchoJuegos, alturaJuegos, Image.SCALE_DEFAULT)));
        juego2.addActionListener(escucha);

        juego3 = new JButton();
        juego3.setName("juego3");
        imageJ3 = new ImageIcon(getClass().getResource("/resources/Lol.jpg"));
        juego3.setIcon(new ImageIcon(imageJ3.getImage().getScaledInstance(anchoJuegos, alturaJuegos, Image.SCALE_DEFAULT)));
        juego3.addActionListener(escucha);

        juego4 = new JButton();
        juego4.setName("juego4");
        imageJ4 = new ImageIcon(getClass().getResource("/resources/valorant.jpg"));
        juego4.setIcon(new ImageIcon(imageJ4.getImage().getScaledInstance(anchoJuegos, alturaJuegos, Image.SCALE_DEFAULT)));
        juego4.addActionListener(escucha);

        juego5 = new JButton();
        juego5.setName("juego5");
        imageJ5 = new ImageIcon(getClass().getResource("/resources/Bioshock2.jpg"));
        juego5.setIcon(new ImageIcon(imageJ5.getImage().getScaledInstance(anchoJuegos, alturaJuegos, Image.SCALE_DEFAULT)));
        juego5.addActionListener(escucha);

        juego6 = new JButton();
        juego6.setName("juego6");
        imageJ6 = new ImageIcon(getClass().getResource("/resources/Sekiro.jpg"));
        juego6.setIcon(new ImageIcon(imageJ6.getImage().getScaledInstance(anchoJuegos, alturaJuegos, Image.SCALE_DEFAULT)));
        juego6.addActionListener(escucha);

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;

        this.add(juegos, constraints);

        j1.add(juego1);
        j2.add(juego2);
        j3.add(juego3);
        j4.add(juego4);
        j5.add(juego5);
        j6.add(juego6);

        compras = new JPanel();
        compras.setPreferredSize(new Dimension(450, 500));

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;

        compras.add(j1);
        compras.add(j2);
        compras.add(j3);
        compras.add(j4);
        compras.add(j5);
        compras.add(j6);

        this.add(compras, constraints);

        memes = new JPanel();
        memes.setPreferredSize(new Dimension(450, 500));

        comunidadLol = new JTextArea();
        comunidadLol.setPreferredSize(new Dimension(300, 400));
        comunidadLol.setText("WHAT\n" +
                "What is one of the most fundamental pieces of any project? If you guessed UI, you’d be right! Even though it’s a necessary step there are a lot of questions around some of the best ways to create and implement it, so this week we’ll be discussing with our own technical writer Michael Prinke some of the best tips and tricks, do’s and don’ts, and a general introduction to common UI.\n" +
                "\n" +
                "WHEN\n" +
                "Thursday, July 21st @ 2:00 PM ET - Countdown 421\n" +
                "\n" +
                "WHERE\n" +
                "Twitch 312\n" +
                "YouTube 3.9k\n" +
                "\n" +
                "WHO\n" +
                "Michael Prinke - Technical Writer - @Mike_Prinke 17\n" +
                "Tina Wisdom - Community Manager - @TheUnWiseTina 13\n" +
                "\n" +
                "If you’re unable to make the livestream, all episodes of Inside Unreal can be viewed afterwards on-demand 648.");
        comunidadLol.setEditable(false);
        comunidadLol.setLineWrap(true);
        comunidadLol.setWrapStyleWord(true);

        memes.add(comunidadLol);

        biblioteca = new JPanel();
        biblioteca.setPreferredSize(new Dimension(700, 500));

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;

        biblioteca.add(juegos);
        biblioteca.add(noticias);
        biblioteca.add(memes);
        biblioteca.add(compras);

        biblioteca.setVisible(false);
        cabecera.setVisible(false);
        sesionMed.setVisible(true);

        this.add(biblioteca, constraints);

    }

    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is executed by console.
     */
    public static void main(String[] args) {

        Connection BaseDatos = null;
        Statement st = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/Proyecto_BD";
            BaseDatos = DriverManager.getConnection(url, "postgres", "pg123");
            System.out.println("Hay conexión");

//            BaseDatos.commit();
//            BaseDatos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        EventQueue.invokeLater(() -> {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {
        int comprar;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ingresar) {
                JOptionPane.showInputDialog("Ingresa tu nombre");
                JOptionPane.showInputDialog("Ingresa tu contraseña");


            }
            if (e.getSource() == registrar) {
                JOptionPane.showInputDialog("Elige un nombre");
                JOptionPane.showInputDialog("Elige una contraseña");
                JOptionPane.showInputDialog("Ingresa tu locación");
                JOptionPane.showInputDialog("Escribe tu fecha de nacimiento");

            }
            if (e.getSource() == bComunidad) {
                memes.setVisible(true);
                compras.setVisible(false);
                juegos.setVisible(false);

            }
            if (e.getSource() == bTienda) {
                compras.setVisible(true);
                juegos.setVisible(false);
                memes.setVisible(false);

            }
            if (e.getSource() == bBiblioteca) {
                juegos.setVisible(true);
                compras.setVisible(false);
                memes.setVisible(false);
            }
            if (e.getSource() == configuracion) {
                System.exit(0);
            }

            if (e.getSource() == juego1) {
                if (compras.isVisible()) {
                    comprar = JOptionPane.showConfirmDialog(null, "Este juego cuesta ¿Deseas comprarlo?", "Compra de " + "Dante's Inferno", JOptionPane.YES_NO_OPTION);
                    if (comprar == 0) {
                        juegos.add(juego1);
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Ya posees este juego, ¿Deseas jugarlo?", "Ejecución de " + "Dante's Inferno", JOptionPane.YES_NO_OPTION);
                }
            }

            if (e.getSource() == juego2) {
                if (compras.isVisible()) {
                    comprar = JOptionPane.showConfirmDialog(null, "Este juego cuesta ¿Deseas comprarlo?", "Compra de " + "Grand Theft Auto V", JOptionPane.YES_NO_OPTION);
                    if (comprar == 0) {
                        juegos.add(juego2);
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Ya posees este juego, ¿Deseas jugarlo?", "Ejecución de " + "Grand Theft Auto V", JOptionPane.YES_NO_OPTION);
                }
            }

            if (e.getSource() == juego3) {
                if (compras.isVisible()) {
                    comprar = JOptionPane.showConfirmDialog(null, "Este juego es gratuito ¿Deseas agregarlo a tu biblioteca??", "Compra de " + "League of Legends", JOptionPane.YES_NO_OPTION);
                    if (comprar == 0) {
                        juegos.add(juego3);
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Ya posees este juego, ¿Deseas jugarlo?", "Ejecución de " + "League of Legends", JOptionPane.YES_NO_OPTION);
                }
            }

            if (e.getSource() == juego4) {
                if (compras.isVisible()) {
                    comprar = JOptionPane.showConfirmDialog(null, "Este juego es gratuito ¿Deseas agregarlo a tu biblioteca??", "Compra de " + "Valorant", JOptionPane.YES_NO_OPTION);
                    if (comprar == 0) {
                        juegos.add(juego4);
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Ya posees este juego, ¿Deseas jugarlo?", "Ejecución de " + "Valorant", JOptionPane.YES_NO_OPTION);
                }
            }

            compras.updateUI();
            revalidate();
            repaint();

        }

    }
}
