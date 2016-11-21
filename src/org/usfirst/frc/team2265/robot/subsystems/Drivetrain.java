package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2265.robot.RobotMap;
import org.usfirst.frc.team2265.robot.commands.DriveCommand;
//http://first.wpi.edu/FRC/roborio/release/docs/java/

/**
 *
 */

public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

	public static CANTalon frontLeft = new CANTalon(RobotMap.frontLeftPort); 
	public static CANTalon rearLeft = new CANTalon(RobotMap.rearLeftPort); 
	public static CANTalon frontRight = new CANTalon(RobotMap.frontRightPort); 
	public static CANTalon rearRight = new CANTalon(RobotMap.rearRightPort); 
	public static Joystick atkJoy = new Joystick(RobotMap.atkJoyPort);
	public static RobotDrive tank = new RobotDrive(frontLeft,rearLeft,frontRight,rearRight);
	public static DoubleSolenoid leftSol = new DoubleSolenoid (RobotMap.leftForwardPort, RobotMap.leftReversePort);
	public static DoubleSolenoid rightSol = new DoubleSolenoid (RobotMap.rightForwardPort, RobotMap.rightReversePort);

	public void drive() {
		double leftVal = atkJoy.getRawAxis(1);
		double rightVal = atkJoy.getRawAxis(5);
		tank.tankDrive(leftVal, rightVal);
  }

	public void extend(){
		leftSol.set(DoubleSolenoid.Value.kForward);
    	rightSol.set(DoubleSolenoid.Value.kForward);
	}
	public void retract(){
		leftSol.set(DoubleSolenoid.Value.kReverse);
    	rightSol.set(DoubleSolenoid.Value.kReverse);
	}

  public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        setDefaultCommand(new DriveCommand());
  }
}