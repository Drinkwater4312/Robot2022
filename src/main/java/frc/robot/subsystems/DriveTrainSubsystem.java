// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.*;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

 
public class DriveTrainSubsystem extends SubsystemBase {
  //adapted from Team 6624

  //Motors
  private static TalonFX LEFT_FRONT_DRIVE_MOTOR;
  private static TalonFX LEFT_BACK_DRIVE_MOTOR;
  private static TalonFX RIGHT_FRONT_DRIVE_MOTOR;
  private static TalonFX RIGHT_BACK_DRIVE_MOTOR;

  //Encoders
  public static Encoder LEFT_FRONT_DRIVE_ENCODER;
  public static Encoder LEFT_BACK_DRIVE_ENCODER;
  public static Encoder RIGHT_FRONT_DRIVE_ENCODER;
  public static Encoder RIGHT_BACK_DRIVE_ENCODER;
 // public static MeadianPIDSource DRIVE_ENCODERS; don't know the import


  public DriveTrainSubsystem(){
    //Motors
    LEFT_FRONT_DRIVE_MOTOR = new TalonFX(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
    LEFT_BACK_DRIVE_MOTOR = new TalonFX(Constants.LEFT_BACK_DRIVE_MOTOR_PORT);
    RIGHT_FRONT_DRIVE_MOTOR = new TalonFX(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT);
    RIGHT_BACK_DRIVE_MOTOR = new TalonFX(Constants.RIGHT_BACK_DRIVE_MOTOR_PORT);

    //Encoders
    LEFT_FRONT_DRIVE_ENCODER = new Encoder(Constants.LEFT_FRONT_DRIVE_ENCODER_PIN_A, Constants.LEFT_FRONT_DRIVE_ENCODER_PIN_B);
    LEFT_BACK_DRIVE_ENCODER = new Encoder(Constants.LEFT_BACK_DRIVE_ENCODER_PIN_A, Constants.LEFT_BACK_DRIVE_ENCODER_PIN_B);
    RIGHT_FRONT_DRIVE_ENCODER = new Encoder(Constants.RIGHT_FRONT_DRIVE_ENCODER_PIN_A, Constants.RIGHT_FRONT_DRIVE_ENCODER_PIN_B);
    RIGHT_BACK_DRIVE_ENCODER = new Encoder(Constants.RIGHT_BACK_DRIVE_ENCODER_PIN_A, Constants.RIGHT_BACK_DRIVE_ENCODER_PIN_B);
    //DRIVE_ENCODERS = new MedianPIDSource(LEFT_FRONT_DRIVE_ENCODER, LEFT_BACK_DRIVE_ENCODER, RIGHT_FRONT_DRIVE_ENCODER, RIGHT_BACK_DRIVE_ENCODER);

  }
  public static void setMecanumDrive(double translationAngle, double translationPower, double turnPower){
    //A is front left, b is front right, c is back left, d is back right
    // calculate motor power
    //Math.sqrt(2) * 0.5 comes from sin(45) and cos(45) (trig is necessary to get the power in mecanum)
    double ADPower = translationPower * Math.sqrt(2) * 0.5 * (Math.sin(translationAngle) + Math.cos(translationAngle));
    double BCPower = translationPower * Math.sqrt(2) * 0.5 * (Math.sin(translationAngle) - Math.cos(translationAngle));

    //check if turning power will interfere with normal translation
    //check ADPower to see if trying to apply turnPower would put motor power over 1.0 or under -1.0
    double turningScale = Math.max(Math.abs(ADPower + turnPower), Math.abs(ADPower - turnPower));
    //check BCPower to see if trying to apply turnPower would put motor power over 1.0 or under -1.0
    turningScale = Math.max(turningScale, Math.max(Math.abs(BCPower + turnPower), Math.abs(BCPower - turnPower)));

    //adjust turn power scale correctly --- 1.0 is the max power of the motor.
    if (Math.abs(turningScale) < 1.0){
      turningScale = 1.0;
    }

    //set the motors, and divide them by turning Scale to make sure none of them go over the top, which would alter the translation angles
    LEFT_FRONT_DRIVE_MOTOR.set(TalonFXControlMode.PercentOutput, (ADPower - turningScale) / turningScale);
    LEFT_BACK_DRIVE_MOTOR.set(TalonFXControlMode.PercentOutput, (BCPower - turningScale) / turningScale);
    RIGHT_FRONT_DRIVE_MOTOR.set(TalonFXControlMode.PercentOutput, (BCPower + turningScale) / turningScale);
    RIGHT_BACK_DRIVE_MOTOR.set(TalonFXControlMode.PercentOutput, (ADPower + turningScale) / turningScale);
  }










//Deprecated
  /*
  private static TalonFX frontLeftMotor = new TalonFX(Constants.FRONT_LEFT_MOTOR_PORT);
  private static TalonFX rearLeftMotor = new TalonFX(Constants.REAR_LEFT_MOTOR_PORT);
  private static TalonFX frontRightMotor = new TalonFX(Constants.FRONT_RIGHT_MOTOR_PORT);
  private static TalonFX rearRightMotor = new TalonFX(Constants.REAR_RIGHT_MOTOR_PORT);

  

  public void m_driveCartesian(double ySpeed, double xSpeed, double zRotation){
    frontLeftMotor.setNeutralMode(NeutralMode.Brake);
    rearLeftMotor.setNeutralMode(NeutralMode.Brake);
    frontRightMotor.setNeutralMode(NeutralMode.Brake);
    rearRightMotor.setNeutralMode(NeutralMode.Brake);

    double frontLeftPower = skim(ySpeed + xSpeed + zRotation);
    double rearLeftPower = skim(ySpeed - xSpeed + zRotation);
    double frontRightPower = skim(ySpeed - xSpeed - zRotation);
    double rearRightPower = skim(ySpeed + xSpeed - zRotation);


    frontLeftMotor.set(TalonFXControlMode.PercentOutput, frontLeftPower);
    rearLeftMotor.set(TalonFXControlMode.PercentOutput, rearLeftPower);
    frontRightMotor.set(TalonFXControlMode.PercentOutput, frontRightPower);
    rearRightMotor.set(TalonFXControlMode.PercentOutput, rearRightPower);
    }

  public void DrivetrainSub() {

  }

  public double skim(double num){
    //This method keeps the power value from being above or below the limits of the motor.

    //1 and -1 are the upper and lower bounds of the motor.
    if (num > 1.0) {
      return 1.0;
    } else if (num < -1.0) {
      return -1.0;
    }
    else{
      return num;
    } 
  }
 */
 
}
