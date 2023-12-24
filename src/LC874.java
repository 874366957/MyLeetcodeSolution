import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LC874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        List<int[]> list = new ArrayList<>(Arrays.asList(obstacles));
        Direction direction = new Direction(0);
        int x = 0;
        int y = 0;
        int res = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] < 0) {
                direction = direction.getDirection(commands[i]);
                continue;
            }
            final int xnow = x;
            final int ynow = y;
            if (direction.direct == 0) {
                final int ypre = y + commands[i];
                List<int[]> collect = list.stream().filter(dir -> dir[0] == xnow && dir[1] > ynow && dir[1] <= ypre).sorted(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1] - o2[1];
                    }
                }).collect(Collectors.toList());
                if (!collect.isEmpty()) {
                    y = collect.get(0)[1] - 1;
                } else {
                    y = ypre;
                }
            } else if (direction.direct == 1) {
                final int xpre = x + commands[i];
                List<int[]> collect = list.stream().filter(dir -> dir[1] == ynow && dir[0] > xnow && dir[0] <= xpre).sorted(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                }).collect(Collectors.toList());
                if (!collect.isEmpty()) {
                    x = collect.get(0)[0] - 1;
                } else {
                    x = xpre;
                }
            } else if (direction.direct == 2) {
                final int ypre = y - commands[i];
                List<int[]> collect = list.stream().filter(dir -> dir[0] == xnow && dir[1] < ynow && dir[1] >= ypre).sorted(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1] - o2[1];
                    }
                }).collect(Collectors.toList());
                if (!collect.isEmpty()) {
                    y = collect.get(0)[1] + 1;
                } else {
                    y = ypre;
                }
            } else {
                final int xpre = x - commands[i];
                List<int[]> collect = list.stream().filter(dir -> dir[1] == ynow && dir[0] < xnow && dir[0] >= xpre).sorted(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                }).collect(Collectors.toList());
                if (!collect.isEmpty()) {
                    x = collect.get(0)[0] + 1;
                } else {
                    x = xpre;
                }
            }
            res = Math.max(res, x * x + y * y);
        }
        return res;
    }

    class Direction {
        //0-N 1-E 2-S 3-W
        int direct;

        public Direction(int direct) {
            this.direct = direct;
        }

        public Direction getDirection(int i) {
            if (i == -1) {
                return this.direct == 3 ? new Direction(0) : new Direction(this.direct + 1);
            } else {
                return this.direct == 0 ? new Direction(3) : new Direction(this.direct - 1);
            }
        }
    }
}
