import java.util.Scanner;

public class LoanCalcJava {
  
  public static String version = "v0.1";

  public static void main(String[] args) {
    System.out.println("AutoCalcGo! " + version + "\n");

    start();
  }

  protected static void start() {
    Scanner scanner = new Scanner(System.in);

    String question = "\nHow would you like to calculate?\n" +
                  "\n" +
                  "(1) Monthly payment\n" +
                  "(2) Loan amount from monthly payment\n";
    System.out.println(question);

    String i = scanner.next();

    switch (i) {
      case "1":
      case "month":
      case "m":
        System.out.println("Month");
        CalcMonthly.calcMonthly();
        break;
      case "2":
      case "loan":
      case "l":
        System.out.println("Loan");
        CalcLoan.calcLoan();
        break;
      default:
        System.out.println(i + " is not a valid selection.\n");
        start();
    }

    exit();
  }

  protected static void exit() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("\n\nPerform another? ");

    String i = scanner.next();
    if (i.equals("y") || i.equals("ye") || i.equals("yes")) {
      start();
    }
  }
}