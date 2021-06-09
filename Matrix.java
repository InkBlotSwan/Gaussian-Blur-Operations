import java.util.Random;
public class Matrix {
	
	static double [][] NewMatrix(int length, int value){
		double [ ][ ] matrix = new double [ length ] [ length ];
		//Populate matrix with 1's.
		for(int i=0; i<length; i++) {
			for(int j=0; j<length; j++)
			{
			matrix[i][j]=value;
			}
		}
		
		return matrix;
	}
	
	static String [][] NewMatrix(int length, String value){
		String [ ][ ] matrix = new String [ length ] [ length ];
		//Populate matrix with 1's.
		for(int i=0; i<length; i++) {
			for(int j=0; j<length; j++)
			{
			matrix[i][j]=value;
			}
		}
		
		return matrix;
	}
	
	static double [][] NewRandomMatrix(int length, int maxValue){
		double [ ][ ] matrix = new double [ length ] [ length ];
		//Populate matrix with 1's.
		Random rand = new Random();
		for(int i=0; i<length; i++) {
			for(int j=0; j<length; j++)
			{
			matrix[i][j]= rand.nextInt(maxValue);
			}
		}
		
		return matrix;
	}
	
	static void DisplayMatrix(double[][] inputMatrix) {
		//Print the matrix to the console.
		for(int i=0; i<inputMatrix.length; i++) {
			for(int j=0; j<inputMatrix.length; j++)
			{
				System.out.print(inputMatrix[i][j]);
				System.out.print(" ");
			}
		System.out.println();
		}	
	}
}
