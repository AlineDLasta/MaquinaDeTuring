const view = {
    atualizarInterface: function (model) {
        document.getElementById('estadoAtual').textContent = model.estadoAtual;
        document.getElementById('posicaoCabecote').textContent = model.posicaoCabecote;
        document.getElementById('passosExecutados').textContent = model.passosExecutados;
        document.getElementById('historicoEstados').textContent = model.historicoEstados.join(" → ");

        // Atualiza visualmente a fita
        const fitaContainer = document.getElementById('fitaContainer');
        fitaContainer.innerHTML = '';
        model.fita.forEach((simbolo, index) => {
            const celula = document.createElement('span');
            celula.textContent = simbolo;
            celula.classList.add('celula');
            if (index === model.posicaoCabecote) {
                celula.classList.add('cabecote');
            }

            fitaContainer.appendChild(celula);
        });

        // Atualiza a tabela de regras da máquina
        const tabela = document.getElementById('tabelaRegras');
        tabela.innerHTML = '';
        model.regras.forEach(regra => {
            const linha = document.createElement('tr');
            linha.innerHTML = `
                <td>${regra.estadoAtual}</td>
                <td>${regra.simboloLido}</td>
                <td>${regra.escrever}</td>
                <td>${regra.movimento}</td>
                <td>${regra.proximoEstado}</td>
            `;
            tabela.appendChild(linha);
        });

        if (model.resultadoDecimal !== null && model.resultadoDecimal !== undefined) {
            document.getElementById('resultadoDecimal').textContent = "Decimal equivalente: " + model.resultadoDecimal;
        } else {
            document.getElementById('resultadoDecimal').textContent = "Decimal equivalente: ";
        }

    }
};
document.addEventListener("DOMContentLoaded", controller.carregarModelo);
