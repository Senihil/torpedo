package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.model.SeaVO;
import hu.nye.progtech.torpedo.service.exception.SeaReadException;
import hu.nye.progtech.torpedo.service.sea.reader.SeaReader;
import hu.nye.progtech.torpedo.service.sea.reader.impl.BufferedReaderSeaReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[][] sea = {
                {0, 0},
                {0, 1}
        };
        boolean[][] fixed = {
                {false, false},
                {false, true}
        };
        SeaVO seaVO = new SeaVO(2,2, sea, fixed);

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("sea/sea.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        SeaReader seaReader = new BufferedReaderSeaReader(bufferedReader);
        try {
            List<String> strings = seaReader.readSea();
            System.out.println(strings);
        } catch (SeaReadException e) {
            e.printStackTrace();
        }

    }

}
