import java.util.*;

import javax.print.event.PrintJobListener;

import javafx.print.PrintColor;

public class solution {
    class UnionCount {
        private int root[];
        private int rank[];
        private int count = 0;
        private int min = Integer.MAX_VALUE;
        Set<Integer> all = new HashSet<>();

        public UnionCount(int n) {
            root = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            Arrays.fill(rank, 1);
        }

        public int find(int x) {
            if (x != root[x]) {
                root[x] = root[root[x]];
                x = root[x];
            }
            return x;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void Union(int x, int y, int time) {
            if (count == 1)
                return;
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;
            if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                if (rank[rootX] == rank[rootY]) {
                    rank[rootY]++;
                }
            }
            min = time;
            count--;
        }

        public int count() {
            return count;
        }

        public int time() {
            return min;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[m][3];
        solution s = new solution();
        solution.UnionCount uc = s.new UnionCount(n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(final int entry1[], final int entry2[]) {
                if (entry1[2] > entry2[2])
                    return 1;
                else
                    return -1;
            }
        });
        // System.out.println(Arrays.deepToString(arr));
        for (int i = 0; i < m; i++) {
            uc.Union(arr[i][0], arr[i][1], arr[i][2]);
            // System.out.println(uc.time());
        }
        System.out.println(uc.time());
        // System.out.println(uc.count());
    }
}