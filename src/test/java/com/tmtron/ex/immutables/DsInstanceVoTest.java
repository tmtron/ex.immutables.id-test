package com.tmtron.ex.immutables;

import org.junit.Assert;
import org.junit.Test;

public class DsInstanceVoTest {

    private final DsInstanceVo vo1a =
            ImmutableDsInstanceVo.builder()
                    .computerName("pc1")
                    .macAddress("12").build();

    private final DsInstanceVo vo1b =
            ImmutableDsInstanceVo.builder()
                    .computerName("pc1")
                    .macAddress("12").build();

    private final DsInstanceVo vo2 =
            ImmutableDsInstanceVo.builder()
                    .computerName("pc2")
                    .macAddress("12").build();


    @Test
    public void assertVoEquals() {
        Assert.assertEquals(vo1a, vo1b);
    }

    @Test
    public void assertVoNotEquals() {
        Assert.assertNotEquals(vo1a, vo2);
        Assert.assertNotEquals(vo1b, vo2);
    }

}
