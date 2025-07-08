public class Controller {
    private Model model;

    public Controller() {
        model = new Model();
    }

    public String obterModeloComoJson() {
        return model.toJson();
    }

    public String executarPasso() {
        model.executarPasso();
        return model.toJson();
    }

    public String reiniciar() {
        model.resetar();
        return model.toJson();
    }
}
