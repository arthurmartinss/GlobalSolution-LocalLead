package br.com.fiap.bean;

import java.time.LocalDate;

public class StatusLinha extends InformacaoTransporte {

    // Atributos
    private LinhaCptm linha;
    private String situacao;
    private String mensagem;

    // Construtor vazio
    public StatusLinha() {
    }

    // Construtor com passagem de parâmetros
    public StatusLinha(LocalDate atualizadoEm, String fonte, LinhaCptm linha, String situacao, String mensagem) {
        super(atualizadoEm, fonte);
        setLinha(linha);
        setSituacao(situacao);
        setMensagem(mensagem);
    }

    // Getters e Setters
    public LinhaCptm getLinha() {
        return linha;
    }

    public void setLinha(LinhaCptm linha) {
        this.linha = linha;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    // Métodos da classe
    public void atualizarStatus(String situacao) {
        this.situacao = situacao;
        atualizarInformacao();

        if (situacao.equalsIgnoreCase("Normal")) {
            mensagem = "Linha operando normalmente.";
        } else if (situacao.equalsIgnoreCase("Reduzida")) {
            mensagem = "Linha operando com velocidade reduzida.";
        } else if (situacao.equalsIgnoreCase("Paralisada")) {
            mensagem = "Linha paralisada no momento.";
        } else if (situacao.equalsIgnoreCase("Operação encerrada")) {
            mensagem = "Operação encerrada no momento.";
        } else {
            mensagem = "Situação operacional não identificada.";
        }
    }

    public boolean estaOperando() {
        if (situacao.equalsIgnoreCase("Normal") || situacao.equalsIgnoreCase("Reduzida")) {
            return true;
        } else {
            return false;
        }
    }

    public String mostrarStatus() {
        String operando;

        if (estaOperando()) {
            operando = "Sim";
        } else {
            operando = "Não";
        }

        return String.format(
                "Status da linha\n\n%s\n\nSituação: %s\nMensagem: %s\nLinha em operação: %s\n\n%s",
                linha.mostrarLinha(),
                situacao,
                mensagem,
                operando,
                mostrarFonte()
        );
    }
}