
public class MoveCommand implements Command{
	private Robot robot;
	
	public MoveCommand(Robot robot){
		this.robot = robot;
	}
	
	@Override
	public void execute(){
		robot.move();
	}
	
	@Override
	public boolean execute(int X,int Y,String F){
		return false;
	}
}

