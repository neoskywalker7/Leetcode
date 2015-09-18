public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int last = 1, lastlast = 1;//因为0和1比较特殊 先对其赋值
        int now = 0;
        for (int i = 2; i <= n; i++) {//last就是 i-1  lastlast就是i-2
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }
}
