package util;

public class GameRecommender {
	/**
	 * This class is used to recommend games to a specific user based on the rating.
	 * It is a machine learning system using a specific algorithm called
	 * collaborative filtering.
	 * 
	 * There are many algorithms used for recommender systems. I just used a simple one
	 * called the "maximum likelihood approach". Other algorithms can be used to enhance 
	 * accuracy.
	 * 
	 * @author Eunsu (Joe) Ryu - jesryu
	 * 
	 */
	
	
	/**
	 * Parameters
	 * Double[][] dataset = user-game rating data organized into a matrix (value at i-row, j-th column corresponds to
	 * 						User i's rating on Game j).
	 * numUsers = number of registered users in the system
	 * numGames = number of registered games in the system
	 * K = rank parameter. Default is set to 5.
	 * lambda = precision parameter. Default is set to 1.0.
	 * numIterations = number of iterations needed to get result. More iterations means more accurate result.
	 * 				   Default is set to 50. 
	 * 
	 */
	private Double[][] dataset;
	private int numUsers;
	private int numGames;
	private int K;
	private double lambda;
	private int numIterations;
	
	
	/**
	 * Constructor for organized data. Used if the rating data is organized into
	 * the user-rating matrix
	 * @param data = dataset
	 */
	public GameRecommender(Double[][] data, int rows, int cols){
		this(data,rows,cols,5,1.0,50);
	}
	
	
	/**
	 * Constructor for organized data. Used if the rating data is organized into
	 * the user-rating matrix
	 * @param data = dataset
	 */
	public GameRecommender(Double[][] data, int rows, int cols, int kval, double lambdaval, int defaultIterations){
		dataset = data;
		numUsers = rows;
		numGames = cols;
		K = kval;
		lambda = lambdaval;
		numIterations = defaultIterations;
	}
	
	
	/**
	 * Take the inner product to two vectors with equal dimension. Multiply the corresponding elements
	 * from the two vectors and add them up.
	 * @param u, first vector
	 * @param v, second vector
	 * @return <u,v>, inner product of the vectors u and v
	 */
	private Double vectorInnerProduct(double[] u, double[] v) {
		double value = 0;
		for (int i = 0; i < u.length; i++){
			value += u[i]*v[i];
		}
		return Double.valueOf(value);
	}
	
	
	
	/**
	 * Predict rating on Game j by User i. We use maximum likelihood approach.
	 * Prediction is done by an algorithm called gradient descent.
	 * @param i, user ID
	 * @param j, game ID
	 * @return predicted rating by User i on Game j.
	 */
	public Double predictRating(int i, int j){
		double[][] U = new double[numUsers][K];
		double[][] V = new double[numGames][K];
		
		for (int iter = 0; iter < numIterations; iter++){
			for (int J = 0; J < numGames; J++) {
				for (int k = 0; k < K; k++){
					if (dataset[i][J]!=null){
						U[i][k] -= -lambda*computeInteremediateGradient(i, J, k, U[i], V[j]);
					}
				}	
			}
			
			for (int I = 0; I <numUsers; I++){
				for (int k = 0; k < K; k++){
					if (dataset[I][j]!=null){
						V[j][k] -= -lambda*computeInteremediateGradient(I, j, k, U[I], V[j]);
					}
				}
			}
		}

		return vectorInnerProduct(U[i], V[j]);
	}
	
	/**
	 * Compute the intermediate gradient for the above predictRating method.
	 */
	private double computeInteremediateGradient(int i, int j, int k, double[] u, double[] v){
		return dataset[i][j] - vectorInnerProduct(u, v)*v[k];
		
	}
		
	

}
