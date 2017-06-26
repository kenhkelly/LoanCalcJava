import java.util.Scanner;

public class LoanCalcJava {

  public static void main(String[] args) {
    String version = "v0.1";
    System.out.println("LoanCalcJava! " + version + "\n");

    start();
  }

  private static void start() {
    Scanner scanner = new Scanner(System.in);

    String question = "\nHow would you like to calculate?\n" +
                  "\n" +
                  "(1) Monthly payment\n" +
                  "(2) Loan amount from monthly payment";
    System.out.println(question);

    String i = scanner.next();

    switch (i) {
      case "1":
      case "month":
      case "m":
        System.out.println("\nCalc Month");
        CalcMonthly.calcMonthly();
        break;
      case "2":
      case "loan":
      case "l":
        System.out.println("\nCalc Loan");
        CalcLoan.calcLoan();
        break;
      default:
        System.out.println(i + " is not a valid selection.\n");
        start();
    }

    exit();
  }

  private static void exit() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("\n\nPerform another? ");

    String i = scanner.next();
    if (i.equals("y") || i.equals("ye") || i.equals("yes")) {
      start();
    }
  }
}