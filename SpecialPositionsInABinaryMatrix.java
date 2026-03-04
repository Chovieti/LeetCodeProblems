public class SpecialPositionsInABinaryMatrix {
    public int numSpecial(int[][] mat) {
        int[] checked =  new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            boolean only = true;
            for (int j = 0, first = -1; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    if (first == -1) {
                        first = j;
                        checked[j]++;
                    } else {
                        checked[first]++;
                        checked[j]+=2;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < checked.length; i++) {
            if (checked[i] == 1) result++;
        }
        return result;
    }
}
