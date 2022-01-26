package com.Main;

import com.Main.graphics.Mainfrm;
import com.Main.logic.Populate;

public class Main{

	 public static void main(String[] args) {
		 for (int i = 0; i < 20; i++) {
	  Populate.addFood();
	  Populate.addVirus();
		 }
		 
	  new Mainfrm();
	  
	 }
	}
