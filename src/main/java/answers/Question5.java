package answers;

import java.util.Arrays; 

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		if (totalValue < 0) throw new IllegalArgumentException("totalValue < 0: " + totalValue.toString());
		int len = allowedAllocations.length;
		int[] ans = new int[totalValue + 1];
		ans[0] = 0;
		for(int i=1;i<=totalValue;i++){
			for(int j=0;j<len;j++){
				int nx = i - allowedAllocations[j];
				if (nx < 0) continue;
				if (ans[i] == 0) ans[i] = ans[nx] + 1;
				else if (ans[nx] + 1 < ans[i]) ans[i] = ans[nx] + 1;
			}
		}
		return ans[totalValue];
	}

}
