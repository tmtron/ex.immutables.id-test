package com.tmtron.ex.immutables;

import org.junit.Assert;
import org.junit.Test;

public class DsInstanceDoTest {

    private final DsInstanceDo do1a =
            ImmutableDsInstanceDo.builder()
                    .id(1)
                    .computerName("pc1")
                    .macAddress("12").build();

    private final DsInstanceDo do1b =
            ImmutableDsInstanceDo.builder()
                    .id(1)
                    .computerName("pc1")
                    .macAddress("12").build();

    private final DsInstanceDo do1c =
            ImmutableDsInstanceDo.builder()
                    .id(1)
                    .computerName("pc2")
                    .macAddress("45").build();

    private final DsInstanceDo do2 =
            ImmutableDsInstanceDo.builder()
                    .id(2)
                    .computerName("pc2")
                    .macAddress("12").build();

    @Test
    public void assertDoEquals() {
        Assert.assertEquals(do1a, do1b);
        Assert.assertEquals(do1a, do1c);
        Assert.assertEquals(do1b, do1c);
    }

    @Test
    public void assertDoNotEquals() {
        Assert.assertNotEquals(do1a, do2);
        Assert.assertNotEquals(do1b, do2);
        Assert.assertNotEquals(do1c, do2);
    }

    @Test
    public void assertValueObject() {
        DsInstanceVo vo = do1a.toValueObject();
        Assert.assertEquals(do1a.computerName(), vo.computerName());
        Assert.assertEquals(do1a.macAddress(), vo.macAddress());

        DsInstanceDo backConverted = vo.toDomainObject(do1a.id());
        Assert.assertEquals(do1a.id(), backConverted.id());
        Assert.assertEquals(do1a.computerName(), backConverted.computerName());
        Assert.assertEquals(do1a.macAddress(), backConverted.macAddress());
    }

}
