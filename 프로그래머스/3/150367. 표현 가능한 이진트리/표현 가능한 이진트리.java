class Solution {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);

            int treeSize = 1;

            while (treeSize < binary.length()) {
                treeSize = treeSize * 2 + 1;
            }

            StringBuilder paddedBinary = new StringBuilder(treeSize);

            int paddingCount = treeSize - binary.length();

            for (int j = 0; j < paddingCount; j++) {
                paddedBinary.append('0');
            }

            paddedBinary.append(binary);

            char[] nodes = paddedBinary.toString().toCharArray();

            boolean valid = isValidTree(
                    nodes,
                    0,
                    nodes.length - 1,
                    false
            );

            answer[i] = valid ? 1 : 0;
        }

        return answer;
    }

    private boolean isValidTree(
            char[] nodes,
            int start,
            int end,
            boolean parentIsDummy
    ) {
        int mid = (start + end) / 2;

        char currentNode = nodes[mid];

        if (parentIsDummy && currentNode == '1') {
            return false;
        }

        if (start == end) {
            return true;
        }

        boolean currentIsDummy = currentNode == '0';

        boolean leftValid = isValidTree(
                nodes,
                start,
                mid - 1,
                currentIsDummy
        );

        if (!leftValid) {
            return false;
        }

        return isValidTree(
                nodes,
                mid + 1,
                end,
                currentIsDummy
        );
    }
}