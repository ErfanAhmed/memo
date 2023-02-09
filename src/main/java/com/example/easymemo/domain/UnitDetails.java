package com.example.easymemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author erfan
 * @since 2/8/23
 */
@Data
@NoArgsConstructor
@Table
@Entity
public class UnitDetails extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    @Column
    private int amount;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;
}
