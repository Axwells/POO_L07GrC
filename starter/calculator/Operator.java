package calculator;

/**
 * Classe abstraite operateur étant la superclasse de tout les autres operateurs
 */
abstract class Operator
{
  abstract void execute(State state);
}
