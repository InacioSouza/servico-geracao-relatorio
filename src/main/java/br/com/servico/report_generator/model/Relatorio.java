package br.com.servico.report_generator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="relatorio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;

    private String subtitulo;

    private String nome;

    private String informacao;

    @Column(name = "descricao_tecnica")
    private String descricao_tecnica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sistema_id")
    private Sistema sistema;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    private Integer versao;

}
