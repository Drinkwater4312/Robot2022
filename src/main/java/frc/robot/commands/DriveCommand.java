/*----------------------------------------------------------------------------*/
/* Copyright (c) 2022 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
 
package frc.robot.commands;
 
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import java.util.function.DoubleSupplier;
 
public class DriveCommand extends CommandBase {
  private final DriveTrainSubsystem sub_driveTrainSubsystem;
  private DoubleSupplier m_sideways;
  private DoubleSupplier m_forward;
  private DoubleSupplier m_rotation;
 
  public DriveCommand(DriveTrainSubsystem subsystem, DoubleSupplier sideways, DoubleSupplier forward, DoubleSupplier twist) {
    sub_driveTrainSubsystem = subsystem;
    m_sideways = sideways;
    m_forward = forward;
    m_rotation = twist;
    
    addRequirements(sub_driveTrainSubsystem);
  }
 
  @Override
  public void execute() {
    double angle = Math.atan2(m_forward.getAsDouble(), m_sideways.getAsDouble());
    double magnitude = Math.hypot(m_sideways.getAsDouble(), m_forward.getAsDouble());
    
    DriveTrainSubsystem.setMecanumDrive(angle, magnitude, m_rotation.getAsDouble());
  }
}