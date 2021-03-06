# Immutables: ValueObjects and DomainObjects 
Using [immutables](https://immutables.github.io/) for ValueObjects and DomainObjects

[![Build Status](https://travis-ci.org/tmtron/ex.immutables.id-test.svg?label=travis)](https://travis-ci.org/tmtron/ex.immutables.id-test/builds) 

## Implementation
The fields of both classes are defined in a common base-class:

Example: [DsInstanceBase](src/main/java/com/tmtron/ex/immutables/DsInstanceBase.java)
```java
public abstract class DsInstanceBase {
    public abstract String computerName();
    public abstract String macAddress();
}
```

## ValueObject
ValueObjects are compared by their content: e.g. the value of all fields.  
We simply need to extend the base-class and add the `Immutable` annotation.  
We can also add a convenience method to build a DomainObject.

Example: [DsInstanceVo](src/main/java/com/tmtron/ex/immutables/DsInstanceVo.java)
```java
@Value.Immutable
public abstract class DsInstanceVo extends DsInstanceBase {

    public DsInstanceDo toDomainObject(long id) {
        return ImmutableDsInstanceDo.builder().from(this)
                .id(id)
                .build();
    }
}
```

## DomainObject
DomainObjects are compared by a single Id field (primitive, any Object or a ValueObject).  
We extend the base-class, add the `Immutable` annotation, add an id field and provide a custom implemenation of `equals` and `hashCode`.

Example: [DsInstanceDo](src/main/java/com/tmtron/ex/immutables/DsInstanceDo.java)
```java
@Value.Immutable
public abstract class DsInstanceDo extends DsInstanceBase {
    public abstract long id();

    @Override
    public final boolean equals( Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DsInstanceDo that = (DsInstanceDo) o;
        return id() == that.id();
    }

    @Override
    public final int hashCode() {
        return (int) (id() ^ (id() >>> 32));
    }

    public DsInstanceVo toValueObject() {
        return ImmutableDsInstanceVo.builder().from(this).build();
    }
}
```

## Wrapper Types
The example in the [longwrapper](src/main/java/com/tmtron/ex/immutables/longwrapper) package shows the usage of [Wrapper Types](https://immutables.github.io/immutable.html#wrapper-types)
