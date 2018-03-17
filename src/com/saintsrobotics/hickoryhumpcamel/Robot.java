package com.saintsrobotics.hickoryhumpcamel;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.github.dozer.TaskRobot;
import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.helpers.RunContinuousTask;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.github.dozer.coroutine.helpers.RunSequentialTask;
import com.github.dozer.output.Motor;
import com.github.dozer.output.MotorSimple;
import com.saintsrobotics.hickoryhumpcamel.input.OI;
import com.saintsrobotics.hickoryhumpcamel.input.Sensors;
import com.saintsrobotics.hickoryhumpcamel.input.TestSensors;
import com.saintsrobotics.hickoryhumpcamel.output.*;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.AutonLiftTask;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.EncoderReportTask;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.ForwardAtHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.TurnToHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.choose.CenterSwitchAuton;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.choose.CrossBaselineAuton;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.choose.LeftSwitchAuton;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.choose.RightSwitchAuton;
import com.saintsrobotics.hickoryhumpcamel.tasks.teleop.ArcadeDrive;
import com.saintsrobotics.hickoryhumpcamel.tasks.teleop.InTakeWheel;
import com.saintsrobotics.hickoryhumpcamel.tasks.teleop.LiftTask;
import com.saintsrobotics.hickoryhumpcamel.tasks.teleop.OutTakeWheel;
import com.saintsrobotics.hickoryhumpcamel.util.ForwardConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.LiftConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.TurnConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.UpdateMotors;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the IterativeRobot documentation. If you change the name of this class
 * or the package after creating this project, you must also update the manifest file in the
 * resource directory.
 */
public class Robot extends TaskRobot {

	private SendableChooser<Supplier<Task>> taskChooser = new SendableChooser<>();

	public RobotMotors motors;
	public OI oi;
	public Flags flags;
	public Sensors sensors;

	public PowerDistributionPanel pdp;
	public static Robot instance;


	@Override
	public void robotInit() {
		Robot.instance = this;
		this.oi = new OI();
		this.motors = new TestBotMotors();
		this.motors.init();
		this.flags = new Flags();
		this.sensors = new TestSensors();

		this.sensors.init();
		this.flags.forwardPidConfig = new ForwardConfiguration(this.sensors.gyro, this.sensors.average);
		this.flags.turnPidConfig = new TurnConfiguration(this.sensors.gyro);

		this.pdp = new PowerDistributionPanel();

		taskChooser.addDefault("LeftSwitchAuton", LeftSwitchAuton::new);
		taskChooser.addObject("RightSwitchAuton", RightSwitchAuton::new);
		taskChooser.addObject("CenterSwitchAuton", CenterSwitchAuton::new);
		taskChooser.addObject("CrossBaselineAuton", CrossBaselineAuton::new);
		SmartDashboard.putData("Autonomous2", taskChooser);
	}

	@Override
	public void autonomousInit() {
		this.sensors.liftEncoder.reset();
		this.sensors.leftEncoder.reset();
		this.sensors.rightEncoder.reset();
		this.sensors.gyro.reset();
		this.flags.gameMessage = DriverStation.getInstance().getGameSpecificMessage();
		this.flags.switchStatus = this.flags.gameMessage.charAt(0) == 'L';
		this.autonomousTasks = new Task[]   {
				new RunSequentialTask(
						taskChooser.getSelected().get(), 
						new AutonLiftTask(18, new LiftConfiguration(this.sensors.liftEncoder))), 
				new UpdateMotors(this.motors),
				new EncoderReportTask()
		};
		super.autonomousInit();
	}

	@Override     
	public void teleopInit() {
		/** TODO: Tell Keval to put stuff here into seperate Tasks **/ 
		try {
			this.sensors.liftEncoder.reset();
			this.sensors.leftEncoder.reset();
			this.sensors.rightEncoder.reset();
			this.sensors.gyro.reset();
		}catch(NullPointerException t) {
			DriverStation.reportError("You didn't connect the gyro you dum dum", false);
		}
		
		
		this.teleopTasks = new Task[] {new ArcadeDrive(), new InTakeWheel(), new OutTakeWheel(), new LiftTask(), new RunEachFrameTask() {

			@Override
			protected void runEachFrame() {
				//right Wing
				double moveAmount =0;
				if(Robot.instance.oi.xboxInput.B()) moveAmount += 1;
				if(Robot.instance.oi.xboxInput.X()) moveAmount -= 1;

				Robot.instance.motors.rightWing.set(moveAmount);

				//left wing
				moveAmount = 0;
				if(Robot.instance.oi.xboxInput.Y()) moveAmount += 1;
				if(Robot.instance.oi.xboxInput.A()) moveAmount -= 1;

				Robot.instance.motors.leftWing.set(moveAmount);


				//Other Debug Code
				SmartDashboard.putNumber("Encoder Distance", sensors.leftEncoder.get());
				SmartDashboard.putNumber("Encoder Avg Distance", sensors.average.pidGet());

				for (int i : new int[] { 0, 1, 2, 3, 12, 13, 14, 15 }) {
					SmartDashboard.putNumber("Current: " + i, pdp.getCurrent(i));
				}        

				SmartDashboard.putNumber("Right Current", motors.rightBack.get());
				SmartDashboard.putNumber("left Current", motors.leftBack.get());
				SmartDashboard.putBoolean("intake", sensors.intake.get());
			}



		}, new UpdateMotors(this.motors)};

		/*this.teleopTasks = new Task[] {
        new Task() {
          @Override
          public void runTask() {
            DriverStation.reportWarning("Ready! Press B to begin/move on",false);
            wait.until(()->oi.xboxInput.B());
            for(int i = 0; i < 8; i++) {
              SpeedController motor = Robot.instance.temp[i];
              DriverStation.reportWarning("doing " + (i+1), false);
              motor.set(1);
              wait.forSeconds(0.5);
              motor.set(-1);
              wait.forSeconds(0.5);
              motor.set(0);
              DriverStation.reportWarning("Finished " + (i+1) + ", Ready to move on to next, which is " + (i+2), false);
              wait.forSeconds(0.5);
              wait.until(()->oi.xboxInput.B());
            }
            System.gc();
          }
        }
    };*/
		super.teleopInit();
	}
	@Override
	public void disabledInit() {
		this.sensors.leftEncoder.reset();
		this.sensors.rightEncoder.reset();
		this.disabledTasks = new Task[] {new EncoderReportTask()};
		super.disabledInit();
	}
}
