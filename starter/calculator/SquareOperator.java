package calculator;

/**
 * Operateur puissance carree
 */
public class SquareOperator extends Operator {
    @Override
    public void execute(State state) {
        if (state.getCurrentValue() != 0.0) {
            state.pushCurrentValue();
        }
        double currentValue = state.getStack().pop();

        // Calculer le carré
        state.setCurrentValue(Math.pow(currentValue, 2));

        // Marquer comme résultat intermédiaire
        state.setIntermediateResult(true);
    }
}
