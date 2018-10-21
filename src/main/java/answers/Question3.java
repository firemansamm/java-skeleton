package answers;

import helpers.Edge;
import java.util.ArrayList;

public class Question3 {

	static ArrayList<ArrayList<Integer>> ad;
	static boolean[] v;

	static int[] dfs(int n, int idx) {
		int[] ret = new int[]{0, 0};
		if (v[n]) return ret;
		v[n] = true;
		int ni = (idx + 1) % 2;
		System.out.println(n);
		for(int o : ad.get(n)) {
			if (v[o]) continue;
			int[] k = dfs(o, ni);
			ret[0] += k[0];
			ret[1] += k[1];
		}
		ret[idx]++;
		return ret;
	}

	public static int lowestExposureToExchanges(int numNodes, Edge[] edgeList) {
		/* build adjlist */
		ad = new ArrayList<ArrayList<Integer>>(numNodes + 5);
		v = new boolean[numNodes + 5];
		int el = edgeList.length;
		for(int i=0;i<el;i++){
			Edge e = edgeList[i];
			int x = e.getEdgeA(), y = e.getEdgeB();
			ad.get(x).add(y);
			ad.get(y).add(x);
		}
		int ans = 0;
		for(int i=1;i<=numNodes;i++) {
			if (v[i]) continue;
			int[] k = dfs(i, 0);
			if (k[0] > k[1]) ans += k[0] - k[1];
			else ans += k[1] - k[0];
		}
		return ans;
	}

}
