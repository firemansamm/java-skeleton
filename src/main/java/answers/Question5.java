package answers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Question5 {

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
	static HashMap<Integer, Boolean> v = new HashMap<Integer, Boolean>();
	static PriorityQueue<State> pq = new PriorityQueue<State>(1, new Compare());
	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		/* hmm */
		pq.add(new State(0, 0));
		int len = allowedAllocations.length;
		while(pq.peek() != null) {
			State c = pq.poll();
			System.err.println(c.cn);
			if (v.get(c.cn) != null) continue;
			/* sign check */
			if ((c.cn < 0 && totalValue > 0) || (c.cn > 0 && totalValue < 0)) continue;
			v.put(c.cn, true);
			if (c.cn == totalValue) return c.cd;
			for(int i=0;i<len;i++){
				pq.add(new State(c.cn + allowedAllocations[i], c.cd + 1));
			}
		}
		return -1;
	}

}
