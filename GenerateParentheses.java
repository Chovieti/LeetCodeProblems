import java.util.*;

public class GenerateParentheses {
    class Pair {
        StringBuilder builder;
        int leftHas;

        Pair(StringBuilder builder) {
            this.builder = builder;
        }

        Pair(StringBuilder builder, int leftHas) {
            this.builder = builder;
            this.leftHas = leftHas;
        }
    }
    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(new StringBuilder("("), 1));
        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            for (int i = current.leftHas; i < n; i++) {
                StringBuilder openedBuilder = new StringBuilder(current.builder);
                openedBuilder.append("(");
                stack.push(new Pair(openedBuilder, current.leftHas + 1));
                if (current.builder.length() < current.leftHas * 2) {
                    current.builder.append(")");
                    StringBuilder tmp = new StringBuilder(current.builder);
                    while (tmp.length() < current.leftHas * 2) {
                        tmp.append(")");
                        stack.push(new Pair(new StringBuilder(tmp), current.leftHas));
                    }
                }
                current.builder.append("(");
                current.leftHas++;
            }
            while (current.builder.length() < n * 2) current.builder.append(")");
            result.add(current.builder.toString());
        }
        return result.stream().toList();
    }
}
