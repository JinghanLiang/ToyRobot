
public class LeftCommand implements Command {
	private Robot robot;

	public LeftCommand(Robot robot) {
		this.robot = robot;
	}

	@Override
	public void execute() {
		robot.rotate("LEFT");
	}

	@Override
	public boolean execute(int X, int Y, String F) {
		return false;
	}
}
