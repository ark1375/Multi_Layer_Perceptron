
package MLP;
import java.lang.Math;


public class Sig_MLP extends MLP{
    
    
    
    public Sig_MLP(String name){
        super(name);
    }
    
    @Override
    public double activation_function(double input){
    
        return Math.tanh(input);
    
    }
    
    @Override
    public double activation_function_derivative(double input){
    
        return (1/Math.cosh(input)) * (1/Math.cosh(input));

    }
    
}
