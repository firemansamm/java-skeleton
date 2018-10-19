package answers;

import java.util.Deque;
import java.util.ArrayDeque;

public class Question4 {

	public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
		int ans = 1<<30, sm = 0, sz = 0, val = 0;
		Deque<Integer> cx = new ArrayDeque<Integer>();
		for(int i=0;i<rows.length;i++){
			cx.clear();
			sm = 0;
			sz = 0;
			for(int j=0;j<rows[i].length;j++){
				if (rows[i][j] == "X") {
					if (sz != 0) {
						cx.clear();
						sz = 0;
						sm = 0;
					}
				} else {
					val = Integer.parseInt(rows[i][j]);
					sm += val;
					sz++;
					cx.addLast(val);
					if (sz == numberMachines) {
						ans = Math.min(sm, ans);
						sm -= cx.pollFirst();
						sz--;
					}
				}
			}
		}
		if (ans == 1<<30) return 0;
		else return ans;
	}

}
