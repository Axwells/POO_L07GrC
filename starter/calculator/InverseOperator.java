package calculator;

/**
 * Operateur inverse (1/x)
 */
public class InverseOperator extends Operator {
    @Override
    public void execute(State state) {
        double currentValue = state.getCurrentValue();

        if (currentValue == 0) {
            state.setError("Impossible de diviser par zéro.");
            return;
        }

        state.setCurrentValue(1 / currentValue);

        state.setIntermediateResult(true);
    }
}
