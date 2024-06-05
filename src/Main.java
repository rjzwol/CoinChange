import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> coins = new ArrayList<>(Arrays.asList(2,3,5,11));
        System.out.println(coinChange(coins, 13));
    }
    static int coinChange(ArrayList<Integer> coins, int amount) {
        int [] c = new int[amount+1];
        c[0] = 0;
        for (int i = 1; i <= amount; i++) {
            c[i] = 2 * amount;
            for (int j : coins) {
                if (j <= i) {
                    int count = c[i - j];
                    if (count + 1 < c[i])
                        c[i] = c[i - j] + 1;
                }
            }
        }
        return c[amount] <= amount ? c[amount] : 0;
    }
}