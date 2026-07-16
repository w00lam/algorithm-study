import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int SIZE = 50;
    private static final int CELL_COUNT = SIZE * SIZE;
    private static final String EMPTY = "EMPTY";

    private int[] parent;
    private String[] values;

    public String[] solution(String[] commands) {
        parent = new int[CELL_COUNT];
        values = new String[CELL_COUNT];

        for (int i = 0; i < CELL_COUNT; i++) {
            parent[i] = i;
            values[i] = EMPTY;
        }

        List<String> answer = new ArrayList<>();

        for (String command : commands) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "UPDATE":
                    if (tokens.length == 4) {
                        updateCell(
                            Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]),
                            tokens[3]
                        );
                    } else {
                        updateValue(tokens[1], tokens[2]);
                    }
                    break;

                case "MERGE":
                    merge(
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]),
                        Integer.parseInt(tokens[3]),
                        Integer.parseInt(tokens[4])
                    );
                    break;

                case "UNMERGE":
                    unmerge(
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2])
                    );
                    break;

                case "PRINT":
                    answer.add(print(
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2])
                    ));
                    break;

                default:
                    throw new IllegalArgumentException(
                        "지원하지 않는 명령어입니다: " + tokens[0]
                    );
            }
        }

        return answer.toArray(new String[0]);
    }

    private void updateCell(int row, int col, String value) {
        int cell = toIndex(row, col);
        int root = find(cell);

        values[root] = value;
    }

    private void updateValue(String oldValue, String newValue) {
        for (int i = 0; i < CELL_COUNT; i++) {
            if (find(i) == i && values[i].equals(oldValue)) {
                values[i] = newValue;
            }
        }
    }

    private void merge(int row1, int col1, int row2, int col2) {
        int cell1 = toIndex(row1, col1);
        int cell2 = toIndex(row2, col2);

        int root1 = find(cell1);
        int root2 = find(cell2);

        if (root1 == root2) {
            return;
        }

        String mergedValue = values[root1].equals(EMPTY)
            ? values[root2]
            : values[root1];

        parent[root2] = root1;

        values[root1] = mergedValue;
        values[root2] = EMPTY;
    }

    private void unmerge(int row, int col) {
        int target = toIndex(row, col);
        int root = find(target);
        String savedValue = values[root];

        List<Integer> group = new ArrayList<>();

        for (int i = 0; i < CELL_COUNT; i++) {
            if (find(i) == root) {
                group.add(i);
            }
        }

        for (int cell : group) {
            parent[cell] = cell;
            values[cell] = EMPTY;
        }

        values[target] = savedValue;
    }

    private String print(int row, int col) {
        int cell = toIndex(row, col);
        int root = find(cell);

        return values[root];
    }

    private int find(int cell) {
        if (parent[cell] == cell) {
            return cell;
        }

        parent[cell] = find(parent[cell]);
        return parent[cell];
    }

    private int toIndex(int row, int col) {
        return (row - 1) * SIZE + (col - 1);
    }
}