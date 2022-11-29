package frc.robot.modules;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.AnalogInput;
import frc.robot.Constants.SwerveConstants;
public class SwerveModuleBasic {
    WPI_TalonFX driveMotor;
    WPI_TalonFX turnMotor;
    boolean driveMotorReversed;
    boolean turnMotorReversed;
    AnalogInput motorSensor;   
    double sumOffset;
    double xOffset;
    double lastOffset;
    public SwerveModuleBasic(int driveMotorID, int turnMotorID,int sensorID, boolean driveMotorReversed, boolean turnMotorReversed){
        driveMotor = new WPI_TalonFX(driveMotorID);
        turnMotor = new WPI_TalonFX(turnMotorID);
        this.driveMotorReversed = driveMotorReversed;
        this.turnMotorReversed = turnMotorReversed;
        this.motorSensor = new AnalogInput(sensorID);
        sumOffset = 0;
    }
    public void drive(double speed, double rotation){
        driveMotor.set(ControlMode.PercentOutput,speed);
        direction();
        //turnMotor.set(ControlMode.Position,Math.atan(speed/rotation));
        
    }
    public void periodic(){
      
    }

    
  public void direction () {

    double speedPercent = 0;
    xOffset = motorSensor.getVoltage();
    this.sumOffset += this.xOffset;

    double slope = this.xOffset - this.lastOffset;

    speedPercent = SwerveConstants.kP + this.sumOffset * SwerveConstants.kI + slope * SwerveConstants.kD;

    this.turnMotor.set(ControlMode.PercentOutput, SwerveConstants.MAX_SPEED * speedPercent);

    this.lastOffset = this.xOffset;
  }
}
