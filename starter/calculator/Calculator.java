package calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        State state = new State();
        String input;

        System.out.println("Mode console - Tapez 'exit' pour quitter.");

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine().trim(); // Lire l'entrée utilisateur

            if (input.equalsIgnoreCase("exit")) {
                break; // Quitter si l'utilisateur tape 'exit'
            }

            try {
                if (isNumber(input)) {
                    // Si c'est un nombre, définir comme valeur courante et empiler
                    state.setCurrentValue(Double.parseDouble(input));
                    state.pushCurrentValue();
                } else {
                    // Sinon, interpréter comme un opérateur
                    Operator operator = getOperator(input);
                    if (operator != null) {
                        operator.execute(state);
                    } else {
                        System.out.println("Opération inconnue : " + input);
                    }
                }
            } catch (Exception e) {
                // Afficher les erreurs éventuelles
                state.setError("Erreur : " + e.getMessage());
            }

            // Afficher l'état actuel
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

    // Vérifier si une chaîne représente un nombre
    private static boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Associer les chaînes à des instances d'opérateurs
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

    private static void displayState(State state) {
        // Obtenir le contenu de la pile
        Object[] stackArray = state.getStack().toArray();
        StringBuilder stackDisplay = new StringBuilder();

        // Construire la chaîne de la pile
        for (Object element : stackArray) {
            stackDisplay.append(element).append(" ");
        }

        // Afficher la pile uniquement si elle n'est pas vide
        if (stackDisplay.length() > 0) {
            System.out.println(stackDisplay.toString().trim());
        }

        // Afficher la valeur courante uniquement si elle est pertinente
        if (state.isIntermediateResult() || state.getCurrentValue() != 0.0 || state.hasDecimalPoint()) {
            System.out.println(state.getCurrentValue());
        }
    }
}
