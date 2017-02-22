import java.util.Scanner;

public class CalcLoan {

  protected static float loan, apr, term, monthly;
  protected static Scanner scanner = new Scanner(System.in);

  protected static void setMonthly(float m) {
    monthly = m;
  }

  protected static float getMonthly() {
    return monthly;
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

  public static void calcLoan() {
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
    float loan = getMonthly() / (float)(j / (1 - Math.pow(1 + j, -term)));
    System.out.println(String.format("Loan is: %.2f", loan));
  }
}