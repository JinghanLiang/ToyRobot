This is an implementation of ToyRobot.md which is based on "command pattern"

=============================================
Client.java

This class is entry of application. It initialized objects of five concrete commands by determining the command's receiver.

Invoker.java

It invokes the commands by calling execute method respectively.

Command interface

It declares execute method.

5 concrete commands.java

Each command class implements corresponding execute methods.

Robot.java

Robot is the receiver of commands. It execute a specific action.

=============================================

Valid "Place" processing:

Store commands into queue -> Iteratively retrive command from queues until a valid place is executed -> execute subsequent commands


=============================================

Boundary processing:

Use a two dimmension array to control boundary.
All operation resuling in out of boundary will throw execption
