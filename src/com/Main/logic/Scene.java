package com.Main.logic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Scanner;

public class Scene{
	
	public static int counter = 0;
	
	public static void setCounter(int counter) {
		Scene.counter = counter;
	}

	public static int getCounter() {
		return counter;
	}
	
	public static int counter2 = 0;
	
	public static void setCounter2(int counter) {
		Scene.counter2 = counter;
	}

	public static int getCounter2() {
		return counter2;
	}
	
	static int count = 0;

	public static LinkedList<Virus> virus = new LinkedList<>();
	public static LinkedList<String> food = new LinkedList<>();

	public static void run(Graphics2D g) throws InterruptedException {
		//while (true) {
		virus.forEach((virus2) -> {
			counter2++;
			g.setColor(Color.GREEN);
			virus2.update();
			if (virus2.dead) {
				//virus.remove(virus2);
				counter2--;
			}
		    g.drawOval(virus2.getX(), virus2.getY(), 4, 4);
		    //
		    
		    counter2 = 0;
		    
		});
		food.forEach((food2) -> {
		    Scanner sc = new Scanner(food2).useDelimiter(",");
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    g.setColor(Color.RED);
		    g.drawOval(x, y, 4, 4); 
		    //System.out.println(x + " : " + y);
		    sc.close();
		});
		
		try {
			Thread.sleep(16);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread.sleep(16);
		//}
		
	}
	
	public static int length() {
		count = 0;
		virus.forEach((virus2) -> {
			count++;
			
			if (virus2.dead) {
				//virus.remove(virus2);
				counter2--;
			}

		    //
		});
		
		return count;
	}
	

}
