import requests
import random
from datetime import datetime



def cadastrar_usuario(): 
    """
    Finalidade: Solicitar o nome de usuário via terminal e exibir uma mensagem de boas-vindas.
    Parâmetros: Nenhum.
    Retorno: 
        - nome (str): O nome digitado pelo usuário para personalização das próximas mensagens.
    """
    nome = input('Bem-vindo ao LocalLead! Digite seu nome de usuário: ')
    print(f'Olá, {nome}! Seja bem-vindo!')
    return nome

def ver_linhas(linhas): 
   """
    Finalidade: Exibir na tela, de forma formatada e organizada, as linhas de transporte ativas no sistema.
    Parâmetros: 
        - linhas (tupla): Coleção contendo os nomes das linhas disponíveis.
    Retorno: 
        - linhas (tupla): A própria coleção recebida para manter o fluxo de dados ativo.
    """
   print('========= LINHAS ATIVAS =========')
    
   for linha in linhas:
     print(f'         {linha}      ')
   print('=================================')
   return linhas


def linhas_disponiveis(): 
    """
    Finalidade: Retornar as linhas de trem atendidas pelo sistema LocalLead.
    Parâmetros: Nenhum.
    Retorno: 
        - linhas (tupla): Uma tupla contendo os nomes das linhas ativas ('Linha 11-Coral', 'Linha 12-Safira').
    """
    linhas = ('Linha 11-Coral', 'Linha 12-Safira')
    return linhas


def obter_clima_real(linhas, nome):  
    """
    Finalidade: Consumir a API OpenWeather para obter dados meteorológicos em tempo real de São Paulo,
                exibir a temperatura/clima atual e avaliar o nível de risco operacional para a linha selecionada.
    Parâmetros: 
        - linhas (tupla): Tupla contendo a listagem das linhas disponíveis no sistema.
        - nome (str): Nome do usuário logado para personalização das mensagens.
    Retorno: 
        - descricao (str): A condição textual do clima retornada pela API (ex: "céu limpo").
        - temperatura (float): A temperatura atual em graus Celsius.
    """
    print('\n===== CLIMA EM TEMPO REAL =====')
    print(' ---- Linhas Disponiveis: ----')
    for i in range(len(linhas)):
        print(f'      {i + 1} - {linhas[i]}        ')
    print('================================')
    
    escolha_clima = 0
    while escolha_clima != 1 and escolha_clima != 2:
        entrada = input('Digite qual linha você gostaria de ver o clima: ')
        if entrada in ['1', '2']:
            escolha_clima = int(entrada)
        else:
            escolha_clima = 0
            print('Opção inválida! Digite 1 ou 2.')
    
    resposta = requests.get('https://api.openweathermap.org/data/2.5/weather?q=Sao Paulo&appid=dff81c6af5d3da962d80e6c826916d18&units=metric&lang=pt_br')
    dados = resposta.json()
    descricao = dados['weather'][0]['description']
    temperatura = dados['main']['temp']
    print(f'Clima em São Paulo: {descricao}')
    print(f'Temperatura: {temperatura}° C')

    hora = datetime.now().hour
    if hora >= 5 and hora < 12:
       saudacao = 'Bom dia'
    elif hora >= 12 and hora < 18:
        saudacao = 'Boa Tarde'
    else:
        saudacao = 'Boa noite'

    if 'céu limpo' in descricao or 'nuvens dispersas' in descricao or 'algumas nuvens' in descricao or 'nuvens fragmentadas' in descricao or 'céu claro' in descricao or 'parcialmente nublado' in descricao:
        print('Status do Risco: Baixo')
        print(f'\n{saudacao}, {nome}! Está {descricao} em São Paulo agora. O risco do clima é baixo, na condição ideal para viajar! Desejamos uma boa viagem!!')
    elif 'chuva leve' in descricao or 'garoa' in descricao or 'nublado' in descricao or 'encoberto' in descricao or 'chuva fraca' in descricao or 'chuvisco' in descricao or 'névoa' in descricao or 'neblina' in descricao:
        print('Status do Risco: Médio')
        print(f'\n{saudacao}, {nome}! Está {descricao} em São Paulo agora. O risco do clima é medio, então fique atento a possíveis mudanças de clima e a possíveis redções na velocidade do trem nas linhas! Desejamos uma boa viagem!')
    elif 'chuva forte' in descricao or 'chuva intensa' in descricao or 'tempestade' in descricao or 'granizo' in descricao or 'vendaval' in descricao or 'chuva torrencial' in descricao:
        print('Status do Risco: Alto!')
        print(f'\n{saudacao}, {nome}! Estamos tendo {descricao} em São Paulo agora. O risco do clima é alto! Há a possibilidade de atrasos e interrupções nas linhas. Tome cuidado e uma boa viagem!')
    else:
        print('Status do Risco: Indefinido')
        print(f'{saudacao}, {nome}! Não foi possível determinar o risco para {descricao}.')

    return descricao, temperatura


