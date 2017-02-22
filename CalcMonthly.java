import java.util.Scanner;

public class CalcMonthly {

  protected static float loan, apr, term, monthly;
  protected static Scanner scanner = new Scanner(System.in);

  protected static void setLoan(float l) {
    loan = l;
  }

  protected static float getLoan() {
    return loan;
  }

  protected static void setApr(float a) {
    apr = a;
  }

  protected static float getApr() {
    return apr;
  }

  protected static void setTerm(float t) {
    term = t;
  }

  protected static float getTerm() {
    return term;
  }

  protected static void setMonthly(float m) {
    monthly = m;
  }

  protected static float getMonthly() {
    return monthly;
  }

  public static void calcMonthly() {
    System.out.print("Enter loan amount: ");
    float i = -1;
    do {
      while (!scanner.hasNextFloat()) {
        System.out.println("Invalid loan input.");
        scanner.next();
      }
      i = scanner.nextFloat();
    } while (i < 0);
    setLoan(i);

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
    float monthly = getLoan() * (float)(j / (1 - Math.pow(1 + j, -term)));

    System.out.println(String.format("Monthly payment is: %.2f", monthly));
  }
}