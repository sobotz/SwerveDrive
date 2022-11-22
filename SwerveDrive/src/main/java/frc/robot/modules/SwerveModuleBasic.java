package frc.robot.modules;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.AnalogInput;

import frc.robot.Constants.SwerveConstants;
public class SwerveModuleBasic {
    WPI_TalonFX driveMotor;
    WPI_TalonFX turnMotor;
    boolean driveMotorReversed;
    boolean turnMotorReversed;
    private AnalogInput motorsensor;   
    public SwerveModuleBasic(int driveMotorID, int turnMotorID, boolean driveMotorReversed, boolean turnMotorReversed){
        driveMotor = new WPI_TalonFX(driveMotorID);
        turnMotor = new WPI_TalonFX(turnMotorID);
        this.driveMotorReversed = driveMotorReversed;
        this.turnMotorReversed = turnMotorReversed;
        motorsensor = new AnalogInput(SwerveConstants.PHOTOELECTRIC_SENSOR_2);
    }
    public void drive(double speed, double rotation){
        driveMotor.set(ControlMode.PercentOutput,speed);
        turnMotor.set(ControlMode.PercentOutput,rotation);
        //turnMotor.set(ControlMode.Position,Math.atan(speed/rotation));
        
    }
    public void periodic(){
      
    }

    
  public void direction () {

    double speedPercent = 0;

    this.sumOffest += this.xOffset;

    double slope = this.xOffset - this.lastOffset;

    speedPercent = proportionalOffset * SwerveConstants.kP + this.sumOffest * SwerveConstants.kI + slope * SwerveConstants.kD;

    this.actuationMotor.set(ControlMode.PercentOutput, SwerveConstants.MAX_SPEED * speedPercent);

    this.lastOffset = this.xOffset;
  }
}
