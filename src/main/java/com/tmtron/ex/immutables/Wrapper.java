package com.tmtron.ex.immutables;

import org.immutables.value.Value;

// base wrapper type
public abstract class Wrapper<T> {
    @Value.Parameter
    public abstract T value();
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + value() + ")";
    }
}
