package codingTest;
import java.util.*;




    class bttonUp {
        public int climbStairs(int n) {
            //✅ 목표 계단 수(n) 크기의 dp 테이블을 만든다.
            int[] dp = new int[n + 1];
            //✅ 0번째, 1번째 계단을 1로 저장한다.
            dp[0] = 1;
            dp[1] = 1;
            //✅ 2번째 계단부터 n번째 계단까지 올라간다.
            for (int i = 2; i <= n; i++) {
                //✅ 점화식에 따라 각 계단에 도달할 수 있는 총 가짓수를 구한다.
                dp[i] = dp[i - 1] + dp[i - 2] ;
            }
            //✅ 현재 계단(n)에 도달하는 총 가짓수를 반환한다.
            return dp[n];
        }
    }

