package roh.draw.graphics;

import org.junit.Test;
import roh.draw.exception.InvalidInputException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanvasTest {

    private String[] commands = "C 20 5".split(" ");

    @Test
    public void Should_InitializeCoordinates_When_ValidCanvas() throws InvalidInputException {

        Canvas canvas = new Canvas();
        char[][] expectedGraphic = {{'-', '-','-','-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, {'|', 0 ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  , '|'}, {'|', 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,0  ,0  , 0 ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  , '|'}, {'|', 0 ,0  ,0  ,0  ,0  ,0  ,0  ,0  , 0 , 0 , 0 ,0  ,0  ,0  , 0 ,0  ,0  ,0  ,0  , 0 ,'|'}, {'|', 0 ,0  , 0 ,0  ,0  ,0  ,0  ,0  , 0 ,0  ,0  , 0 ,0  ,0  ,0  ,0  ,0  , 0 , 0 , 0 , '|'}, {'|',0  ,0  ,0  ,0  ,0  ,0  , 0 ,0  ,0  ,0  , 0 , 0 , 0 ,0  ,0  ,0  , 0 , 0 , 0 , 0 , '|'}, {'-','-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
        canvas.initializeCoordinates(commands);

        assertTrue(canvas.getHeight() == 5);
        assertTrue(canvas.getWidth() == 20);
        assertEquals(Arrays.deepToString(canvas.getGraphic()), Arrays.deepToString(expectedGraphic));
    }
}



