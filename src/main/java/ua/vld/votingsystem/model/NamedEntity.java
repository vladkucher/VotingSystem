package ua.vld.votingsystem.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @NotBlank
    @Column(name = "name", nullable = false)
    protected String name;

    public NamedEntity() {
    }

    protected NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
