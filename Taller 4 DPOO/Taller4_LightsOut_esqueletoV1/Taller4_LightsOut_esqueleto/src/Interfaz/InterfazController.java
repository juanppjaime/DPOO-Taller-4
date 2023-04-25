package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class InterfazController extends JFrame implements MouseListener{
	
	private int num=6;
    private Tablero tab = new Tablero(11);
    private infoInterfaz info = new infoInterfaz();
    private opcionesJuego opciones;
    private interfazConfiguraciones config;
    private tableroJuego tablero = new tableroJuego(tab.darTablero());
    private String nombreJugador;
    private nombreUsuario usuarios= new nombreUsuario();
    private Top10 top = new Top10();
    private panelTop topsito = new panelTop();
    private boolean[][] tablero_original = tab.darTablero();
    

    public InterfazController() {
    	
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(info, BorderLayout.SOUTH);
        info.setVisible(true);
        setSize(750, 500);
        opciones = new opcionesJuego(this);
        panel.add(opciones, BorderLayout.EAST);
        opciones.setVisible(true);
        config = new interfazConfiguraciones(this, tablero);
        config.setBackground(Color.CYAN);
        panel.add(config, BorderLayout.NORTH);
        config.setVisible(true);
        panel.add(tablero, BorderLayout.CENTER);
        tablero.setVisible(true);
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        add(panel);

        tablero.addMouseListener(this); // Registrar esta instancia como un MouseListener en el panel tablero
    }

    public void setnombreJugador(String name)
    {
    	nombreJugador = name;
    	cambiarJugador();
    }
    public void cambiarJugador()
    {
    	info.cambiarTextoJugador(nombreJugador);
    }
    
    public void setNum(int numero)
    {
    	num = numero;
    }
    public int getNum()
    {
    	return num;
    }
    public void Reiniciar()
    {
    	tab.reiniciar();
    	repaint();
    }
    public void dificultadFacil()
    {
    	tab.desordenar(1);
    	repaint();
    }
    public void dificultadMedio()
    {
    	tab.desordenar(6);
    	repaint();
    }
    public void dificultadDificil()
    {
    	tab.desordenar(8);
    	repaint();
    }
    public void Nuevo()
    {
    	String nombreActual = nombreJugador;
        // Cerrar la ejecución actual
        dispose();
        // Crear una nueva instancia de InterfazController
        InterfazController nuevaEjecucion = new InterfazController();
         // Establecer el nombre del jugador en la nueva instancia
        nuevaEjecucion.setVisible(true);
}
    
    private int[] convertirCoordenadasACasilla(int x, int y)
    {
    	int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
		int altoCasilla = altoPanelTablero / num;
        int anchoCasilla = anchoPanelTablero / num;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
    }

    // Métodos de la interfaz MouseListener

    @Override
    public void mouseClicked(MouseEvent e) {
        // Lógica para manejar el clic del mouse en la ventana
        int x = e.getX(); // Obtener coordenada X del clic
        int y = e.getY(); // Obtener coordenada Y del clic
        int[] casilla = convertirCoordenadasACasilla(x,y);
        int fila = casilla[0];
        int columna = casilla[1];
        tab.jugar(columna,fila);
        boolean verificacion = tab.tableroIluminado();
        if (verificacion == true)
        {
        	int puntaje = tab.calcularPuntaje();
        	System.out.println(puntaje);
        	
        }

        info.cambiarTextoJugadas(tab.darJugadas());
        repaint();
    }
    

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Lógica para manejar el release del mouse en la ventana
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Lógica para manejar la entrada del mouse en la ventana
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Lógica para manejar la salida del mouse de la ventana
    }

    public static void main(String[] args) {
    	
        InterfazController paginaPrincipal = new InterfazController();
        paginaPrincipal.setVisible(true);
        
    }

}
