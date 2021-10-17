package hu.nye.progtech.torpedo.service.sea.reader;

import hu.nye.progtech.torpedo.service.exception.SeaReadException;

import java.util.List;

public interface SeaReader {

    List<String> readSea() throws SeaReadException;

}
