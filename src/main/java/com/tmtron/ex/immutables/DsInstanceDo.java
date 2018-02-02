package com.tmtron.ex.immutables;

import org.immutables.value.Value;

@Value.Immutable
public abstract class DsInstanceDo extends DsInstanceBase {

    public abstract long id();

    @Override
    public final boolean equals( Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DsInstanceDo that = (DsInstanceDo) o;

        return id() == that.id();
    }

    @Override
    public final int hashCode() {
        return (int) (id() ^ (id() >>> 32));
    }

    public DsInstanceVo toValueObject() {
        return ImmutableDsInstanceVo.builder().from(this).build();
    }

}
