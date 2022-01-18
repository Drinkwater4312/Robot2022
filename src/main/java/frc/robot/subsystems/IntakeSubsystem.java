// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

  private static TalonFX intakeMotor = new TalonFX(Constants.INTAKE_MOTOR_PORT);
  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  public void m_intake() {
    intakeMotor.set(TalonFXControlMode.PercentOutput, Constants.INTAKE_SPEED);
  }

  public void m_outtake() {
    intakeMotor.set(TalonFXControlMode.PercentOutput, Constants.OUTTAKE_SPEED);
  }

}
