// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FeedSubsystem;

public class FeedInCommand extends CommandBase {
  /** Creates a new FeedInCommand. */
 
  private FeedSubsystem sub_feedSubsystem;
  //first IR sensor is close to flywheel
  private boolean firstIRSensor, secondIRSensor;
  
  public FeedInCommand(FeedSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    sub_feedSubsystem = subsystem;
    addRequirements(sub_feedSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {   
    firstIRSensor = sub_feedSubsystem.m_getSensor1();
    secondIRSensor = sub_feedSubsystem.m_getSensor2();

    if(firstIRSensor && secondIRSensor){
      sub_feedSubsystem.m_stopFeed();
    }else if(!firstIRSensor && secondIRSensor){
      sub_feedSubsystem.m_feedIn();
    }else if(firstIRSensor && !secondIRSensor){
      sub_feedSubsystem.m_stopFeed();
    }else if(!firstIRSensor && !secondIRSensor){
      sub_feedSubsystem.m_stopFeed();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
}
