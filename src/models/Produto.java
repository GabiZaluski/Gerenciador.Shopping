package models;

public class Produto {

    private String nome;
    private double preco;
    private Data dataValidade;

    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "models.Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", dataValidade=" + dataValidade +
                '}';
    }

    public boolean estaVencido(Data data) {
        Data dataParaComparar = data;
        if (this.dataValidade.getAno() < dataParaComparar.getAno()) {
            return true;
        }
        if (this.dataValidade.getAno() > dataParaComparar.getAno()) {
            return false;
        }
        if (this.dataValidade.getMes() < dataParaComparar.getMes()) {
            return true;
        }
        if (this.dataValidade.getMes() > dataParaComparar.getMes()) {
            return false;
        }
        if (this.dataValidade.getDia() < dataParaComparar.getDia()) {
            return true;
        }
        return false;
    }
}