package com.bahar.review.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Description database table "authority"
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority{// extends BaseEntity {//version1

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private AuthorityEnum name;
}
