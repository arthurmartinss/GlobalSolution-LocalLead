package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Clima {

    // Atributos
    private String cidade;
    private float temperatura;
    private int umidade;
    private String condicao;

    // Construtor vazio
    public Clima() {
    }

    // Construtor com passagem de parâmetros
    public Clima(String cidade, float temperatura, String condicao) {
        setCidade(cidade);
        setTemperatura(temperatura);
        setCondicao(condicao);
    }

    // Getters e Setters
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        try {
            if (temperatura >= -10 && temperatura <= 45) {
                this.temperatura = temperatura;
            } else {
                throw new Exception("A temperatura deve estar entre -10 e 45 graus.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int getUmidade() {
        return umidade;
    }

    public void setUmidade(int umidade) {
        try {
            if (umidade >= 0 && umidade <= 100) {
                this.umidade = umidade;
            } else {
                throw new Exception("A umidade deve estar entre 0 e 100%.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        try {
            if (condicao != null && condicao.length() > 0) {
                this.condicao = condicao;

                if (condicao.equalsIgnoreCase("chuva")) {
                    this.umidade = 85;
                } else if (condicao.equalsIgnoreCase("nublado")) {
                    this.umidade = 70;
                } else if (condicao.equalsIgnoreCase("sol")) {
                    this.umidade = 50;
                } else {
                    throw new Exception("Condição inválida. Use chuva, nublado ou sol.");
                }

            } else {
                throw new Exception("A condição climática não pode ser vazia.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Métodos da classe
    public boolean estaChovendo() {
        if (condicao != null && condicao.equalsIgnoreCase("chuva")) {
            return true;
        } else {
            return false;
        }
    }

    public String avaliarImpacto() {
        if (estaChovendo() && umidade >= 80) {
            return "Alerta: chuva e umidade elevada podem aumentar o fluxo nas estações e causar atrasos.";
        } else if (estaChovendo()) {
            return "Atenção: a chuva pode causar lentidão no deslocamento.";
        } else if (condicao != null && condicao.equalsIgnoreCase("nublado")) {
            return "Atenção: tempo nublado pode indicar instabilidade no deslocamento.";
        } else if (temperatura >= 32) {
            return "Atenção: temperatura elevada pode aumentar o desconforto em vagões cheios.";
        } else {
            return "Clima estável: baixo risco climático para o transporte.";
        }
    }

    public String mostrarClima() {
        return String.format(
                "Cidade: %s\nTemperatura: %.1f graus\nUmidade estimada: %d%%\nCondição: %s",
                cidade,
                temperatura,
                umidade,
                condicao
        );
    }

    public String gerarResumoParaUsuario() {
        String respostaChuva;

        if (estaChovendo()) {
            respostaChuva = "Sim";
        } else {
            respostaChuva = "Não";
        }

        return String.format(
                "%s\n\nAnálise LocalLead:\n%s\n\nEstá chovendo: %s",
                mostrarClima(),
                avaliarImpacto(),
                respostaChuva
        );
    }
}