package me.dio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "tb_account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(nullable = false, unique = true)
    private String agency;

    @Column(nullable = false, precision = 13, scale = 2)
    private BigDecimal balance;

    @Column(name = "additional_limit", nullable = false, precision = 13, scale = 2)
    private BigDecimal limit;
}
