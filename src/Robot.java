
public class Robot {

	final String[] direction = { "NORTH", "EAST", "SOUTH", "WEST" };
	final int len = 5;
	private char[][] grid = new char[len][len]; // initialize 5*5 grid
	private int X = 0; // coordinateX
	private int Y = 0; // coordinateY
	private String F = ""; // facing direction

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public String getF() {
		return F;
	}

	public void setX(int x) {
		X = x;
	}

	public void setY(int y) {
		Y = y;
	}

	public void setF(String f) {
		F = f;
	}

	// "PLACE" cmd
	public boolean placeRobot(int X, int Y, String F) {
		try {
			grid[X][Y] = 'O';
			this.X = X;
			this.Y = Y;
			this.F = F;
			return true;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("invalid operation is ignored as out of the boundary");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// "MOVE" cmd
	public void move() {
		switch (F) {
		case "NORTH":
			placeRobot(X, Y + 1, "NORTH");
			break;
		// if(placeRobot(X,Y+1,"NORTH")){
		// Y = Y+1;
		// break;
		// }
		case "SOUTH":
			placeRobot(X, Y - 1, "SOUTH");
			break;
		// if(placeRobot(X,Y-1,"SOUTH")){
		// Y = Y-1;
		// break;
		// }
		case "EAST":
			placeRobot(X + 1, Y, "EAST");
			break;
		// if(placeRobot(X+1,Y,"EAST")){
		// X=X+1;
		// break;
		// }
		case "WEST":
			placeRobot(X - 1, Y, "WEST");
			break;
		// if(placeRobot(X-1,Y,"WEST")){
		// X=X-1;
		// break;
		// }
		}
	}

	// "ROTATE" cmd
	public void rotate(String rotateDir) {
		int indexF = 0; // the index of F in the direction array
		for (int i = 0; i < direction.length; i++) {
			if (F.equals(direction[i]))
				indexF = i;
		}
		if (rotateDir == "LEFT") {
			if (indexF == 0) {
				F = direction[direction.length - 1];
			} else {
				F = direction[indexF - 1];
			}
		} else {
			if (indexF == direction.length - 1) {
				F = direction[0];
			} else {
				F = direction[indexF + 1];
			}
		}
	}

	// "Report" cmd
	public void report() {
		System.out.println(X + "," + Y + "," + F);
	}

}
