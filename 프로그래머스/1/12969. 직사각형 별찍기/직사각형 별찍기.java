import java.util.Scanner;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        IntStream.range(0, n).forEach(i -> sb.append("*"));
        IntStream.range(0, m).forEach(i -> System.out.println(sb.toString()));
    }
}