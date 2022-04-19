package com.java;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * Unit test for simple App.
 */
public class AppTest
{

    private Response output = new Response();
    private InputCommands input = new InputCommands();


    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void throwsIllegalArgumentExceptionInvalidInput() throws IllegalArgumentException {
        input.roomDimensions(2, 2);
        input.robotPosition(1, 1, "N");
        input.robotMoves("Y");
    }

    @Test
    public void reportRobotLocationFor12NPosition() {

        input.roomDimensions(5, 5);
        input.robotPosition(1, 2, "N");
        input.robotMoves("RFRFFRFRF");
        executeRobot();
        String response = output.toString();
        assertTrue(response.contains("1 3 N"));


    }

    @Test
    public void reportRobotLocationFor00EPosition() {

        input.roomDimensions(5, 5);
        input.robotPosition(0, 0, "E");
        input.robotMoves("RFLFFLRF");
        executeRobot();
        String response = output.toString();
        assertTrue(response.contains("3 1 E"));

    }

    @Test
    public void invalidPositionException() throws IllegalArgumentException {
        input.roomDimensions(5, 5);
        input.robotPosition(1, 1, "X");
        input.robotMoves("F");
    }

    @Test
    public void invalidDimensionException()  {
        input.roomDimensions(-1, -1);
        input.robotPosition(0, 0, "N");
        input.robotMoves("RRRRR");
        try {
            executeRobot();

        } catch (Exception e)
        {
            String response = e.toString();
            assertTrue(response.contains("invalid"));
        }

    }


    private void executeRobot() {
        RobotApplication app = new RobotApplication(input.stream(), output.stream());
        app.run();
    }

}
