
package MLP;
import java.util.ArrayList;


public abstract class MLP {
    
    private String mlpName ="";                  //A chosen name for the ann
    
    private int hiddenLayerCount = -1 ;          //Number of hidden layers
    private int inputLayerCount = 0;             //Number of input layers which is actualy the dimension of the input
    private int outputLayerCount = 0;            //Number of output layers whic
    
    private double learingingRate = 0;           //The alpha parameter or the learning reate
    private double[][][] weights;                //Weights of the network
    private ArrayList<double[]> data = null;     //Actual input data that ann will be train with

    private boolean isClassActivated = false;
    
    MLP(){}

    /********************************Setters************************************/

    private void setHiddenLayerCount(int hiddenLayerCount) {
        if (hiddenLayerCount >= 0)
            this.hiddenLayerCount = hiddenLayerCount;
    }

    private void setInputLayerCount(int inputLayerCount) {
             
        if (inputLayerCount >= 1)
            this.inputLayerCount = inputLayerCount;
    }

    private void setOutputLayerCount(int outputLayerCount) {
        if (this.outputLayerCount >= 1)
            this.outputLayerCount = outputLayerCount;
    }
    
    
    public void setMlpName(String mlpName) {
        this.mlpName = mlpName;
    }

    public void setLearningRate(double lrate){
        
        if (lrate >= 1)
            this.learingingRate = 1;
        
        else if (lrate <= 0)
            this.learingingRate = 0.0001;
       
        else
            this.learingingRate = lrate;
            
    }
    
    
    /***************************************************************************/
    
    
    //this method will initialize the network
    // inputing number of hidden layers, train data, alpha parameter, number of hidden layers
    public void init(){
    
    }
    
    private boolean isActivated(){
        
        isClassActivated = true;
        
        if (mlpName == ""){
            System.out.println("Name not Entered");
            this.isClassActivated = false;
        }
        
        
        if (this.hiddenLayerCount == -1){
            System.out.println("Hidden layer number not entered");
            this.isClassActivated = false;
        }
        
        if (this.inputLayerCount == 0){
            System.out.println("Input layer number not entered");
            this.isClassActivated = false;
        }
        
        if (this.outputLayerCount == 0){
            System.out.println("Output layer number not entered");
            this.isClassActivated = false;
        }
        
        if (this.learingingRate == 0){
            System.out.println("Learning Rate is not entered");
            this.isClassActivated = false;
        }
        
        return this.isClassActivated;
        
    }   
    
    public abstract double activation_function(double input);
    
    public abstract double activation_function_derivative(double input);
    
    private double induced_field(int layer  , int neuron , double[] signals ){
        
        
        double induced_field = 0;
        
        for(int i = 0 ; i < signals.length ; i++)
            induced_field += weights[layer][neuron][i] * signals[i];
        
        return induced_field;
        
        
    } 

    private double error_function(float signal , float des_signal){

        return des_signal-signal;


    }
    
    public void inititate_learning(int epochs){}
    
    
    
    
    
}
