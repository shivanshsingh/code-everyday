/*
* This is the solution to the coin change problem, using dynamic programming.
*/
public class CoinChangeDP {
	public static int count(int amount, int[] coins) {
		// Matrix to store the solution
		int[][] solution = new int[coins.length+1][amount+1];

		// When amount is zero, exact solution found. Return 1.
		for(int noOfCoins=0;noOfCoins<=coins.length;noOfCoins++)
			solution[noOfCoins][0] = 1;

		// When amount is non-zero but coins available is zero, no solution exist. Return 0.
		for(int amountRemaining=1;amountRemaining<=amount;amountRemaining++)
			solution[0][amountRemaining] = 0;

		// Fill rest of the matrix.
		for(int c=1;c<=coins.length;c++) {
			for(int amt=1;amt<=amount;amt++) {
				// If coin value is less than amount, then find solution by including the coin + excluding the coin
				if(coins[c-1] <= amt)
					solution[c][amt] = solution[c][amt-coins[c-1]] + solution[c-1][amt];
				// exclude coin and find solution
				else
					solution[c][amt] = solution[c-1][amt];
			}
		}
		return solution[coins.length][amount];
	}

	public static void main(String[] args) {
		int amount = 5;
		int[] coins = new int[] {1,2,3};
		int result = count(amount, coins);
		System.out.println(result);
	}
}