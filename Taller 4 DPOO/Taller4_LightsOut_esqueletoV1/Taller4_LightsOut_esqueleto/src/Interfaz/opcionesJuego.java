package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.dpoo.taller4.modelo.Tablero;

public class opcionesJuego extends JPanel implements ActionListener {
    
    private JButton btnNuevo;
    private JButton btnReiniciar;
    private JButton btnTop;
    private JButton btnCambiarJugador;
    private InterfazController interfaz;
    private JButton btnGuardar = new JButton();
    private JFrame frameUsuario;
    private JTextField texto;
    private panelTop top = new panelTop();;
    
    public opcionesJuego(InterfazController pInterfaz) {
    	
    	
    	interfaz = pInterfaz;
        setLayout(new GridLayout(15, 1));
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        btnNuevo = new JButton(); 
        btnNuevo.setText("NUEVO");
        btnReiniciar = new JButton(); 
        btnReiniciar.setText("REINICIAR");
        btnTop = new JButton(); 
        btnTop.setText("TOP-10");
        btnCambiarJugador = new JButton(); 
        btnCambiarJugador.setText("CAMBIAR JUGADOR");
        btnNuevo.setBackground(Color.CYAN);
        btnReiniciar.setBackground(Color.CYAN);
        btnTop.setBackground(Color.CYAN);
        btnCambiarJugador.setBackground(Color.CYAN);
        add(btnNuevo);
        add(new JLabel());
        add(btnReiniciar);
        add(new JLabel());
        add(btnTop);
        add(new JLabel());
        add(btnCambiarJugador);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        btnNuevo.addActionListener(this);
        btnReiniciar.addActionListener(this);
        btnTop.addActionListener(this);
        btnCambiarJugador.addActionListener(this);
    }

    	public JButton getReiniciar()
    	{
    		return btnReiniciar;
    	}
    	public void top10(String nombre, int puntaje)
    	{
    		top.agregarReg(nombre, puntaje);
    	}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReiniciar) {
        	interfaz.Reiniciar();
        } else if (e.getSource() == btnNuevo) {
        	interfaz.Nuevo();
        } else if (e.getSource() == btnTop) {
     
        	JFrame frame = new JFrame();
            frame.add(top);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(frame);
            frame.setTitle("Top 10");
            frame.setVisible(true);
        } else if (e.getSource() == btnCambiarJugador) {
        	nombreUsuario panelUsuario = new nombreUsuario();
        	JPanel panel = new JPanel();
        	JLabel jugador = new JLabel("Ingrese su nickname (máximo 3 letras):");
        	texto = new JTextField();
        	texto.setPreferredSize(new Dimension(300,100));
        	texto.setEnabled(true);
        	top10("ZDS", 40);
        	frameUsuario = new JFrame();
        	btnGuardar.setText("GUARDAR NOMBRE");
			btnGuardar.addActionListener(this);
        	panel.add(jugador);
        	panel.add(texto);
        	panel.add(btnGuardar);
        	frameUsuario.add(panel);
        	frameUsuario.setSize(400,300);
        	frameUsuario.setVisible(true);
        	frameUsuario.setLocationRelativeTo(frameUsuario);
        }else if (e.getSource()== btnGuardar) {
        	interfaz.setnombreJugador(texto.getText());
        	frameUsuario.dispose();
        }
    }
}

