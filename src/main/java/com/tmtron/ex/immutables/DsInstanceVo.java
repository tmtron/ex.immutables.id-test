package com.tmtron.ex.immutables;

import org.immutables.value.Value;

@Value.Immutable
public abstract class DsInstanceVo extends DsInstanceBase {

    public DsInstanceDo toDomainObject(long id) {
        return ImmutableDsInstanceDo.builder().from(this)
                .id(id)
                .build();
    }

}
