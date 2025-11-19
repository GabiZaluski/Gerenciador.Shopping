package models.lojas;

import models.Data;
import models.Endereco;
import models.Loja;

import java.util.Arrays;

public class Cosmetico extends Loja {

    private double taxaComercializacao;

    public Cosmetico(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, double taxaComercializacao, int tamanhoEstoque) {

        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoque);

        this.taxaComercializacao = taxaComercializacao;
    }

    public double getTaxaComercializacao() {

        return taxaComercializacao;
    }

    public void setTaxaComercializacao(double taxaComercializacao) {
        this.taxaComercializacao = taxaComercializacao;
    }

    @Override
    public String toString() {
        return "models.Loja{" +
                "nome='" + getNome() + '\'' +
                ", quantidadeFuncionarios=" + getQuantidadeFuncionarios() +
                ", salarioBaseFuncionario=" + getSalarioBaseFuncionario() +
                ", endereco=" + getEndereco() +
                ", dataFundacao=" + getDataFundacao() +
                ", taxaComercializacao=" + taxaComercializacao +
                ", estoqueProdutos=" + Arrays.toString(getEstoqueProdutos()) +
                '}';
    }
}