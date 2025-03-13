import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[N];

        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt() - 1;
            int B = scanner.nextInt() - 1;
            adj.get(A).add(B);
            inDegree[B]++;
        }

        List<Integer> result = kahn(adj, inDegree, N);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> kahn(List<List<Integer>> adj, int[] inDegree, int n) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u + 1);

            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        return result;
    }
}
