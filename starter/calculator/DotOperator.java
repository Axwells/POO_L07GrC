package calculator;

/**
 * Operateur permettant d'ecrire la partie decimale d'un nombre
 */
public class DotOperator extends Operator {
    @Override
    public void execute(State state) {
        if (!state.hasDecimalPoint()) {
            state.setDecimalPoint(true);
        }
    }
}
