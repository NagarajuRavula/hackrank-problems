package com.hackerrank.problems.general;

import java.util.Scanner;

public class Necklace {

	private static int b,g,r,y,necklaceLength = 0;
	private static boolean isFirstTurn = true;
	private static String lastColor = "";
	
	public static void main(String args[]) {	
		Scanner sc = new Scanner(System.in);
		b = sc.nextInt(); 
		r = sc.nextInt();
	    y = sc.nextInt();
		g = sc.nextInt();
		if(b>y) {
			necklaceLength = necklaceLength+(b-y);
			b = y;
		}
		else if(g>r) {
			necklaceLength = necklaceLength+(g-r);
			g = r;
		}
		necklaceLength = calculateLength(b,r,y,g);
		System.out.println("Necklace length is: "+necklaceLength);
		
	}
	private static int calculateLength(int blue,int red,int yellow,int green) {
		if(isFirstTurn) {
			if(blue>0) {
				necklaceLength ++;
				isFirstTurn = false;
				blue--;
				lastColor = "blue";
				return calculateLength(blue,red,yellow,green);
			}
			else if(red>0) {
				necklaceLength ++;
				isFirstTurn = false;
				red--;
				lastColor = "red";
				return calculateLength(blue,red,yellow,green);
			}
				
		}
		
		
		switch(lastColor){
			case "blue": {
				if(blue>0||red>0) {
					if(blue>=red) {
						necklaceLength ++;
						blue--;
						lastColor = "blue";
						return calculateLength(blue,red,yellow,green);
					}
					else {
						necklaceLength ++;
						red--;
						lastColor = "red";
						return calculateLength(blue,red,yellow,green);
					}
				}
				else
					return necklaceLength;
			}
			case "green": {
				
				if(green>0||yellow>0) {
					if(green>=yellow) {
						necklaceLength ++;
						green--;
						lastColor = "green";
						return calculateLength(blue,red,yellow,green);
					}
					else {
						necklaceLength ++;
						yellow--;
						lastColor = "yellow";
						return calculateLength(blue,red,yellow,green);
					}
				}
				else
					return necklaceLength;
			}
			case "red": {
				if(green>0||yellow>0) {
					if(green>=yellow) {
						necklaceLength ++;
						green--;
						lastColor = "green";
						return calculateLength(blue,red,yellow,green);
					}
					else {
						necklaceLength ++;
						yellow--;
						lastColor = "yellow";
						return calculateLength(blue,red,yellow,green);
					}
				}
				else
					return necklaceLength;
			}
			case "yellow": {
				if(blue>0||red>0) {
					if(blue>=red) {
						necklaceLength ++;
						blue--;
						lastColor = "blue";
						return calculateLength(blue,red,yellow,green);
					}
					else {
						necklaceLength ++;
						red--;
						lastColor = "red";
						return calculateLength(blue,red,yellow,green);
					}
				}
				else
					return necklaceLength;
				
			}
			
			default : {
				if(green>0||yellow>0) {
					if(yellow>=red) {
						necklaceLength ++;
						yellow--;
						lastColor = "yellow";
						return calculateLength(blue,red,yellow,green);
					}
					else {
						necklaceLength ++;
						green--;
						lastColor = "green";
						return calculateLength(blue,red,yellow,green);
					}
				}
				else
					return necklaceLength;
			}			
		}
	}
}
