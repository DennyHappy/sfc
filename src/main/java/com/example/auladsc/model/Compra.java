package com.example.auladsc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//Anotações JPA
@Entity
@Table(name="TB_COMPRA")
//Anotações Lombok
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Embeddable
@Builder
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private double valor;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private LocalDate data;

    @NotBlank
    @Column(nullable = false)
    private String notaFiscal;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_loja")
    private Loja loja;
}