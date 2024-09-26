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
public class Company extends Persistent {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companySeq")
    @SequenceGenerator(name = "companySeq", sequenceName = "company_seq", allocationSize = 1)
    private int id;

    @Column(nullable = false)
    private String name;
}
