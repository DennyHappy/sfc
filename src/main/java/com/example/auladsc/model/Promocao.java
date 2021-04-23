package com.example.auladsc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

//Anotações JPA
@Entity
@Table(name="TB_PROMOCAO")
//Anotações Lombok
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Embeddable
@Builder
public class Promocao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String descricao;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private LocalDate data_validade;

    @Column(nullable = false)
    private float valor_desconto;

    @Column(nullable = false)
    private int moedas_necesssarias;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_loja")
    private Loja loja;

    @ElementCollection
    @OneToMany(mappedBy = "promocao", cascade = CascadeType.PERSIST)
    private List<Cupom> cupons;

}
