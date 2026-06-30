package br.com.fiap.bean;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Lotacao {

    // Atributos
    private float percentual;
    private LocalTime horario;
    private String nivel;

    // Construtor vazio
    public Lotacao() {
        this.horario = LocalTime.now();
    }

    // Construtor com passagem de parâmetros
    public Lotacao(float percentual, LocalTime horario, String nivel) {
        setPercentual(percentual);
        setHorario(horario);
        setNivel(nivel);
    }

    // Getters e Setters
    public float getPercentual() {
        return percentual;
    }

    public void setPercentual(float percentual) {
        try {
            if (percentual >= 0 && percentual <= 100) {
                this.percentual = percentual;
            } else {
                throw new Exception("O percentual de lotação deve estar entre 0 e 100.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        try {
            if (nivel != null && nivel.length() > 0) {
                this.nivel = nivel;
            } else {
                throw new Exception("O nível da lotação não pode ser vazio.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Métodos da classe
    public String classificarLotacao() {
        horario = LocalTime.now().plusMinutes(1);

        if (horario.isAfter(LocalTime.of(4, 0).minusMinutes(1)) && horario.isBefore(LocalTime.of(6, 0))) {
            nivel = "Baixa";
            percentual = 30;

        } else if (horario.isAfter(LocalTime.of(6, 0).minusMinutes(1)) && horario.isBefore(LocalTime.of(8, 30))) {
            nivel = "Alta";
            percentual = 85;

        } else if (horario.isAfter(LocalTime.of(8, 30).minusMinutes(1)) && horario.isBefore(LocalTime.of(17, 0))) {
            nivel = "Baixa";
            percentual = 35;

        } else if (horario.isAfter(LocalTime.of(17, 0).minusMinutes(1)) && horario.isBefore(LocalTime.of(20, 30))) {
            nivel = "Alta";
            percentual = 90;

        } else if (horario.isAfter(LocalTime.of(20, 30).minusMinutes(1)) && horario.isBefore(LocalTime.of(23, 58).plusMinutes(1))) {
            nivel = "Baixa";
            percentual = 30;

        } else {
            nivel = "Fora do horário analisado";
            percentual = 0;
        }

        return nivel;
    }

    public boolean estaCheia() {
        if (classificarLotacao().equalsIgnoreCase("Alta")) {
            return true;
        } else {
            return false;
        }
    }

    public String mostrarLotacao() {
        classificarLotacao();

        String horarioFormatado = horario.format(DateTimeFormatter.ofPattern("HH:mm"));

        String recomendacao;

        if (estaCheia()) {
            recomendacao = "Atenção: horário de alta lotação. Recomenda-se sair com antecedência.";
        } else if (nivel.equalsIgnoreCase("Baixa")) {
            recomendacao = "Lotação baixa: horário mais tranquilo para realizar a viagem.";
        } else {
            recomendacao = "Horário fora do período analisado pelo sistema.";
        }

        return String.format(
                "Lotação estimada\n\nHorário atual: %s\nPercentual estimado: %.1f%%\nNível de lotação: %s\n\n%s",
                horarioFormatado,
                percentual,
                nivel,
                recomendacao
        );
    }
}
