package com.bahar.review.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass // 1st strategy for inheritance
public abstract class BaseEntity<T extends Serializable> {//version1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
