This is an implementation of ToyRobot.md
It is written by Java.
It includes two classes.

TestInitalizer.java
This class is for creating 10 test examples on total random rules. (File has already included 10 examples)
 
Operation.java
This is the main function class.
The 5*5 grid is implemented by array;
Robot is presented by character "O";
Move operations will correspond to X and Y operation.

West -> X-1
East -> X+1
North -> Y+1
South -> Y-1

Boundary propessing:
Each move will be test its validation. Invalid move (out of boundary) will be ignored and next cmd will be executed.
Invalid placement will also be ignored and robot will be place on default place [0,0]
