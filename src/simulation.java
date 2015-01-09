
import java.util.*;
//Class definition
public class simulation 
{
	public static void main(String[] args) {
		int resample; //Number of re-samples
		ArrayList<trajectories> list = new ArrayList<trajectories>(); //initialize list
		// Create instances for the required classes
		weightedEnsemble WE = new weightedEnsemble();
		Dynamics dynamics = new Dynamics();
		Random rand = new Random();
		Scanner S = new Scanner(System.in);
		trajectories Node = new trajectories();
		//Accept the number of times re-sampling has to be done
		System.out.println("Enter the number of resamples");
		resample = S.nextInt();
		//Initialize the first node and add it to the list with weight 1
		Node.setbin(1);
		Node.setwt(1);
		Node.setIndex(0);
		list.add(Node);
		//Perform dynamics and WE for Re-sample times
		int index=0;
		for(int i=0;i<resample;i++)
		{
			System.out.println("Dynamics");
			dynamics.start(list);
			System.out.print("\n");
			System.out.println("WE");
			WE.start(list);
			System.out.print("\n");
		}
	} 
}