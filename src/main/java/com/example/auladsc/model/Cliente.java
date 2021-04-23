package com.example.auladsc.model;

import lombok.*;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//Anotações JPA
@Entity
@Table(name="TB_CLIENTE")

//Anotações Lombok
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Embeddable
@Builder(toBuilder = true)

public class Cliente {
    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private int moedas;

    @ElementCollection
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private List<Compra> compras;

    @ElementCollection
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private List<Cupom> cupons;
}