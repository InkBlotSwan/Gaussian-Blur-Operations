
public class Main {

	public static void main(String[] args) {
		
		int matrixSize = 3; // Arbitrary size for testing, can be tweaked.
		int nodeCount = 10; // Number of nodes to simulate, can be tweaked.
		int networkStability = 5; //Chance of node succeeding in a calculation as a percentage.
		
		// Generate matrix to be calculated by the simulated network.
		double[][] matrix = Matrix.NewRandomMatrix(matrixSize, 100);
		// Calculate the blur of that matrix using network simulation.
		ThreadManagerTask4 t = new ThreadManagerTask4();
		double[][] blurredMatrix = t.SimulateNetwork(nodeCount, matrix, networkStability);
		
		// Display the three matrices to the console
		Matrix.DisplayMatrix(matrix);
		System.out.println();
		Matrix.DisplayMatrix(blurredMatrix);
	}
}
