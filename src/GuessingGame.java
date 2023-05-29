import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    private int number;
    private int attempts;
    private int maxAttempts;
    private String result;
    private Scanner input;
    private boolean isEnd;
    private int minInt = 1;
    private int maxInt = 100;

    private final String VERMELHO = "\u001B[31m";
    private final String VERDE = "\u001B[32m";

    /**
     * You will start the game when you instantiate this class.
     */
    public GuessingGame() {
        this.input = new Scanner(System.in);
        System.out.println(VERDE + "Bem-vindo ao jogo de adivinhação! \n");

        choiceDifficulty();
        generateRandomNum();

        String text = colorTextRed(Integer.toString(minInt));
        String anotherText = colorTextRed(Integer.toString(maxInt));
        System.out.println(String.format("Tente adivinhar um número entre %s %s %s \n", text,
                "e", anotherText));
    }

    private String colorTextRed(String text) {
        return VERMELHO + text + VERDE;
    }

    /**
     * This function define by input the level of diffyculty.
     * 1 = easy, 2 = medium, 3 = hard and for another number, you can choice your
     * challenge.
     */
    private void choiceDifficulty() {
        try {

            System.out.println("Escolha sua dificuldade. \n");

            System.out.println(String.format(
                    "Caso deseje um desafio mais tranquilo, digite %s.",
                    colorTextRed("1")));
            System.out.println(String.format(
                    "Caso deseje um desafio moderado, digite %s.",
                    colorTextRed("2")));
            System.out.println(String.format(
                    "Caso deseje um desafio desafior, digite %s.",
                    colorTextRed("3")));
            System.out.println(String.format(
                    "Caso deseje um desafio personalizado, digite %s. \n",
                    colorTextRed("4")));

            System.out.print("Escolha sua dificuldade: " + VERMELHO);
            int number = this.input.nextInt();

            switch (number) {
                case 1:
                    this.maxAttempts = 15;
                    this.attempts = 15;
                    break;
                case 2:
                    this.maxAttempts = 10;
                    this.attempts = 10;
                    break;
                case 3:
                    this.maxAttempts = 5;
                    this.attempts = 5;
                    break;
                default:
                    System.out.print(VERDE + "\nQual o número minimo? " + VERMELHO);
                    this.minInt = this.input.nextInt();
                    System.out.print(VERDE + "Qual o número máximo? " + VERMELHO);
                    this.maxInt = this.input.nextInt();
                    System.out.print(VERDE + "\nQuantas tentativas você quer ter? " + VERMELHO);
                    int attemps = this.input.nextInt();
                    this.maxAttempts = attemps;
                    this.attempts = attemps;
                    break;
            }

            String attemptsText = colorTextRed(Integer.toString(this.attempts, 10));

            System.out.println(String.format("%sVocê tem %s tentativas. \n", VERDE,
                    attemptsText));
        } catch (Exception e) {
            System.out.println(VERMELHO + "Digite um número!");
        }
    }

    /**
     * This function define a random int number.
     */
    private void generateRandomNum() {
        Random random = new Random();
        int numero = (random.nextInt(this.maxInt - this.minInt) + this.minInt);
        this.number = numero;
    }

    /**
     * This function check the result. In case you choice the rigth number, this
     * will define the end message and the conditon to stop the game. In another
     * case, it will define game messages!
     * 
     * @param number "This will be compare with the result."
     */
    private void checkResult(int number) {
        String numberText = colorTextRed(Integer.toString(number, 10));
        if (number < this.number) {
            this.result = String.format(VERDE + "O número é maior do que %s \n", numberText);
        } else if (number > this.number) {
            this.result = String.format(VERDE + " O número é menor do que %s \n", numberText);
        } else {
            this.isEnd = true;
            this.result = String.format(VERDE + "Parabéns! Você acertou o número em %s tentativas. \n",
                    colorTextRed(Integer.toString((this.maxAttempts - this.attempts), 10)));
        }
    }

    /**
     * This function check if you can play. In case your attemps end, this will
     * define the end message and the stop game condition.
     * In another case, this will decrease the attempts number!
     */
    private void checkAttempts() {
        if (this.attempts == 0) {
            this.result = String.format("O número de tentativas acabaram! o resultado era %d", this.number);
            this.isEnd = true;
        } else {
            this.attempts -= 1;
        }
    }

    /**
     * This function call the input and put in screen the result.
     */
    public void play() {
        try {
            System.out.print(VERMELHO + "Digite seu palpite: ");
            int number = this.input.nextInt();
            checkAttempts();
            checkResult(number);
            System.out.println(this.result);
            if (!isEnd) {
                play();
            } else {
                this.input.close();
            }
        } catch (Exception e) {
            System.out.println("Digite um número!");
        }
    }
}
