package br.com.fiap.main;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import br.com.fiap.bean.Clima;
import br.com.fiap.bean.Estacao;
import br.com.fiap.bean.Intervalo;
import br.com.fiap.bean.LinhaCptm;
import br.com.fiap.bean.Lotacao;
import br.com.fiap.bean.MapaTransporte;
import br.com.fiap.bean.Previsao;
import br.com.fiap.bean.SistemaLocalLead;
import br.com.fiap.bean.StatusLinha;

public class Main {

    public static void main(String[] args) {

        int opcao;
        int codigoLinha;
        String nomeLinha;
        String corLinha;
        String sentido;
        String nomeEstacao;
        String municipio;
        String condicao;
        float temperatura;

        try {
            codigoLinha = Integer.parseInt(JOptionPane.showInputDialog(
                    "Digite o código da linha:\n11 - Coral\n12 - Safira"
            ));

            if (codigoLinha == 11) {
                nomeLinha = "Coral";
                corLinha = "Coral";

                sentido = JOptionPane.showInputDialog(
                        "Digite o sentido da Linha 11-Coral:\nLuz\nEstudantes"
                );

            } else if (codigoLinha == 12) {
                nomeLinha = "Safira";
                corLinha = "Safira";

                sentido = JOptionPane.showInputDialog(
                        "Digite o sentido da Linha 12-Safira:\nBrás\nCalmon Viana"
                );

            } else {
                nomeLinha = "Linha não monitorada";
                corLinha = "Não definida";
                sentido = "Não definido";

                JOptionPane.showMessageDialog(
                        null,
                        "Linha não monitorada pelo LocalLead.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE
                );
            }

            LinhaCptm linha = new LinhaCptm(codigoLinha, nomeLinha, corLinha, sentido);

            Previsao previsao = new Previsao();
            Lotacao lotacao = new Lotacao();
            MapaTransporte mapa = new MapaTransporte("Região Metropolitana de São Paulo", 4, 2);

            SistemaLocalLead sistema = new SistemaLocalLead(
                    "LocalLead",
                    1.0f,
                    "São Paulo",
                    null,
                    previsao,
                    lotacao,
                    mapa
            );

            StatusLinha statusLinha = new StatusLinha();
            statusLinha.setFonte("Entrada operacional simulada");
            statusLinha.setLinha(linha);

            Intervalo intervalo = new Intervalo(LocalDate.now(), "Tabela CPTM - dias úteis", linha);

            JOptionPane.showMessageDialog(
                    null,
                    sistema.iniciarSistema(),
                    "LocalLead",
                    JOptionPane.INFORMATION_MESSAGE
            );

            do {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(
                        "LocalLead - Menu Principal\n\n" +
                                "1 - Consultar linha\n" +
                                "2 - Consultar estação\n" +
                                "3 - Consultar clima\n" +
                                "4 - Consultar previsão\n" +
                                "5 - Consultar lotação\n" +
                                "6 - Consultar status da linha\n" +
                                "7 - Consultar intervalo dos trens\n" +
                                "8 - Exibir mapa\n" +
                                "9 - Encerrar\n\n" +
                                "Digite a opção desejada:"
                ));

                switch (opcao) {
                    case 1:
                        JOptionPane.showMessageDialog(
                                null,
                                linha.mostrarLinha(),
                                "Linha CPTM",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        break;

                    case 2:
                        nomeEstacao = JOptionPane.showInputDialog("Digite o nome da estação:");

                        municipio = "Região Metropolitana de São Paulo";

                        Estacao estacaoConsulta = new Estacao(nomeEstacao, municipio, linha);

                        JOptionPane.showMessageDialog(
                                null,
                                sistema.consultarEstacao(estacaoConsulta),
                                "Consulta de estação",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        break;

                    case 3:
                        condicao = JOptionPane.showInputDialog(
                                "Digite a condição climática:\nchuva\nnublado\nsol"
                        );

                        temperatura = Float.parseFloat(JOptionPane.showInputDialog(
                                "Digite a temperatura atual:"
                        ));

                        Clima clima = new Clima("São Paulo", temperatura, condicao);

                        sistema.setClima(clima);

                        previsao.mostrarPrevisao();

                        JOptionPane.showMessageDialog(
                                null,
                                sistema.consultarClima(),
                                "Consulta climática",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        break;

                    case 4:
                        JOptionPane.showMessageDialog(
                                null,
                                previsao.mostrarPrevisao(),
                                "Previsão",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        break;

                    case 5:
                        nomeEstacao = JOptionPane.showInputDialog("Digite o nome da estação:");

                        municipio = "Região Metropolitana de São Paulo";

                        Estacao estacaoLotacao = new Estacao(nomeEstacao, municipio, linha);

                        JOptionPane.showMessageDialog(
                                null,
                                sistema.consultarLotacao(estacaoLotacao),
                                "Lotação",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        break;

                    case 6:
                        String situacao = JOptionPane.showInputDialog(
                                "Digite a situação da linha:\nNormal\nReduzida\nParalisada\nOperação encerrada"
                        );

                        statusLinha.atualizarStatus(situacao);

                        JOptionPane.showMessageDialog(
                                null,
                                statusLinha.mostrarStatus(),
                                "Status da linha",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        break;

                    case 7:
                        JOptionPane.showMessageDialog(
                                null,
                                intervalo.mostrarIntervalo(),
                                "Intervalo dos trens",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        break;

                    case 8:
                        JOptionPane.showMessageDialog(
                                null,
                                sistema.exibirMapa(),
                                "Mapa LocalLead",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        break;

                    case 9:
                        break;

                    default:
                        throw new Exception("Opção inválida.");
                }

            } while (opcao != 9 && JOptionPane.showConfirmDialog(
                    null,
                    "Deseja continuar?",
                    "Atenção",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            ) == 0);

            JOptionPane.showMessageDialog(
                    null,
                    "Fim de programa. Volte sempre!",
                    "LocalLead",
                    JOptionPane.WARNING_MESSAGE
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}