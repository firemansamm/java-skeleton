package answers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question6 {

	static class State {
		public int cn;
		public int cd;
		public State(int n, int d) {
			cn = n;
			cd = d;
		}
	}

	static class Compare implements Comparator<State> {
		@Override
		public int compare(State a0, State a1) {
			return a0.cd - a1.cd;
		}
	}

	public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
		PriorityQueue<State> pq = new PriorityQueue<State>(numServers, new Compare());
		boolean[] v = new boolean[numServers + 5];
		pq.add(new State(0, 0));
		while(pq.peek() != null) {
			State c = pq.poll();
			if (c.cn == targetServer) {
				return c.cd;
			}
			if(v[c.cn]) continue;
			v[c.cn] = true;
			for(int i=0;i<numServers;i++){
				if (v[i]) continue;
				pq.add(new State(i, c.cd + times[c.cn][i]));
			}
		}
		return times[0][targetServer];
	}

}
