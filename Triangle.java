    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {//triangle 都这么写 可变长 可变的2维数组
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();
        int[][] sum = new int[n][n];//改用2维数组存它的

        for (int i = 0; i < n; i++) {
            sum[n - 1][i] = triangle.get(n - 1).get(i);//bottom 自底向上 最后一行
        }

        for (int i = n - 2; i >= 0; i--) { 
            for (int j = 0; j <= i; j++) {
                sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) + triangle.get(i).get(j);//慢慢从底向上坐上来
            }
        }

        return sum[0][0];
    }
