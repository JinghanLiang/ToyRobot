
public class ReportCommand implements Command{
	private Robot robot;
	
	public ReportCommand(Robot robot){
		this.robot = robot;
	}
	
	@Override
	public void execute(){
		robot.report();
	}
	
	@Override
	public boolean execute(int X,int Y,String F){
		return false;
	}

}
