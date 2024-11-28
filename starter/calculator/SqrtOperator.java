package calculator;

/**
 * Operateur racine carree
 */
public class SqrtOperator extends Operator {
    @Override
    public void execute(State state) {
        if (state.getCurrentValue() != 0.0) {
            state.pushCurrentValue();
        }
        double currentValue = state.getStack().pop();

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
