package hard;

public class Solution335 {
    public boolean isSelfCrossing(int[] distance) {
        int startX = 0;
        int startY = 0;
        Line[] lines = new Line[distance.length];
        for (int i = 0; i < distance.length; i++) {
            Line t = new Line(startX, startY, i % 4, distance[i]);
            startX = t.endX;
            startY = t.endY;

            for (int j = i - 3; j >= 0 && j >= i - 5; j--) {
                if (t.intersecting(lines[j])) {
                    return true;
                }
            }
            lines[i] = t;
        }
        return false;
    }

    private static class Line {
        private final int startX;
        private final int startY;
        private final int endX;
        private final int endY;

        private Line(int startX, int startY, int direction, int length) {
            this.startX = startX;
            this.startY = startY;
            if (direction == 0) {
                this.endY = startY + length;
                this.endX = startX;
            } else if (direction == 1) {
                this.endY = startY;
                this.endX = startX - length;
            } else if (direction == 2) {
                this.endY = startY - length;
                this.endX = startX;
            } else {
                this.endY = startY;
                this.endX = startX + length;
            }
        }

        private boolean intersecting(Line b) {
            //this是竖线
            if (startX == endX) {
                //b是竖线
                if (b.startX == b.endX) {
                    //this 和 b 在同一条竖线上,且有重合
                    return (startX == b.startX) && (contains(startY, endY, b.startY) || contains(startY, endY, b.endY));
                }
                //b是横线
                else {
                    return contains(startY, endY, b.startY) && contains(b.startX, b.endX, startX);
                }
            }
            //this是横线
            else {
                //b是横线
                if (b.startY == b.endY) {
                    return (startY == b.startY) && (contains(startX, endX, b.startX) || contains(startX, endX, b.endX));
                }
                //b是竖线
                else {
                    return contains(startX, endX, b.startX) && contains(b.startY, b.endY, startY);
                }
            }
        }


        private boolean contains(int start, int end, int target) {
            return (target >= start && target <= end) || (target >= end && target <= start);
        }
    }
}
