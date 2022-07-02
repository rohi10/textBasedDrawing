package roh.draw.graphics;

import org.junit.Test;
import roh.draw.exception.InvalidInputException;
import roh.draw.helper.GraphicComponentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineTest {

    private String[]  canvasCommand = "C 4 8".split(" ");

    private String[]  commands = "L 1 4 3 4".split(" ");

    private String[] commandWithInvalidCoords = "L 150 100 200 70".split(" ");

    public static final String INVALID_COORDINATE_VALUES = "Given coordinates are either invalid or not within the canvas";

    @Test
    public void Should_InitializeCoordinates_When_ValidLine( ) throws InvalidInputException {

        Canvas canvas = new Canvas();
        canvas.setWidth(8);
        canvas.setHeight(4);
        canvas.initializeCoordinates(canvasCommand);
        Line line = new Line();


        char[][] expectedGraphic = {{'-','-', '-', '-', '-', '-'}, {'|', 0 ,0  ,0  ,0  , '|'}, {'|', 0 ,0  ,0  , 0 , '|'}, {'|', 0 , 0 ,0  ,0  , '|'}, {'|', 'X', 'X', 'X', 0 , '|'}, {'|',0  ,0  ,0  ,0  , '|'}, {'|',0  ,0  ,0  ,0  , '|'}, {'|',  0, 0 , 0 , 0 , '|'}, {'|',  0, 0 , 0 , 0 , '|'}, {'-','-', '-', '-', '-', '-'}};
        line.initializeCoordinates(commands);

        assertTrue(line.getHeight() == 4);
        assertTrue(line.getWidth() == 8);
        assertEquals(Arrays.deepToString(line.getGraphic()), Arrays.deepToString(expectedGraphic));


    }
    @Test
    public void Should_Throw_InvalidInputException_When_CoordsExceedCanvas() throws InvalidInputException {

        Line line = new Line();


        Exception exception = assertThrows(InvalidInputException.class, () -> {
            line.initializeCoordinates(commandWithInvalidCoords);
        });

        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(INVALID_COORDINATE_VALUES));
    }



}
