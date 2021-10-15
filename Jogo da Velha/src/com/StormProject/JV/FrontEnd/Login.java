package com.StormProject.JV.FrontEnd;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.StormProject.JV.BackEnd.Bolinha;
import com.StormProject.JV.BackEnd.Campo;
import com.StormProject.JV.BackEnd.Events;
import com.StormProject.JV.BackEnd.Usuario;
import com.StormProject.JV.BackEnd.Xizinho;

@SuppressWarnings("serial")
public class Login extends JPanel{

	BorderLayout layout;
	public Users usere;
	ArrayList<LoginListenner> Observers = new ArrayList<LoginListenner>();
	boolean isLogged = false;  
	
	
	public Login() {
		JTextField j1name = new JTextField(30);
		JTextField j2name = new JTextField(30);
		JLabel name1 = new JLabel("Nome: ");
		JLabel name2 = new JLabel("Nome: ");
		JButton OK_Button = new JButton("OK");
		JCheckBox choseX = new JCheckBox("X");
		JCheckBox choseO = new JCheckBox("O");
		choseX.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (choseX.isSelected()) {
					if (choseO.isSelected()) {
						
						choseO.setSelected(false);
						
					}
					
				}
			}
		});;
		choseO.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (choseO.isSelected()) {
					if (choseX.isSelected()) {
						
						choseX.setSelected(false);
						
					}
					
				}
			}
		});;
		
		JPanel name1P = new JPanel();
		name1P.setLayout(new FlowLayout());
		name1P.add(name1);
		name1P.add(j1name);
		
		JPanel name2P = new JPanel();
		name2P.setLayout(new FlowLayout());
		name2P.add(name2);
		name2P.add(j2name);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		panel1.add(Box.createRigidArea(new Dimension(0,10)));
		panel1.add(name1P);
		panel1.add(new JLabel("Jogador 1 escolha seu Simbolo"));
		panel1.add(Box.createRigidArea(new Dimension(0,10)));
		panel1.add(choseX);
		panel1.add(choseO);
		panel1.add(Box.createRigidArea(new Dimension(0,10)));
		panel1.setBorder(BorderFactory.createTitledBorder("Jogador1 login:"));
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.add(Box.createRigidArea(new Dimension(0,10)));
		panel2.add(name2P);
		panel2.setBorder(BorderFactory.createTitledBorder("Jogador 2 login:"));
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.add(OK_Button);
		
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
//		add(new JLabel("Jogador 1 Login"));
		add(panel1);
		add(panel2);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(panel3);
		
		OK_Button.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if (e.getButton() == 1) {
					
					if (!((j1name.getText().isEmpty()) || ((j1name.getText() == null)))) {
						
						if (choseO.isSelected() || choseX.isSelected()) {
							
							if (!((j2name.getText().isEmpty()) || ((j2name.getText() == null)))) {
								
								Function< Boolean, Campo> choose = (choose1) -> {
									
									Xizinho X = new Xizinho();
									Bolinha O = new Bolinha();
									
									if (choseX.isSelected()) {
										
										if (choose1) {
											
											return X;
											
										}else {
											
											return O;
										}
										
									} else {
										
										if (choose1) {
											
											return O;
											
										} else {

											return X;
											
										}
										
									}
									
								};
								
								Usuario p1 = new Usuario(j1name.getText(), choose.apply(true));
								Usuario p2 = new Usuario(j2name.getText(), choose.apply(false));
								
								ArrayList<Usuario> users = new ArrayList<Usuario>();
								
								users.add(p1);
								users.add(p2);
								
								
								notifyEvent(Events.LOGGED, users);
								usere = new Users(users);
								
							} else {

								messageDialog("O nome do jogador 2 está Vazio");
								
								
							}
							
						} else {

							messageDialog("Jogador 1 excolha seu Simbolo");
							
						}
						
					}else {
						
						messageDialog("O nome do jogador 1 está Vazio");
						
					}
					
				}
				
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
			}
		});
		
	}
	
	public void notifyMe(LoginListenner listenner) {
		
		if (listenner == null) {
			return;
		}
		
		Observers.add(listenner);
		
	}
	
	public void notifyEvent(Events event, ArrayList<Usuario> list) {
		
		Observers.forEach(o -> o.loginListenner(event, list));
		
	}
	
	public void messageDialog(String txt) {
		
		JOptionPane pane = new JOptionPane();
		
		pane.showMessageDialog(null, txt);
		
		
	}
}
	
