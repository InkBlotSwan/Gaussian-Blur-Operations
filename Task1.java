
public class Task1 {

	public static void main(String[] args) {
		// Generate 1000 by 1000 matrix of random numbers between 0 and 10
		double[][] matrix = Matrix.NewRandomMatrix(1000, 10);
		// Calculate the blur of that matrix
		double[][] blurredMatrix = Blur.CalculateMatrix(matrix);
		
		// Output the original and blurred matrices to the console.
		Matrix.DisplayMatrix(matrix);
		System.out.println();
		Matrix.DisplayMatrix(blurredMatrix);		
		
	}

}
