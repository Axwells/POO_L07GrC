package calculator;

/**
 * Operateur permettant de stocker la valeur courante dans la Stack
 */
public class EnterOperator extends Operator {
    @Override
    public void execute(State state) {
        if (state.getCurrentValue() != null) {
            state.pushCurrentValue();
            state.setCurrentValue(0.0);
            state.setDecimalPoint(false);
        }
    }
}
