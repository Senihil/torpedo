package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.model.SeaVO;
import hu.nye.progtech.torpedo.service.exception.SeaReadException;
import hu.nye.progtech.torpedo.service.sea.parser.SeaParser;
import hu.nye.progtech.torpedo.service.sea.reader.SeaReader;
import hu.nye.progtech.torpedo.service.sea.reader.impl.BufferedReaderSeaReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("sea/sea.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        SeaReader seaReader = new BufferedReaderSeaReader(bufferedReader);
        try {
            List<String> strings = seaReader.readSea();
            //System.out.println(strings);

            SeaParser seaParser = new SeaParser(10, 10);
            SeaVO seaVO1 = seaParser.parseSea(strings);
            SeaVO seaVO2 = seaParser.parseSea(strings);
            //System.out.println(seaVO1);
            //System.out.println(seaVO2);
        } catch (SeaReadException e) {
            e.printStackTrace();
        }

    }

}
