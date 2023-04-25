package Interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class tableroJuego extends JPanel {

    private int GRID_SIZE;
    private boolean[][] cells;
    Tablero tab = new Tablero(GRID_SIZE);
    private int arcSize = 10; // Tamaño del arco de las esquinas redondeadas
    
    public tableroJuego(boolean[][] pcells) {
        cells = pcells;
        GRID_SIZE = 5;
      
    }

    public void setGridSize(int tam) {
        GRID_SIZE = tam;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int cellWidth = getWidth() / GRID_SIZE;
        int cellHeight = getHeight() / GRID_SIZE;

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if ((cells[i][j])) {
                    // Si cells[i][j] es true, entonces rellenamos el cuadro de color amarillo
                    g.setColor(Color.YELLOW); 
                    g.fillRoundRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight, arcSize, arcSize); 
                    
                    // Cargar y dibujar la imagen en la casilla
                    try {
                        // Cambia la ruta de tu imagen
                    	File imagenFile = new File("data/luz.png");
                        Image imagen = ImageIO.read(imagenFile);
                        g.drawImage(imagen, i * cellWidth, j * cellHeight, cellWidth, cellHeight, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                g.setColor(Color.RED); // Color de los bordes rojo
                g.drawRoundRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight, arcSize, arcSize); 
            }  
        }
    }
}

    

