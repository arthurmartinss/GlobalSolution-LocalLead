package br.com.fiap.bean;

public class Estacao {

    // Atributos
    private String nome;
    private String municipio;
    private LinhaCptm linha;

    // Construtor vazio
    public Estacao() {
    }

    // Construtor com passagem de parâmetros
    public Estacao(String nome, String municipio, LinhaCptm linha) {
        setNome(nome);
        setMunicipio(municipio);
        setLinha(linha);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public LinhaCptm getLinha() {
        return linha;
    }

    public void setLinha(LinhaCptm linha) {
        this.linha = linha;
    }

    // Métodos da classe
    public String mostrarLocalizacao() {
        String dadosLinha;

        if (linha != null) {
            dadosLinha = linha.mostrarLinha();
        } else {
            dadosLinha = "Linha não informada.";
        }

        return String.format(
                "Estação: %s\nMunicípio: %s\n\n%s",
                nome,
                municipio,
                dadosLinha
        );
    }
}