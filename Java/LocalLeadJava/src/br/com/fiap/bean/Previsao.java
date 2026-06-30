package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Previsao {

    // Atributos
    private LocalDate data;
    private float temperaturaMinima;
    private float temperaturaMaxima;
    private float chanceChuva;

    // Construtor vazio
    public Previsao() {
    }

    // Construtor com passagem de parâmetros
    public Previsao(LocalDate data, float temperaturaMinima, float temperaturaMaxima, float chanceChuva) {
        setData(data);
        setTemperaturaMinima(temperaturaMinima);
        setTemperaturaMaxima(temperaturaMaxima);
        setChanceChuva(chanceChuva);
    }

    // Getters e Setters
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(float temperaturaMinima) {
        try {
            if (temperaturaMinima >= -10 && temperaturaMinima <= 45) {
                this.temperaturaMinima = temperaturaMinima;
            } else {
                throw new Exception("A temperatura mínima deve estar entre -10 e 45 graus.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public float getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(float temperaturaMaxima) {
        try {
            if (temperaturaMaxima >= -10 && temperaturaMaxima <= 45) {
                this.temperaturaMaxima = temperaturaMaxima;
            } else {
                throw new Exception("A temperatura máxima deve estar entre -10 e 45 graus.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public float getChanceChuva() {
        return chanceChuva;
    }

    public void setChanceChuva(float chanceChuva) {
        try {
            if (chanceChuva >= 0 && chanceChuva <= 100) {
                this.chanceChuva = chanceChuva;
            } else {
                throw new Exception("A chance de chuva deve estar entre 0 e 100.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Métodos da classe
    public float calcularMediaTemperatura() {
        return (temperaturaMinima + temperaturaMaxima) / 2;
    }

    public boolean temRiscoDeChuva() {
        if (chanceChuva >= 60) {
            return true;
        } else {
            return false;
        }
    }

    public String mostrarPrevisao() {
        data = LocalDate.now();

        int mes = data.getMonthValue();
        String periodo;

        if (mes == 12 || mes == 1 || mes == 2 || mes == 3) {
            periodo = "Período de calor e maior chance de chuva";
            setTemperaturaMinima(20);
            setTemperaturaMaxima(31);
            setChanceChuva(70);
        } else if (mes == 4 || mes == 5) {
            periodo = "Período de temperatura moderada";
            setTemperaturaMinima(17);
            setTemperaturaMaxima(27);
            setChanceChuva(45);
        } else if (mes == 6 || mes == 7 || mes == 8) {
            periodo = "Período mais frio e com menor chance de chuva";
            setTemperaturaMinima(13);
            setTemperaturaMaxima(24);
            setChanceChuva(30);
        } else {
            periodo = "Período de transição climática";
            setTemperaturaMinima(16);
            setTemperaturaMaxima(28);
            setChanceChuva(55);
        }

        return String.format(
                "Previsão estimada\n\nData: %s\nPeríodo: %s\nTemperatura mínima: %.1f graus\nTemperatura máxima: %.1f graus\nTemperatura média: %.1f graus\nChance de chuva: %.1f%%\nRisco de chuva: %s",
                data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                periodo,
                temperaturaMinima,
                temperaturaMaxima,
                calcularMediaTemperatura(),
                chanceChuva,
                temRiscoDeChuva() ? "Sim" : "Não"
        );
    }
}