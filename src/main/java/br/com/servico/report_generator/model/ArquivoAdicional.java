package br.com.servico.report_generator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "arquivo_adicional")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArquivoAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "versao_relatorio_id")
    private VersaoRelatorio versaoRelatorio;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_arquivo")
    private TipoArquivoEnum tipoArquivo;

    private byte[] arquivoCompilado;

    private byte[] arquivoOriginal;

    private Integer versao;
}
