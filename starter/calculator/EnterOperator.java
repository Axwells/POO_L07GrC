package calculator;

public class EnterOperator extends Operator {
    @Override
    public void execute(State state) {
        if (state.getCurrentValue() != null) {
            state.pushCurrentValue(); // Empile la valeur courante sur la pile
            state.setCurrentValue(0.0); // Réinitialiser pour une nouvelle entrée
            state.setDecimalPoint(false); // Réinitialiser le mode décimal
        }
    }
}
