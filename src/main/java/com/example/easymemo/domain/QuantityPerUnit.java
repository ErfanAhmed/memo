package com.example.easymemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author erfan
 * @since 2/6/23
 * <p>
 * i.e. Chilli powder 200gm pack - this 200gm is QuantityPerUnit
 * this is optional
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

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "unit_id")
    private Unit unit;
}
