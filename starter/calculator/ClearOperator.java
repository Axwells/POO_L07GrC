package calculator;

class ClearOperator extends Operator {
    @Override
    void execute(State state) {
        state.clear();
    }
}
