package calculator;

import util.Stack;

public class State {
    private Stack<Double> stack;
    private Double currentValue;
    private String errorMessage;
    private boolean hasDecimalPoint;
    private int decimalPlaces;
    private boolean isIntermediateResult;

    public State() {
        stack = new Stack<>();
        currentValue = 0.0;
        errorMessage = null;
        hasDecimalPoint = false;
        decimalPlaces = 0;
        isIntermediateResult = false;
    }

    public Stack<Double> getStack() {
        return stack;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double value) {
        currentValue = value;
    }

    public void pushCurrentValue() {
        stack.push(currentValue);
        currentValue = 0.0;
        hasDecimalPoint = false;
        decimalPlaces = 0;
        isIntermediateResult = false;
    }

    public Double pop() {
        if (stack.isEmpty()) {
            setError("Pile vide.");
            return null;
        }
        return stack.pop();
    }

    public void clear() {
        stack = new Stack<>();
        currentValue = 0.0;
        errorMessage = null;
        hasDecimalPoint = false; // Réinitialisation
    }

    public void setError(String message) {
        errorMessage = message;
        currentValue = 0.0;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean hasError() {
        return errorMessage != null;
    }

    public void clearError() {
        errorMessage = null;
    }

    public boolean hasEnoughOperands(int count) {
        return stack.size() >= count;
    }

    public boolean hasDecimalPoint() {
        return hasDecimalPoint;
    }

    public void setDecimalPoint(boolean hasDecimalPoint) {
        this.hasDecimalPoint = hasDecimalPoint;
        if (hasDecimalPoint) {
            decimalPlaces = 0; // Réinitialiser le compteur des décimales
        }
    }

    public void incrementDecimalPlaces() {
        decimalPlaces++;
    }

    public int getDecimalPlaces() {
        return decimalPlaces;
    }

    public boolean isIntermediateResult() {
        return isIntermediateResult;
    }

    public void setIntermediateResult(boolean isIntermediateResult) {
        this.isIntermediateResult = isIntermediateResult;
    }

    @Override
    public String toString() {
        return hasError() ? "Erreur: " + errorMessage : "Pile: " + stack + ", Valeur courante: " + currentValue;
    }
}
