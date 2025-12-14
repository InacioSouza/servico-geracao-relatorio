package br.com.servico.report_generator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "versao_relatorio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VersaoRelatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome_arquivo")
    private String nomeArquivo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "relatorio_id")
    private Relatorio relatorio;

    @Column(name = "descricao_versao")
    private String descricaoVersao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_arquivo")
    private TipoArquivoEnum tipoArquivo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_final_relatorio")
    private TipoArquivoEnum tipoFinalRelatorio;

    @Column(name = "arquivo_compilado")
    private byte[] arquivoCompilado;

    @Column(name = "arquivo_original")
    private byte[] arquivoOriginal;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    private Integer versao;

}
