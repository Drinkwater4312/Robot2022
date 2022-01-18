// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  
    //Joystick constants
    public static int DRIVE_JOYSTICK_PORT = 0;
    public static int BUTTONS_JOYSTICK_PORT = 1;
    public static int X = 0;
    public static int Y = 1;
    public static int Z = 2;
    public static int S = 3;

    //Motor Ports
    public static int LEFT_FRONT_DRIVE_MOTOR_PORT = 0;
    public static int LEFT_BACK_DRIVE_MOTOR_PORT = 1;
    public static int RIGHT_FRONT_DRIVE_MOTOR_PORT = 2;
    public static int RIGHT_BACK_DRIVE_MOTOR_PORT = 3;

    public static int LEFT_LIFT_MOTOR_PORT = 4;
    public static int RIGHT_LIFT_MOTOR_PORT = 5;

    public static int INTAKE_MOTOR_PORT = 6;

    public static int FEED_LEFT_MOTOR_PORT = 7;
    public static int FEED_RIGHT_MOTOR_PORT = 8;

    public static int SHOOTER_LEFT_MOTOR_PORT = 21;
    public static int SHOOTER_RIGHT_MOTOR_PORT = 22;

    //Encoder pins
    public static int LEFT_FRONT_DRIVE_ENCODER_PIN_A = 0;
    public static int LEFT_FRONT_DRIVE_ENCODER_PIN_B = 1;
    public static int LEFT_BACK_DRIVE_ENCODER_PIN_A = 2;
    public static int LEFT_BACK_DRIVE_ENCODER_PIN_B = 3;
    public static int RIGHT_FRONT_DRIVE_ENCODER_PIN_A = 4;
    public static int RIGHT_FRONT_DRIVE_ENCODER_PIN_B = 5;
    public static int RIGHT_BACK_DRIVE_ENCODER_PIN_A = 6;
    public static int RIGHT_BACK_DRIVE_ENCODER_PIN_B = 7;

    //Other drive constants
    public static double TURN_ADJUST = 0.4;


    //Desired rpm (temporary)
    public static double RPM = 6380.0;


    //Motor Speeds
    public static double LIFT_UP_SPEED = 1.0;
    public static double LIFT_DOWN_SPEED = -0.1;

    public static double INTAKE_SPEED = 1.0;
    public static double OUTTAKE_SPEED = -1.0;

    public static double FEED_LEFT_IN_SPEED = 1.0;
    public static double FEED_RIGHT_IN_SPEED = -1.0; 
    public static double FEED_LEFT_OUT_SPEED = -1.0;
    public static double FEED_RIGHT_OUT_SPEED = 1.0;

    public static double SHOOTER_SPEED = 0.8;
    //(2048.0 / 600.0) * RPM; //600 is a modifer to get min to 100 ms and 2048 gets rotations to units 


    //Buttons
    public static boolean NOT_INTERRUPTIBLE = false;
    public static boolean INTERRUPTIBLE = true;

    public static int LIFT_UP_BUTTON = 1;
    public static int LIFT_DOWN_BUTTON = 2;

    public static int FEED_IN_BUTTON = 3;
    public static int FEED_OUT_BUTTON = 4;

    public static int INTAKE_BUTTON = 5;
    public static int OUTTAKE_BUTTON = 6;

    public static int SHOOT_BUTTON = 7;
    



}
