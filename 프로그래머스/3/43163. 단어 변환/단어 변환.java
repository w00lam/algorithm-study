import java.util.*;

class Solution {

    static class Node {
        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) {
                    continue;
                }

                if (!canConvert(current.word, words[i])) {
                    continue;
                }

                if (words[i].equals(target)) {
                    return current.count + 1;
                }

                visited[i] = true;
                queue.offer(new Node(words[i], current.count + 1));
            }
        }

        return 0;
    }

    private boolean canConvert(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}