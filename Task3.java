
public class Task3 {

	public static void main(String[] args) {
		
		int matrixSize = 10; // Arbitrary size for testing, can be tweaked.
		int nodeCount = 10; // Number of nodes to simulate, can be tweaked.
		
		// Generate matrix to be calculated by the simulated network.
		double[][] matrix = Matrix.NewRandomMatrix(matrixSize, nodeCount);
		// Calculate the blur of that matrix using network simulation.
		ThreadManager t = new ThreadManager();
		double[][] blurredMatrix = t.SimulateNetwork(3, matrix);
		
		// Display the three matrices to the console
		Matrix.DisplayMatrix(matrix);
		System.out.println();
		Matrix.DisplayMatrix(blurredMatrix);
	}

}
