package com.java;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class RobotApplication {

  private final Scanner scanner;
  private final PrintStream printer;

  private final RoomCommand roomCommand;
  private final PositionCommand positionCommand;
  private final MoveCommand moveCommand;

  public RobotApplication(InputStream in, OutputStream out) {
    this.scanner = new Scanner(in);
    this.printer = new PrintStream(out);
    this.roomCommand = new RoomCommand(scanner, printer);
    this.positionCommand = new PositionCommand(scanner, printer);
    this.moveCommand = new MoveCommand(scanner, printer);
  }

  public static void main(String[] args) {
    RobotApplication app = new RobotApplication(System.in, System.out);
    app.run();
  }

  public void run() {
    Room room = roomCommand.prompt();
    Position position = positionCommand.prompt(room);
    List<Move> moves = moveCommand.prompt();

    Robot robot = new Robot(position);
    robot.perform(moves);
    robot.reportPositionUsing(printer);
  }

}
