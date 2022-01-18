// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LiftSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private static TalonFX leftLiftMotor = new TalonFX(Constants.LEFT_LIFT_MOTOR_PORT);
  private static TalonFX rightLiftMotor = new TalonFX(Constants.RIGHT_LIFT_MOTOR_PORT);
  public LiftSubsystem() {}

  public void m_liftUp(){
    leftLiftMotor.set(TalonFXControlMode.PercentOutput, Constants.LIFT_UP_SPEED);
    rightLiftMotor.set(TalonFXControlMode.PercentOutput, Constants.LIFT_UP_SPEED);
  }

  public void m_liftDown(){
    leftLiftMotor.set(TalonFXControlMode.PercentOutput, Constants.LIFT_DOWN_SPEED);
    rightLiftMotor.set(TalonFXControlMode.PercentOutput, Constants.LIFT_DOWN_SPEED);
  }
}
