package calculator;

class ClearErrorOperator extends Operator {
    @Override
    public void execute(State state) {
        state.clearError();
    }
}