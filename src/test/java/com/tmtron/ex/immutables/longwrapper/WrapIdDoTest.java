package com.tmtron.ex.immutables.longwrapper;

import org.junit.Assert;
import org.junit.Test;

public class WrapIdDoTest {

    private final WrapIdDo do1a =
            ImmutableWrapIdDo.builder()
                    .id(InstanceId.of(1L))
                    .computerName("pc1")
                    .macAddress("12").build();

    private final WrapIdDo do1b =
            ImmutableWrapIdDo.builder()
                    .id(InstanceId.of(1L))
                    .computerName("pc1")
                    .macAddress("12").build();

    private final WrapIdDo do1c =
            ImmutableWrapIdDo.builder()
                    .id(InstanceId.of(1L))
                    .computerName("pc2")
                    .macAddress("45").build();

    private final WrapIdDo do2 =
            ImmutableWrapIdDo.builder()
                    .id(InstanceId.of(2L))
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
        WrapIdVo vo = do1a.toValueObject();
        Assert.assertEquals(do1a.computerName(), vo.computerName());
        Assert.assertEquals(do1a.macAddress(), vo.macAddress());

        WrapIdDo backConverted = vo.toDomainObject(do1a.id());
        Assert.assertEquals(do1a.id(), backConverted.id());
        Assert.assertEquals(do1a.computerName(), backConverted.computerName());
        Assert.assertEquals(do1a.macAddress(), backConverted.macAddress());
    }

}
