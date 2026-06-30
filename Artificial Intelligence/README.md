# 🚇 LocalLead AI — Assistente Inteligente de Mobilidade Urbana

## 📌 Descrição do Projeto

O **LocalLead AI** é um assistente virtual desenvolvido utilizando o **IBM Watson Assistant**, criado para a Global Solution FIAP 2026.

A solução tem como objetivo auxiliar usuários do transporte ferroviário urbano através de previsões inteligentes sobre mobilidade, utilizando conceitos de inteligência artificial, análise climática e inteligência espacial.

Diferentemente dos aplicativos tradicionais, que apenas exibem informações em tempo real, o LocalLead AI busca antecipar possíveis situações que impactam a mobilidade urbana, como:

- Superlotação de linhas e estações;
- Possíveis atrasos operacionais;
- Impactos climáticos no transporte;
- Horários de pico;
- Fluxo urbano previsto.

O projeto está alinhado ao tema **Space Connect**, conectando dados espaciais, inteligência artificial e mobilidade urbana.

---

## 🎯 Objetivo

Transformar a mobilidade urbana de um modelo reativo para um modelo preditivo.

O LocalLead AI permite que passageiros recebam informações antecipadas para melhor planejamento de seus deslocamentos diários.

---

## 🛰️ Tecnologias Utilizadas

- IBM Watson Assistant
- IBM Cloud
- Node-RED
- Telegram
- Speech-to-Text (STT)
- Text-to-Speech (TTS)
- Variáveis de Contexto e Memória

---

## 🧠 Funcionalidades

### 🚇 Consulta de Lotação

Permite consultar o fluxo previsto de passageiros em linhas e estações.

**Exemplos:**

- Como está a Linha Vermelha?
- A estação Sé está lotada?
- Tem muita gente na Linha Azul?

---

### ⚠️ Consulta de Atrasos

Permite verificar possíveis atrasos ou lentidões operacionais.

**Exemplos:**

- Existe atraso na Linha Amarela?
- O metrô está funcionando normalmente?
- Há alguma falha operacional?

---

### 🌧️ Consulta Climática

Permite identificar possíveis impactos climáticos na mobilidade urbana.

**Exemplos:**

- Vai chover hoje?
- Existe risco de enchente?
- A chuva pode afetar o metrô?

---

### 📈 Melhor Horário para Embarque

Sugere horários mais adequados para deslocamentos.

**Exemplos:**

- Qual melhor horário para embarcar?
- Quando o fluxo diminui?
- Que horas fica mais tranquilo?

---

### 🔮 Previsão Urbana

Utiliza conceitos de IA preditiva para antecipar situações futuras.

**Exemplos:**

- Como estará o metrô mais tarde?
- Vai ter superlotação hoje?
- Existe previsão de lentidão?
- O movimento vai aumentar?

---

## 💬 Exemplos de Conversação

### Consulta de Lotação

**Usuário:**

> Como está a Linha Vermelha?

**LocalLead AI:**

> ⚠️ A Linha Vermelha apresenta fluxo intenso previsto para os próximos 40 minutos.

---

### Consulta Climática

**Usuário:**

> Vai chover hoje?

**LocalLead AI:**

> 🌧️ Há risco de impactos operacionais devido às condições climáticas previstas.

---

### Consulta de Atrasos

**Usuário:**

> Existe atraso na Linha Azul?

**LocalLead AI:**

> 🚇 Há risco moderado de lentidão operacional nas próximas horas.

---

### Consulta de Melhor Horário

**Usuário:**

> Qual melhor horário para embarcar?

**LocalLead AI:**

> 📈 Melhor horário previsto entre 18h10 e 18h25.

---

### Consulta de Previsão Urbana

**Usuário:**

> Como estará o metrô mais tarde?

**LocalLead AI:**

> 🔮 Com base na análise climática e padrões históricos de mobilidade, há previsão de aumento de demanda nas próximas horas.

---

## 💾 Contexto e Memória

O LocalLead AI utiliza variáveis de contexto do IBM Watson Assistant para armazenar informações fornecidas durante a conversa.

Exemplo:

```text
Usuário: Como está a Linha Azul?

Variável armazenada:
linha_usuario = Linha Azul
```

Essas variáveis permitem que o assistente mantenha o contexto e forneça respostas mais naturais e personalizadas.

---

## 🏗️ Estrutura do Assistente

### Intents

```text
#saudacao
#consultar_lotacao
#consultar_atrasos
#consultar_clima
#consultar_horario
#consultar_previsao
```

### Entities

```text
@clima
@estacao
@linha
@nivel_risco
@periodo
@problema
```

---

## 🔄 Dialog

```text
Bem-vindo
    ↓
Lotação linha
    ↓
Lotação estação
    ↓
Clima
    ↓
Atrasos
    ↓
Melhor horário
    ↓
Fallback
    ↓
Em outros casos
```

---

## 📱 Integrações

O LocalLead AI pode ser integrado com:

- IBM Watson Assistant
- Telegram
- Node-RED
- Speech-to-Text (STT)
- Text-to-Speech (TTS)

---

## 🌎 Conexão com o Tema Space Connect

O projeto utiliza conceitos de inteligência espacial e análise preditiva para transformar a mobilidade urbana.

Principais pilares da solução:

- 🛰️ Monitoramento climático e urbano
- 🤖 Inteligência Artificial preditiva
- 🚇 Mobilidade urbana inteligente
- 📡 Conectividade em tempo real
- 🌍 Análise de dados para tomada de decisão

A proposta busca transformar a mobilidade urbana em um sistema mais eficiente, previsível e conectado.

---

## 👥 Integrantes

<table>
  <thead>
    <tr>
      <th>Nome do Integrante</th>
      <th>RM</th>
      <th>Turma</th>
      <th>LinkedIn</th>
      <th>GitHub</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Arthur Carvalho Brito Martins</td>
      <td>RM 572325</td>
      <td>1TDSPH</td>
      <td><a href="https://www.linkedin.com/in/arthur-martinss/">LinkedIn</a></td>
      <td><a href="https://github.com/arthurmartinss">GitHub</a></td>
    </tr>
    <tr>
      <td>Diego Soares Trujillo</td>
      <td>RM 570147</td>
      <td>1TDSPH</td>
      <td><a href="https://www.linkedin.com/in/diego-trujillo-3441b9380/">LinkedIn</a></td>
      <td><a href="https://github.com/diegotrujillo011">GitHub</a></td>
    </tr>
    <tr>
      <td>Enzo Nukui da Silva</td>
      <td>RM 569770</td>
      <td>1TDSPH</td>
      <td><a href="https://www.linkedin.com/in/enzo-nukui/">LinkedIn</a></td>
      <td><a href="https://github.com/EnzoNukui">GitHub</a></td>
    </tr>
    <tr>
      <td>Leticia Cardoso de Almeida</td>
      <td>RM 569415</td>
      <td>1TDSPH</td>
      <td><a href="https://www.linkedin.com/in/let%C3%ADcia-almeida-70b851294/">LinkedIn</a></td>
      <td><a href="https://github.com/lehalmeidafc0">GitHub</a></td>
    </tr>
    <tr>
      <td>Leticia Dias Araujo Felix Moratori</td>
      <td>RM 569138</td>
      <td>1TDSPH</td>
      <td><a href="https://www.linkedin.com/in/leticia-felix-660253286">LinkedIn</a></td>
      <td><a href="https://github.com/LeticiaFelix18">GitHub</a></td>
    </tr>
  </tbody>
</table>
 

---


