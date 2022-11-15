// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.modules.SwerveModuleBasic;
import frc.robot.Constants.SwerveDrive;

public class SwerveSubsystem extends SubsystemBase {
  /** Creates a new SwerveSubsystem. */
  SwerveModuleBasic frontLeftModule, frontRightModule, backLeftModule, backRightModule;
  public SwerveSubsystem() {
    frontLeftModule = new SwerveModuleBasic(SwerveDrive.FRONT_LEFT_MOTOR,SwerveDrive.FRONT_LEFT_ROTATION,false,false);
    frontRightModule = new SwerveModuleBasic(SwerveDrive.FRONT_RIGHT_MOTOR,SwerveDrive.FRONT_RIGHT_ROTATION,false,false);
    backLeftModule = new SwerveModuleBasic(SwerveDrive.BACK_LEFT_MOTOR,SwerveDrive.BACK_LEFT_ROTATION,false,false);
    backRightModule = new SwerveModuleBasic(SwerveDrive.BACK_RIGHT_MOTOR,SwerveDrive.BACK_RIGHT_ROTATION,false,false);
  }
  public void drive(double speedStrafe,double directionStrafe,double speedRotation, double directionRotation,int motor){
    double x = directionStrafe;
    double y = speedStrafe;
    double rX = directionRotation;
    double rY = speedRotation;
    //double actPower = Math.sqrt((difX * difX) + (difY * difY));
    double actSpeed = (y * 0.5) + (rY * 0.5);
    double actDirection = (x*0.5) + (rX * 0.5);
    double degrees = Math.atan(actSpeed/actDirection);

    if (motor == 1){
      frontLeftModule.drive(actSpeed,degrees);
    }
    else if (motor == 2){
      frontRightModule.drive(actSpeed,degrees);
    }
    else if (motor == 3){
      backLeftModule.drive(actSpeed,degrees);
    }
    else{
      backRightModule.drive(actSpeed,degrees);
    }
    
    
    
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}
