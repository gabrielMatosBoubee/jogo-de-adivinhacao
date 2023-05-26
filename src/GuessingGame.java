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
        System.out.println("Bem-vindo ao jogo de adivinhação! \n");
        generateRandomNum();
        this.attempts = 10;
        System.out.println("Tente adivinhar um número entre 1 e 100");
        choiceDifficulty();
    }

    /**
     * This function define by input the level of diffyculty.
     * 1 = easy, 2 = medium and for number value is hard
     */
    private void choiceDifficulty() {
        try {

            System.out.println("Escolha sua dificuldade.");
            System.out.println("Caso deseje um desafio mais tranquilo, digite 1.");
            System.out.println("Caso deseje um desafio moderado, digite 2.");
            System.out.println("Caso deseje um desafio desafior, digite 3. \n");

            System.out.print("Escolha sua dificuldade:");
            int number = this.input.nextInt();

            switch (number) {
                case 1:
                    this.attempts = 15;
                    break;
                case 2:
                    this.attempts = 10;
                    break;
                default:
                    this.attempts = 5;
                    break;
            }

            System.out.println(String.format("Você tem %d tentativas. \n", this.attempts));
        } catch (Exception e) {
            System.out.println("Digite um número!");
        }
    }

    private void generateRandomNum() {
        Random random = new Random();
        int numero = (random.nextInt(99) + 1);
        this.number = numero;
    }

    private void checkResult(int number) {
        if (number < this.number) {
            this.result = String.format("O número é maior do que %d \n", number);
        } else if (number > this.number) {
            this.result = String.format("O número é menor do que %d \n", number);
        } else {
            this.isEnd = true;
            this.result = String.format("Parabéns! Você acertou o número em %d tentativas. \n", (10 - this.attempts));
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
            System.out.print("Digite seu palpite:");
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
            System.out.println("Digite um número!");
        }
    }
}
