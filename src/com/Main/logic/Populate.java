package com.Main.logic;

public class Populate {
	
	public static void addFood() {
		int x = (int) (Math.random()*1000+1);
		int y = (int) (Math.random()*1000+1);
		Scene.food.add(x+","+y);
		
	}
	
	public static void addVirus() {
		int x = (int) (Math.random()*1000+1);
		int y = (int) (Math.random()*1000+1);
		Scene.virus.add(new Virus(x, y, 1, 1, 100, 0, Scene.getCounter()));
		Scene.setCounter(Scene.getCounter()+1);
		
	}
	
	

}
