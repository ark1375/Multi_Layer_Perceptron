
package MLP;
import java.util.ArrayList;


public abstract class MLP {
    
    
    private int hiddenLayerCount = -1 ;          //Number of hidden layers
    private int inputLayerDimension = 0;             //Number of input layers which is actualy the dimension of the input
    private int outputLayerDimension = 0;            //Number of output layers whic
    private int hiddenLayerDimension = 0;
    
    private double[][][] weights;                //Weights of the network
    private double[][] bias;
    
    private String mlpName ="";                  //A chosen name for the ann
    private double learingingRate = 0;           //The alpha parameter or the learning reate
    private ArrayList<double[]> data = null;     //Actual input data that ann will be train with

    private boolean isClassActivated = false;
    
    MLP(String name){
        
        this.mlpName = name;
    }

    /********************************Setters************************************/

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
    
    
    // this method will initialize the network
    // inputing number of hidden layers, train data, alpha parameter, number of hidden layers
    
    public boolean init(ArrayList<double[]> train , int numberOfHiddenLayers, int hiddenLayerDimension, int outPutDimension, int inputDimension, double learningRate)  {
    
        if (train != null && numberOfHiddenLayers >= 0 && hiddenLayerDimension > 0 && outPutDimension > 0 && inputDimension > 0 && learningRate > 0 && learningRate <= 0)
            isClassActivated = true;
        
        else return false;
        
        double[] temp = train.get(0);
        
        if (temp.length != inputDimension)
            return false;
        
        this.data = train;
        this.hiddenLayerCount = numberOfHiddenLayers;
        this.hiddenLayerDimension = hiddenLayerDimension;
        this.inputLayerDimension = inputDimension;
        this.outputLayerDimension = outPutDimension;
        this.learingingRate = learningRate;
        
        
        this.weights = new double[hiddenLayerCount + 1][][];
        this.bias = new double[hiddenLayerCount + 1][];
        
        //creating the apropriate array of weights
        for (int i = 0 ; i < weights.length ; i++){
                if ( i == hiddenLayerCount )
                    this.weights[i] = new double[outputLayerDimension][this.hiddenLayerDimension];
                
                else if (i == 0)
                    this.weights[i] = new double[this.hiddenLayerDimension][inputLayerDimension];
                
                else
                    this.weights[i] = new double[this.hiddenLayerDimension][this.hiddenLayerDimension];
        }
        
        //Setting initial weights
        for (int i = 0 ; i < weights.length ; i++)
            for (int j = 0; j < weights[i].length ; j++)
                for (int k = 0; k < weights[i][j].length ; k++)
                    this.weights[i][j][k] = 1;
        
        //Creating bias array
        for (int i = 0 ; i < bias.length ; i++){
                if ( i == hiddenLayerCount )
                    this.bias[i] = new double[outputLayerDimension];
                
                else if ( i == 0 )
                    this.bias[i] = new double[hiddenLayerDimension];
                
                else
                    this.bias[i] = new double[inputLayerDimension];
        }
        
        
        //Setting initial biases
        for (int i=0; i < this.bias.length ; i++)
            for (int j=0 ; j < this.bias[i].length ; j++)
                this.bias[i][j] = 0;
        
        
        return true;     
        
        
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
