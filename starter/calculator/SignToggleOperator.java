package calculator;

/**
 * Operateur permettant de changer le signe de la valeur courante
 */
class SignToggleOperator extends Operator {
    @Override
    public void execute(State state) {
        state.setCurrentValue(state.getCurrentValue() * -1);
    }
}