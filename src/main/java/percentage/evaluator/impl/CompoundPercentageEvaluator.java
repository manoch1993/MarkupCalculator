package percentage.evaluator.impl;

import percentage.evaluator.CompoundEvaluator;
import percentage.model.Percentage;
import percentage.model.impl.FixedPercentage;

/**
 * Implementation of Compounding Percentage Evaluator
 *
 * @author "Simar Paul Singh"
 */
public class CompoundPercentageEvaluator implements CompoundEvaluator {

    private static final float BASE_VALUE = 1f;

    /**
     * {@inheritDoc}
     */
    @Override
    public Percentage evaluate(final Percentage... percentages) {
        // taking base factor as 1
        final double compoundedValue = compound(BASE_VALUE, percentages);
        // returning aggregated compounded percentage from compounded Value
        return new FixedPercentage((compoundedValue - BASE_VALUE) * 100);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double compound(final double baseValue, final Percentage... percentages) {

        double compoundedValue = baseValue;
        // calculating compounded value over base value
        for (final Percentage nextPercentage : percentages) {
            compoundedValue = (compoundedValue * (1f + nextPercentage.getValue() / 100));
        }
        // returning aggregated compounded value
        return compoundedValue;
    }
}
