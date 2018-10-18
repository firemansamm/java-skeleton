package answers;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		int[] ans = new int[totalValue + 1];
		Arrays.fill(ans, allowedAllocations.length + 5);
		ans[0] = 0;
		for(int i=1;i<=totalValue;i++){
			for(int j=0;j<allowedAllocations.length;j++){
				int nx = i - allowedAllocations[j];
				if (nx < 0) continue;
				ans[i] = Math.min(ans[nx] + 1, ans[i]);
			}
		}
		return ans[totalValue];
	}

}
