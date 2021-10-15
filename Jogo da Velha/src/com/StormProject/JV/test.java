package com.StormProject.JV;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class test {
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      JPanel pane = new JPanel();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.add(pane);
      frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
      JPanel panel = new JPanel();
      JButton btn1 = new JButton("One");
      JButton btn2 = new JButton("Two");
      JButton btn3 = new JButton("Three");
      JButton btn4 = new JButton("Four");
      JButton btn5 = new JButton("Five");
      panel.add(btn1);
      panel.add(btn2);
      panel.add(btn3);
      panel.add(btn4);
      panel.add(btn5);
      panel.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.setPreferredSize(new Dimension(400, 100));
      panel.setMaximumSize(new Dimension(400, 100));
      panel.setBorder(BorderFactory.createTitledBorder("demo"));
      frame.getContentPane().add(panel);
      frame.setSize(550, 300);
      frame.setVisible(true);
   }
}
