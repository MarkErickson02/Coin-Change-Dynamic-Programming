import java.util.Scanner;

public class CoinChanging 
{
	public static void minChange(int[] d, int amount){
		int[] minCoins = new int[amount+1];
		int[] coinsUsed = new int[amount+1];
		minCoins[0] = 0;
		coinsUsed[0] = 0;
		int min;
		int currentCoin;
		for (int a=1; a<amount+1;a++){
			min = Integer.MAX_VALUE;
			currentCoin = 0;
			for (int i=0;i<d.length;i++){
				if (d[i] <= a){
					if ((1 + minCoins[a-d[i]]) < minCoins[a] || 1+minCoins[a-d[i]] < min){
						min = 1 + minCoins[a-d[i]];
						currentCoin = i;
					}
				}
			}
			minCoins[a] = min;
			coinsUsed[a] = currentCoin;
		}
		
		int counter = 0;
		System.out.print("Coins used:{");
		while (amount > 0){
			System.out.print(d[coinsUsed[amount]] + ",");
			amount = amount - d[coinsUsed[amount]];
			counter++;
		}
		System.out.print("}");
		System.out.println("Number of coins used: " + counter);
		
	}
	public static void main(String[] args){
		int[] denominations = {1,10,25};
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter an amount: ");
		String input = keyboard.nextLine();
		int amount = Integer.parseInt(input);
		minChange(denominations,amount);
		keyboard.close();
	}

}
