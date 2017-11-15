
public class PlaceCommand implements Command{
	private Robot robot;
	
	public PlaceCommand(Robot robot){
		this.robot = robot ;
	}
	
	@Override
	public void execute(){
	}

	public boolean execute(int X, int Y, String F){
		return robot.placeRobot(X,Y,F);
	}
	
}
