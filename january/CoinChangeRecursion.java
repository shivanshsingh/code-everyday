/*
* This is the solution to the coin change problem, using recursion.
*/
public class CoinChangeRecursion {
	public static int count(int amount, int[] coins, int i) {
		// amount reaches negative, no solution.
		if(amount < 0)
			return 0;
		// amount is exactly 0, found exact combination.
		if(amount == 0)
			return 1;
		// all coins included, still amount is greater than zero, no solution.
		if(i==coins.length && amount > 0)
			return 0;
		
		// include the coin - i.e. reduce the amount by value of coin and find solution in sub-problem with same coin + 
		// exclude the coin - i.e. keep the same amount and find solution with next coin.
		return(count(amount-coins[i], coins, i) + count(amount, coins, i+1));
	}

	public static void main(String[] args) {
		int amount = 5;
		int[] coins = new int[] {1,2,3};
		// Start with 1st coin.
		int result = count(amount, coins, 0);
		System.out.println(result);
	}
}