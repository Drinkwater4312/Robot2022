// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeedSubsystem extends SubsystemBase {
  /** Creates a new FeedSubsystem. */
  private static TalonFX leftFeedMotor = new TalonFX(Constants.FEED_LEFT_MOTOR_PORT);
  private static TalonFX rightFeedMotor = new TalonFX(Constants.FEED_RIGHT_MOTOR_PORT);
  public FeedSubsystem() {}

  public void m_feedIn(){
    leftFeedMotor.set(TalonFXControlMode.PercentOutput, Constants.FEED_LEFT_IN_SPEED);
    rightFeedMotor.set(TalonFXControlMode.PercentOutput, Constants.FEED_RIGHT_IN_SPEED);
  }

  public void m_feedOut(){
    leftFeedMotor.set(TalonFXControlMode.PercentOutput, Constants.FEED_LEFT_OUT_SPEED);
    rightFeedMotor.set(TalonFXControlMode.PercentOutput, Constants.FEED_RIGHT_OUT_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
