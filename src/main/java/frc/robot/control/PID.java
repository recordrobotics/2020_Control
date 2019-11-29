package frc.robot.control;

public class PID {
    //variables for current error, previous error, and integral, and the coefficients
    private double integral = 0, error = 0, prevError = 0;
    private double kp, ki, kd, target;

    private final double time = 0.02; //robot periodic called once every 20ms

    public PID (double p, double i, double d, double setpoint){
        //takes as args the 3 coefficients and the target value
        kp = p;
        ki = i;
        kd = d;
        target = setpoint;
    }

    public double control(double value) {
        //should be called once every time interval
        //gets the output of the PID given the target and coefficients declared for the object and current value

        double output = 0;

        //set the error and the prevError
        prevError = error;
        error = target - value;

        //factor in the p-term
        output += kp * error;
        //factor in the i-term
        integral += error*time;
        output += ki * integral;
        //factor in the d-term
        output += kd * ((error - prevError)/time);

        return output;
    }
}