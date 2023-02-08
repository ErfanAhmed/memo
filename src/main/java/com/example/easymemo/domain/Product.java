package com.example.easymemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author erfan
 * @since 1/12/23
 */
@Data
@NoArgsConstructor
@Table
@Entity
@NamedQueries(
        @NamedQuery(name = "product.getAll", query = "FROM Product")
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
    private Double quantity;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private QuantityPerUnit quantityPerUnit;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UnitDetails unitDetails;

    @JsonIgnore
    public String getProductDetails() {
        return "Product name: " + name
                + " " + quantityPerUnit()
                + "\n Available quantity: " + quantity()
                + unitDetails();
    }

    public String quantity() {
        return quantity + " " + unit.getName();
    }

    public String unitDetails() {
        return Objects.nonNull(unitDetails)
                ? "[" + unitDetails.getAmount() + " " + unitDetails.getUnit().getName() + " per " + unit.getName() + "]"
                : "";
    }

    public String quantityPerUnit() {
        return Objects.nonNull(quantityPerUnit)
                ? quantityPerUnit.getAmount() + " " + quantityPerUnit.getUnit().getName() : "";
    }
}
