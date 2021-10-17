package hu.nye.progtech.torpedo.service.sea.parser;

import hu.nye.progtech.torpedo.model.SeaVO;

import java.util.Arrays;
import java.util.List;

public class SeaParser {

    private int numberOfRows;
    private int numberOfColumns;

    public SeaParser(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public SeaVO parseSea(List<String> rawSea) {
        int[][] sea = getSea(rawSea);
        boolean[][] fixed = getFixed(sea);

        System.out.println(Arrays.deepToString(sea));

        return new SeaVO(numberOfRows, numberOfColumns, sea, fixed);
    }

    private int[][] getSea(List<String> rawSea) {
        int[][] result = new int[numberOfRows][];
        for(int i = 0; i < numberOfRows; i++) {
            result[i] = new int[numberOfColumns];

            String line = rawSea.get(i);                    //Get values of the row
            String[] parts = line.split("");          //Break apart each value

            for(int j = 0; j < numberOfColumns; j++) {
                result[i][j] = Integer.parseInt(parts[j]);
            }
        }
        return result;
    }

    private boolean[][] getFixed(int[][] sea) {
        boolean[][] result = new boolean[numberOfRows][];

        for(int i = 0; i < numberOfRows; i++) {
            result[i] = new boolean[numberOfColumns];

            for(int j = 0; j < numberOfColumns; j++) {
                result[i][j] = sea[i][j] == 0;
            }
        }

        return result;
    }

}
