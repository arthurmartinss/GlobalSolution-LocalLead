package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Intervalo extends InformacaoTransporte {

    // Atributos
    private LinhaCptm linha;
    private LocalTime horarioAtual;
    private float intervaloMinutos;

    // Construtor vazio
    public Intervalo() {
    }

    // Construtor com passagem de parâmetros
    public Intervalo(LocalDate atualizadoEm, String fonte, LinhaCptm linha) {
        super(atualizadoEm, fonte);
        setLinha(linha);
    }

    // Getters e Setters
    public LinhaCptm getLinha() {
        return linha;
    }

    public void setLinha(LinhaCptm linha) {
        this.linha = linha;
    }

    public LocalTime getHorarioAtual() {
        return horarioAtual;
    }

    public void setHorarioAtual(LocalTime horarioAtual) {
        this.horarioAtual = horarioAtual;
    }

    public float getIntervaloMinutos() {
        return intervaloMinutos;
    }

    public void setIntervaloMinutos(float intervaloMinutos) {
        this.intervaloMinutos = intervaloMinutos;
    }

    // Métodos da classe
    public void calcularIntervaloAtual() {
        horarioAtual = LocalTime.now().plusMinutes(1);
        atualizarInformacao();

        if (linha.getCodigo() == 11) {
            intervaloMinutos = 15;

            if (horarioAtual.isAfter(LocalTime.of(4, 0).minusMinutes(1)) && horarioAtual.isBefore(LocalTime.of(8, 0))) {
                intervaloMinutos = 7;

            } else if (horarioAtual.isAfter(LocalTime.of(8, 0).minusMinutes(1)) && horarioAtual.isBefore(LocalTime.of(15, 30))) {
                intervaloMinutos = 11;

            } else if (horarioAtual.isAfter(LocalTime.of(15, 30).minusMinutes(1)) && horarioAtual.isBefore(LocalTime.of(20, 0))) {
                intervaloMinutos = 7;

            } else if (horarioAtual.isAfter(LocalTime.of(20, 0).minusMinutes(1)) && horarioAtual.isBefore(LocalTime.of(23, 30))) {
                intervaloMinutos = 8;

            } else if (horarioAtual.isAfter(LocalTime.of(23, 30).minusMinutes(1)) && horarioAtual.isBefore(LocalTime.of(23, 59).plusMinutes(1))) {
                intervaloMinutos = 15;
            }

        } else if (linha.getCodigo() == 12) {
            intervaloMinutos = 10;

            if (horarioAtual.isAfter(LocalTime.of(4, 0).minusMinutes(1)) && horarioAtual.isBefore(LocalTime.of(4, 30))) {
                intervaloMinutos = 9;

            } else if (horarioAtual.isAfter(LocalTime.of(4, 30).minusMinutes(1)) && horarioAtual.isBefore(LocalTime.of(8, 30))) {
                intervaloMinutos = 4.5f;

            } else if (horarioAtual.isAfter(LocalTime.of(8, 30).minusMinutes(1)) && horarioAtual.isBefore(LocalTime.of(16, 0))) {
                intervaloMinutos = 8;

            } else if (horarioAtual.isAfter(LocalTime.of(16, 0).minusMinutes(1)) && horarioAtual.isBefore(LocalTime.of(20, 0))) {
                intervaloMinutos = 4.5f;

            } else if (horarioAtual.isAfter(LocalTime.of(20, 0).minusMinutes(1)) && horarioAtual.isBefore(LocalTime.of(21, 30))) {
                intervaloMinutos = 8;

            } else if (horarioAtual.isAfter(LocalTime.of(21, 30).minusMinutes(1)) && horarioAtual.isBefore(LocalTime.of(23, 59).plusMinutes(1))) {
                intervaloMinutos = 10;
            }
        }
    }

    public String mostrarIntervalo() {
        calcularIntervaloAtual();

        String horarioFormatado = horarioAtual.format(DateTimeFormatter.ofPattern("HH:mm"));

        return String.format(
                "Consulta de intervalo LocalLead\n\n%s\n\nHorário atual: %s\nIntervalo médio programado entre trens: %.1f minutos\n\n%s",
                linha.mostrarLinha(),
                horarioFormatado,
                intervaloMinutos,
                mostrarFonte()
        );
    }
}