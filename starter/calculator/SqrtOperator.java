package calculator;

public class SqrtOperator extends Operator {
    @Override
    public void execute(State state) {
        double currentValue = state.getCurrentValue();

        // Si la valeur est négative, signaler une erreur
        if (currentValue < 0) {
            state.setError("Impossible de calculer la racine carrée d'un nombre négatif.");
            return;
        }

        // Calculer la racine carrée
        state.setCurrentValue(Math.sqrt(currentValue));

        // Marquer comme résultat intermédiaire
        state.setIntermediateResult(true);
    }
}
