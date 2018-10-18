package answers;

public class Question1 {

	public static int bestMergedPortfolio(int[] portfolios) {
		int ans = 0, v = 0;
		for (int i=0;i<portfolios.length;i++) {
			for(int j=i+1;j<portfolios.length;j++){
				int vf = portfolios[i] ^ portfolios[j];
				int vx = Integer.bitCount(vf);
				if (vx > v) {
					v = vx;
					ans = vf;
				}
			}
		}
		return ans;
	}

}
