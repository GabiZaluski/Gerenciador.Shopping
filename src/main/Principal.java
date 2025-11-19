package main;

import models.Loja;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        Loja lojaCriada = null;
        Produto produtoCriado = null;

        while (opcao != 3) {
            System.out.println("\n--- MENU ---");
            System.out.println("(1) criar uma loja");
            System.out.println("(2) criar um produto");
            System.out.println("(3) sair");
            System.out.print("Digite sua opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    System.out.println("--- Criando models.Loja ---");
                    System.out.print("Nome da models.Loja: ");
                    String nomeLoja = scanner.nextLine();
                    System.out.print("Quantidade de Funcionários: ");
                    int qtdFunc = Integer.parseInt(scanner.nextLine());
                    System.out.print("Salário Base Funcionário: ");
                    double salarioBase = Double.parseDouble(scanner.nextLine());

                    System.out.println("--- Endereço da models.Loja ---");
                    System.out.print("Nome da Rua: ");
                    String rua = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();
                    System.out.print("País: ");
                    String pais = scanner.nextLine();
                    System.out.print("CEP: ");
                    String cep = scanner.nextLine();
                    System.out.print("Número: ");
                    String numero = scanner.nextLine();
                    System.out.print("Complemento: ");
                    String complemento = scanner.nextLine();

                    Endereco endLoja = new Endereco(rua, cidade, estado, pais, cep, numero, complemento);

                    System.out.println("--- models.Data de Fundação da models.Loja ---");
                    System.out.print("Dia (DD): ");
                    int diaFund = Integer.parseInt(scanner.nextLine());
                    System.out.print("Mês (MM): ");
                    int mesFund = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ano (AAAA): ");
                    int anoFunc = Integer.parseInt(scanner.nextLine());

                    Data dataFunc = new Data(diaFund, mesFund, anoFunc);

                    System.out.print("Tamanho do Estoque (Nº de produtos): ");
                    int tamanhoEstoque = Integer.parseInt(scanner.nextLine());

                    lojaCriada = new Loja(nomeLoja, qtdFunc, salarioBase, endLoja, dataFunc, tamanhoEstoque);

                    System.out.println("models.Loja criada com sucesso!");
                    break;

                case 2:
                    System.out.println("--- Criando models.Produto ---");
                    System.out.print("Nome do models.Produto: ");
                    String nomeProd = scanner.nextLine();
                    System.out.print("Preço: ");
                    double precoProd = Double.parseDouble(scanner.nextLine());

                    System.out.println("--- models.Data de Validade do models.Produto ---");
                    System.out.print("Dia (DD): ");
                    int diaVal = Integer.parseInt(scanner.nextLine());
                    System.out.print("Mês (MM): ");
                    int mesVal = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ano (AAAA): ");
                    int anoVal = Integer.parseInt(scanner.nextLine());

                    Data dataVal = new Data(diaVal, mesVal, anoVal);

                    produtoCriado = new Produto(nomeProd, precoProd, dataVal);
                    System.out.println("models.Produto criado com sucesso!");
                    System.out.println("models.Produto criado com sucesso!");
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

        System.out.println("\n--- Verificação Final ---");

        if (lojaCriada != null && produtoCriado != null) {

            Data dataTeste = new Data(20, 10, 2023);

            if (produtoCriado.estaVencido(dataTeste)) {
                System.out.println("PRODUTO VENCIDO");
            } else {
                System.out.println("PRODUTO NÃO VENCIDO");
            }

            System.out.println("\nInformações da models.Loja Criada:");
            System.out.println(lojaCriada.toString());
            System.out.println(produtoCriado.toString());

        } else {
            System.out.println("Atenção: Você saiu do menu sem criar os dois objetos (models.Loja e models.Produto).");
            System.out.println("A verificação final não será executada.");
        }

        scanner.close();
    }
}