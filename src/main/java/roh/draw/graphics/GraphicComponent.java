package roh.draw.graphics;

import roh.draw.exception.InvalidInputException;

public abstract class GraphicComponent {

    protected int width;
    protected int height;
    protected char[][] graphic;

    public char[][] getGraphic() {
        return graphic;
    }

    public void setGraphic(char[][] graphic) {
        this.graphic = graphic;
    }


    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void draw(int x1, int y1, int x2, int y2, char character) {

        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                graphic[i][x1] = character;
            }
        } else if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                graphic[y1][i] = character;
            }

        }
    }

    public void checkIfCoordsAreWithinCanvas(int x1, int y1, int x2, int y2)
            throws InvalidInputException {
        if (!(x1 < width && y1 < height && x2 < width && y2 < height && x1 >= 1 && y1 >= 1 && x2 >= 1 && y2 >= 1 && x1 <= x2 && y1 <= y2)) {
            throw new InvalidInputException(
                    "Given coordinates are either invalid or not within the canvas");

        }
        }

    public void printUsingCoordinates() {


        for (int i = 0; i < graphic.length; ++i) {
            for (int j = 0; j < graphic[i].length; j++) {
                if (graphic[i][j] == 0) {
                    System.out.print(GraphicConstants.EMPTY_CHAR);
                } else {
                    System.out.print(graphic[i][j]);
                }
            }
            System.out.println();
        }
    }

    public abstract void initializeCoordinates(String[] commands) throws InvalidInputException;
}
