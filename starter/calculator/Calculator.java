package calculator;

import java.util.Scanner;

/**
 * Programme d'éxecution de la calculatrice en ligne de commande
 */
public class Calculator {
    /**
     * Programme principal
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        State state = new State();
        String input;

        System.out.println("Mode console - Tapez 'exit' pour quitter.");

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine().trim(); // Lire l'entrée utilisateur

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                if (isNumber(input)) {
                    state.setCurrentValue(Double.parseDouble(input));
                    state.pushCurrentValue();
                } else {
                    Operator operator = getOperator(input);
                    if (operator != null) {
                        operator.execute(state);
                    } else {
                        System.out.println("Opération inconnue : " + input);
                    }
                }
            } catch (Exception e) {
                state.setError("Erreur : " + e.getMessage());
            }

            if (state.hasError()) {
                System.out.println(state.getErrorMessage());
                state.clearError();
            } else {
                displayState(state);
            }
        }

        scanner.close();
        System.out.println("Calculatrice terminée.");
    }

    /**
     * Fonction permettant de verifier si l'input de l'utilisateur est un nombre valide
     * @param input nombre écrit par l'utilisateur
     * @return true si il s'agit d'un nombre réel valide, false si ce n'est pas le cas
     */
    private static boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Fonction permettant d'effectuer la bonne opération selon input
     * @param input opérateur demandé par l'utiliseur
     * @return
     */
    private static Operator getOperator(String input) {
        return switch (input) {
            case "+" -> new AddOperator();
            case "-" -> new SubtractOperator();
            case "*" -> new MultiplyOperator();
            case "/" -> new DivideOperator();
            case "sqrt" -> new SqrtOperator();
            case "x^2" -> new SquareOperator();
            case "1/x" -> new InverseOperator();
            default -> null;
        };
    }

    /**
     * Méthode affichant l'état actuel du calculateur
     * @param state
     */
    private static void displayState(State state) {
        Object[] stackArray = state.getStack().toArray();
        StringBuilder stackDisplay = new StringBuilder();

        for (Object element : stackArray) {
            stackDisplay.append(element).append(" ");
        }

        if (stackDisplay.length() > 0) {
            System.out.println(stackDisplay.toString().trim());
        }

        if (state.isIntermediateResult() || state.getCurrentValue() != 0.0 || state.hasDecimalPoint()) {
            System.out.println(state.getCurrentValue());
        }
    }
}