def verificar_vagoes(linhas): 
    """
    Finalidade: Simular e analisar a ocupação percentual de 8 vagões de uma linha escolhida,
                identificando e recomendando o vagão mais vazio para o usuário.
    Parâmetros: 
        - linhas (tupla): Coleção contendo as linhas operadas no sistema.
    Retorno: 
        - vagoes (lista): Matriz contendo o número do vagão e seu respectivo nível de ocupação.
        - mais_vazio (lista): Lista com o ID e o menor percentual de ocupação encontrado.
    """
    print('\n================ VERIFICAÇÃO DE VAGÕES ================')
    print('Linhas diponiveis:')
    
    for i in range(len(linhas)):
   
        print(f'               {i + 1} - {linhas[i]}                ')
    print('===========================================================')
    escolher_vagao = 0
    while escolher_vagao != 1 and escolher_vagao != 2:
        entrada = input('Digite o número da linha para verificar os vagões disponíveis: ')
        if entrada in ['1', '2']:
            escolher_vagao = int(entrada)
        else:
            escolher_vagao = 0
            print('Opção inválida! Digite 1 ou 2.')
    vagoes = []
    for i in range(8):
         ocupacao = random.randint(0, 100)
         pessoas = random.randint(0, 300)
         vagoes.append([i + 1, ocupacao , pessoas])

         print(f'Vagão {vagoes[i][0]}: {vagoes[i][1]}% de ocupação | O vagão tem {vagoes[i][2]} pessoas')

    mais_vazio = vagoes[0]
    for vagao in vagoes:
         if vagao[1] < mais_vazio[1]:
          mais_vazio = vagao

    print(f'Vagão mais vazio: Vagão {mais_vazio[0]} com {mais_vazio[1]}% de ocupação')
    print('======================================================')
    return vagoes, mais_vazio


def gerar_relatorio(linhas, descricao, temperatura): 
    """
    Finalidade: Exibir um relatório geral contendo o ID das linhas do sistema 
                junto com as últimas informações climáticas salvas em memória
    Parâmetros: 
        - linhas (tupla): Linhas ativas do sistema
        - descricao (str): Última descrição do clima registrada
        - temperatura (float): Última temperatura registrada
    Retorno: Nenhum (Procedimento de exibição)
    """
    print('\n================ RELATÓRIO GERAL ================')
    for i in range(len(linhas)):
        print(f'ID: {i + 1} | Linha: {linhas[i]}')
    print(f'Clima atual em SP: {descricao} | Temperatura: {temperatura} °C')
    print('=================================================')


def menu(): 
    """
    Finalidade: Gerenciar o fluxo principal do programa, exibindo as opções do sistema,
                capturando a escolha do usuário e direcionando para as funções correspondentes.
    Parâmetros: Nenhum.
    Retorno: Nenhum.
    """

    nome = cadastrar_usuario()
    lista_linhas = linhas_disponiveis()
    ultimo_clima = 'Indefinido'
    ultima_temperatura = 0
    escolha = -1

    while escolha != 0:
        print(f'\n ========= LocalLead - Olá, {nome}! ======== ')
        print('       1 - Ver linhas              ')
        print('       2 - Ver o clima em tempo real')
        print('       3 - Verificar Vagões         ')
        print('       4 - Gerar Relatório          ')
        print('       5 - Sobre o nosso projeto    ')
        print('       0 - Sair do sistema          ')
        print('  ===================================')

        entrada = input('Escolha uma opção: ')
        if entrada in ['0', '1', '2', '3', '4', '5']:
            escolha = int(entrada)
        else:
            escolha = -1
        match escolha:
            case 1:
                ver_linhas(lista_linhas)
            case 2:
                ultimo_clima, ultima_temperatura = obter_clima_real(lista_linhas, nome)
            case 3:
                verificar_vagoes(lista_linhas)
            case 4:
                gerar_relatorio(lista_linhas, ultimo_clima, ultima_temperatura)
            case 5:
                 print('\n       ======= Sobre o Projeto =======')
                 print('A LocalLead é uma inovação orbital conectada ao seu cotidiano!')
                 print('Uma plataforma que antecipa os impactos climaticos e')
                 print('a superlotação antes mesmo que eles aconteçam,')
                 print('reduzindo o tempo perdido nas grandes cidades e')
                 print('gerando bem-estar através da tecnologia preditiva.')
                 print('====================================================')

            case 0:
                print('Saindo do sistema... Até logo!')
                return
            case _:
                print('Opção inválida! Tente novamente.')   



menu()