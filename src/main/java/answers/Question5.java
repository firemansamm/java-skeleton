package answers;

import java.util.Arrays; 

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		int sgn = totalValue / Math.abs(totalValue);
		totalValue = Math.abs(totalValue);
		int[] ans = new int[totalValue + 1];
		ans[0] = 0;
		if (sgn == -1) {
			for(int i=0;i<allowedAllocations.length;i++){
				allowedAllocations[i] *= sgn;
				//if (allowedAllocations[i] < 0) 
			}
		}
		for(int i=1;i<=totalValue;i++){
			for(int j=0;j<allowedAllocations.length;j++){
				int nx = i - allowedAllocations[j];
				if (nx < 0) continue;
				if (ans[i] == 0) ans[i] = ans[nx] + 1;
				else ans[i] = Math.min(ans[nx] + 1, ans[i]);
			}
		}
		return ans[totalValue];
	}

}
