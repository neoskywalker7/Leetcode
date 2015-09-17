    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {//往下
            sum[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {//往右都只有一种
            sum[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];每一个也只能是前一个左和前一个上之和
            }
        }
        return sum[m - 1][n - 1];
    }
