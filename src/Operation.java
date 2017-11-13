/**
 * Written by Jinghan Liang
 * The application is a simulation of a toy robot moving on a 5*5 grid;
 * The robot is free to roam around the surface of the table,
 * When reach the boundary of grid, the move will be ignored and execute next cmd.
 * If the robot is initially placed on invalid place, the placement will be ignored and robot 
 * placed on default position [0,0]
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Operation {
	final String[] direction = {"NORTH","EAST","SOUTH","WEST"};
	final int len = 5;
	private char[][] grid = new char[len][len]; //initialize 5*5 grid
	int X=0;  // coordinateX
	int Y=0;  // coordinateY
	String F=""; //facing direction 
	
	public static void main(String[] args) {
		Operation oper = new Operation();
		int testNum = 0; 
		while(testNum < 10){ //10 test examples
			File file = new File("test"+testNum+ ".txt");
	        BufferedReader reader = null;
	        String operations = null;
	        
	        try {
	            reader = new BufferedReader(new FileReader(file));
	            while ((operations = reader.readLine()) != null) { //read command line by line
	            	String[] cmd = operations.split(" ");
	            	
	        		switch(cmd[0]){
	        			case "PLACE":
	        				String[] cmdInfo = cmd[1].split(",");
	        				oper.X = Integer.parseInt(cmdInfo[0]);
	        				oper.Y = Integer.parseInt(cmdInfo[1]);
	        				oper.F = cmdInfo[2];	
	        				oper.placeRobot(oper.X,oper.Y);
	        				break;
	        			case "MOVE":
	        				oper.move(oper.X,oper.Y,oper.F);
	        				break;
	        			case "LEFT":
	        				oper.rotate(oper.F,"LEFT");
	        				break;
	        			case "RIGHT":
	        				oper.rotate(oper.F,"RIGHT");
	        				break;
	        			case "REPORT":
	        				System.out.println("test"+testNum + "   "+oper.X + "," + oper.Y + "," + oper.F);
	        				testNum++;
	        				break;
	        		}
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
		}
	}
	
	// "PLACE" cmd
	public void placeRobot(int X, int Y){
		if(isValid(X)&&isValid(Y)){
			grid[X][Y] = 'O';
		}
		else{
			System.out.println("Invalid place,the robot is put on default place[0,0]");
			grid[0][0] = 'O';
		}
	}
	
	//"MOVE" cmd
	public void move(int X,int Y,String F){
		String errorMsg = "invalid move as out of the boundary,this move is ignored";
		switch(F){
			case "NORTH":
				if(isValid(Y+1)){
					this.Y = Y+1;
					break;
				}
				else{
					System.out.println(errorMsg);
					break;
				}
			case "SOUTH":
				if(isValid(Y-1)){
					this.Y = Y-1;
					break;
				}
				else{
					System.out.println(errorMsg);
					break;
				}
			case "EAST":
				if(isValid(X+1)){
					this.X = X+1;
					break;
				}
				else{
					System.out.println(errorMsg);
					break;
				}
			case "WEST":
				if(isValid(X-1)){
					this.X = X-1;
					break;
				}
				else{
					System.out.println(errorMsg);
					break;
				}
		}
		placeRobot(this.X,this.Y);
	}
	
	// validating whether the position is out of boundary of grid
	public boolean isValid(int pos){
		if(pos<0||pos>len-1)
			return false;
		else
			return true;
	}
	
	//"ROTATE" cmd
	public void rotate(String F,String rotateDir){
		int indexF=0;  // the index of F in the direction array
		for(int i=0;i<direction.length;i++){
			if(F.equals(direction[i]))
				indexF = i;
		}
		if(rotateDir == "LEFT"){
			if(indexF == 0){
				this.F = direction[direction.length-1];
			}
			else{
				this.F = direction[indexF-1];
			}
		}
		else{
			if(indexF == direction.length-1){
				this.F = direction[0];
			}
			else{
				this.F = direction[indexF+1];
			} 
		}
	}
}
