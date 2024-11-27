package calculator;

public class InverseOperator extends Operator {
    @Override
    public void execute(State state) {
        double currentValue = state.getCurrentValue();

        // Vérifier si la division par zéro est possible
        if (currentValue == 0) {
            state.setError("Impossible de diviser par zéro.");
            return;
        }

        // Calculer l'inverse
        state.setCurrentValue(1 / currentValue);

        // Marquer comme résultat intermédiaire
        state.setIntermediateResult(true);
    }
}
