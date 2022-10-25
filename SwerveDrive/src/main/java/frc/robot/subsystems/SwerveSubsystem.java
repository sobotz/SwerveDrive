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
  public void drive(double speed,double rotation){
    frontLeftModule.drive(speed,rotation);
    frontRightModule.drive(speed,rotation);
    backLeftModule.drive(speed,rotation);
    backRightModule.drive(speed,rotation);
  }
  public void setZero(){
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}
