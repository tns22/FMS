import java.util.Random;
import java.util.Date;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    game();
  }

  public static Random rand = new Random();

  public static Scanner scnr = new Scanner(System.in);

  public static boolean isCorrectSequence(String[] userSequence, String[] sequence) {
    if (Arrays.equals(userSequence, sequence)) {
      return true;
    } else {
      return false;
    }
  }

  public static String random() {
    String[] colors = {
      "red",
      "green",
      "yellow",
      "blue"
    };

    int color;

    int range = colors.length;

    color = rand.nextInt(range);

    return colors[color];
  }

  public static String[] sequence(int millisecondsPassed) throws InterruptedException {
    String rand1 = random();
    String rand2 = random();
    String rand3 = random();
    String rand4 = random();
    String rand5 = random();

    String rectangleColor1 = rand1;
    String rectangleColor2 = rand2;
    String rectangleColor3 = rand3;
    String rectangleColor4 = rand4;
    String rectangleColor5 = rand5;
    String sequence[] = {
      rectangleColor1,
      rectangleColor2,
      rectangleColor3,
      rectangleColor4,
      rectangleColor5
    };

    for (int i = 0; i < sequence.length; i++) {
      Thread.sleep(millisecondsPassed);
      System.out.println(sequence[i]);
    }

    return sequence;
  }

  public static void incorrect() throws InterruptedException {
    int secondsPassed = 300;
    Thread.sleep(secondsPassed);
    System.out.println("Incorrect -1 life");
  }

  public static void correct() throws InterruptedException {
    int secondsPassed = 300;
    Thread.sleep(secondsPassed);
    System.out.println("Correct +5 points");
  }

  public static void game() throws InterruptedException {
    int lives = 5;
    int score = 0;
    int milliseconds = 2000;

    while (lives > 0) {
      String[] sequence = sequence(milliseconds);
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();

      System.out.println("1st Color? ");
      String in1 = scnr.next();
      System.out.println();
      System.out.println("2nd color? ");
      String in2 = scnr.next();
      System.out.println("3rd Color? ");
      String in3 = scnr.next();
      System.out.println();
      System.out.println("4th color? ");
      String in4 = scnr.next();
      System.out.println();
      System.out.println("5th color? ");
      String in5 = scnr.next();
      System.out.println();

      String[] userSequence = {
        in1,
        in2,
        in3,
        in4,
        in5
      };

      if (isCorrectSequence(userSequence, sequence)) {
        correct();
        score += 5;
        System.out.println("Lives: " + lives + "      Score: " + score);

      } else {
        incorrect();
        lives -= 1;
        System.out.println("Lives: " + lives + "      Score: " + score);
      }

      milliseconds -= 50;
    }

    System.out.println("Game Over! Final Score: " + score);
  }
}
