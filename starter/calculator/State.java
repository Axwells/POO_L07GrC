package calculator;

import util.Stack;

public class State {
    private Stack<Double> stack; // Pile pour la notation polonaise inverse
    private Double currentValue; // Valeur courante
    private String errorMessage; // Message d'erreur éventuel

    // Constructeur
    public State() {
        stack = new Stack<>();
        currentValue = 0.0;
        errorMessage = null;
    }

    // Obtenir la pile
    public Stack<Double> getStack() {
        return stack;
    }

    // Obtenir la valeur courante
    public Double getCurrentValue() {
        return currentValue;
    }

    // Définir la valeur courante
    public void setCurrentValue(Double value) {
        currentValue = value;
    }

    // Pousser la valeur courante sur la pile
    public void pushCurrentValue() {
        stack.push(currentValue);
        currentValue = 0.0;
    }

    // Dépiler une valeur
    public Double pop() {
        if (stack.isEmpty()) {
            setError("Pile vide.");
            return null;
        }
        return stack.pop();
    }

    // Effacer l'état
    public void clear() {
        stack = new Stack<>();
        currentValue = 0.0;
        errorMessage = null;
    }

    // Définir une erreur
    public void setError(String message) {
        errorMessage = message;
        currentValue = 0.0;
    }

    // Obtenir le message d'erreur
    public String getErrorMessage() {
        return errorMessage;
    }

    // Vérifier s'il y a une erreur
    public boolean hasError() {
        return errorMessage != null;
    }

    // Réinitialiser les erreurs
    public void clearError() {
        errorMessage = null;
    }

    @Override
    public String toString() {
        return hasError() ? "Erreur: " + errorMessage : "Pile: " + stack + ", Valeur courante: " + currentValue;
    }
}
