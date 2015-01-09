

import java.util.ArrayList;
import java.util.Random;
//Weighted Ensemble Splits and Merges nodes at random provided they belong
//to the same bin and the daughter trajectories weights are decided by the parent trajectory
public class weightedEnsemble {
	Random rand = new Random();
	int indexpick;
	//Start function which accepts a list as the parameter returns the processed list
	public ArrayList<trajectories> start(ArrayList<trajectories> list){
		float weight;
		//Number of times the nodes are Split
		int randomsplit = rand.nextInt((3 - 1) + 1)+1;
		//Number of times the nodes are merged
		int randommerge = rand.nextInt((3 - 1) + 1)+1;
		int s=list.size();
		//Splitting loop
		System.out.println("Splitting");
		for(int i=s;i<s+randomsplit;i++)
		{
			trajectories Node = new trajectories();
			indexpick = rand.nextInt((s-1) + 1);
			weight = list.get(indexpick).getwt();
			list.get(indexpick).setwt(weight/2);
			list.add(Node);
			list.get(i).setIndex(i);
			list.get(i).setwt(weight/2); //Daughter trajectory with weight W/N
			list.get(i).setbin(list.get(indexpick).getbin());
		}
		//Display the list after Splitting
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getIndex() +"\t" + list.get(i).getbin()+"\t" + list.get(i).getwt());
		}
		//Merging loop
		System.out.println("Merging");
		for(int i=0;i<randommerge;i++)
		{
			//Only if the list has more than 2 nodes, merging can be done
			if(list.size()>2)
			{
				merge(list);
				System.out.println("\n");
			}
		}
		return list;
	}
	//A function that accepts a list and returns a merged list
	public ArrayList<trajectories> merge(ArrayList<trajectories> list){
		int s=list.size();
		indexpick = rand.nextInt(((s-1)-1) + 1);
		//A temporary list is used for merging operations
		ArrayList<trajectories> newlist = new ArrayList<trajectories>();
		int k=0;
		//If the picked index is not equal to the iterator k
		if(k!=indexpick)
		{
			//Find K'th node in the list which belongs to the same bin as (indexpick)'th node
			while(list.get(k).getbin()!=list.get(indexpick).getbin() && k<s-1)
			{	
				if(k!=indexpick-1)
				{
					k++;
				}
				else
				{
					k=k+2;
				}
			}
			//Merging after finding k'th node
			if(list.get(k).getbin()==list.get(indexpick).getbin())
			{
				float newwt = list.get(indexpick).getwt()+list.get(k).getwt();
				list.get(indexpick).setwt(newwt);
				//Merging and index changing
				for(int j=0;j<list.size();j++)
				{
					if(j<k){
						trajectories N = new trajectories();
						newlist.add(N);
						newlist.get(j).setIndex(j);
						newlist.get(j).setbin(list.get(j).getbin());
						newlist.get(j).setwt(list.get(j).getwt());
					}
					else if(j>k){
						trajectories N = new trajectories();
						newlist.add(N);
						newlist.get(j-1).setIndex(j-1);
						newlist.get(j-1).setbin(list.get(j).getbin());
						newlist.get(j-1).setwt(list.get(j).getwt());
					}
				}
				list.remove(k);
				//Copying the trajectories from the new list to the list that we return
				for(int j=0;j<newlist.size();j++)
				{
						list.get(j).setIndex(newlist.get(j).getIndex());
						list.get(j).setbin(newlist.get(j).getbin());
						list.get(j).setwt(newlist.get(j).getwt());
				}
			}	
		}
		//If the picked index is not equal to the iterator k and if k is in the list
		else if(k<list.size()-1){
			k++;
			//Find K'th node in the list which belongs to the same bin as (indexpick)'th node
			while(list.get(k).getbin()!=list.get(indexpick).getbin() && k<s-1)
			{
					k++;
			}
			//Merging after finding k'th node
			if(list.get(k).getbin()==list.get(indexpick).getbin())
			{
				float newwt = list.get(indexpick).getwt()+list.get(k).getwt();
				list.get(indexpick).setwt(newwt);
				//Merging and index changing
				for(int j=0;j<list.size();j++)
				{
					if(j<k){
						trajectories N = new trajectories();
						newlist.add(N);
						newlist.get(j).setIndex(j);
						newlist.get(j).setbin(list.get(j).getbin());
						newlist.get(j).setwt(list.get(j).getwt());
					}
					else if(j>k){
						trajectories N = new trajectories();
						newlist.add(N);
						newlist.get(j-1).setIndex(j-1);
						newlist.get(j-1).setbin(list.get(j).getbin());
						newlist.get(j-1).setwt(list.get(j).getwt());
					}
				}
				list.remove(k);
				//Copying the trajectories from the new list to the list that we return
				for(int j=0;j<newlist.size();j++)
				{
						list.get(j).setIndex(newlist.get(j).getIndex());
						list.get(j).setbin(newlist.get(j).getbin());
						list.get(j).setwt(newlist.get(j).getwt());
				}
			}	
		}
		//Display the list after Merging
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getIndex() +"\t" + list.get(i).getbin()+"\t"+ list.get(i).getwt());
		}
			return list;
	}
}