package calculator;

/**
 * Operateur de reinitialisation de la calculatrice
 */
class ClearOperator extends Operator {
    @Override
    void execute(State state) {
        state.clear();
    }
}
