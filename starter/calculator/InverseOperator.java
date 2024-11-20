package calculator;

class InverseOperator extends Operator {
    @Override
    public void execute(State state) {
        double currentValue = state.getCurrentValue();

        // Vérification si la valeur courante est 0 pour éviter la division par zéro
        if (currentValue == 0) {
            state.setError("Division par zéro impossible.");
        } else {
            state.setCurrentValue(1 / currentValue); // Inversion de la valeur
        }
    }
}
