package calculator;

class DivideOperator extends Operator {
    @Override
    public void execute(State state) {
        if (state.getStack().size() < 2) {
            state.setError("Pas assez d'opérandes pour la division.");
            return;
        }
        double b = state.pop();
        if (b == 0) {
            state.setError("Division par zéro.");
            return;
        }
        double a = state.pop();
        state.setCurrentValue(a / b);
        state.pushCurrentValue();
    }
}
