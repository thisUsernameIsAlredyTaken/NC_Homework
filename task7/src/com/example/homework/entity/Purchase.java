package com.example.homework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.DateType;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;

    @NonNull
    @Column(nullable = false)
    private DateType date;

    @NonNull
    @ManyToOne(optional = false)
    private Store seller;

    @NonNull
    @ManyToOne(optional = false)
    private Customer buyer;

    @NonNull
    @ManyToOne(optional = false)
    private Book book;

    @NonNull
    private int amount;

    @NonNull
    private double cost;
}
