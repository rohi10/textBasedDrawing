package roh.draw.processor;

import roh.draw.exception.InvalidInputException;
import roh.draw.graphics.Canvas;
import roh.draw.graphics.GraphicComponent;
import roh.draw.helper.GraphicComponentFactory;

public class GraphicProcessor {

    private GraphicComponent baseGraphicComponent;

    public void process(String[] commands) throws InvalidInputException {

        if (baseGraphicComponent == null) {
            baseGraphicComponent = new Canvas();
        }

        GraphicComponentFactory graphicComponentFactory = new GraphicComponentFactory();
        GraphicComponent graphicComponent = graphicComponentFactory.getGraphicComponent(commands);

        //Setting properties when canvas is already created and other commands are invoked.
        if (this.baseGraphicComponent != null) {
            graphicComponent.setHeight(this.baseGraphicComponent.getHeight());
            graphicComponent.setWidth(this.baseGraphicComponent.getWidth());
            graphicComponent.setGraphic(this.baseGraphicComponent.getGraphic());
        }
        graphicComponent.initializeCoordinates(commands);

        baseGraphicComponent.setGraphic(graphicComponent.getGraphic());
        baseGraphicComponent.setWidth(graphicComponent.getWidth());
        baseGraphicComponent.setHeight(graphicComponent.getHeight());

    }

    public GraphicComponent getBaseGraphicComponent() {
        return baseGraphicComponent;
    }
}
