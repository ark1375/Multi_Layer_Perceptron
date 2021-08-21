# A Dense Neural Network Implementation
## Operation Charmander
Operation Charmander (I don't know why I picked this name) is a university project designed around implementing some of the most popular ANNs like Multilayer Perceptron Network and ANFIS (Adaptive neuro-fuzzy inference system) using Java programming language. It's not a fancy project that you can use in your application or something but it is fine for understanding the coding and some maths behind neural networks. So for any large project, I recommend you to use a commercial library.

The main source of the knowledge behind this project is a book called **"Fundamentals of Computational Intelligence"** by ***Keller, Liu, and Fogel***. So for any more detail on maths of the project, I refer to this book.
I may or may not include some HTML files in the project for the readers to follow for a better understanding of the code, but for any more information feel free to create an issue. I'll check them every them.
  
# Versions and Installation
As this is a small project, It doesn't require any fancy build options. I coded this using Jave with help of tools like **Maven** (I have to learn it first) and **NetBeans**.
My JDK version is 1.8 and the NetBeans version is 11. It doesn't require any fancy dependencies as well (yet); But I think even if it'll need some, Maven would handle it well.

For running the project, just build it normally using Maven or import it in NetBeans *(Recommended)*, compile and run it.

#### A simple explanation on using Maven
Download Maven binary (bin) based on your operating system from this [link](https://maven.apache.org/download.cgi).
In windows create a directory anywhere you like. Extract the bin file that you just download in there. Then go to your environment variable settings and add the *"bin"* folder 
address in the Path section.
Open a command prompt and cd to the project folder.
Run: 
```
mvn package
mvn compile
```
You have your jar files ready to go.
##### On Linux
Simply install Maven using ```sudo apt install maven``` and follow the steps I explained before.


# Last Word
Don't use it as your own university project. It's a shitty thing to do. Just try to follow the code and learn from it. Then you can write your project faster and better.

Peace
