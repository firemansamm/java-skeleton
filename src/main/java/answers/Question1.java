package answers;

public class Question1 {

	public static int bestMergedPortfolio(int[] portfolios) {
		int ans = 0, len = portfolios.length, x;
		for (int i=0;i<len;i++) {
			int p = portfolios[i];
			for(int j=i+1;j<len;j++){
				x = p ^ portfolios[j];
				if (x > ans) ans = x;
			}
		}
		return ans;
	}

}
