
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
    
        if (train != null && numberOfHiddenLayers >= 0 && hiddenLayerDimension > 0 && outPutDimension > 0 && inputDimension > 0 && learningRate > 0 && learningRate <= 1)
            isClassActivated = true;
        
        else return false;
        
        double[] temp = train.get(0);
        
        if (temp.length - outPutDimension != inputDimension)
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
                if ( i == weights.length - 1 )
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
                if ( i == bias.length - 1 )
                    this.bias[i] = new double[outputLayerDimension];
                
                else
                    
                    this.bias[i] = new double[hiddenLayerDimension];
        }
        
        
        //Setting initial biases
        for (int i=0; i < this.bias.length ; i++)
            for (int j=0 ; j < this.bias[i].length ; j++)
                this.bias[i][j] = 0;
        
        
        return true;     
        
        
    }
    
    public double[] activate(double[] data){
        
        double[] preLayerSignals = data;
        
        for (int i=0 ; i < weights.length ; i++){ //Choses the layer
            
            double[] signals = new double[weights[i].length];

            for (int j = 0 ; j < weights[i].length ; j++){ //Looping through neurons

                double sum = this.bias[i][j];
                for (int k = 0 ; k < weights[i][j].length ; k++)
                    sum += preLayerSignals[k] * weights[i][j][k];
                
                signals[j] = activation_function(sum);

            }
            
            preLayerSignals = signals;
        }

        return preLayerSignals;
    }
    
    public abstract double activation_function(double input);
    
    public abstract double activation_function_derivative(double input);
    
    private double[][] induced_field(double[] input){
        
        
        double[][] fields =  new double[hiddenLayerCount + 1][];    //Fields array
        double[] preLayerSignals = input;
        
        for (int i=0 ; i < fields.length ; i++){                 //Creating fields array like biases array
            if (i == hiddenLayerCount)
                fields[i] = new double[outputLayerDimension];
            else
                fields[i] = new double[hiddenLayerDimension];
        }
        
        for (int i=0 ; i < weights.length ; i++){ //Choses the layer
            
            double[] signals = new double[weights[i].length];

            for (int j = 0 ; j < weights[i].length ; j++){ //Looping through neurons

                double sum = this.bias[i][j];
                for (int k = 0 ; k < weights[i][j].length ; k++)
                    sum += preLayerSignals[k] * weights[i][j][k];
                
                fields[i][j] = sum;
                signals[j] = activation_function(sum);

            }
            
            preLayerSignals = signals;
        }

        return fields;
        
        
    } 

    private double[][] neurons_output(double[] input){
    
        double[][] outputs =  new double[hiddenLayerCount + 1][];    //Fields array
        double[] preLayerSignals = input;
        
        for (int i=0 ; i < outputs.length ; i++){                 //Creating fields array like biases array
            if (i == hiddenLayerCount)
                outputs[i] = new double[outputLayerDimension];
            else
                outputs[i] = new double[hiddenLayerDimension];
        }
        
        for (int i=0 ; i < weights.length ; i++){ //Choses the layer
            
            double[] signals = new double[weights[i].length];

            for (int j = 0 ; j < weights[i].length ; j++){ //Looping through neurons

                double sum = this.bias[i][j];
                for (int k = 0 ; k < weights[i][j].length ; k++)
                    sum += preLayerSignals[k] * weights[i][j][k];
                
                outputs[i][j] = activation_function(sum);
                signals[j] = activation_function(sum);

            }
            
            preLayerSignals = signals;
        }

        return outputs;
    
    }
    
    public void inititate_learning(int epochs){}
    
    
    
    public double[][] backpropogation(double[] input){
    
        
        double[] network_input = new double[inputLayerDimension];   //Network input
        double[] desiered_output = new double[outputLayerDimension];//d(j)
        
        for (int i=0 ; i <  input.length ; i++){
            if (i < inputLayerDimension)
                network_input[i] = input[i];
            else
                desiered_output[i-inputLayerDimension] = input[i];
        }
        
        double[] network_output = activate(network_input);      //Networks output
        double[][] fields = induced_field(network_input);       //v(ij)
        double[][] outputs = neurons_output(network_input);     //y(ij)
        double[][][] weights = this.weights;                    //w(ij)
        double[][] errors = new double[this.weights.length][];
        
        for (int i=0 ; i < weights.length; i++)
            errors[i] = new double[weights[i].length];
                
        System.out.println("error");
        /*Potential Error*/
        for (int i = errors.length - 1 ; i >= 0 ; i--){     //current layer
            for (int j = 0 ; j < errors[i].length ; j++){   //current neuron
                
                if (i == errors.length - 1)
                    errors[i][j] = desiered_output[j] - network_output[j];
                
                else{
                    double error = 0;
                    
                    for (int k = 0 ; k < errors[i+1].length ; k++)
                        error += errors[i+1][k] * activation_function_derivative(fields[i+1][k]) * weights[i+1][k][j];
                    
                    
                    errors[i][j] = error;
                
                }
//            
            }
            
            
        }
            
        return errors;
    }
    
    
    
}
