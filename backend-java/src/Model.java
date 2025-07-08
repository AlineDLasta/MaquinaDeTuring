import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

    private List<String> fita = new ArrayList<>(Arrays.asList(
            "1", "0", "0", "1", "E", "0", "0", "0", "0", "0"
    ));

    private int posicaoCabecote = 0;
    private String estadoAtual = "q0";
    private List<Regra> regras = new ArrayList<>();
    private int passosExecutados = 0;
    private List<String> historicoEstados = new ArrayList<>();
    private Integer resultadoDecimal;

    public static class Regra {
        String estadoAtual, simboloLido, escrever, movimento, proximoEstado;

        public Regra(String estadoAtual, String simboloLido, String escrever, String movimento, String proximoEstado) {
            this.estadoAtual = estadoAtual;
            this.simboloLido = simboloLido;
            this.escrever = escrever;
            this.movimento = movimento;
            this.proximoEstado = proximoEstado;
        }
    }

    public Model() {
        regras.add(new Regra("q0", "1", "1", "R", "q0"));
        regras.add(new Regra("q0", "0", "0", "R", "q0"));
        regras.add(new Regra("q0", "E", "E", "N", "qf"));
    }

    public void executarPasso() {
        if (estadoAtual.equals("qf")) return;  //para se estiver no estado final

        historicoEstados.add(estadoAtual);
        passosExecutados++;

        String simboloLido = fita.get(posicaoCabecote);

        for (Regra regra : regras) {
            if (regra.estadoAtual.equals(estadoAtual) && regra.simboloLido.equals(simboloLido)) {
                fita.set(posicaoCabecote, regra.escrever);

                switch (regra.movimento) {
                    case "R":
                        posicaoCabecote++;
                        if (posicaoCabecote >= fita.size()) {
                            fita.add("0");
                        }
                        break;
                    case "L":
                        if (posicaoCabecote > 0) posicaoCabecote--;
                        break;
                    case "N":
                        // sem movimento
                        break;
                }

                //atualizando para o próximo estado
                estadoAtual = regra.proximoEstado;

                if (estadoAtual.equals("qf")) {
                    historicoEstados.add("qf");
                }
                break;
            }
        }
    }

    public void resetar() {
        fita = new ArrayList<>(Arrays.asList(
                "1", "0", "0", "1", "E", "0", "0", "0", "0", "0"
        ));
        posicaoCabecote = 0;
        estadoAtual = "q0";
        passosExecutados = 0;
        historicoEstados.clear();
    }

    // Retorna o decimal da fita se estiver no estado final
    public Integer getResultadoDecimal() {
        if (!estadoAtual.equals("qf")) return null; // só calcula no estado final
        String binario = extrairBinarioAntesDoE();
        if (binario.isEmpty()) return 0;
        try {
            return Integer.parseInt(binario, 2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private String extrairBinarioAntesDoE() {
        StringBuilder binario = new StringBuilder();
        for (String simbolo : fita) {
            if (simbolo.equals("E")) break;
            if (simbolo.equals("0") || simbolo.equals("1")) {
                binario.append(simbolo);
            }
        }
        return binario.toString();
    }

    // Atualiza o campo resultadoDecimal e converte o objeto para uma string JSON formatada
    public String toJson() {
        this.resultadoDecimal = getResultadoDecimal();
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        return gson.toJson(this);
    }

}
