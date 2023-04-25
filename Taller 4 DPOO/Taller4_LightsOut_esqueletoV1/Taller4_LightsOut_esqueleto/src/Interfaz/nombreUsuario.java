package Interfaz;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class nombreUsuario extends JPanel implements ActionListener{

		private JLabel digitar = new JLabel();
		private JTextField texto = new JTextField();
		
		public nombreUsuario()
		{
			digitar.setText("Digite su nickname (máximo 3 letras): ");
			texto.setPreferredSize(new Dimension(300,100));
			texto.setEnabled(true);
			add(digitar);
			add(texto);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		        
		        	
		        } 
		}
