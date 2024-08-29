package br.ufc.dc.tpi.janelas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MinhaJanela extends JFrame {
	
	private JTextArea areatexto;
	
	public MinhaJanela(){
		JButton botao = new JButton ("Antigo texto");
		
		JPanel pane = new JPanel();
		
		areatexto = new JTextArea(10,30);
		areatexto.setEditable(true); 
		
		MeuOuvinte listener = new MeuOuvinte();
		
		pane.add(botao);
		pane.add(areatexto);
		
		botao.addActionListener(listener);
		
		setContentPane(pane);
		pack();
		setVisible(true);
		
	}
	
	public class MeuOuvinte implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Object fonte = e.getSource();
			if (fonte instanceof JButton){
				((JButton)fonte).setText("Novo Texto");
				
				
				String texto = areatexto.getText();
				areatexto.setText(texto.toUpperCase());
				System.out.println(texto);
			}
			
		}

	}

}
//Jframe, Jpanel, JLabel(pode ter imagem dentro também), JTextArea, JButton, JTextField, JPasswordField, JRadioButton e JButtonGroup, JComboBox