package roh.draw;

import roh.draw.exception.InvalidInputException;
import roh.draw.processor.GraphicProcessor;

import java.util.Scanner;

public class DrawingApplication {



    public static void main(String[] args) {

        GraphicProcessor graphicProcessor = new GraphicProcessor();
        displayUsage();
        try {
            while (true) {
                Scanner in = new Scanner(System.in);
                System.out.print("enter command: ");
                String inputStr = in.nextLine();
                String[] commands = inputStr.split(" ");
                graphicProcessor.process(commands);
            }

        } catch (InvalidInputException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
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

}
