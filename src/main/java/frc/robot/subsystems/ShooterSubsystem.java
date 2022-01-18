// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

 private static TalonFX leftShooterMotor = new TalonFX(Constants.SHOOTER_LEFT_MOTOR_PORT);
 private static TalonFX rightShooterMotor = new TalonFX(Constants.SHOOTER_RIGHT_MOTOR_PORT);


  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void m_shoot()
  {
    leftShooterMotor.set(TalonFXControlMode.PercentOutput, Constants.SHOOTER_SPEED);
    rightShooterMotor.set(TalonFXControlMode.PercentOutput, -Constants.SHOOTER_SPEED);
    /*
  leftShooterMotor.set(TalonFXControlMode.Velocity, Constants.SHOOTER_SPEED);
  rightShooterMotor.set(TalonFXControlMode.Velocity, -Constants.SHOOTER_SPEED);
  */
  }
  public void m_stopSpinning()
  {
    leftShooterMotor.set(TalonFXControlMode.PercentOutput, 0.0);//it's a stray number but you can tell it makes the motor spin at 0%
    rightShooterMotor.set(TalonFXControlMode.PercentOutput, 0.0);
  }
}
