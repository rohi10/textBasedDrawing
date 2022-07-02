package roh.draw.graphics;

public abstract class GraphicComponent {

    int width;
    int height;
char[][] graphic;

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
                //    System.out.print(elementNew[i][x1]);
                graphic[i][x1] = character;
            }
        } else if (y1 == y2) {
            for (int i = x1; i <=x2; i++) {
                //  System.out.print(elementNew[0][0]);

                graphic[y1][i] = character;
            }

        }
    }

    public void printUsingCoordinates() {


        for(int i = 0; i< graphic.length; ++i){
            for(int j = 0; j< graphic[i].length; j++) {
                if(graphic[i][j] == 0){
                    System.out.print(GraphicConstants.EMPTY_CHAR);
                } else {
                    System.out.print(graphic[i][j]);
                }
            }
            System.out.println();
        }
    }

    public abstract void initializeCoordinates(String[] commands);
}
