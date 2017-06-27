import java.util.Scanner;

class CalcMonthly {

  private static float loan, apr, term;
  private static Scanner scanner = new Scanner(System.in);

  private static void setLoan(float l) {
    loan = l;
  }

  private static float getLoan() {
    return loan;
  }

  private static void setApr(float a) {
    apr = a;
  }

  private static float getApr() {
    return apr;
  }

  private static void setTerm(float t) {
    term = t;
  }

  private static float getTerm() {
    return term;
  }

  static void calcMonthly() {
    System.out.print("Enter loan amount: ");
    //noinspection UnusedAssignment
    float i = -1;
    do {
      while (!scanner.hasNextFloat()) {
        System.out.println("Invalid loan input.");
        scanner.next();
      }
      i = scanner.nextFloat();
    } while (i < 0);
    setLoan(i);

    //noinspection UnusedAssignment
    i = -1;
    System.out.print("Enter annual interest rate (APR): ");
    do {
      while (!scanner.hasNextFloat()) {
        System.out.println("Invalid apr input.");
        scanner.next();
      }
      i = scanner.nextFloat();
    } while (i < 0);
    setApr(i);

    //noinspection UnusedAssignment
    i = -1;
    System.out.print("Enter loan term in years: ");
    do {
      while (!scanner.hasNextFloat()) {
        System.out.println("Invalid term input.");
        scanner.next();
      }
      i = scanner.nextFloat();
    } while (i < 0);
    setTerm(i);

    float monthly = calculate(getLoan(), getApr(), getTerm());
    System.out.println(String.format("Monthly payment is: %.2f", monthly));
  }

  public static float calculate(float loanAmount, float aprAmount, float termAmount) {
    float j = (aprAmount / 100 / 12);
    float term = termAmount * 12;
    return loanAmount * (float)(j / (1 - Math.pow(1 + j, -term)));
  }
}