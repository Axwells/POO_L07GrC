package calculator;

class DotOperator extends Operator {
    @Override
    public void execute(State state) {
        double currentValue = state.getCurrentValue();
        String currentText = String.valueOf(currentValue);

        // Vérifier si un point existe déjà dans la valeur
        if (!currentText.contains(".")) {
            state.setCurrentValue(currentValue + 0.0); // Ajouter un point décimal
        }
    }
}
