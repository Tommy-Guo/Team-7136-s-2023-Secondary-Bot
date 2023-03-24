package frc.robot.helpers;

// This class is used to store all the values and IDs of the controllers, motors, and other things that are used in the code.
// It is the appendix of our robot. All values & IDs are stored here for better readibility and easier access.

public class appendix {

    // Values & IDs of controllers //
    public static int driveControllerID = 0;
    public static int actionControllerID = 0;

    // Values & IDs of inputs on controller //
    public static int buttonX = 3;
    public static int buttonY = 4;
    public static int buttonA = 1;
    public static int buttonB = 2;
 
    public static int buttonRight = 5;
    public static int buttonLeft = 6;
 
    public static int triggerLeft = 2;
    public static int triggerRight = 3;
 
    public static int axisLeftX = 0;
    public static int axisLeftY = 1;
    public static int axisRightX = 4;
    public static int axisRightY = 5;

    // Values & IDs of drive base motors //
    public static int motorLeft1 = 3;
    public static int motorLeft2 = 5;
    public static int motorRight1 = 4;
    public static int motorRight2 = 6;
 
    public static double rotateSpeed = 0.3;
 
    // Values & IDs of intake motors //
    public static int motorRotational = 7;
    public static int motorIntake = 1;
    public static double intakeSpeedLimit = 0.75;

    // Values & IDs of Arm motors //
    public static int motorArm1 = 7;
    public static int motorArm2 = 9;
}

// *All speed values in this appendix file are in percentages, for example a value of 50 would
// denote 50% of the respective motor's speed.
