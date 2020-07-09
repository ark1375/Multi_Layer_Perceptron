
package MLP;
import java.util.ArrayList;
import java.lang.Math;

public abstract class MLP {
    
    private String mlpName;             //A chosen name for the ann
    private ArrayList<float[]> data;     //Actual input data that ann will be train with
    private int hiddenLayerCount;       //Number of hidden layers
    private int inputLayerCount;        //Number of input layers which is actualy the dimension of the input
    private int outputLayerCount;       //Number of output layers whic
    
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
    
    public boolean activate(){return false;}         //not completed yet
    
    public abstract double activation_function();
    
    
    
    
    
}
