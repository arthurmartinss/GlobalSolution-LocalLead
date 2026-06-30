package br.com.fiap.bean;

public class LinhaCptm {

    // Atributos
    private int codigo;
    private String nome;
    private String cor;
    private String sentido;

    // Construtor vazio
    public LinhaCptm() {
    }

    // Construtor com passagem de parâmetros
    public LinhaCptm(int codigo, String nome, String cor, String sentido) {
        setCodigo(codigo);
        setNome(nome);
        setCor(cor);
        setSentido(sentido);
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    // Métodos da classe
    public boolean verificarLinhaPermitida() {
        if (codigo == 11 || codigo == 12) {
            return true;
        } else {
            return false;
        }
    }

    public String mostrarLinha() {
        return String.format(
                "Linha CPTM\nCódigo: %d\nNome: %s\nCor: %s\nSentido: %s",
                codigo,
                nome,
                cor,
                sentido
        );
    }
}