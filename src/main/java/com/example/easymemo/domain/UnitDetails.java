package com.example.easymemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author erfan
 * @since 2/8/23
 *
 * i.e. Tissue 20 box; each box contains 30 pcs tissue.
 * Here, 30 pcs is the UniteDetails of BOX.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
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
