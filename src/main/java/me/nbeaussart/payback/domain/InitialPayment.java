package me.nbeaussart.payback.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A InitialPayment.
 */
@Entity
@Table(name = "initial_payment")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class InitialPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ammount")
    private Long ammount;

    @ManyToOne
    private ExtandedUser user;

    @ManyToOne
    private Event event;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmmount() {
        return ammount;
    }

    public void setAmmount(Long ammount) {
        this.ammount = ammount;
    }

    public ExtandedUser getUser() {
        return user;
    }

    public void setUser(ExtandedUser extandedUser) {
        this.user = extandedUser;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InitialPayment initialPayment = (InitialPayment) o;
        if(initialPayment.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, initialPayment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "InitialPayment{" +
            "id=" + id +
            ", ammount='" + ammount + "'" +
            '}';
    }
}
