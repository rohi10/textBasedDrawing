package roh.draw.helper;

import roh.draw.graphics.Canvas;
import roh.draw.graphics.GraphicComponent;
import roh.draw.graphics.Line;
import roh.draw.graphics.Rectangle;

public class GraphicComponentFactory {

    public GraphicComponent getGraphicComponent(final String input) {

        GraphicComponent graphicComponent = null;
        switch (input) {
            case "C":
                graphicComponent = new Canvas();
                break;
            case "L":
                graphicComponent = new Line();
                break;
            case "R":
                graphicComponent = new Rectangle();
                break;
            case "Q":
                System.exit(0);


        }
        return graphicComponent;

    }
}
