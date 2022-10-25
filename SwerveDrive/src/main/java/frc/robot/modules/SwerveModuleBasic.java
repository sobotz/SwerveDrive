package frc.robot.modules;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
public class SwerveModuleBasic {
    WPI_TalonFX driveMotor;
    WPI_TalonFX turnMotor;
    boolean driveMotorReversed;
    boolean turnMotorReversed;
    public SwerveModuleBasic(int driveMotorID, int turnMotorID, boolean driveMotorReversed, boolean turnMotorReversed){
        driveMotor = new WPI_TalonFX(driveMotorID);
        turnMotor = new WPI_TalonFX(turnMotorID);
        this.driveMotorReversed = driveMotorReversed;
        this.turnMotorReversed = turnMotorReversed;
    }
    public void drive(double speed, double rotation){
        driveMotor.set(ControlMode.PercentOutput,speed);
        turnMotor.set(ControlMode.PercentOutput,rotation);
    }
}
