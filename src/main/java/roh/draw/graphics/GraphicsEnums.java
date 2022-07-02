package roh.draw.graphics;

import roh.draw.exception.InvalidInputException;

import java.util.HashMap;
import java.util.Map;

public class GraphicsEnums {

    public enum InputCharacters {

        CANVAS("C", 2),
        LINE("L", 4),
        RECTANGLE("R", 4),
        QUIT("Q", 0);

        private final String inputChar;

        private final int numOfCordinates;

        private static final Map<String, InputCharacters> INPUT_CONSTANTS = new HashMap<String, InputCharacters>();

        static {
            for (InputCharacters inputCharacters : values()) {
                INPUT_CONSTANTS.put(inputCharacters.inputChar, inputCharacters);
            }
        }

        private InputCharacters(String inputChar, int numOfCordinates) {
            this.inputChar = inputChar;
            this.numOfCordinates = numOfCordinates;
        }

        public String getInputChar() {
            return inputChar;
        }

        public int getNumOfCordinates() {
            return numOfCordinates;
        }

        public static InputCharacters fromValue(final String value) throws InvalidInputException {
            final InputCharacters constant = INPUT_CONSTANTS.get(value);
            if (constant == null) {
                throw new InvalidInputException("Invalid input " + value);
            } else {
                return constant;
            }
        }

        @Override
        public String toString() {
            return inputChar;
        }
    }





}
