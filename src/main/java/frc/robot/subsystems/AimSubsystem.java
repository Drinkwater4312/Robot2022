// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AimSubsystem extends SubsystemBase {
  /** Creates a new AimSubsystem. */
  private static TalonFX LEFT_FRONT_DRIVE_MOTOR = new TalonFX(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
  private static TalonFX LEFT_BACK_DRIVE_MOTOR = new TalonFX(Constants.LEFT_BACK_DRIVE_MOTOR_PORT);
  private static TalonFX RIGHT_FRONT_DRIVE_MOTOR = new TalonFX(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT);
  private static TalonFX RIGHT_BACK_DRIVE_MOTOR = new TalonFX(Constants.RIGHT_BACK_DRIVE_MOTOR_PORT);

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  static double steering_adjust = 0.0;

  
  public AimSubsystem() {}

  public void m_TurnOnLimelight(){
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0); 
  }

  public void m_TurnOffLimelight(){
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);  
  }


  public void m_aim(){
    double x = tx.getDouble(0.0);

    double heading_error = -x;

    SmartDashboard.putNumber("Steering Adjust", steering_adjust);
    SmartDashboard.putNumber("Limelight x", x);

    //I believe 1.0 is in degrees so this is a tight margin
    //We don't want too small of an error to result in no movement from the motors so this is necessary, but we will see if it's
    //too hardcore.
    if (x > 1.0) 
    {
      steering_adjust = Constants.KP_DRIVE_AIM*heading_error - Constants.MIN_COMMAND_DRIVE_AIM;
    }
    else if (x < 1.0)
    {
      steering_adjust = Constants.KP_DRIVE_AIM*heading_error + Constants.MIN_COMMAND_DRIVE_AIM;
    }
    LEFT_FRONT_DRIVE_MOTOR.set(TalonFXControlMode.PercentOutput, -steering_adjust);
    LEFT_BACK_DRIVE_MOTOR.set(TalonFXControlMode.PercentOutput, -steering_adjust);
    RIGHT_FRONT_DRIVE_MOTOR.set(TalonFXControlMode.PercentOutput, steering_adjust);
    RIGHT_BACK_DRIVE_MOTOR.set(TalonFXControlMode.PercentOutput, steering_adjust);
  }
  
}

