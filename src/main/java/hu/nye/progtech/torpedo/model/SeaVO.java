package hu.nye.progtech.torpedo.model;

import java.util.Arrays;
import java.util.Objects;

public final class SeaVO {

    private final int numberOfRows;
    private final int numberOfColumns;
    private final int[][] sea;
    private final boolean[][] fixed;

    public SeaVO(int numberOfRows, int numberOfColumns, int[][] sea, boolean[][] fixed) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.sea = deepCopy(sea);
        this.fixed = deepCopy(fixed);
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int[][] getMap() {
        return deepCopy(this.sea);
    }

    public boolean[][] getFixed() {
        return deepCopy(this.fixed);
    }

    private int[][] deepCopy(int[][] sea) {
        int[][] result = new int[sea.length][];

        for(int i = 0; i < sea.length; i++) {
            result[i] = new int[sea[i].length];
            for(int j = 0; j < sea[i].length; j++) {
                result[i][j] = sea[i][j];
            }
        }
        return result;
    }

    private boolean[][] deepCopy(boolean[][] sea) {
        boolean[][] result = new boolean[sea.length][];

        for(int i = 0; i < sea.length; i++) {
            result[i] = new boolean[sea[i].length];
            for(int j = 0; j < sea[i].length; j++) {
                result[i][j] = sea[i][j];
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeaVO seaVO = (SeaVO) o;
        return numberOfRows == seaVO.numberOfRows && numberOfColumns == seaVO.numberOfColumns && Arrays.deepEquals(sea, seaVO.sea) && Arrays.deepEquals(fixed, seaVO.fixed);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfRows, numberOfColumns);
        result = 31 * result + Arrays.deepHashCode(sea);
        result = 31 * result + Arrays.deepHashCode(fixed);
        return result;
    }

    @Override
    public String toString() {
        return "MapVO{" +
                "numberOfRows=" + numberOfRows +
                ", numberOfColumns=" + numberOfColumns +
                ", map=" + Arrays.deepToString(sea) +
                ", fixed=" + Arrays.deepToString(fixed) +
                '}';
    }

}
