package roh.draw.graphics;

import roh.draw.exception.InvalidInputException;

public class Canvas extends GraphicComponent {

    @Override
    public void initializeCoordinates(String[] commands) throws InvalidInputException {

        int width = Integer.parseInt(commands[1]);
        int height = Integer.parseInt(commands[2]);
        graphic = new char[height + 2][width + 2];

        setWidth(width);
        setHeight(height);

        draw(0, 0, width + 1, 0, GraphicConstants.CANVAS_HORIZONTAL_CHAR);
        draw(0, 1, 0, height + 1, GraphicConstants.CANVAS_VERTICAL_CHAR);
        draw(0, height + 1, width + 1, height + 1, GraphicConstants.CANVAS_HORIZONTAL_CHAR);
        draw(width + 1, 1, width + 1, height, GraphicConstants.CANVAS_VERTICAL_CHAR);
        printUsingCoordinates();
    }


}
