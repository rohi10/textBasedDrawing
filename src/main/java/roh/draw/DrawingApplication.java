package roh.draw;

import roh.draw.exception.InvalidInputException;
import roh.draw.graphics.Canvas;
import roh.draw.graphics.GraphicComponent;
import roh.draw.helper.GraphicComponentFactory;
import roh.draw.helper.InputValidator;
import roh.draw.processor.DrawingProcessor;

import java.util.Scanner;

public class DrawingApplication {

    private DrawingProcessor drawingProcessor;
    private GraphicComponent baseGraphicComponent;


    public static void main(String[] args) {

        DrawingApplication drawingApplication = new DrawingApplication();
        displayUsage();
        try {
            while (true) {
                Scanner in = new Scanner(System.in);
                System.out.print("enter command: ");
                String inputStr = in.nextLine();
                String[] commands = inputStr.split(" ");
                if (InputValidator.validateInput(commands)) {
                    drawingApplication.process(commands);

                } else {
                    throw new InvalidInputException("Not a valid input");
                }


//            String command = commands[0];
//            Canvas canvas = null;
//            if (command.equals("C")) {
//                canvas = new Canvas();
//                canvas.setWidth(Integer.parseInt(commands[1]));
//                canvas.setHeight(Integer.parseInt(commands[2]));
//                canvas.getCanvas();
//                System.out.println();
//                System.out.println("LENGTH" + canvas.getGraphic().length);
//
//
//            }
//            System.out.println("LENGTH again" + canvas.getGraphic().length);
//            if (command.equals("L")) {
//                Line line = new Line();
//                System.out.println("canvas" + canvas);
//                System.out.println("LENGTH.." + canvas.getGraphic().length);
//                line.setGraphic(canvas.getGraphic());
//               line.getLine();
//               // String inputStr1 = "C 20 3";
//                //String[] commands1 = inputStr1.split(" ");
//                //drawCanvas(commands1);
//                //drawLine(commands);
//                //System.out.println();
//
//            }
//            if (command.equals("Q")) {
//                System.exit(0);
//            }
            }

        } catch (InvalidInputException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void process(String[] commands) {

        if (baseGraphicComponent == null) {
            baseGraphicComponent = new Canvas();
        }

        GraphicComponentFactory graphicComponentFactory = new GraphicComponentFactory();
        GraphicComponent graphicComponent = graphicComponentFactory.getGraphicComponent(commands[0]);

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


    private static void displayUsage() {
        String usage = "Usage: \n"
                + "-------\n"
                + "Example          Description\n"
                + "C w h            Create a new canvas of width w and height h\n"
                + "L x1 y1 x2 y2    Draw a new line from coordinates (x1, y1) to (x2, y2) horizontally or vertically. Lines are made up of the x character\n"
                + "R x1 y1 x2 y2    Draw a rectangle whose upper left corner is (x1,y1) and\n"
                + "                 lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n"
                + "                 using the 'x' character.\n"
                + "Q                Quit the program";


        System.out.println(usage);

    }

    private static void drawLine(String[] commandStr) {
        int x1 = Integer.parseInt(commandStr[1]);
        int y1 = Integer.parseInt(commandStr[2]);
        int x2 = Integer.parseInt(commandStr[3]);
        int y2 = Integer.parseInt(commandStr[4]);

        for (int i = 0; i < x1; i++) {
            System.out.println(' ');

        }

        for (int i = 0; i < y2; i++) {
            System.out.print("*");
        }


    }

    private static void drawCanvas(String[] commandStr) {

        int width = Integer.parseInt(commandStr[1]);
        int height = Integer.parseInt(commandStr[2]);
        int totalCanvasWidth = width + 2;


        for (int i = 0; i < totalCanvasWidth; i++) {
            System.out.print("-");

        }
        for (int j = 0; j < height; j++) {
            System.out.println();
            System.out.print("|");

            for (int i = 1; i < width + 1; i++) {
                System.out.print(" ");
            }
            System.out.println("|");


        }
        for (int i = 0; i < totalCanvasWidth; i++) {
            System.out.print("-");
        }
    }

}
