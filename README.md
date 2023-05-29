## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
# jogo-de-adivinhacao

![GuessingGame](/imagens/game.png)

## Iniciar do jogo

Ao executar o jogo e selecionar entre umas das 3 dificuldades padrões, o jogo vai sortear um número de 1 a 100 e você terá que adivinhar o número sorteado.

## Dificuldade

Você pode escolher em 4 dificuldades diferentes. 

1. Você terá 15 tentativas.
1. Você terá 10 tentativas. 
1. Você terá 5 tentativas.
1. Você pode personalizar a quantidade de tentativas e os limites para se sortear um número.

## Regras

* Você terá X tentativas e caso você esgote elas o jogo irá encerrar e vai receber a seguinte mensagem "O número de tentativas acabaram! o resultado era 'X'".

* Em caso de digitar algo que não seja um número inteiro você vai receber a seguinte mensagem de erro "Digite um número!" e o jogo vai se encerrar!

* Em caso de digitar um número menor que o número sorteado, você receberá a seguinte mensagem "O número é menor do que 'numero digitado'".

* Em caso de digitar um número maior que o número sorteado, você receberá a seguinte mensagem "O número é maior do que 'numero digitado'".

* Por ultimo você caso você acerte o número vai receber a seguinte mensagem "Parabéns! Você acertou o número em 'X' tentativas."