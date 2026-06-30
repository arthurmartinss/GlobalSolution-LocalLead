/* script solucao locallead */

export const initSolucao = () => {
  // Busca todas as etapas do fluxo na página
  const etapas = document.querySelectorAll(".pipeline-item");

  const verificarScroll = () => {
    // Percorre cada etapa para verificar se ela já apareceu na tela
    etapas.forEach((etapa) => {
      // getBoundingClientRect().top pega a distância do elemento até o topo da tela
      const posicaoTopo = etapa.getBoundingClientRect().top;

      // Define o ponto de gatilho como 85% da altura da tela
      // Ou seja, a animação dispara antes do elemento chegar no fim da tela
      const alturaGatilho = window.innerHeight * 0.85;

      // Se o elemento já passou do ponto de gatilho, adiciona a classe is-visible
      // É o CSS que usa essa classe para fazer a etapa aparecer com animação suave
      if (posicaoTopo < alturaGatilho) {
        etapa.classList.add("is-visible");
      }
    });
  };

  // Roda a verificação toda vez que o usuário rola a página
  window.addEventListener("scroll", verificarScroll);

  // Roda uma vez quando a página carrega para animar etapas já visíveis
  verificarScroll();
};