import java.util.*;

public class CodingTest {

    public static boolean canAbhimanyuCross(int[] enemiesPower, int p, int a, int b, int rechargePower) {
        int n = enemiesPower.length;
        boolean k3Regenerated = false, k7Regenerated = false;

        for (int i = 0; i < n; i++) {
            int currentEnemyPower = enemiesPower[i];

            if (i == 3 && !k3Regenerated) {
                p -= enemiesPower[2] / 2;
                k3Regenerated = true;
                if (p <= 0) {
                    return false;
                }
                if (b > 0) {
                    p += rechargePower;
                    b--;
                }
            }

            if (i == 7 && !k7Regenerated) {
                p -= enemiesPower[6] / 2;
                k7Regenerated = true;
                if (p <= 0) {
                    return false;
                }
                if (b > 0) {
                    p += rechargePower;
                    b--;
                }
            }

            if (p >= currentEnemyPower) {
                p -= currentEnemyPower;
            } else if (a > 0) {
                a--;
            } else if (b > 0) {
                p += rechargePower;
                b--;
                if (p >= currentEnemyPower) {
                    p -= currentEnemyPower;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] enemiesPower1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        int p1 = 150, a1 = 1, b1 = 2, rechargePower1 = 30;
        boolean result1 = canAbhimanyuCross(enemiesPower1, p1, a1, b1, rechargePower1);
        System.out.println("Can Abhimanyu cross in Test Case 1: " + result1);

        int[] enemiesPower2 = {10, 15, 30, 45, 55, 65, 75, 85, 95, 105, 115};
        int p2 = 120, a2 = 2, b2 = 1, rechargePower2 = 35;
        boolean result2 = canAbhimanyuCross(enemiesPower2, p2, a2, b2, rechargePower2);
        System.out.println("Can Abhimanyu cross in Test Case 2: " + result2);
    }
}
