package calculator;

public class DotOperator extends Operator {
    @Override
    public void execute(State state) {
        if (!state.hasDecimalPoint()) {
            state.setDecimalPoint(true); // Activer le mode décimal
        }
    }
}
