package roh.draw.graphics;

public class Line extends GraphicComponent {

    @Override
    public void initializeCoordinates(String[] commands) {

        setWidth(this.getWidth());
        setHeight(this.getHeight());
        setGraphic(this.getGraphic());

        int x1 = Integer.parseInt(commands[1]);
        int y1 = Integer.parseInt(commands[2]);
        int x2 = Integer.parseInt(commands[3]);
        int y2 = Integer.parseInt(commands[4]);
        draw(x1, y1, x2, y2, GraphicConstants.LINE_CHAR);
        printUsingCoordinates();


    }

}
