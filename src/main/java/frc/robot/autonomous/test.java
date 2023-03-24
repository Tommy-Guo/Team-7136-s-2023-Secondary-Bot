// package frc.robot;

// import edu.wpi.first.wpilibj.Joystick;

// import edu.wpi.first.wpilibj.TimedRobot;

// import edu.wpi.first.wpilibj.Timer;

// import com.ctre.phoenix.motorcontrol.ControlMode;

// import com.ctre.phoenix.motorcontrol.can.TalonFX;

// public class Robot extends TimedRobot {

//     // Some easy constants for joystick button numbers for Logitech F320

//     public static final int A = 1;

//     public static final int B = 2;

//     public static final int X = 3;

//     public static final int Y = 4;

//     public static final int LB = 5;

//     public static final int RB = 6;

//     public static final int BACK = 7;

//     public static final int START = 8;

//     public static final int LT = 2;

//     public static final int RT = 3;

//     // Left and right drivetrain motors

//     // Requires CTRE Phoenix framework, need to set CAN IDs through Phoenix Tuner

//     TalonFX[] left1 = new TalonFX[] { new TalonFX(1) };

//     TalonFX[] right1 = new TalonFX[] { new TalonFX(3) };

//     TalonFX[] left2 = new TalonFX[] { new TalonFX(2) };

//     TalonFX[] right2 = new TalonFX[] { new TalonFX(4) };

//     // climber has been set to break mode through the Phoenix Tuner

//     TalonFX[] climber = new TalonFX[] { new TalonFX(5) };

//     TalonFX[] shooter = new TalonFX[] { new TalonFX(6) };

//     TalonFX[] shooterIntake = new TalonFX[] { new TalonFX(7) };

//     Joystick driverJS = new Joystick(0);

//     Joystick operatorJS = new Joystick(1);

//     Timer timer = new Timer();

//     double intakeSpeed = 0;

//     double shooterSpeed = 0;

//     @Override

//     public void robotInit() {

//     }

//     @Override

//     public void teleopPeriodic() {

//         // Get joystick values

//         double throttle = driverJS.getRawAxis(1);

//         double turn = driverJS.getRawAxis(4);

//         // Deadband

//         if (Math.abs(throttle) < 0.1)

//             throttle = 0;

//         if (Math.abs(turn) < 0.1)

//             turn = 0;

//         // If throttle is non-zero, scale turning by throttle

//         if (Math.abs(throttle) > 0.05)

//             turn *= Math.abs(throttle);

//         // Calculate left and right sides

//         double l = throttle + turn;

//         double r = throttle - turn;

//         // Set every motor controller

//         for (TalonFX s : left1)

//             s.set(ControlMode.PercentOutput, l);

//         for (TalonFX s : left2)

//             s.set(ControlMode.PercentOutput, l);

//         for (TalonFX s : right1)

//             s.set(ControlMode.PercentOutput, -r);

//         for (TalonFX s : right2)

//             s.set(ControlMode.PercentOutput, -r);

//         // Shooter intake speed

//         if (operatorJS.getRawButton(A))

//             intakeSpeed = -0.3;

//         // Off

//         else if (operatorJS.getRawButton(B))

//             intakeSpeed = 0;

//         // Shooter on

//         if (operatorJS.getRawButton(X))

//             shooterSpeed = -1;

//         // Off

//         else if (operatorJS.getRawButton(Y))

//             shooterSpeed = 0;

//         for (TalonFX s : shooterIntake)

//             s.set(ControlMode.PercentOutput, intakeSpeed);

//         for (TalonFX s : shooter)

//             s.set(ControlMode.PercentOutput, shooterSpeed);

//         // Left stick Y is climber

//         double climberSpeed = -operatorJS.getRawAxis(1);

//         // Climber JS deadband

//         if (Math.abs(climberSpeed) < 0.15)

//             climberSpeed = 0;

//         for (TalonFX s : climber)

//             s.set(ControlMode.PercentOutput, climberSpeed);

//     }

//     @Override

//     public void autonomousInit() {

//         timer.reset();

//         timer.start();

//     }

//     @Override

//     public void autonomousPeriodic() {

//         // spin up shooter

//         if (timer.get() < 2) {

//             for (TalonFX s : shooter)

//                 s.set(ControlMode.PercentOutput, -1);

//         }

//         // turn on feed to shooter

//         else if (timer.get() < 4) {

//             for (TalonFX s : shooterIntake)

//                 s.set(ControlMode.PercentOutput, -0.3);

//         }

//         // rotate about 90 degrees

//         else if (timer.get() < 4.5) {

//             for (TalonFX s : left1)

//                 s.set(ControlMode.PercentOutput, -.5);

//             for (TalonFX s : left2)

//                 s.set(ControlMode.PercentOutput, -.5);

//             for (TalonFX s : right1)

//                 s.set(ControlMode.PercentOutput, -.5);

//             for (TalonFX s : right2)

//                 s.set(ControlMode.PercentOutput, -.5);

//         }

//         // drive off the line

//         else if (timer.get() < 5.1) {

//             for (TalonFX s : left1)

//                 s.set(ControlMode.PercentOutput, .5);

//             for (TalonFX s : left2)

//                 s.set(ControlMode.PercentOutput, .5);

//             for (TalonFX s : right1)

//                 s.set(ControlMode.PercentOutput, -.5);

//             for (TalonFX s : right2)

//                 s.set(ControlMode.PercentOutput, -.5);

//         }

//         // turn all the motors off

//         else {

//             for (TalonFX s : left1)

//                 s.set(ControlMode.PercentOutput, 0);

//             for (TalonFX s : left2)

//                 s.set(ControlMode.PercentOutput, 0);

//             for (TalonFX s : right1)

//                 s.set(ControlMode.PercentOutput, 0);

//             for (TalonFX s : right2)

//                 s.set(ControlMode.PercentOutput, 0);

//             for (TalonFX s : shooterIntake)

//                 s.set(ControlMode.PercentOutput, 0);

//             for (TalonFX s : shooter)

//                 s.set(ControlMode.PercentOutput, 0);

//         }
//     }
// }