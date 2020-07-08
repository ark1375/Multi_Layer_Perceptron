
package MLP;
import java.util.Vector;
import java.util.ArrayList;

public abstract class MLP {
    
    private String mlpName;             //A chosen name for the ann
    private ArrayList<Vector> data;     //Actual input data that ann will be train with
    private int hiddenLayerCount;       //Number of hidden layers
    private int inputLayerCount;        //Number of input layers which is actualy the dimension of the input
    private int outputLayerCount;       //Number of output layers whic
    
    private boolean isClassActivated = false;
    
    MLP(){}
    MLP(String name , int hiddenLayer , int outputLayer){
        
    }

    public void setMlpName(String mlpName) {
        this.mlpName = mlpName;
    }

    public void setHiddenLayerCount(int hiddenLayerCount) {
        this.hiddenLayerCount = hiddenLayerCount;
    }

    public void setInputLayerCount(int inputLayerCount) {
        this.inputLayerCount = inputLayerCount;
    }

    public void setOutputLayerCount(int outputLayerCount) {
        this.outputLayerCount = outputLayerCount;
    }
    
    
    
    
}
