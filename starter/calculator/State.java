package calculator;

import util.Stack;

/**
 * Classe stockant l'etat actuel de la calculatrice (valeur courante, Stack, etc...)
 */
public class State {
    private Stack<Double> stack;
    private Double currentValue;
    private String errorMessage;
    private boolean hasDecimalPoint;
    private int decimalPlaces;
    private boolean isIntermediateResult;

    /**
     * Constructeur
     */
    public State() {
        stack = new Stack<>();
        currentValue = 0.0;
        errorMessage = null;
        hasDecimalPoint = false;
        decimalPlaces = 0;
        isIntermediateResult = false;
    }

    /**
     * Getter de la Stack
     * @return Stack
     */
    public Stack<Double> getStack() {
        return stack;
    }

    /**
     * Getter de la valeur courante
     * @return currentValue
     */
    public Double getCurrentValue() {
        return currentValue;
    }

    /**
     * Setter de la valeur courante
     * @param value currentValue
     */
    public void setCurrentValue(Double value) {
        currentValue = value;
    }

    /**
     * Methode poussant la valeur courante dans la stack
     */
    public void pushCurrentValue() {
        if (currentValue != 0.0 || hasDecimalPoint() || isIntermediateResult()) {
            stack.push(currentValue);
        }
        currentValue = 0.0;
        hasDecimalPoint = false;
        decimalPlaces = 0;
        isIntermediateResult = false;
    }

    /**
     * Methode supprimant le sommet de la Stack
     * @return valeur supprimee
     */
    public Double pop() {
        if (stack.isEmpty()) {
            setError("Pile vide.");
            return null;
        }
        return stack.pop();
    }

    /**
     * Methode reinitialisant la valeur courante, Stack, etc...
     */
    public void clear() {
        stack = new Stack<>();
        currentValue = 0.0;
        errorMessage = null;
        hasDecimalPoint = false;
    }

    /**
     * Setter d'un message d'erreur
     * @param message message d'erreur propre au contexte
     */
    public void setError(String message) {
        errorMessage = message;
        currentValue = 0.0;
    }

    /**
     * Getter du message d'erreur
     * @return message d'erreur
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Methode permettant de savoir si la calculatrice est en etat d'erreur
     * @return true si un message d'erreur est affiche, sinon false
     */
    public boolean hasError() {
        return errorMessage != null;
    }

    /**
     * Methode reinitialisant la flag d'erreur
     */
    public void clearError() {
        errorMessage = null;
    }

    /**
     * Methode permettant de savoir si la Stack possede assez de valeurs pour effectuer une operation
     * @param count nombre d'operandes necessaires
     * @return true si la Stack comporte assez d'operandes, sinon false
     */
    public boolean hasEnoughOperands(int count) {
        return stack.size() >= count;
    }

    /**
     * Methode permettant de savoir si la valeur courante est un nombre a virgule
     * @return true si c'est un nombre a virgule, false si c'est un entier
     */
    public boolean hasDecimalPoint() {
        return hasDecimalPoint;
    }

    /**
     * Setter de l'emplacement de la decimale de la valeur courante
     * @param hasDecimalPoint
     */
    public void setDecimalPoint(boolean hasDecimalPoint) {
        this.hasDecimalPoint = hasDecimalPoint;
        if (hasDecimalPoint) {
            decimalPlaces = 0;
        }
    }

    /**
     * Methode permettant d'incrementer le nombre de chiffres après la virgule que possède la valeur courante
     */
    public void incrementDecimalPlaces() {
        decimalPlaces++;
    }

    /**
     * Methode permettant de connaitre le nombre de chiffres après la virgule que possède la valeur courante
     * @return nombre de chiffres après la virgule
     */
    public int getDecimalPlaces() {
        return decimalPlaces;
    }

    /**
     * Methode permettant de savoir si la valeur courante est le resultat intermediare d'une operation
     * @return
     */
    public boolean isIntermediateResult() {
        return isIntermediateResult;
    }

    /**
     * Setter permettant de stocker si la valeur courant est le resultat intermediare d'une operation ou non
     * @param isIntermediateResult
     */
    public void setIntermediateResult(boolean isIntermediateResult) {
        this.isIntermediateResult = isIntermediateResult;
    }
}
