package calculator;

class SignToggleOperator extends Operator {
    @Override
    public void execute(State state) {
        state.setCurrentValue(state.getCurrentValue() * -1);
    }
}