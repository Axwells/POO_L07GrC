package calculator;

/**
 * Operateur de suppression d'erreur
 */
public class ClearErrorOperator extends Operator {
    @Override
    public void execute(State state) {
        state.clearError();
        state.setCurrentValue(0.0);
    }
}
