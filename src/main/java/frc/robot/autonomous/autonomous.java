// package frc.robot.autonomous;

// import frc.robot.helpers.appendix;
// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

// import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

// public class autonomous {
//     Timer godTimer = new Timer();

//     WPI_VictorSPX motorArm_01 = new WPI_VictorSPX(appendix.motorArm1);
//     WPI_VictorSPX motorArm_02 = new WPI_VictorSPX(appendix.motorArm2);

//     WPI_VictorSPX intake = new WPI_VictorSPX(appendix.motorIntake);

//     WPI_VictorSPX motorleft_01 = new WPI_VictorSPX(appendix.motorLeft1);
//     WPI_VictorSPX motorleft_02 = new WPI_VictorSPX(appendix.motorLeft2);
//     WPI_VictorSPX motorright_01 = new WPI_VictorSPX(appendix.motorRight1);
//     WPI_VictorSPX motorright_02 = new WPI_VictorSPX(appendix.motorRight2);

//     MotorControllerGroup arm = new MotorControllerGroup(motorArm_01, motorArm_02);

//     MotorControllerGroup motorsLeft = new MotorControllerGroup(motorleft_01, motorleft_02);
//     MotorControllerGroup motorsRight = new MotorControllerGroup(motorright_01, motorright_02);

//     DifferentialDrive driveBase = new DifferentialDrive(motorsLeft, motorsRight);

//     public autonomous() {
//         intake.setSafetyEnabled(false);
//         driveBase.setSafetyEnabled(false);
//         godTimer.reset();
//         godTimer.start();
//     }

//     public void runAuto() {
//         if (godTimer.get() < 2) {
//             driveBase.curvatureDrive(0, -0.2, true);
//         } else if (godTimer.get() < 3) {
//            driveBase.curvatureDrive(0, 0.2, true);
//         } else if (godTimer.get() < 6) {
//             driveBase.curvatureDrive(0, 0, true);
//         }
//     }
// }
