package com.tmtron.ex.immutables.longwrapper;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstanceIdTest {

    private InstanceId id1a = InstanceId.of(1L);
    private InstanceId id1b = InstanceId.of(1L);
    private InstanceId id2 = InstanceId.of(2L);

    @Test
    public void testEquals() {
        Assert.assertEquals(id1a, id1b);
    }

    @Test
    public void testNotEquals() {
        Assert.assertNotEquals(id1a, id2);
        Assert.assertNotEquals(id1b, id2);
    }

}