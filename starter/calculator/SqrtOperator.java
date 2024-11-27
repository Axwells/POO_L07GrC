package calculator;

public class SqrtOperator extends Operator {
    @Override
    public void execute(State state) {
        double currentValue = state.getCurrentValue();

        if (currentValue == 0.0 && state.getStack().isEmpty()) {
            state.setError("Pas de valeur pour calculer la racine carrée.");
            return;
        }

        if (currentValue < 0) {
            state.setError("Impossible de calculer la racine carrée d'un nombre négatif.");
            return;
        }

        state.setCurrentValue(Math.sqrt(currentValue));
        state.setIntermediateResult(true);
    }
}
