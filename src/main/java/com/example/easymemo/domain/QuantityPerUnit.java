package com.example.easymemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author erfan
 * @since 2/6/23
 */
@Data
@NoArgsConstructor
@Table
@Entity
public class QuantityPerUnit extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    @Column
    private int amount;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id")
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "unit_id")
    private Unit unit;
}
