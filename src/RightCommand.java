
public class RightCommand implements Command{
	private Robot robot;
	
	public RightCommand(Robot robot){
		this.robot = robot;
	}
	
	@Override
	public void execute(){
		robot.rotate("RIGHT");
	}
	
	@Override
	public boolean execute(int X,int Y,String F){
		return false;
	}

}
