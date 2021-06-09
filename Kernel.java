
public class Kernel {
	
	//Calculate a single pixel function. pass in a 3x3 matrix.
		static double CalculateValue(double[][] matrix){
			double cornerValue = 0.0625;
			double sideValue = 0.125;
			double centerValue = 0.25;
			
			double result = ((matrix[0][0]*cornerValue) + (matrix[0][1]*sideValue) + (matrix[0][2]*cornerValue) + (matrix[1][0]*sideValue) + (matrix[1][1]*centerValue) + (matrix[1][2]*sideValue) + (matrix[2][0]*cornerValue) + (matrix[2][1]*sideValue) + (matrix[2][2]*cornerValue));
			
			
			return result;
		}
}
