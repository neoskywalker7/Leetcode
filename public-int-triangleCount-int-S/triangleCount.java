    public int triangleCount(int S[]) {
        //int left = 0, right = S.length - 1;
        int result = 0;
        Arrays.sort(S);
        for(int i=2; i<S.length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (S[left] + S [right] > S[i]) {
                    result = result + (right - left);
                    right --;
                }else {
                    left ++;
                }
            }
        }
        return result;
    }
