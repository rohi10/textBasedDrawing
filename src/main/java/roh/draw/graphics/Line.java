package roh.draw.graphics;

import roh.draw.exception.InvalidInputException;

public class Line extends GraphicComponent {

    @Override
    public void initializeCoordinates(String[] commands) throws InvalidInputException {

//        setWidth(this.getWidth());
//        setHeight(this.getHeight());
//        setGraphic(this.getGraphic());

        int x1 = Integer.parseInt(commands[1]);
        int y1 = Integer.parseInt(commands[2]);
        int x2 = Integer.parseInt(commands[3]);
        int y2 = Integer.parseInt(commands[4]);

        checkIfCoordsAreWithinCanvas(x1, y1, x2, y2);
        draw(x1, y1, x2, y2, GraphicConstants.LINE_CHAR);
        printUsingCoordinates();


    }

}
