package com.bms.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass //Whenever we have an inheritance relationship
//Tells JPA, this is a parent entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY means auto-increment in integers.
    private Long id;
    //Special columns
    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;
    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedAt;
}
