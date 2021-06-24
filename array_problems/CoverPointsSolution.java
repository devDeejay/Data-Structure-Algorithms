package array_problems;

import java.util.ArrayList;

/**
 * You are in an infinite 2D grid where you can move in any of the 8 directions
 * (x,y) to
 * (x-1, y-1),
 * (x-1, y)  ,
 * (x-1, y+1),
 * (x  , y-1),
 * (x  , y+1),
 * (x+1, y-1),
 * (x+1, y)  ,
 * (x+1, y+1)
 * You are given a sequence of points and the order in which you need to cover the points..
 * Give the minimum number of steps in which you can achieve it. You start from the first point.
 */

class CoverPointsSolution {
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int numSteps = 0;
        for (int i = 1; i < X.size(); i++) {
            numSteps += Math.max(Math.abs(X.get(i) - X.get(i - 1)), Math.abs(Y.get(i) - Y.get(i - 1)));
        }
        return numSteps;
    }
}