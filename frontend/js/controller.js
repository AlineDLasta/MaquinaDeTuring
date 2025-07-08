const controller = {
    proximoPasso: function () {
        fetch("http://localhost:8000/step", { method: "POST" })
            .then(response => response.json())
            .then(model => view.atualizarInterface(model));
    },

    resetar: function () {
        fetch("http://localhost:8000/reset", { method: "POST" })
            .then(response => response.json())
            .then(model => view.atualizarInterface(model));
    },

    carregarModelo: function () {
        fetch("http://localhost:8000/model")
            .then(response => response.json())
            .then(model => view.atualizarInterface(model));
    }
};
