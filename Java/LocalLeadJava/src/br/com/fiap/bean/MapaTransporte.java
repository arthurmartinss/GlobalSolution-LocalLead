package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class MapaTransporte {

    // Atributos
    private String regiao;
    private int quantidadeEstacoes;
    private int quantidadeLinhas;

    // Construtor vazio
    public MapaTransporte() {
    }

    // Construtor com passagem de parâmetros
    public MapaTransporte(String regiao, int quantidadeEstacoes, int quantidadeLinhas) {
        setRegiao(regiao);
        setQuantidadeEstacoes(quantidadeEstacoes);
        setQuantidadeLinhas(quantidadeLinhas);
    }

    // Getters e Setters
    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public int getQuantidadeEstacoes() {
        return quantidadeEstacoes;
    }

    public void setQuantidadeEstacoes(int quantidadeEstacoes) {
        try {
            if (quantidadeEstacoes > 0) {
                this.quantidadeEstacoes = quantidadeEstacoes;
            } else {
                throw new Exception("A quantidade de estações deve ser maior que zero.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int getQuantidadeLinhas() {
        return quantidadeLinhas;
    }

    public void setQuantidadeLinhas(int quantidadeLinhas) {
        try {
            if (quantidadeLinhas > 0) {
                this.quantidadeLinhas = quantidadeLinhas;
            } else {
                throw new Exception("A quantidade de linhas deve ser maior que zero.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Métodos da classe
    public String exibirMapa() {
        return String.format(
                "Mapa de Transporte LocalLead\n\nRegião monitorada: %s\nQuantidade de linhas monitoradas: %d\nQuantidade de estações principais: %d\n\nRecorte do MVP:\nLinha 11-Coral: Luz até Estudantes\nLinha 12-Safira: Brás até Calmon Viana\n\nO mapa apresenta apenas as linhas usadas no protótipo inicial da LocalLead.",
                regiao,
                quantidadeLinhas,
                quantidadeEstacoes
        );
    }
}