package answers;

import java.util.LinkedList;

public class Question4 {

	static LinkedList<Integer> cx = new LinkedList<Integer>();

	public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
		int ans = 1<<30, sm = 0, sz = 0, val = 0, r = rows.length, c = rows[0].length;
		for(int i=0;i<r;i++){
			cx.clear();
			sm = 0;
			sz = 0;
			String[] v = rows[i];
			for(int j=0;j<c;j++){
				String k = v[j];
				if (k.charAt(0) == 'X') {
					if (sz != 0) {
						cx.clear();
						sz = 0;
						sm = 0;
					}
				} else {
					val = Integer.parseInt(k);
					sm += val;
					sz++;
					cx.add(val);
					if (sz == numberMachines) {
						if (sm < ans) ans = sm;
						sm -= cx.removeFirst();
						sz--;
					}
				}
			}
		}
		if (ans == 1<<30) return 0;
		else return ans;
	}

}
