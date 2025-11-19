package models;

import models.lojas.*;

public class Shopping {

    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int maxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[maxLojas];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    @Override
    public String toString() {
        return "models.Shopping{" +
                "nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", capacidade=" + lojas.length + //tenta com o arrays de string
                '}';
    }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < this.lojas.length; i++) {
            if (this.lojas[i] == null) {
                this.lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < this.lojas.length; i++) {
            if (this.lojas[i] != null && this.lojas[i].getNome().equals(nomeLoja)) {
                this.lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipoLoja) {
        if (!tipoLoja.equals("models.lojas.Cosmetico") && !tipoLoja.equals("models.lojas.Vestuario") &&
                !tipoLoja.equals("models.lojas.Bijuteria") && !tipoLoja.equals("models.lojas.Alimentacao") &&
                !tipoLoja.equals("Informática")) {
            return -1;
        }

        int contador = 0;
        for (Loja loja : this.lojas) {
            if (loja != null) {
                if (tipoLoja.equals("models.lojas.Cosmetico") && loja instanceof Cosmetico) {
                    contador++;
                } else if (tipoLoja.equals("models.lojas.Vestuario") && loja instanceof Vestuario) {
                    contador++;
                } else if (tipoLoja.equals("models.lojas.Bijuteria") && loja instanceof Bijuteria) {
                    contador++;
                } else if (tipoLoja.equals("models.lojas.Alimentacao") && loja instanceof Alimentacao) {
                    contador++;
                } else if (tipoLoja.equals("Informática") && loja instanceof Informatica) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaMaisCara = null;
        double maiorSeguro = 0;

        for (Loja loja : this.lojas) {
            if (loja instanceof Informatica) {
                Informatica lojaInfo = (Informatica) loja;

                if (lojaMaisCara == null || lojaInfo.getSeguroEletronicos() > maiorSeguro) {
                    maiorSeguro = lojaInfo.getSeguroEletronicos();
                    lojaMaisCara = lojaInfo;
                }
            }
        }
        return lojaMaisCara;
    }
}