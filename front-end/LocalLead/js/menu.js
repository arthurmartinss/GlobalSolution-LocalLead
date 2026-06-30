/* script menu locallead */

export const initMenu = () => {
  // Busca o botão hambúrguer e o menu de navegação
  const botao = document.querySelector(".navbar__toggle");
  const menu = document.querySelector(".navbar__menu");

  // Quando o usuário clica no botão hambúrguer
  botao.addEventListener("click", () => {
    // toggle adiciona a classe "is-open" se não tiver, ou remove se já tiver
    // O CSS usa essa classe para abrir e fechar o menu no mobile
    botao.classList.toggle("is-open");
    menu.classList.toggle("is-open");
  });
};