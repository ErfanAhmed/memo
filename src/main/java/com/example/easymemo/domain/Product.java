package com.example.easymemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import static java.util.Objects.nonNull;

/**
 * @author erfan
 * @since 1/12/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
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

    @NotEmpty(message = "{product.name.not.empty}")
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

    public void setQuantityPerUnit(QuantityPerUnit quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;

        if (nonNull(quantityPerUnit)) {
            this.quantityPerUnit.setProduct(this);
        }
    }

    public void setUnitDetails(UnitDetails unitDetails) {
        this.unitDetails = unitDetails;

        if (nonNull(unitDetails)) {
            this.unitDetails.setProduct(this);
        }
    }

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
        return nonNull(unitDetails)
                ? "[" + unitDetails.getAmount() + " " + unitDetails.getUnit().getName() + " per " + unit.getName() + "]"
                : "";
    }

    public String quantityPerUnit() {
        return nonNull(quantityPerUnit)
                ? quantityPerUnit.getAmount() + " " + quantityPerUnit.getUnit().getName() : "";
    }
}
