
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        try (Scanner terminal = new Scanner(System.in)) {
            int start;
            int end;

            while (true) {
                System.out.println("Digite o primeiro parâmetro");
                if (terminal.hasNextInt()) {
                    start = terminal.nextInt();
                    break;
                } else {
                    System.out.println("Valor invalido! Digite um valor valido:");
                    terminal.next(); 
                }
            }

            while (true) {
                System.out.println("Digite o segundo parâmetro");
                if (terminal.hasNextInt()) {
                    end = terminal.nextInt();
                    if (end > start) {
                        break;
                    } else {
                        System.out.println("O segundo parâmetro deve ser maior que o primeiro");
                    }
                } else {
                    System.out.println("Valor invalido! Digite um valor valido:");
                    terminal.next(); 
                }
            }

            try {
                contar(start, end);
            } catch (InvalidRangeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void contar(int start, int end) throws InvalidRangeException {
        if (start >= end) {
            throw new InvalidRangeException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = end - start;
        for (int i = start; i <= end; i++) {
            System.out.println(String.format("Imprimindo o numero %d",i));
        }
    }
}

class InvalidRangeException extends Exception {
    public InvalidRangeException(String message) {
        super(message);
    }
}