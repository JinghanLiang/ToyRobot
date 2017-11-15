
public class Invoker {

	private Command placeCmd;
	private Command moveCmd;
	private Command leftCmd;
	private Command rightCmd;
	private Command reportCmd;

	public void setPlaceCmd(Command placeCmd) {
		this.placeCmd = placeCmd;
	}

	public void setMoveCmd(Command moveCmd) {
		this.moveCmd = moveCmd;
	}

	public void setLeftCmd(Command leftCmd) {
		this.leftCmd = leftCmd;
	}

	public void setRightCmd(Command rightCmd) {
		this.rightCmd = rightCmd;
	}

	public void setReportCmd(Command reportCmd) {
		this.reportCmd = reportCmd;
	}

	public boolean place(int X, int Y, String F) {
		return placeCmd.execute(X, Y, F);
	}

	public void move() {
		moveCmd.execute();
	}

	public void left() {
		leftCmd.execute();
	}

	public void right() {
		rightCmd.execute();
	}

	public void report() {
		reportCmd.execute();
	}

}
