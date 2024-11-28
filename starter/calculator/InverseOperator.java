package calculator;

/**
 * Operateur inverse (1/x)
 */
public class InverseOperator extends Operator {
    @Override
    public void execute(State state) {
        if (state.getCurrentValue() != 0.0) {
            state.pushCurrentValue();
        }
        double currentValue = state.getStack().pop();

        if (currentValue == 0) {
            state.setError("Impossible de diviser par zéro.");
            return;
        }

        state.setCurrentValue(1 / currentValue);

        state.setIntermediateResult(true);
    }
}
