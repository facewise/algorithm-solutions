package solution.level2;

import java.util.ArrayList;
import java.util.List;

public class Sol81302 {
    List<Point> people = new ArrayList<>();
    int[][] table = new int[5][5];
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                char[] arr = places[i][j].toCharArray();
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k] == 'P') {
                        people.add(new Point(j, k));
                    } else if (arr[k] == 'O') {
                        table[j][k] = 1;
                    }
                }
            }
            answer[i] = check() ? 1 : 0;
            people.clear();
            table = new int[5][5];
        }
        return answer;
    }
    boolean check() {
        for (int a = 0; a < people.size() - 1; a++) {
            Point p1 = people.get(a);
            for (int b = a + 1; b < people.size(); b++) {
                Point p2 = people.get(b);
                int d = p1.getDistance(p2);
                if (d == 1) {
                    return false;
                } else if (d == 2) {
                    if (p1.x == p2.x) {
                        if (table[p1.x][(p1.y + p2.y) / 2] == 1)
                            return false;
                    } else if (p1.y == p2.y) {
                        if (table[(p1.x + p2.x) / 2][p1.y] == 1)
                            return false;
                    } else {
                        if (table[p1.x][p2.y] == 1 || table[p2.x][p1.y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getDistance(Point p) {
            return Math.abs(x - p.x) + Math.abs(y - p.y);
        }
    }
}
