public class Solution {// DP
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        boolean[] can = new boolean[A.length];//难道boolean直接初始化就是0吗？
        can[0] = true;//起点当然可以啊
        
        for (int i = 1; i < A.length; i++) {//j<i&&f[j]=true&&j能调到i
            for (int j = 0; j < i; j++) {//注意i从1 j从0
                if (can[j] && j + A[j] >= i) {
                    can[i] = true;//基本上都是iterative的
                    break;//break 只是跳出j那层循环   我也感觉到这不是最优的，但是还有点讲不出清楚
                }
            }
        }
        
        return can[A.length - 1];
    }
}
public class Solution {//greedy
    public boolean canJump(int[] A) {
        // think it as merging n intervals
        if (A == null || A.length == 0) {//区分空和为零的区别
            return false;
        }
        int farthest = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= farthest && A[i] + i >= farthest) {//就是数最远的到哪个格子
                farthest = A[i] + i;//比如说从第一个数开始，如果条件不满足farthest还是第0个数的，这就是贪心啊
            }
        }
        return farthest >= A.length - 1;//最后还是一个价值判断，不用开数组，
    }
}
