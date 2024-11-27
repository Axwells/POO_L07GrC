package calculator;

/**
 * Operateur de multiplication
 */
public class MultiplyOperator extends Operator {
    @Override
    public void execute(State state) {
        if (state.getCurrentValue() != 0.0 || state.hasDecimalPoint()) {
            state.pushCurrentValue();
        }

        if (!state.hasEnoughOperands(2)) {
            state.setError("Pas assez d'opérandes pour la multiplication.");
            return;
        }

        double b = state.pop();
        double a = state.pop();
        state.setCurrentValue(a * b);
        state.setIntermediateResult(true);
    }
}
