package org.dayatang.domain.internal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.dayatang.domain.QueryCriterion;
import org.dayatang.utils.Assert;

public class NotCriterion implements QueryCriterion {

    private final QueryCriterion criterion;

    public NotCriterion(QueryCriterion criterion) {
        Assert.notNull(criterion, "Query criterion is null!");
        this.criterion = criterion;
    }

    public QueryCriterion getCriteron() {
        return criterion;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotCriterion)) {
            return false;
        }
        NotCriterion that = (NotCriterion) other;
        return new EqualsBuilder()
                .append(this.getCriteron(), that.getCriteron())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getCriteron()).toHashCode();
    }

    @Override
    public String toString() {
        return "not " + criterion;
    }
}