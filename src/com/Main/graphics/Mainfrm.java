package com.Main.graphics;
import javax.swing.*;

public class Mainfrm extends JFrame{
 
 MainPanel panel;
 
 public Mainfrm(){
  
  panel = new MainPanel();
  
  
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  this.add(panel);
  this.pack();
  this.setLocationRelativeTo(null);
  this.setVisible(true);
  
  while(true) {
	  panel.repaint();
	  
	  try {
		Thread.sleep(16);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
 }  
}