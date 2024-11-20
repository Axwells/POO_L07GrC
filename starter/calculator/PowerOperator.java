package calculator;

class PowerOperator extends Operator {
    @Override
    public void execute(State state) {
        if (state.getStack().size() < 2) {
            state.setError("Pas assez d'opérandes pour l'exposant.");
            return;
        }
        double b = state.pop();
        double a = state.pop();
        state.setCurrentValue(Math.pow(a, b));
        state.pushCurrentValue();
    }
}
