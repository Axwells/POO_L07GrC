package calculator;

/**
 * Operateur permettant d'écrire un nombre
 */
public class NumberOperator extends Operator {
    private final int number;

    public NumberOperator(int number) {
        this.number = number;
    }

    @Override
    public void execute(State state) {
        if (state.isIntermediateResult()) {
            state.pushCurrentValue();
        }

        if (state.hasDecimalPoint()) {
            double currentValue = state.getCurrentValue();
            int decimalPlaces = state.getDecimalPlaces();
            currentValue += number * Math.pow(10, -(decimalPlaces + 1));
            state.setCurrentValue(currentValue);
            state.incrementDecimalPlaces();
        } else {
            double currentValue = state.getCurrentValue();
            state.setCurrentValue(currentValue * 10 + number);
        }

        state.setIntermediateResult(false);
    }
}
