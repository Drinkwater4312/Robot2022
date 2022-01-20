// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AimSubsystem;
public class AimCommand extends CommandBase {
  /** Creates a new AimCommand. */
  private final AimSubsystem sub_aimSubsystem;

  public AimCommand(AimSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    sub_aimSubsystem = subsystem;
    addRequirements(sub_aimSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    sub_aimSubsystem.m_TurnOnLimelight();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sub_aimSubsystem.m_aim();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    sub_aimSubsystem.m_TurnOffLimelight();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
