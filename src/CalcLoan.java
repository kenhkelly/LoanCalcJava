import java.util.Scanner;

class CalcLoan {

  private static float apr, term, monthly;
  private static Scanner scanner = new Scanner(System.in);

  private static void setMonthly(float m) {
    monthly = m;
  }

  private static float getMonthly() {
    return monthly;
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

  static void calcLoan() {
    //noinspection UnusedAssignment
    float i = -1;

    System.out.print("Enter monthly amount: ");
    do {
      while (!scanner.hasNextFloat()) {
        System.out.println("Invalid monthly input.");
        scanner.next();
      }
      i = scanner.nextFloat();
    } while (i < 0);
    setMonthly(i);

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

    float j = (getApr() / 100 / 12);
    float term = getTerm() * 12;
    float loan = getMonthly() / (float)(j / (1 - Math.pow(1 + j, -term)));
    System.out.println(String.format("Loan is: %.2f", loan));
  }
}