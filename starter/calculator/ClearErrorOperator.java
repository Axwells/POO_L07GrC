package calculator;

public class ClearErrorOperator extends Operator {
    @Override
    public void execute(State state) {
        // Réinitialiser uniquement la valeur courante et les erreurs
        state.clearError(); // Supprimer les erreurs
        state.setCurrentValue(0.0); // Réinitialiser l'affichage à 0
    }
}
