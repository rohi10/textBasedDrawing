package roh.draw.processor;

import org.junit.Test;
import roh.draw.exception.InvalidInputException;
import roh.draw.graphics.Canvas;
import roh.draw.graphics.GraphicComponent;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphicProcessorTest {

    private GraphicComponent baseGraphicComponent;

    private String[] canvasCommand = "C 20 5".split(" ");

    private String[] lineCommand = "L 7 1 7 3".split(" ");


    @Test
    public void Should_Process_When_InputIsCanvas() throws InvalidInputException {
        GraphicProcessor graphicProcessor = new GraphicProcessor();
        graphicProcessor.process(canvasCommand);
        assertNotEquals(graphicProcessor.getBaseGraphicComponent().getGraphic().length, 0);
        assertTrue(graphicProcessor.getBaseGraphicComponent() instanceof Canvas);

    }
}
