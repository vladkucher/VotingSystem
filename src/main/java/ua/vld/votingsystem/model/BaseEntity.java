package ua.vld.votingsystem.model;

import org.hibernate.Hibernate;
import ua.vld.votingsystem.HasId;

import javax.persistence.*;


@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity implements HasId {
    @Id
    @Access(value = AccessType.PROPERTY)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    public BaseEntity() {
    }

    protected BaseEntity(Integer id) {
        this.id = id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;
        return getId() != null && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return (getId() == null) ? 0 : getId();
    }

    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", getClass().getName(), getId());
    }
}
