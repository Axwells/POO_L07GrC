package calculator;

class EnterOperator extends Operator {
    @Override
    public void execute(State state) {
        // Empiler la valeur courante
        state.pushCurrentValue();

        // Réinitialiser la valeur courante (cela peut être à zéro, ou à une valeur par défaut)
        state.setCurrentValue(0.0);
    }
}