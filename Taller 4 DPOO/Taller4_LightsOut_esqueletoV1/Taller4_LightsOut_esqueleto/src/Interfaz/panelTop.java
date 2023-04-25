package Interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.xml.crypto.Data;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class panelTop extends JPanel {

    private JLabel nombres = new JLabel();
    private Top10 top = new Top10();
    private ArrayList<Object> nuevoTop = new ArrayList<>();
    private Object[] arregloTop;
    private DefaultListModel<String> listaModelo = new DefaultListModel<>(); 
    private JList<String> lista = new JList<>(listaModelo); 

    public panelTop() {
        nombres.setText("# Nombre");
        nombres.setForeground(Color.RED);
        add(nombres);
        Collection<RegistroTop10> listaRegistros = top.darRegistros();
        setLayout(new FlowLayout());
        for (RegistroTop10 registro : listaRegistros) {
            String label = (listaModelo.size() + 1) + ". " + registro.toString();
            listaModelo.addElement(label);
            JLabel emptyLabel = new JLabel("");
            add(emptyLabel);
        }
        add(lista); 

       
        lista.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                
                int index = lista.locationToIndex(e.getPoint());
                if (index >= 0) {
                    lista.setSelectionBackground(new Color(38, 50, 56)); 
                    lista.setSelectionForeground(new Color(236, 240, 241)); 
                    lista.setFont(new Font("Helvetica", Font.BOLD, 14)); 
                } else {
                    lista.setSelectionBackground(Color.WHITE); 
                    lista.setSelectionForeground(Color.BLACK); 
                    lista.setFont(new Font("Helvetica", Font.PLAIN, 12)); 
                }
            }
        });

        
        lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                lista.setSelectionBackground(Color.WHITE); 
                lista.setSelectionForeground(Color.BLACK); 
                lista.setFont(new Font("Helvetica", Font.PLAIN, 12)); 
            }
        });
    }

    public void agregarReg(String nombre, int puntos) {
        top.agregarRegistro(nombre, puntos);
        String label = (listaModelo.size() + 1) + ". " + nombre + ": " + puntos; 
        listaModelo.addElement(label); 
    }
}

