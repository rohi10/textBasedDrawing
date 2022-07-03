package roh.draw.graphics;

import org.junit.Test;
import roh.draw.exception.InvalidInputException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RectangleTest {

    private String[]  canvasCommand = "C 4 8".split(" ");

    private String[]  commands = "R 1 1 3 5".split(" ");

    private String[] commandWithInvalidCoords = "R -1 0 0 0".split(" ");

    public static final String INVALID_COORDINATE_VALUES = "Given coordinates are either invalid or not within the canvas";

    @Test
    public void Should_InitializeCoordinates_When_ValidRectangle( ) throws InvalidInputException {

        Canvas canvas = new Canvas();
        canvas.setWidth(8);
        canvas.setHeight(4);
        canvas.initializeCoordinates(canvasCommand);
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(canvas.height);
        rectangle.setWidth(canvas.width);
        rectangle.setGraphic(canvas.graphic);

        char[][] expectedGraphic = {{'-','-', '-', '-', '-', '-'}, {'|', 'X' ,'X'  ,'X'  ,0  , '|'}, {'|', 'X' ,0  ,'X'  , 0 , '|'}, {'|', 'X' , 0 ,'X'  ,0  , '|'}, {'|', 'X', 0, 'X', 0 , '|'}, {'|','X'  ,'X'  ,'X'  ,0  , '|'}, {'|',0  ,0  ,0  ,0  , '|'}, {'|',  0, 0 , 0 , 0 , '|'}, {'|',  0, 0 , 0 , 0 , '|'}, {'-','-', '-', '-', '-', '-'}};


        rectangle.initializeCoordinates(commands);
        System.out.println(rectangle.getHeight());
        System.out.println(rectangle.height);

        assertTrue(rectangle.getHeight() == 8);
        assertTrue(rectangle.getWidth() == 4);
        assertEquals(Arrays.deepToString(rectangle.getGraphic()), Arrays.deepToString(expectedGraphic));


    }

    @Test
    public void Should_Throw_InvalidInputException_When_CoordsExceedCanvas() throws InvalidInputException {
        Rectangle rectangle = new Rectangle();

        Exception exception = assertThrows(InvalidInputException.class, () -> {
            rectangle.initializeCoordinates(commandWithInvalidCoords);
        });

        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(INVALID_COORDINATE_VALUES));
    }

}