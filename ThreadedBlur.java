
public class ThreadedBlur extends Thread{
	
	double [ ][ ] blurredMatrix;
	
	public void Run(int i, int j, double[][] inputMatrix) {
		//Get given i and j along with reference to the inputMatrix and blurred matrix
		double[][] temp3x3 = new double[3][3];
		
		temp3x3[0][0] = inputMatrix[i-1][j-1];
		temp3x3[0][1] = inputMatrix[i-1][j];
		temp3x3[0][2] = inputMatrix[i-1][j+1];
		
		temp3x3[1][0] = inputMatrix[i][j-1];
		temp3x3[1][1] = inputMatrix[i][j];
		temp3x3[1][2] = inputMatrix[i][j+1];
		
		temp3x3[2][0] = inputMatrix[i+1][j-1];
		temp3x3[2][1] = inputMatrix[i+1][j];
		temp3x3[2][2] = inputMatrix[i+1][j+1];
		
		blurredMatrix[i][j] = Kernel.CalculateValue(temp3x3);
	}
	
	double[][] CalculateMatrixThreaded(double[][] inputMatrix){
		
		//Initialise matrix for blurred result
		int length = inputMatrix.length;
		blurredMatrix = new double [ length ] [ length ];
		
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < length; j++) {
					
					//If check nothing will be out of bounds, if so skip the value cropping the output matrix.
					if((i>0 && j>0) && (i<length-1 && j<length-1)) {
						//Start thread to calculate value.
						Run(i,j,inputMatrix);
					}
					else {
					}
					//pass values to temp 3x3 matrix
				}
			}
		return blurredMatrix;
	}
}
