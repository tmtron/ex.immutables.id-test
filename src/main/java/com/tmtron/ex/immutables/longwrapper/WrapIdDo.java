package com.tmtron.ex.immutables.longwrapper;

import com.tmtron.ex.immutables.DsInstanceDo;
import com.tmtron.ex.immutables.ImmutableDsInstanceVo;

import org.immutables.value.Value;

@Value.Immutable
public abstract class WrapIdDo extends WrapIdBase {

    public abstract LongId id();

    @Override
    public final boolean equals( Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WrapIdDo that = (WrapIdDo) o;

        return id().equals(that.id());
    }

    @Override
    public final int hashCode() {
        return id().hashCode();
    }

    public WrapIdVo toValueObject() {
        return ImmutableWrapIdVo.builder().from(this).build();
    }

}
