import java.io.*;
import java.util.*;

public class BOJ_18870ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // add list
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(i, Integer.parseInt(st.nextToken())));
        }

        // sort
        list.sort(Comparator.comparingInt(o -> o.val));


        int val = list.get(0).val;
        int cnt = 0;
        int[] arr = new int[n];
        arr[list.get(0).idx] = cnt;

        for (int i = 1; i < list.size(); i++) {
            int nVal = list.get(i).val;
            cnt = nVal == val ? cnt : cnt+1;
            val = nVal;

            arr[list.get(i).idx] = cnt;
        }

        // print
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]+" ");
        }
        System.out.println(sb.toString());
    }
    static class Node{
        int idx;
        int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
