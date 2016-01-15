package cli;

import java.util.*;

public class SearchAlgorithm {
    private Matrix matrix;

    public SearchAlgorithm(Matrix matrix) {
        this.matrix = matrix.clone();
    }

    public Map<DegreeOfRisk, Integer> getGroupFound() {
        Map<DegreeOfRisk, Integer> groups = new HashMap<>();
        List<DegreeOfRisk> listGroups = findGroupsInMatrix();
        for (DegreeOfRisk element : listGroups) {
            groups.put(element, Collections.frequency(listGroups, element));
        }
        return groups;
    }

    private List<DegreeOfRisk> findGroupsInMatrix() {
        List<DegreeOfRisk> result = new ArrayList<>();
        int count = 0;
        int row = matrix.getRow();
        int column = matrix.getColumn();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ("|X|".equals(matrix.getElement(i, j))) {
                    count += checkSideToFind(i, j);
                    if (count > 0 && count < 3) {
                        result.add(DegreeOfRisk.NONE);
                        count = 0;
                        continue;
                    }
                    if (count > 2 && count < 5) {
                        result.add(DegreeOfRisk.MINOR);
                        count = 0;
                        continue;
                    }
                    if (count > 4 && count < 8) {
                        result.add(DegreeOfRisk.NORMAL);
                        count = 0;
                        continue;
                    }
                    if (count > 7 && count < 14) {
                        result.add(DegreeOfRisk.MAJOR);
                        count = 0;
                        continue;
                    }
                    if (count > 13) {
                        result.add(DegreeOfRisk.CRITICAL);
                        count = 0;
                    }
                }
            }
        }
        return result;
    }

    private int checkSideToFind(int i, int j) {
        int count = 1;
        matrix.setElement(i, j, " - ");

        List<String> sideList = new ArrayList<>();
        sideList.add("left");
        sideList.add("right");
        sideList.add("top");
        sideList.add("bot");
        Iterator iterator = new Iterator() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return !sideList.isEmpty();
            }

            @Override
            public Object next() {
                Random randNumber = new Random();
                index = randNumber.nextInt(sideList.size());
                return sideList.get(index);
            }

            @Override
            public void remove() {
                sideList.remove(index);
            }


        };
        while (iterator.hasNext()) {
            switch (iterator.next().toString()) {
                case "left":
                    count += checkLeft(i, j);
                    break;
                case "right":
                    count += checkRight(i, j);
                    break;
                case "top":
                    count += checkTop(i, j);
                    break;
                case "bot":
                    count += checkBot(i, j);
                    break;
            }
            iterator.remove();
        }

        return count;
    }

    private int checkTop(int i, int j) {
        if (i - 1 < 0) {
            return 0;
        }
        if ("|X|".equals(matrix.getElement(i - 1, j))) {
            matrix.setElement(i - 1, j, " - ");
            return checkSideToFind(i - 1, j);
        } else {
            return 0;
        }
    }

    private int checkRight(int i, int j) {
        if (j + 1 > matrix.getColumn() - 1) {
            return 0;
        }
        if ("|X|".equals(matrix.getElement(i, j + 1))) {
            matrix.setElement(i, j + 1, " - ");
            return checkSideToFind(i, j + 1);
        } else {
            return 0;
        }
    }

    private int checkBot(int i, int j) {
        if (i + 1 > matrix.getRow() - 1) {
            return 0;
        }
        if ("|X|".equals(matrix.getElement(i + 1, j))) {
            matrix.setElement(i + 1, j, " - ");
            return checkSideToFind(i + 1, j);
        } else {
            return 0;
        }
    }

    private int checkLeft(int i, int j) {
        if (j - 1 < 0) {
            return 0;
        }
        if ("|X|".equals(matrix.getElement(i, j - 1))) {
            matrix.setElement(i, j - 1, " - ");
            return checkSideToFind(i, j - 1);
        } else {
            return 0;
        }
    }
}
