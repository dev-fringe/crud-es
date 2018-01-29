package dev.fringe.crud.model;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Table(name="One")
@Data
public class One {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int  id;
    private String name;

    public One() {
    }
    public One(String name) {
        this.name = name;
    }

    public String toString() {
        return ToStringBuilder
                .reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
