package com.example.auladsc.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

//Anotações JPA
@Entity
@Table(name="TB_CUPOM")
//Anotações Lombok
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Embeddable
@Builder
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_promocao")
    private Promocao promocao;

    @ManyToOne
    @JoinColumn(nullable = true, name = "id_cliente")
    private Cliente cliente;

}
