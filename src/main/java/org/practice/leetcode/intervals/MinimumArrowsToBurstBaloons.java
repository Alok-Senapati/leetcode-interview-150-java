package org.practice.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumArrowsToBurstBaloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int intervalEnd = points[0][1];
        int noOfArrows = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > intervalEnd) {
                noOfArrows++;
                intervalEnd = points[i][1];
            }
        }
        return noOfArrows;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        System.out.println(new MinimumArrowsToBurstBaloons().findMinArrowShots(points));
    }
}
