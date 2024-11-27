package calculator;

public class SquareOperator extends Operator {
    @Override
    public void execute(State state) {
        double currentValue = state.getCurrentValue();

        // Calculer le carré
        state.setCurrentValue(Math.pow(currentValue, 2));

        // Marquer comme résultat intermédiaire
        state.setIntermediateResult(true);
    }
}
