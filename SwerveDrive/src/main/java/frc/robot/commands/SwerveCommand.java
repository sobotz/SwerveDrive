// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveSubsystem;

public class SwerveCommand extends CommandBase {
  /** Creates a new SwerveCommand. */
  private final SwerveSubsystem m_swerve;
  private Joystick m_joystick;
  double strafeSpeed;
  double strafeDirection;
  double rotationSpeed;
  double rotationDirection;
  
  public SwerveCommand(SwerveSubsystem swerve, Joystick joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_swerve = swerve;
    m_joystick = joystick;
    addRequirements(m_swerve);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    strafeSpeed  = m_joystick.getY();
    strafeDirection = m_joystick.getX();
    rotationSpeed = m_joystick.getTwist();
    m_swerve.drive(strafeSpeed,strafeDirection,rotationSpeed,45,1);
    m_swerve.drive(strafeSpeed,strafeDirection,rotationSpeed,135,2);
    m_swerve.drive(strafeSpeed,strafeDirection,rotationSpeed,225,3);
    m_swerve.drive(strafeSpeed,strafeDirection,rotationSpeed,180,4);
    
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
