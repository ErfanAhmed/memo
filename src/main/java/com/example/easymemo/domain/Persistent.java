package com.example.easymemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author erfan
 * @since 1/12/23
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Persistent {

    private Date created;
    private Date updated;
    private int version;
}
