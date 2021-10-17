package hu.nye.progtech.torpedo.service.sea.reader.impl;

import hu.nye.progtech.torpedo.service.exception.SeaReadException;
import hu.nye.progtech.torpedo.service.sea.reader.impl.BufferedReaderSeaReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class BufferedReaderSeaReaderTest {

    private static final String LINE_1 = "line1";
    private static final String LINE_2 = "line2";

    @Mock
    private BufferedReader bufferedReader;

    private BufferedReaderSeaReader underTest;

    @BeforeEach
    public void setUp() {
        underTest = new BufferedReaderSeaReader(bufferedReader);
    }

    @Test
    public void testReadSeaShouldReturnRowsReadFromBufferedReader() throws SeaReadException, IOException{
        //given
        given(bufferedReader.readLine()).willReturn(LINE_1, LINE_2, null);

        //when
        List<String> result = underTest.readSea();

        //then
        assertEquals(List.of(LINE_1, LINE_2), result);

    }

    @Test
    public void testReadSeaShouldThrowSeaReadExceptionWhenBufferedReaderFailsToRead() throws IOException {
        //give
        doThrow(IOException.class).when(bufferedReader).readLine();

        //when - then
        assertThrows(SeaReadException.class, () -> {
            underTest.readSea();
        });

    }

}
