package roh.draw.processor;

import roh.draw.graphics.GraphicComponent;
import roh.draw.helper.GraphicComponentFactory;

public class DrawingProcessor {

    private GraphicComponent baseGraphicComponent;


    public void process(String[] commands){
        GraphicComponentFactory graphicComponentFactory = new GraphicComponentFactory();
        GraphicComponent graphicComponent = graphicComponentFactory.getGraphicComponent(commands[0]);

        if(this.baseGraphicComponent != null) {
            graphicComponent.setHeight(this.baseGraphicComponent.getHeight());
            graphicComponent.setWidth(this.baseGraphicComponent.getWidth());
            graphicComponent.setGraphic(this.baseGraphicComponent.getGraphic());
        }
        graphicComponent.initializeCoordinates(commands);

    }
}
