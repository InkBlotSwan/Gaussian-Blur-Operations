import java.util.Date;
import java.util.Random;

public class ThreadManagerTask4 {
	double [ ][ ] blurredMatrix;
	private  String[][]  tasks;
	Date date = new Date();
	int failRate;
	
	public void Run(String threadID, double[][] inputMatrix) {
		String ID = threadID;
		boolean running = true;
		boolean allTasksComplete;
		while(running) {
			allTasksComplete = true;
		//Go through tasks until find an incomplete one. Set to in progress. Set start time in Manager. If all tasks complete, end.
			for(int i = 0; i < tasks.length; i++) {
				for(int j = 0; j < tasks.length; j++) {
					if((i>0 && j>0) && (i<tasks.length-1 && j<tasks.length-1)) {
					if(tasks[i][j] == "incomplete") {
						allTasksComplete = false;
						//Set task to threadID for the manager process.
						tasks[i][j] = String.valueOf(date.getTime());
						
						// Calculate value
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
						
						double result = Kernel.CalculateValue(temp3x3);
						
						
						//Sleep for 200 milliseconds NOTE! 200ms is quite substantial when scaled.
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						//Check if this node fails
						Random rand = new Random();
						if(rand.nextInt(100) <= failRate) {
							blurredMatrix[i][j] = result;
							System.out.print("Nodecomplete");
						}
						else {
							allTasksComplete = false;
						}
					}	
					else if(tasks[i][j] != "complete") {
						allTasksComplete = false;
					}
					}
				}
			}
		if(allTasksComplete) {
			running = false;
		}
		}
	}
	
	public double[][] SimulateNetwork(int numOfNodes, double[][] inputMatrix, int failRate) {
		//Initialise matrix for blurred result
		this.failRate = failRate;
		int length = inputMatrix.length;
		blurredMatrix = new double [ length ][ length ];
		//Initialise matrix for managing thread progress
		tasks = Matrix.NewMatrix(length, "incomplete");
		
		//Start the node threads
		for(int i=0; i <numOfNodes; i++) {
			Run(String.valueOf(i), inputMatrix);
		}
		
		//While nodes are running check for in progress tasks. Check if they have timed out, if yes, set task back to incomplete.
		boolean running = true;
		int incompleteCount;
		while(running) {
			incompleteCount = 0;
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < length; j++) {
					//If check task needs to be completed.
					if((i>0 && j>0) && (i<length-1 && j<length-1)) {
						if(tasks[i][j] != "complete") {
							incompleteCount++;
							System.out.print("CHECK");
							if(tasks[i][j] != "incomplete") {
								//Check thread hasn't timed out.
								if(date.getTime() - Long.parseLong(tasks[i][j]) >= 3 ) {
									tasks[i][j] = "incomplete";
									System.out.println("Thread timed out");
								}
							}
						}
					}
					else {
						
					}
				}
			}
			if(incompleteCount == 0) {
				running = false;
			}
		}
		
		
		//Blur is complete, return result
		return blurredMatrix;
	}
}
