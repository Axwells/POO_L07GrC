package calculator;

class AddOperator extends Operator {
    @Override
    public void execute(State state) {
        if (state.getStack().size() < 2) {
            state.setError("Pas assez d'opérandes pour l'addition.");
            return;
        }
        double b = state.pop();
        double a = state.pop();
        state.setCurrentValue(a + b);
        state.pushCurrentValue();
    }
}
