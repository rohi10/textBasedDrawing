package roh.draw.helper;

import org.junit.Test;
import roh.draw.exception.InvalidInputException;
import roh.draw.graphics.Canvas;
import roh.draw.graphics.GraphicComponent;
import roh.draw.graphics.Line;
import roh.draw.graphics.Rectangle;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GraphicComponentFactoryTest {

    public static final String INVALID_NUMBER_OF_INPUT_COORDINATES = "Invalid number of input coordinates";
    public static final String INVALID_INPUT = "Invalid input";
    private String[] invalidCommands = "D 50 4".split(" ");
    private String[] commandWithInvalidArgs = "C 50".split(" ");
    private String[] canvasCommand = "C 20 5".split(" ");
    private String[] rectangleCommand = "R 15 2 20 5".split(" ");
    private String[] lineCommand = "L 1 3 7 3".split(" ");


    @Test
    public void Should_Throw_InvalidInputException_When_InValidCommand() throws InvalidInputException {

        GraphicComponentFactory graphicComponentFactory = new GraphicComponentFactory();


        Exception exception = assertThrows(InvalidInputException.class, () -> {
            graphicComponentFactory.getGraphicComponent(invalidCommands);
        });

        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(INVALID_INPUT));
    }


    @Test
    public void Should_Throw_InvalidInputException_When_InvalidCmdArgs() throws InvalidInputException {

        GraphicComponentFactory graphicComponentFactory = new GraphicComponentFactory();


        Exception exception = assertThrows(InvalidInputException.class, () -> {
            graphicComponentFactory.getGraphicComponent(commandWithInvalidArgs);
        });

        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(INVALID_NUMBER_OF_INPUT_COORDINATES));
    }

    @Test
    public void Should_ReturnCanvas_When_InputIsCanvas() throws InvalidInputException {
        GraphicComponentFactory graphicComponentFactory = new GraphicComponentFactory();
        GraphicComponent graphicComponent = graphicComponentFactory.getGraphicComponent(canvasCommand);
        assertTrue(graphicComponent instanceof Canvas);
    }

    @Test
    public void Should_ReturnLine_When_InputIsLine() throws InvalidInputException {
        GraphicComponentFactory graphicComponentFactory = new GraphicComponentFactory();
        GraphicComponent graphicComponent = graphicComponentFactory.getGraphicComponent(lineCommand);
        assertTrue(graphicComponent instanceof Line);
    }

    @Test
    public void Should_ReturnRectangle_When_InputIsRectangle() throws InvalidInputException {
        GraphicComponentFactory graphicComponentFactory = new GraphicComponentFactory();
        GraphicComponent graphicComponent = graphicComponentFactory.getGraphicComponent(rectangleCommand);
        assertTrue(graphicComponent instanceof Rectangle);
    }


    }
