
public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrixSize = 6;
		
		// Generate 1000 by 1000 matrix of random numbers between 0 and 10
		double[][] matrix = Matrix.NewRandomMatrix(matrixSize, 10);
		// Calculate the blur of that matrix using non threaded approach
		double[][] blurredMatrix = Blur.CalculateMatrix(matrix);
		// Calculate the blur using threads
		ThreadedBlur t = new ThreadedBlur();
		double[][] threadBlurMatrix = t.CalculateMatrixThreaded(matrix);
		
		// Subtract the threaded solution from the gold solution.
		int length = blurredMatrix.length;
		double[][] sanityMatrix = Matrix.NewMatrix(matrixSize, 0);
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				sanityMatrix[i][j] = blurredMatrix[i][j] - threadBlurMatrix[i][j];
			}
		}
		
		// Display the three matrices to the console
		Matrix.DisplayMatrix(matrix);
		System.out.println();
		Matrix.DisplayMatrix(blurredMatrix);
		System.out.println();
		Matrix.DisplayMatrix(threadBlurMatrix);
		System.out.println("Subtraction of threaded and gold approaches:");
		Matrix.DisplayMatrix(sanityMatrix);
	}

}
