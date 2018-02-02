package com.tmtron.ex.immutables;

import org.immutables.value.Value;

public abstract class DsInstanceBase {

    public abstract String computerName();

    public abstract String macAddress();

    @Value.Check
    protected void check() {
        if (computerName().isEmpty()) {
            throw new RuntimeException("ComputerName must not be empty");
        }
    }

    @Value.Lazy
    String computerNameUpper() {
        return computerName().toUpperCase();
    }

}
