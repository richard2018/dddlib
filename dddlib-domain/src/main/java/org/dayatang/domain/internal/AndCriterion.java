package org.dayatang.domain.internal;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.dayatang.domain.QueryCriterion;
import org.dayatang.utils.Assert;

public class AndCriterion implements QueryCriterion {

    private final QueryCriterion[] criterions;

    public AndCriterion(QueryCriterion... criterions) {
        Assert.notNull(criterions, "At least two query criterions required!");
        Assert.isTrue(criterions.length > 1, "At least two query criterions required!");
        this.criterions = criterions;
    }

    public QueryCriterion[] getCriterons() {
        return criterions;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AndCriterion)) {
            return false;
        }
        AndCriterion that = (AndCriterion) other;
        return new EqualsBuilder()
                .append(this.getCriterons(), that.getCriterons())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getCriterons()).toHashCode();
    }

    @Override
    public String toString() {
        return StringUtils.join(criterions, " and ");
    }

}