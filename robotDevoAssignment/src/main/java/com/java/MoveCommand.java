package com.java;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

class MoveCommand {

  private final Scanner scanner;
  private final PrintStream printer;

  public MoveCommand(Scanner scanner, PrintStream printer) {
    this.scanner = scanner;
    this.printer = printer;
  }

  public List<Move> prompt() {
    printer.println("The\n" +
            "robot receives a number of navigation commands in the form of characters. The\n" +
            "following commands shall be implemented: \n"
            + "L Turn left\n"
            + "R Turn right\n"
            + "F Walk forward\n"
            + "Example:\n"
            + " LFFRFRFRFF\n"
    + "  Please enter:");

    String input = scanner.nextLine();

    Stream<String> moveCommands = Arrays.stream(input.split(""));
    return moveCommands
            .map(this::toMove)
            .collect(toList());
  }

  private Move toMove(String moveCommand) {
    switch (moveCommand) {
      case "F":
        return Move.FORWARD;
      case "L":
        return Move.LEFT;
      case "R":
        return Move.RIGHT;
    }
    throw new IllegalArgumentException(format("This direction not known to robot for move [%s]", moveCommand));
  }


}
