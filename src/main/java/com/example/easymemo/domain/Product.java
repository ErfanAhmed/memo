package com.example.easymemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author erfan
 * @since 1/12/23
 */
@Data
@NoArgsConstructor
@Table
@Entity
@NamedQueries(
        @NamedQuery(
                name = "product.getAll",
                query = "FROM Product"
        )
)
public class Product extends Persistent {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeq")
    @SequenceGenerator(name = "productSeq", sequenceName = "product_seq", allocationSize = 1)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;
}
