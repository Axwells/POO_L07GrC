package calculator;

class SqrtOperator extends Operator {
    @Override
    public void execute(State state) {
        if (state.getStack().isEmpty()) {
            state.setError("Pile vide pour la racine carrée.");
            return;
        }
        double a = state.pop();
        if (a < 0) {
            state.setError("Valeur négative pour la racine carrée.");
            return;
        }
        state.setCurrentValue(Math.sqrt(a));
        state.pushCurrentValue();
    }
}
