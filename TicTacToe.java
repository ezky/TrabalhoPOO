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
		private JButton buttons[] = new JButton[9];
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
				buttons[i] = new JButton();
				buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
				pnlForm.add(buttons[i]);
	            buttons[i].setText("");
	            buttons[i].addActionListener(new clicarBotao());
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
	            buttons[i].setText("");
	            buttons[i].setEnabled(true);
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
	            if(buttons[0].getText().equals(buttons[1].getText())
	            		&& buttons[1].getText().equals(buttons[2].getText()))
	                return buttons[0].getText();
	            else if(buttons[3].getText().equals(buttons[4].getText()) 
	            		&& buttons[4].getText().equals(buttons[5].getText()))
	                return buttons[3].getText();
	            else if(buttons[6].getText().equals(buttons[7].getText()) 
	            		&& buttons[7].getText().equals(buttons[8].getText()))
	                return buttons[6].getText();
	            
	            //vertical
	            else if(buttons[0].getText().equals(buttons[3].getText()) 
	            		&& buttons[3].getText().equals(buttons[6].getText()))
	                return buttons[0].getText();
	            else if(buttons[1].getText().equals(buttons[4].getText()) 
	            		&& buttons[4].getText().equals(buttons[7].getText()))
	                return buttons[1].getText();
	            else if(buttons[2].getText().equals(buttons[5].getText()) 
	            		&& buttons[5].getText().equals(buttons[8].getText()))
	                return buttons[2].getText();
	            
	            //diagonal
	            else if(buttons[0].getText().equals(buttons[4].getText()) 
	            		&& buttons[4].getText().equals(buttons[8].getText()))
	                return buttons[0].getText();
	            else if(buttons[2].getText().equals(buttons[4].getText()) 
	            		&& buttons[4].getText().equals(buttons[6].getText()))
	                return buttons[2].getText();
	            else
	            	return null;
	        }
	       
	    }

}


