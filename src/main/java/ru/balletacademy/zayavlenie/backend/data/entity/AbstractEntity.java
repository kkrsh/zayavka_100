package ru.balletacademy.zayavlenie.backend.data.entity;

import java.io.Serializable;

import javax.persistence.*;

@MappedSuperclass
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    public boolean isNew() {
        return id == null;
    }

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return super.hashCode();
        }

        return 31 + id.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (id == null) {
            // New entities are only equal if the instance if the same
            return super.equals(other);
        }

        if (this == other) {
            return true;
        }
        if (!(other instanceof AbstractEntity)) {
            return false;
        }
        return id.equals(((AbstractEntity) other).id);
    }

}
