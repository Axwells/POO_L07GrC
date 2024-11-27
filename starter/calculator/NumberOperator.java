package calculator;

public class NumberOperator extends Operator {
    private final int number;

    public NumberOperator(int number) {
        this.number = number;
    }

    @Override
    public void execute(State state) {
        // Si un résultat intermédiaire est affiché, empiler la valeur courante avant une nouvelle saisie
        if (state.isIntermediateResult()) {
            state.pushCurrentValue();
        }

        // Construire un entier ou gérer les décimales
        if (state.hasDecimalPoint()) {
            // Ajouter un chiffre après le point décimal
            double currentValue = state.getCurrentValue();
            int decimalPlaces = state.getDecimalPlaces();
            currentValue += number * Math.pow(10, -(decimalPlaces + 1));
            state.setCurrentValue(currentValue);
            state.incrementDecimalPlaces();
        } else {
            // Construire un entier
            double currentValue = state.getCurrentValue();
            state.setCurrentValue(currentValue * 10 + number);
        }

        // Nouvelle saisie : ce n'est plus un résultat intermédiaire
        state.setIntermediateResult(false);
    }
}
