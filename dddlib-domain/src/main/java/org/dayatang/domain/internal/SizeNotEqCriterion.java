package org.dayatang.domain.internal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.dayatang.domain.QueryCriterion;
import org.dayatang.utils.Assert;

public class SizeNotEqCriterion implements QueryCriterion {

    private final String propName;
    private final int value;

    public SizeNotEqCriterion(String propName, int value) {
        Assert.notBlank(propName, "Property name is null!");
        this.propName = propName;
        this.value = value;
    }

    public String getPropName() {
        return propName;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SizeNotEqCriterion)) {
            return false;
        }
        SizeNotEqCriterion that = (SizeNotEqCriterion) other;
        return new EqualsBuilder().append(this.getPropName(), that.getPropName()).append(value, that.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPropName()).append(value).toHashCode();
    }

    @Override
    public String toString() {
        return "size of " + getPropName() + " != " + value;
    }
}