// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeedSubsystem extends SubsystemBase {
  /** Creates a new FeedSubsystem. */
  private final DigitalInput irSensor1;
  private final DigitalInput irSensor2;

  Servo feedServo = new Servo(Constants.FEED_SERVO_PORT);

  private static double intakeAngle = 30.0;

  public FeedSubsystem() {
    irSensor1 = new DigitalInput(Constants.IR_SENSOR_1_PORT);
    irSensor2 = new DigitalInput(Constants.IR_SENSOR_2_PORT);}

  public void m_feedIn(){
    feedServo.setAngle(intakeAngle);
  }

  public void m_feedInManual(){
    feedServo.set(Constants.FEED_SERVO_SPEED);
  }
  public void m_feedOut(){
    feedServo.setAngle(-intakeAngle);;
  }
  public void m_stopFeed(){
    feedServo.set(0); //clearly this is to stop the servo
  }
  public boolean m_getSensor1(){
    return irSensor1.get();
  }

  public boolean m_getSensor2(){
    return irSensor2.get();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
