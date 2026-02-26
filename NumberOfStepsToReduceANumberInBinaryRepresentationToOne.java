public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public int numSteps(String s) {
        int count = 0, rent = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            switch (s.charAt(i)) {
                case '0' -> count += (rent == 0) ? 1 : 2;
                case '1' -> {
                    count += (rent == 1) ? 1 : 2;
                    rent = 1;
                }
            }
        }
        return count + rent;
    }
}
