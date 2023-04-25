package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class infoInterfaz extends JPanel
{

    private JLabel jugadas;
    private JLabel jugador;
    private JTextField jugadorT;
    private JTextField jugadasT;
    

    public infoInterfaz ()
    {
        setLayout( new GridLayout( 1,4 ) );
        jugadas = new JLabel();
        jugadas.setText("jugadas");
        jugador = new JLabel();
        jugador.setText("jugador");
        jugadasT = new JTextField();
        jugadasT.setForeground(Color.BLUE);
        jugadasT.setEnabled(false);
        jugadorT = new JTextField();
        jugadorT.setEnabled(false);
        add(jugadas);
        add(jugadasT);
        add(jugador);
        add(jugadorT);
    }

    public void cambiarTextoJugadas(int i)
    {
        jugadasT.setText(Integer.toString(i)); 
    }

    void cambiarTextoJugador(String cadena)
    {
        jugadorT.setText(cadena);
        jugadorT.setForeground(Color.BLACK);
    }
    public void darJugadas () {
    	jugadasT.getText();
    }
    public void darJugador () {
    	jugadorT.getText();
    }
}