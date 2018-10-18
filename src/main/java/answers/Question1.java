package answers;

public class Question1 {

	public static int bestMergedPortfolio(int[] portfolios) {
		int ans = 0;
		for (int i=0;i<portfolios.length;i++) {
			for(int j=i+1;j<portfolios.length;j++){
				ans = Math.max(ans, Integer.bitCount(portfolios[i] ^ portfolios[j]));
			}
		}
		return ans;
	}

}
