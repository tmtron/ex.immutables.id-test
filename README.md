# ex.immutables.id-test
Using [immutables](https://immutables.github.io/) for ValueObjects and DomainObjects

## Implementation
The fields of both classes are defined in a common base-class:

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
We extend the base-class, add the `Immutable` annotation, add an id field and provide a custom implemenation of `equals` and `hashCode`

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
