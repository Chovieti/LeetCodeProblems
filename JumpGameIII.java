import java.util.Stack;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) return true;

        int l = arr.length;
        boolean[] visited = new boolean[l];
        visited[start] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (index + arr[index] < l) {
                if (arr[index + arr[index]] == 0) return true;
                if (!visited[index + arr[index]]) {
                    visited[index + arr[index]] = true;
                    stack.push(index + arr[index]);
                }
            }
            if (index - arr[index] >= 0) {
                if (arr[index - arr[index]] == 0) return true;
                if (!visited[index - arr[index]]) {
                    visited[index - arr[index]] = true;
                    stack.push(index - arr[index]);
                }
            }
        }

        return false;
    }
}
