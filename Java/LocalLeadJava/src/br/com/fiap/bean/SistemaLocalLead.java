package br.com.fiap.bean;

public class SistemaLocalLead {

    //atributos
    private String nomeSistema;
    private float versao;
    private String cidadeBase;
    private Clima clima;
    private Previsao previsao;
    private Lotacao lotacao;
    private MapaTransporte mapaTransporte;

    //construtores
    public SistemaLocalLead() {
    }

    public SistemaLocalLead(String nomeSistema, float versao, String cidadeBase, Clima clima, Previsao previsao, Lotacao lotacao, MapaTransporte mapaTransporte) {
        this.nomeSistema = nomeSistema;
        this.versao = versao;
        this.cidadeBase = cidadeBase;
        this.clima = clima;
        this.previsao = previsao;
        this.lotacao = lotacao;
        this.mapaTransporte = mapaTransporte;
    }

    //getters e setters
    public String getNomeSistema() {
        return nomeSistema;
    }
    public void setNomeSistema(String nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    public float getVersao() {
        return versao;
    }
    public void setVersao(float versao) {
        this.versao = versao;
    }

    public String getCidadeBase() {
        return cidadeBase;
    }
    public void setCidadeBase(String cidadeBase) {
        this.cidadeBase = cidadeBase;
    }

    public Clima getClima() {
        return clima;
    }
    public void setClima(Clima clima) {
        this.clima = clima;
    }

    public Previsao getPrevisao() {
        return previsao;
    }
    public void setPrevisao(Previsao previsao) {
        this.previsao = previsao;
    }

    public Lotacao getLotacao() {
        return lotacao;
    }
    public void setLotacao(Lotacao lotacao) {
        this.lotacao = lotacao;
    }

    public MapaTransporte getMapaTransporte() {
        return mapaTransporte;
    }
    public void setMapaTransporte(MapaTransporte mapaTransporte) {
        this.mapaTransporte = mapaTransporte;
    }

    //métodos da classe

    public String iniciarSistema() {
        return String.format(
                "Sistema %s iniciado.\nVersão: %.1f\nCidade base: %s\n\nO LocalLead auxilia o usuário na consulta de clima, previsão, lotação, estações e linhas monitoradas.",
                nomeSistema,
                versao,
                cidadeBase
        );
    }

    public String consultarEstacao(Estacao estacao) {
        return String.format(
                "Consulta de estação LocalLead\n\n%s",
                estacao.mostrarLocalizacao()
        );
    }

    public String consultarClima() {
        if (clima == null) {
            return "Clima não configurado no sistema.";
        }

        String analisePrevisao;

        if (previsao != null && previsao.temRiscoDeChuva()) {
            analisePrevisao = "A previsão indica risco de chuva. O usuário deve considerar sair com antecedência.";
        } else {
            analisePrevisao = "A previsão não indica risco elevado de chuva para o deslocamento.";
        }

        String recomendacao;

        if (clima.estaChovendo()) {
            recomendacao = "Recomendação LocalLead: atenção ao deslocamento, pois a chuva pode aumentar o tempo de espera e a lotação nas estações.";
        } else {
            recomendacao = "Recomendação LocalLead: o clima não apresenta impacto crítico para a viagem neste momento.";
        }

        return String.format(
                "Consulta climática LocalLead\n\n%s\n\nImpacto no transporte:\n%s\n\nAnálise da previsão:\n%s\n\n%s",
                clima.mostrarClima(),
                clima.avaliarImpacto(),
                analisePrevisao,
                recomendacao
        );
    }

    public String consultarLotacao(Estacao estacao) {
        if (lotacao == null) {
            return "Lotação não configurada no sistema.";
        }

        String recomendacao;

        if (lotacao.estaCheia()) {
            recomendacao = "Recomendação LocalLead: evite esse horário se possível ou embarque com antecedência, pois há risco de superlotação.";
        } else if (clima != null && clima.estaChovendo()) {
            recomendacao = "Recomendação LocalLead: mesmo sem lotação crítica, a chuva pode aumentar o fluxo de passageiros na estação.";
        } else {
            recomendacao = "Recomendação LocalLead: a viagem está dentro de um nível aceitável de conforto.";
        }

        return String.format(
                "Consulta de lotação para a estação %s\n\n%s\n\n%s",
                estacao.getNome(),
                lotacao.mostrarLotacao(),
                recomendacao
        );
    }

    public String exibirMapa() {
        if (mapaTransporte == null) {
            return "Mapa de transporte não configurado no sistema.";
        }

        return String.format(
                "Consulta de mapa LocalLead\n\n%s",
                mapaTransporte.exibirMapa()
        );
    }
}