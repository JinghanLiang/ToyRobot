import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Client {

	public static void main(String[] args) {
		int X=0;
		int Y=0;
		String F= "";
		Queue<String> cmdList = new LinkedList<String>();
		
		//create "receiver" object
        Robot robot = new Robot();
        //create command object
        Command placeCommand = new PlaceCommand(robot);
        Command moveCommand = new MoveCommand(robot);
        Command leftCommand = new LeftCommand(robot);
        Command rightCommand = new RightCommand(robot);
        Command reportCommand = new ReportCommand(robot);
        //create "invoker" object
        Invoker invoker = new Invoker();
        invoker.setPlaceCmd(placeCommand);
        invoker.setMoveCmd(moveCommand);
        invoker.setLeftCmd(leftCommand);
        invoker.setRightCmd(rightCommand);
        invoker.setReportCmd(reportCommand);
        

        //test
        int testNum = 1; 
		while(testNum <= 10){ //10 test examples
			File file = new File("/Users/Jinghan/Github/ToyRobot/testInput/test"+testNum+ ".txt");
	        BufferedReader reader = null;        
	        try {
	        	//read test file and store commands into arraryList
	            reader = new BufferedReader(new FileReader(file));
	            String lineText = null;
	            while ((lineText = reader.readLine())!= null) { 
	            	cmdList.add(lineText);
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
            //process command
            String[] cmd = null;
            boolean isPlaced = false;
            while(cmdList.size()>0){
            	cmd = cmdList.poll().split(" ");
            	if(cmd[0].equals("PLACE")){
    				String[] cmdInfo = cmd[1].split(",");
    				X = Integer.parseInt(cmdInfo[0]);
    				Y = Integer.parseInt(cmdInfo[1]);
    				F = cmdInfo[2];	
    				isPlaced = invoker.place(X,Y,F);
            	}
            	else if(isPlaced){
	        		switch(cmd[0]){		        			
	        			case "MOVE":
	        				invoker.move();
	        				break;
	        			case "LEFT":
	        				invoker.left();
	        				break;
	        			case "RIGHT":
	        				invoker.right();
	        				break;
	        			case "REPORT":
	        				invoker.report();
	        				testNum++;
	        				break;
	        		}
            	}
            }
		}	
	}
}
