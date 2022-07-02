package roh.draw.graphics;

public class Rectangle extends GraphicComponent {

    @Override
    public void initializeCoordinates(String[] commands) {

        int x1 = Integer.parseInt(commands[1]);
        int y1 = Integer.parseInt(commands[2]);
        int x2 = Integer.parseInt(commands[3]);
        int y2 = Integer.parseInt(commands[4]);
        System.out.println("x1, y1, x2, y2" + x1 + "," + y1 + "," +  x2 + "," + y2);
        draw(x1, y2, x2, y2, GraphicConstants.LINE_CHAR);
        draw(x1, y1, x2, y1, GraphicConstants.LINE_CHAR);
        draw(x2, y1, x2, y2, GraphicConstants.LINE_CHAR);
        draw(x1, y1, x1, y2, GraphicConstants.LINE_CHAR);




        printUsingCoordinates();


    }

}
