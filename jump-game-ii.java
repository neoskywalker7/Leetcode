public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        int[] steps = new int[A.length];
        
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;// 每次都直接给他一个最大值 可以避免麻烦
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {// 只要可以step的值 就行了。
                    steps[i] = steps[j] + 1;//所以这个肯定不是最优的 因为它每次都要回到第一步来计算可不可以，比如说这题 它要到位置4，它又要从0位置起找
                    break;
                }
            }
        }
        
        return steps[A.length - 1];
    }
}


public class Solution {//这个greedy 还是比较难想的
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;//跳几步就能到
            int farthest = end;//然后里面的start end 变化就比较多了。
            for (int i = start; i <= end; i++) {//注意这里是i <= end 一开始他们是重合
                if (A[i] + i > farthest) {//有了这个 它就不用做什么双重循环了
                    farthest = A[i] + i;
                }
            }
            start = end + 1;//每次start到end之间 看能不能找到一个比farth远的 我不要最好的 我只要局部最优的  然后end 帮助出局
            end = farthest;
        }
        return jumps;
    }
}
