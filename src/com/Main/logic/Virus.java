package com.Main.logic;

import java.awt.Point;
import java.util.Iterator;
import java.util.Scanner;

public class Virus {
	
	public int x = 0;
	public int y = 0;
	
	public int target_x;
	public int target_y;
	
	private int eyes = 20;
	
	private int hunger = 1200;
	private int mating_timer = 600;
	private int age = 6000;
	
	private int offspring = 0;
	private int age_length = 0;
	
	private int matingPriority = 1;
	private int hungerPriority = 1;
	
	private final int DEFAULT_SPEED = 5;
	
	public int iteration = 0;
	
	public boolean readytoMate = false;
	public boolean dead = false;
	
	public boolean hasTarget = false;
	boolean ready = false;
	Virus temp;
	
	int num = 0;
	
	public Virus(int x, int y, int mat, int hun, int eye, int iteration, int num) {
		this.x = x;
		this.y = y;
		
		matingPriority = mat;
		hungerPriority = hun;
		eyes = eye;
		
		mating_timer = (int) (mating_timer * (Math.random()*20+1)/10);
		
		this.iteration = iteration;
		this.num = num;
	}
	
	public void update () {
		hunger--;
		//age--;
		
		//System.out.println(hunger + " " + age);
		
		if (hunger > -20 || age <= 0) {
			dead = true;
		}
		
		if (mating_timer <= 0) {
			ready = true;
		}else {
			mating_timer--;
		}
		
		age_length++; 
		
		if (ready == true) {
			Scene.virus.add(temp);
			System.out.println("-------------------------------------------------------");
			ready = false;
			mating_timer = 30000;
			
		}
		
		
		
		
		if (foodscan() && (hunger < 10)){
			
				int angle = (int) getAngle(new Point(target_x, target_y));
//				x = x - (int) (Math.sin(Math.toRadians(angle))*2);
//			    y = y + (int) (Math.cos(Math.toRadians(angle))*2);
				
				if (x < target_x) {
					x+=5;
				}
				if (x > target_x) {
					x-=5;
				}
				if (y < target_y) {
					y+=5;
				}
				if (y > target_y) {
					y-=5;
				}
				
				
				System.out.println("YAYAYAYA");
			
		}
			if (matescan() && readytoMate) {
				//int angle = (int) getAngle(new Point(target_x, target_y));
				//y = y + (int) (Math.sin(Math.toRadians(angle)));
			   // x = x + (int) (Math.cos(Math.toRadians(angle)));
				
				if (x < target_x) {
					x+=10;
				}
				if (x > target_x) {
					x-=10;
				}
				if (y < target_y) {
					y+=10;
				}
				if (y > target_y) {
					y-=10;
				}
				
				
			}
			
				int angle = (int) (Math.random()*4+1);
				
				System.out.print(angle);
				
				if (angle == 1) {
					x+= 5;
				}
				if (angle == 2) {
					x-= 5;
				}
				if (angle == 3) {
					y+= 5;
				}
				if (angle == 4) {
					y-= 5;
				}
				
			   //y = y + (int) (Math.sin(Math.toRadians(angle)) * DEFAULT_SPEED);
			  // x = x + (int) (Math.cos(Math.toRadians(angle)) * DEFAULT_SPEED);
				
				
				
			}
		
		
		
		
		
	//}
	
	public boolean foodscan() {
		Iterator it = Scene.food.iterator();
		int count = 0;
		//System.out.println("Flag");
        while(it.hasNext()){
        	Scanner sc = new Scanner(it.next() + "").useDelimiter(",");
        	int tempx = sc.nextInt();
        	int tempy = sc.nextInt();
        	//System.out.println("Flag");
        	if (calculateDistanceBetweenPointsWithHypot(x, y, tempx, tempy) < eyes) {
        		double temp = (hungerPriority + matingPriority);
        		//System.out.println(Math.random()*temp+1);
        		
        		if ((Math.random()*temp) <= hungerPriority) {
        			//System.out.println("Flag222222");
        			if (calculateDistanceBetweenPointsWithHypot(x, y, tempx, tempy) <= 20) {
        				Scene.food.remove(count);
        				Populate.addFood();
        				
        				hunger = 40;
        			}else {
        			
        			target_x = tempx;
        			target_y = tempy;
        			//System.out.println("Flag2");
        			
        			
        			}
        			return true;
        		}
        		
        		
    		}
        	sc.close();
        	count++;
        }
		return false;
		
	}
	
	public boolean matescan() {
		Iterator it = Scene.virus.iterator();

        while(it.hasNext()){
        	Virus virus2 = (Virus) it.next();
        	int tempx = virus2.getX();
        	int tempy = virus2.getY();
        	
        	
        	Scanner sc = new Scanner(it.next() + "").useDelimiter(",");
        	
        	if (calculateDistanceBetweenPointsWithHypot(x, y, tempx, tempy) < eyes) {
        		if (calculateDistanceBetweenPointsWithHypot(x, y, tempx, tempy) <= 20) {
        			//Adjust Prior
        			
        			temp = new Virus(x, y, 1, 1, 100, iteration+1, Scene.getCounter());
        			Scene.setCounter(Scene.getCounter()+1);
        			
        			
        		}
        		double temp = (hungerPriority + matingPriority);
        		
        		if ((Math.random()*temp) >= hungerPriority && virus2.ready) {
        			System.out.println("ajnrgnbshbsjnfjnefjnfjfjnak----------------------------------------------------");
        			target_x = tempx;
        			target_y = tempy;
        			ready = true;
        			
        			
        			return true;
        		}
        		
        		
    		}
        	sc.close();
        }
        
        //it.remove();
        
        //Scene.virus.add(temp);
		return false;
	}
	
	public double calculateDistanceBetweenPointsWithHypot(double x1, double y1, double x2, double y2) {     
		    double ac = Math.abs(y2 - y1);
		    double cb = Math.abs(x2 - x1);
		        
		    return Math.hypot(ac, cb);
	}
	
	public float getAngle(Point target) {
	    float angle = (float) Math.toDegrees(Math.atan2(target.y - y, target.x - x));

	    if(angle < 0){
	        angle += 360;
	    }

	    return angle;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
	
	

}
