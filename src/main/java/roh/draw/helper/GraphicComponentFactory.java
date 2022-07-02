package roh.draw.helper;

import roh.draw.exception.InvalidInputException;
import roh.draw.graphics.Canvas;
import roh.draw.graphics.GraphicComponent;
import roh.draw.graphics.Line;
import roh.draw.graphics.Rectangle;
import roh.draw.graphics.GraphicsEnums;


public class GraphicComponentFactory {

    public GraphicComponent getGraphicComponent(final String[] commands) throws InvalidInputException {

        int numberOfCoordinates = commands.length - 1;

        GraphicsEnums.InputCharacters inputCharacter = GraphicsEnums.InputCharacters.fromValue(commands[0].toUpperCase());
        GraphicComponent graphicComponent = null;

        if (numberOfCoordinates != inputCharacter.getNumOfCordinates()) {

            throw new InvalidInputException("Invalid number of input coordinates");
        }

        switch (inputCharacter) {
            case CANVAS:
                graphicComponent = new Canvas();
                break;
            case LINE:
                graphicComponent = new Line();
                break;
            case RECTANGLE:
                graphicComponent = new Rectangle();
                break;
            case QUIT:
                System.exit(0);

        }
        return graphicComponent;

    }
}
