

import java.util.ArrayList;
import java.util.Random;

public class Dynamics {

	public ArrayList<trajectories> start(ArrayList<trajectories> list){
		int randomNum; int index,change;
		float wt1 = 0;float wt2 = 0;float wt3 = 0;float wt4 = 0;
		//Create instances for the classes needed
		trajectories Node = new trajectories();
		Random rand = new Random();
		//randomly select the nodes to be shifted to different bins
		randomNum = rand.nextInt((list.size()-1) + 1)+1;
		//Change the bin number for each randomly selected node from the list
		for(int i=0;i<randomNum;i++)
		{
			index = rand.nextInt((randomNum-1) + 1);
			change = rand.nextInt((4 - 1) + 1)+1;
			list.get(index).setbin(change);
		}
		//Display the List after dynamics
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getIndex() +"\t" + list.get(i).getbin()+"\t"+ list.get(i).getwt());
		}
		//Calculate Individual bin weights and total weight
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getbin()==1)
			{
				wt1=wt1+list.get(i).getwt();
			}
			else if(list.get(i).getbin()==2)
			{
				wt2=wt2+list.get(i).getwt();
			}
			else if(list.get(i).getbin()==3)
			{
				wt3=wt3+list.get(i).getwt();
			}
			else if(list.get(i).getbin()==4)
			{
				wt4=wt4+list.get(i).getwt();
			}
		}
		//Display the weights
		System.out.println("Total weight of bin 1 :" + wt1 +"\n" +"Total weight of bin 2 :" + wt2 +"\n"+"Total weight of bin 3 :" + wt3 +"\n"+"Total weight of bin 4 :" + wt4 );
		System.out.println("Total weight:" + (wt1+wt2+wt3+wt4));
		return list;
	}
}