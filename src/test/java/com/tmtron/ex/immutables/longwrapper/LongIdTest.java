package com.tmtron.ex.immutables.longwrapper;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongIdTest {

    private LongId id1a = LongId.of(1L);
    private LongId id1b = LongId.of(1L);
    private LongId id2 = LongId.of(2L);

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