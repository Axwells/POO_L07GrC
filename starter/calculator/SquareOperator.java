package calculator;

class SquareOperator extends Operator {
    @Override
    public void execute(State state) {
        double currentValue = state.getCurrentValue();
        state.setCurrentValue(Math.pow(currentValue, 2)); // x²
    }
}
