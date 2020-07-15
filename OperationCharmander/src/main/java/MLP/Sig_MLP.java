
package MLP;

public class Sig_MLP extends MLP{
    
    
    
    public Sig_MLP(String name){
        super(name);
    }
    
    @Override
    public double activation_function(double input){return 2.0;}
    
    @Override
    public double activation_function_derivative(double input){return 2.0;}
    
}
