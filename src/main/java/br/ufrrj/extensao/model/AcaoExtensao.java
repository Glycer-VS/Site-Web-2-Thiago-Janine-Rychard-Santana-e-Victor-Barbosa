package br.ufrrj.extensao.model;

import java.time.LocalDate;

public class AcaoExtensao {
    private int id;
    private String titulo;
    private String descricao;
    private String responsavel;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String local;
    private String publicoAlvo;
    private boolean possuiTaxa;
    private String linkExterno;
    private String status;

    public AcaoExtensao() {
    }

    public AcaoExtensao(int id, String titulo, String descricao, String responsavel,
            LocalDate dataInicio, LocalDate dataFim, String local,
            String publicoAlvo, boolean possuiTaxa, String linkExterno,
            String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.local = local;
        this.publicoAlvo = publicoAlvo;
        this.possuiTaxa = possuiTaxa;
        this.linkExterno = linkExterno;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public String getLocal() {
        return local;
    }

    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    public boolean isPossuiTaxa() {
        return possuiTaxa;
    }

    public String getLinkExterno() {
        return linkExterno;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "AcaoExtensao{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", status='" + status + '\'' +
                '}';
    }
}
