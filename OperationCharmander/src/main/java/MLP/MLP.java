
package MLP;
import java.util.ArrayList;
import java.lang.Math;
import javafx.application.Platform;

public abstract class MLP {
    
    private String mlpName ="";             //A chosen name for the ann
    private ArrayList<float[]> data = null;     //Actual input data that ann will be train with
    private int hiddenLayerCount = -1 ;       //Number of hidden layers
    private int inputLayerCount = 0;        //Number of input layers which is actualy the dimension of the input
    private int outputLayerCount = 0;      //Number of output layers whic
    
    private boolean isClassActivated = false;
    
    MLP(){}
    
    MLP(String name , int hiddenLayer , int outputLayer){
        
        setMlpName(mlpName);
        setHiddenLayerCount(hiddenLayerCount);
        setInputLayerCount(inputLayerCount);
        setOutputLayerCount(outputLayerCount);
        
        this.isClassActivated = true;
    }

    public void setMlpName(String mlpName) {
        this.mlpName = mlpName;
    }

    public void setHiddenLayerCount(int hiddenLayerCount) {
        if (hiddenLayerCount >= 0)
            this.hiddenLayerCount = hiddenLayerCount;
    }

    public void setInputLayerCount(int inputLayerCount) {
             
        if (inputLayerCount >= 1)
            this.inputLayerCount = inputLayerCount;
    }

    public void setOutputLayerCount(int outputLayerCount) {
        if (this.outputLayerCount >= 1)
            this.outputLayerCount = outputLayerCount;
    }
    
    public boolean activate(){
        
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
        
        if (hiddenLayerCount != -1 && this.inputLayerCount != 0 && this.outputLayerCount != 0 && this.mlpName != "") 
            this.isClassActivated = true;
        
        return this.isClassActivated;
        
    }         //not completed yet
    
    public abstract double activation_function(double input);
    
    public abstract double activation_function_derivative(double input);
    
    
    
    
    
    
}
