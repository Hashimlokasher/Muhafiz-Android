package org.iilab.pb.calculator;

public interface Calculator {

    /**
     * Handles a button press and returns a string to be displayed.
     */
    String handleButtonPress(Button button);

    enum Button {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, ZERO,
        EQUALS, PLUS, MINUS, MULTIPLY, DIVIDE
    }
}
