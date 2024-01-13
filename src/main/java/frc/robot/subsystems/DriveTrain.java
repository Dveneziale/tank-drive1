// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  CANSparkMax frontRight; 
  CANSparkMax frontLeft; 
  CANSparkMax backRight;
  CANSparkMax backLeft; 
  MotorControllerGroup leftMotorGroup;
  MotorControllerGroup rightMotorGroup;
  /** Creates a new DriveTrain. */

  public DriveTrain() {
    frontRight = new CANSparkMax(Constants.FRONTRIGHT_CANID, CANSparkMaxLowLevel.MotorType.kBrushed);
    frontLeft = new CANSparkMax(Constants.FRONTLEFT_CANID, CANSparkMaxLowLevel.MotorType.kBrushed);
    backRight = new CANSparkMax(Constants.BACKRIGHT_CANID, CANSparkMaxLowLevel.MotorType.kBrushed);
    backLeft = new CANSparkMax(Constants.BACKLEFT_CANID, CANSparkMaxLowLevel.MotorType.kBrushed);
    leftMotorGroup = new MotorControllerGroup(frontLeft, backLeft);
    leftMotorGroup.setInverted(true);
    rightMotorGroup = new MotorControllerGroup(frontRight, backRight);
  }
  
  public void drive(double rightSpeed, double leftSpeed) {
    leftMotorGroup.set(leftSpeed);
    rightMotorGroup.set(rightSpeed);

    
  }

  public void stop(){
    leftMotorGroup.stopMotor();
    rightMotorGroup.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
