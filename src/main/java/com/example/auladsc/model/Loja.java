package com.example.auladsc.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

//Anotações JPA
@Entity
@Table(name="TB_LOJA")
//Anotações Lombok
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Embeddable
@Builder
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String cnpj;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String classificacao;

    @ElementCollection
    @OneToMany(mappedBy = "loja", cascade = CascadeType.PERSIST)
    private List<Compra> compras;

    @ElementCollection
    @OneToMany(mappedBy = "loja", cascade = CascadeType.PERSIST)
    private List<Promocao> promocoes;

    public boolean validaCupom(Cupom cupom){
        if (cupom.getPromocao().getData_validade().equals(LocalDate.now())){
            return true;
        }
        if (cupom.getPromocao().getData_validade().isAfter(LocalDate.now())){
            return false;
        }else{
            return true;
        }
    }

}