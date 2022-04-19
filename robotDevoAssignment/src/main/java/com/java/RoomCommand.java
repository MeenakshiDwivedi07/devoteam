package com.java;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;

class RoomCommand {

  private final Pattern pattern = Pattern.compile("[0-9]* [0-9]*");
  private final Scanner scanner;
  private final PrintStream out;

  public RoomCommand(Scanner scanner, PrintStream out) {
    this.scanner = scanner;
    this.out = out;
  }

  public Room prompt() {
    out.println("Please enter how big the room is? For example,5 7 as Input means that the room is 5 fields wide and is 7 fields deep.");

    String input = scanner.nextLine();
    Matcher inputMatcher = pattern.matcher(input);
    if (!inputMatcher.matches()) {
      throw new IllegalArgumentException(format("Room dimensions [%s] is invalid.", input));
    }

    String[] widthAndHeight = input.split(" ");

    return new Room(
            parseInt(widthAndHeight[0]),
            parseInt(widthAndHeight[1])
    );

  }


}
