package frc.robot.control;
import java.util.ArrayList;

public class PID {
    /**variables for current error, previous error, and integral, and the coefficients*/
    private double integral = 0, error = 0, deriv = 0;
    private double kp, ki, kd, target;

    /**robot periodic called once every 20ms*/
    private final double time = 0.02;

    private ArrayList<Double> errorlist = new ArrayList<Double>();

    public PID (double p, double i, double d, double setpoint){
        //takes as args the 3 coefficients and the target value
        kp = p;
        ki = i;
        kd = d;
        target = setpoint;
    }

    /**
    * should be called once every time interval
    * gets the output of the PID given the target and coefficients declared for the object and current value
    */
    public double control(double value) {

        double output = 0;

        error = target - value;
        errorlist.add(error);

        //factor in the p-term
        output += kp * error;
        //factor in the i-term
        integral += error*time;
        output += ki * integral;

        if (errorlist.size() >= 10){
            updateDeriv();
        }

        //factor in the d-term
        output += kd * deriv;

        return output;
    }

    /**
     * Updates the derivative using the linear regression of the past 10 points
     */
    private void updateDeriv(){
        double sumx = 0, sumy = 0, sumxy = 0, sumxsq = 0;

        for (int i = 0; i < errorlist.size(); i++){
            sumx += errorlist.get(i);
            sumy += 0.2 * i;
            sumxy += (errorlist.get(i) * 0.2 * i);
            sumxsq += errorlist.get(i) * errorlist.get(i);
        }

        double m = (sumxy - sumx * sumy)/(sumxsq - sumx * sumx);
        deriv = m;

        errorlist.clear();
    }
}