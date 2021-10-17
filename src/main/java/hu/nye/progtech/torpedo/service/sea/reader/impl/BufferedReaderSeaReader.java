package hu.nye.progtech.torpedo.service.sea.reader.impl;

import hu.nye.progtech.torpedo.service.exception.SeaReadException;
import hu.nye.progtech.torpedo.service.sea.reader.SeaReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedReaderSeaReader implements SeaReader {

    private BufferedReader bufferedReader;

    public BufferedReaderSeaReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public List<String> readSea() throws SeaReadException {

        String line;
        List<String> result = new ArrayList<>();

        try {
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            throw new SeaReadException("Failed to read sea");
        }

        return result;
    }
}
