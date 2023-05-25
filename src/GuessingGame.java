import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    private int number;
    private int attempts;
    private String result;
    private Scanner input;
    private boolean isEnd;

    public GuessingGame() {
        this.input = new Scanner(System.in);
        System.out.println("Bem-vindo ao jogo de adivinhação!");
        generateRandomNum();
        this.attempts = 10;
        System.out.println("");
        System.out.println("Tente adivinhar um número entre 1 e 100");
        System.out.println("Você tem 10 tentativas.");
    }

    private void generateRandomNum() {
        Random random = new Random();
        int numero = (random.nextInt(99) + 1);
        this.number = numero;
    }

    private void checkResult(int number) {
        if (number < this.number) {
            this.result = String.format("O número é maior do que %d", number);
        } else if (number > this.number) {
            this.result = String.format("O número é menor do que %d", number);
        } else {
            this.isEnd = true;
            this.result = String.format("Parabéns! Você acertou o número em %d tentativas.", (10 - this.attempts));
        }
    }

    private void checkAttempts() {
        if (this.attempts == 0) {
            this.result = "O número de tentativas acabaram";
            this.isEnd = true;
        } else {
            this.attempts = this.attempts - 1;
        }
    }

    public void getResult() {
        try {
            System.out.println("Digite seu palpite:");
            int number = this.input.nextInt();
            checkResult(number);
            checkAttempts();
            System.out.println(this.result);
            if (!isEnd) {
                getResult();
            } else {
                this.input.close();
            }
        } catch (Exception e) {
            System.out.println("Digite um número");
        }
    }
}
