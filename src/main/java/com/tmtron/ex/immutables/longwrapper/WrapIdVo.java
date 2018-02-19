package com.tmtron.ex.immutables.longwrapper;

import com.tmtron.ex.immutables.ImmutableDsInstanceDo;

import org.immutables.value.Value;

@Value.Immutable
public abstract class WrapIdVo extends WrapIdBase {

    public WrapIdDo toDomainObject(InstanceId id) {
        return ImmutableWrapIdDo.builder().from(this)
                .id(id)
                .build();
    }

}
