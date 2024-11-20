package calculator;

class NumberOperator extends Operator {
    private final int number;

    public NumberOperator(int number) {
        this.number = number;
    }

    @Override
    public void execute(State state) {
        double currentValue = state.getCurrentValue();
        state.setCurrentValue(1.0 * number);  // Simuler l'entrée numérique
    }
}