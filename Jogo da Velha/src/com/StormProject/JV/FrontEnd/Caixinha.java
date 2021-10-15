package com.StormProject.JV.FrontEnd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.StormProject.JV.BackEnd.Area;
import com.StormProject.JV.BackEnd.AreaListenner;
import com.StormProject.JV.BackEnd.Events;
import com.StormProject.JV.BackEnd.TabuleiroListenner;

@SuppressWarnings("serial")
public class Caixinha extends JButton implements AreaListenner{

	ArrayList<CaixinhaListenner> Observers = new ArrayList<CaixinhaListenner>();
	private final Color BG_PADRAO = new Color(184, 184, 184);
	private final Color BG_WHITE = new Color(255, 55, 255);
	Area area;
	
	public Caixinha(Area area2) {
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
		area = area2;
//		setBounds(new Rectangle(new Dimension(80,80)));
		addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if (e.getButton() == 1) {
					
					notifyEvent(Events.CLICKED, area);
//					System.out.println("" + area.getLinha() + area.getColuna());
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

	@Override
	public void eventListenner(Events event) {
		if (event == Events.CAMP_ADDED) {
			
			setText(area.getCamp().toString());
//		    System.out.println(area.getCamp().toString());
			
		} 
		
	}
	
	public void notifyMe(CaixinhaListenner listenner) {
		
		Observers.add(listenner);
		
	}
	
	public void notifyEvent(Events event, Area area) {
		
		Observers.forEach(o -> o.eventListenner(event, area));
		
	}
}
