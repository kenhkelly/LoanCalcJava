import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import static java.lang.System.*;

public class LoanCalcJava {
  private static String version = "v1.0";

  public static void main(String[] args) {
    out.println("LoanCalcJava! " + version + "\n");

    start();
  }

  private static void start() {
    if (console() != null) {
      runHeadless();
    } else {
      Gui.runGui(version);
    }
  }

  private static void runHeadless() {
    Scanner scanner = new Scanner(in);

    String question = "\nHow would you like to calculate?\n" +
                  "\n" +
                  "(1) Monthly payment\n" +
                  "(2) Loan amount from monthly payment";
    out.println(question);

    String i = scanner.next();

    switch (i) {
      case "1":
      case "month":
      case "m":
        out.println("\nCalc Month");
        CalcMonthly.calcMonthly();
        break;
      case "2":
      case "loan":
      case "l":
        out.println("\nCalc Loan");
        CalcLoan.calcLoan();
        break;
      default:
        out.println(i + " is not a valid selection.\n");
        start();
    }

    exit();

  }

  private static void exit() {
    Scanner scanner = new Scanner(in);
    out.print("\n\nPerform another? ");

    String i = scanner.next();
    if (i.equals("y") || i.equals("ye") || i.equals("yes")) {
      start();
    }
  }
}