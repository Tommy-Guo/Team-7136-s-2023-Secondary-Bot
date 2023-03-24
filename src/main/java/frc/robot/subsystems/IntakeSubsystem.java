// package frc.robot.subsystems;

// import frc.robot.helpers.appendix;
// import frc.robot.helpers.common;
// import edu.wpi.first.wpilibj.Joystick;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

// public class IntakeSubsystem {

//     Joystick gamePad = new Joystick(appendix.driveControllerID);
    
//     WPI_VictorSPX intakeMotor = new WPI_VictorSPX(appendix.motorIntake);
//     WPI_VictorSPX intakeRotation = new WPI_VictorSPX(appendix.motorRotational);

//     double getArmTrigger() {
//         double rightValue = gamePad.getRawAxis(appendix.triggerRight);
//         double leftValue =  gamePad.getRawAxis(appendix.triggerLeft);
//         return (rightValue > leftValue ? rightValue * -1 : leftValue);
//     }

//     public void teleopPeriodic() {
//         // double rotationSpeed = 0;

//         // if (gamePad.getRawButton(appendix.buttonRight)) {
//         //     rotationSpeed = 0.05;
//         // } else if (gamePad.getRawButton(appendix.buttonLeft)) {
//         //     rotationSpeed = -0.6;
//         // }

//         // double intakeSpeed = common.quadraticDrive(getArmTrigger(), appendix.intakeSpeedLimit);

//         // intakeRotation.set(rotationSpeed);
//         // intakeMotor.set(intakeSpeed);
    
//         double rotationSpeed = gamePad.getRawAxis(appendix.axisRightX) * 0.2;
//         double intakeSpeed = common.quadraticDrive(getArmTrigger(), appendix.intakeSpeedLimit);

//         intakeRotation.set(rotationSpeed);
//         // intakeRotation.set(0.05 < Math.abs(rotationSpeed) ? rotationSpeed : -0.05);
//         intakeMotor.set(intakeSpeed);
//     }
// }


















package frc.robot.subsystems;

import frc.robot.helpers.appendix;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class IntakeSubsystem {

    Joystick gamePad = new Joystick(appendix.driveControllerID);
    
    WPI_VictorSPX intakeMotor = new WPI_VictorSPX(appendix.motorIntake);
    WPI_VictorSPX intakeRotationMotor = new WPI_VictorSPX(appendix.motorRotational);

    public void teleopPeriodic() {
        intakePeriodic();
        // intakeRotationPeriodic();
    }

    private double getArmTrigger() {
        double rightValue = gamePad.getRawAxis(appendix.triggerRight);
        double leftValue =  gamePad.getRawAxis(appendix.triggerLeft);
        return (rightValue > leftValue ? rightValue * -1 : leftValue);
    }

    private void intakePeriodic() {
        // intakeMotor.set(gamePad.getRawButton(appendix.buttonRight) ? (appendix.buttonLeft):);
        if (gamePad.getRawButton(appendix.buttonRight)) {
            intakeMotor.set(0.6);
        } else if (gamePad.getRawButton(appendix.buttonLeft)) {
            intakeMotor.set(-0.6);
        } else {
            intakeMotor.set(0);
        }
        intakeRotationMotor.set(getArmTrigger());
    }
}