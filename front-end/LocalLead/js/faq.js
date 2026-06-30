/* script faq locallead */

export const initFaq = () => {
  // Busca todos os itens de pergunta e resposta da página
  const itens = document.querySelectorAll(".faq-item");

  // Percorre cada item encontrado
  itens.forEach((item) => {
    // Dentro de cada item, busca o elemento clicável que é a pergunta
    const pergunta = item.querySelector(".faq-item__question");

    // Quando o usuário clica na pergunta
    pergunta.addEventListener("click", () => {
      // toggle adiciona a classe "aberto" se não tiver, ou remove se já tiver
      // É o CSS que usa essa classe para mostrar ou esconder a resposta
      item.classList.toggle("aberto");
    });
  });
};

// quando o botao for clicado vai agir ( abrir)