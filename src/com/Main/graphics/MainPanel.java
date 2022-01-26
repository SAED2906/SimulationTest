package com.Main.graphics;

import java.awt.*;
import javax.swing.*;

import com.Main.logic.Scene;

public class MainPanel extends JPanel{

 //Image image;
 
 MainPanel(){
  
  //image = new ImageIcon("sky.png").getImage();
  this.setPreferredSize(new Dimension(1000,1000));
 }
 
 public void paint(Graphics g) {
  
  Graphics2D g2D = (Graphics2D) g;
  g2D.clearRect(0, 0, 1000, 1000);
  //g2D.drawImage(image, 0, 0, null);
  
  
  g2D.setStroke(new BasicStroke(5));
  
  
  //while (true) {
	  
  try {
	Scene.run(g2D);
	g2D.drawString(Scene.length() + "", 20, 20);
	g2D.drawString(10+ "", 20, 80);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	  
	  
	  
	 
 // }
  
  //g2D.setPaint(Color.pink);
  //g2D.drawRect(0, 0, 100, 200);
  //g2D.fillRect(0, 0, 100, 200);
  
  //g2D.setPaint(Color.orange);
  //g2D.drawOval(0, 0, 100, 100);
  //g2D.fillOval(0, 0, 100, 100);
  
  //g2D.setPaint(Color.red);
  //g2D.drawArc(0, 0, 100, 100, 0, 180);
  //g2D.fillArc(0, 0, 100, 100, 0, 180);
  //g2D.setPaint(Color.white);
  //g2D.fillArc(0, 0, 100, 100, 180, 180);
  
  //int[] xPoints = {150,250,350};
  //int[] yPoints = {300,150,300};
  //g2D.setPaint(Color.yellow);
  //g2D.drawPolygon(xPoints, yPoints, 3);
  //g2D.fillPolygon(xPoints, yPoints, 3);
  
  //g2D.setPaint(Color.magenta);
  //g2D.setFont(new Font("Ink Free",Font.BOLD,50));
  //g2D.drawString("U R A WINNER! :D", 50, 50);  
  
  
  
 }
}
