package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class interfazConfiguraciones extends JPanel implements ActionListener {

    private JLabel dificultad;
    private JLabel tamanio;
    private JLabel facil;
    private JLabel medio;
    private JLabel dificil;
    private JComboBox<String> tamanioTab;
    private String[] opcionesComboBox;
    private JRadioButton modoJuego;
    private JRadioButton facilRadioButton;
    private JRadioButton medioRadioButton;
    private JRadioButton dificilRadioButton;
    private ButtonGroup grupo;
    private InterfazController interfaz;
    private static final long serialVersionUID = 1L;
    public tableroJuego tablero;
   
    

    public interfazConfiguraciones(InterfazController pInterfaz, tableroJuego pTablero) {
    	
    	tablero = pTablero;
    	interfaz = pInterfaz;
        setLayout(new GridLayout(1, 9));
        tamanio = new JLabel();
        tamanio.setText("Tamaño:");
        add(tamanio);
        String[] opciones = {"5x5", "7x7", "9x9"};
        JComboBox<String> tamanioTab = new JComboBox<>(opciones);
        tamanioTab.addActionListener(this); // Agregar ActionListener al JComboBox
        add(tamanioTab);
        dificultad = new JLabel();
        dificultad.setText("Dificultad:");
        add(dificultad);
        JRadioButton facilRadioButton = new JRadioButton("Fácil");
        JRadioButton medioRadioButton = new JRadioButton("Medio");
        JRadioButton dificilRadioButton = new JRadioButton("Difícil");
        facilRadioButton.setBackground(Color.CYAN);
        medioRadioButton.setBackground(Color.CYAN);
        dificilRadioButton.setBackground(Color.CYAN);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(facilRadioButton);
        grupo.add(medioRadioButton);
        grupo.add(dificilRadioButton);
        facilRadioButton.addActionListener(this); // Agregar ActionListener al JRadioButton Fácil
        medioRadioButton.addActionListener(this); // Agregar ActionListener al JRadioButton Medio
        dificilRadioButton.addActionListener(this); // Agregar ActionListener al JRadioButton Difícil
        add(facilRadioButton);
        add(medioRadioButton);
        add(dificilRadioButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JRadioButton) {

            JRadioButton radioButton = (JRadioButton) e.getSource();
            if (radioButton.getText().equals("Fácil")) {
                interfaz.dificultadFacil();
            } else if (radioButton.getText().equals("Medio")) {
                interfaz.dificultadMedio();
            } else if (radioButton.getText().equals("Difícil")) {
                interfaz.dificultadDificil();
            }

        } else if (e.getSource() instanceof JComboBox) {
            JComboBox<?> comboBox = (JComboBox<?>) e.getSource();
            String selectedOption = (String) comboBox.getSelectedItem();
            // Implementa la lógica para cada opción seleccionada en el JComboBox
            if (selectedOption.equals("5x5")) {

                tablero.setGridSize(5);
                interfaz.setNum(6);
                tablero.repaint();
            } else if (selectedOption.equals("7x7")) {

                tablero.setGridSize(7);
                interfaz.setNum(9);
                repaint();

                repaint();
            } else if (selectedOption.equals("9x9")) {

                tablero.setGridSize(9); 
                interfaz.setNum(11);
                repaint();
            }
        }
    }
}


