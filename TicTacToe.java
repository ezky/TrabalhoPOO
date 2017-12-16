package controller;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TicTacToe extends JFrame implements ActionListener{
		private JButton casa[] = new JButton[9];
		private JButton btnRecomecar = new JButton();
		private JTextField txtJogadorX = new JTextField(2);
		private JTextField txtJogadorO = new JTextField(2);
		int alternate = 0;
		int count = 0;
		
		public TicTacToe(){
			JFrame janela1 = new JFrame("Jogo da Velha");
			JPanel pnlPrincipal = new JPanel(new BorderLayout());
			JPanel pnlForm = new JPanel(new GridLayout(3,3,5,5));
			JPanel pnlMenu = new JPanel();
			txtJogadorX.setText("0");
			txtJogadorO.setText("0");
			
			pnlMenu.add(new JLabel("Vitórias  |  Jogador X: "));
			pnlMenu.add(txtJogadorX);
			pnlMenu.add(new JLabel("Jogador O: "));
			pnlMenu.add(txtJogadorO);
			btnRecomecar.setText("Recomeçar");
			btnRecomecar.addActionListener(this);
			pnlMenu.add(btnRecomecar);

			for (int i =0; i <9; i++){
				casa[i] = new JButton();
				casa[i].setFont(new Font("Arial", Font.PLAIN, 40));
				pnlForm.add(casa[i]);
	            casa[i].setText("");
	            casa[i].addActionListener(new clicarBotao());
			}

			pnlPrincipal.add(pnlMenu, BorderLayout.NORTH);
			pnlPrincipal.add(pnlForm, BorderLayout.CENTER);
			
			janela1.setContentPane(pnlPrincipal);
			janela1.setSize(400, 450);
			janela1.setResizable(false);
			janela1.setVisible(true);
			janela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}

		public void zerarValores(){
	        for(int i = 0; i < 9; i++){
	            casa[i].setText("");
	            casa[i].setEnabled(true);
	            count = 0;
	        }
	    }
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
    		if ("Recomeçar".equals(cmd)) {
                txtJogadorX.setText("0");
                txtJogadorO.setText("0");
                zerarValores();
    		}
		}
		
	    private class clicarBotao implements ActionListener{	       
	        public void actionPerformed(ActionEvent e){
	        	int vencedor;
	            JButton botaoClicado = (JButton)e.getSource(); 
	            
	            if(alternate%2 == 0){
	                botaoClicado.setText("X");
	            	botaoClicado.setEnabled(false);
	            }else{
	                botaoClicado.setText("O");
            		botaoClicado.setEnabled(false);
	            }
	            
	            if(ChecarVencedor() == "X"){
	                JOptionPane.showMessageDialog(null, "Jogador X Venceu!");
	                vencedor = Integer.parseInt(txtJogadorX.getText());
	                vencedor+= 1;
	                txtJogadorX.setText(""+ vencedor);
	                zerarValores();
	            }else if(ChecarVencedor() == "O"){
	                JOptionPane.showMessageDialog(null, "Jogador O Venceu!");
	                vencedor = Integer.parseInt(txtJogadorO.getText());
	                vencedor+= 1;
	                txtJogadorO.setText(""+ vencedor);
	                zerarValores();
	            }else{
	            	count++;
	            	if (count == 9){
		                JOptionPane.showMessageDialog(null, "Empatou!");
	            		zerarValores();
	            	}
	            }
	            alternate++;
	        }
	        
	        public String ChecarVencedor(){
	            //horizontal
	            if(casa[0].getText().equals(casa[1].getText())
	            		&& casa[1].getText().equals(casa[2].getText()))
	                return casa[0].getText();
	            else if(casa[3].getText().equals(casa[4].getText()) 
	            		&& casa[4].getText().equals(casa[5].getText()))
	                return casa[3].getText();
	            else if(casa[6].getText().equals(casa[7].getText()) 
	            		&& casa[7].getText().equals(casa[8].getText()))
	                return casa[6].getText();
	            
	            //vertical
	            else if(casa[0].getText().equals(casa[3].getText()) 
	            		&& casa[3].getText().equals(casa[6].getText()))
	                return casa[0].getText();
	            else if(casa[1].getText().equals(casa[4].getText()) 
	            		&& casa[4].getText().equals(casa[7].getText()))
	                return casa[1].getText();
	            else if(casa[2].getText().equals(casa[5].getText()) 
	            		&& casa[5].getText().equals(casa[8].getText()))
	                return casa[2].getText();
	            
	            //diagonal
	            else if(casa[0].getText().equals(casa[4].getText()) 
	            		&& casa[4].getText().equals(casa[8].getText()))
	                return casa[0].getText();
	            else if(casa[2].getText().equals(casa[4].getText()) 
	            		&& casa[4].getText().equals(casa[6].getText()))
	                return casa[2].getText();
	            else
	            	return null;
	        }
	       
	    }

}


