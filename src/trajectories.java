

public class trajectories {
	//Generic class for all the trajectories or nodes that has to be added to the list
		private int index;
		private int bin;
		private float wt;
		//INDEX FOR REFERENCE
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		//Bin in which the trajectory lies
		public int getbin() {
			return bin;
		}
		public void setbin(int bin) {
			this.bin = bin;
		}
		//Weight of that trajectory
		public float getwt() {
			return wt;
		}
		public void setwt(float wt) {
			this.wt = wt;
		}
	}