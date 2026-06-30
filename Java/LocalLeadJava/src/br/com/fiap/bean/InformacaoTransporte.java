package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InformacaoTransporte {

    // Atributos
    private LocalDate atualizadoEm;
    private String fonte;

    // Construtor vazio
    public InformacaoTransporte() {
    }

    // Construtor com passagem de parâmetros
    public InformacaoTransporte(LocalDate atualizadoEm, String fonte) {
        setAtualizadoEm(atualizadoEm);
        setFonte(fonte);
    }

    // Getters e Setters
    public LocalDate getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDate atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    // Métodos da classe
    public void atualizarInformacao() {
        this.atualizadoEm = LocalDate.now();
    }

    public String mostrarFonte() {
        return String.format(
                "Informação do transporte\nFonte: %s\nAtualizado em: %s",
                fonte,
                atualizadoEm.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
    }
}