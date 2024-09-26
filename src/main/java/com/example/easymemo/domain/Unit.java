package com.example.easymemo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author erfan
 * @since 1/30/23
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table
@Entity
public class Unit extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unitSeq")
    @SequenceGenerator(name = "unitSeq", sequenceName = "unit_seq", allocationSize = 1)
    private int id;

    @Column(nullable = false)
    private String name;
}
