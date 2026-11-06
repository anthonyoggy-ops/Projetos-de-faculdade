import java.util.Scanner;
import java.util.ArrayList;


class Funcionario {
    String nome;
    int ra;
    String tipo;
    double salarioFinal;
    double extras;

    Funcionario(String nome, int ra, String tipo, double salarioFinal, double extras) {
        this.nome = nome;
        this.ra = ra;
        this.tipo = tipo;
        this.salarioFinal = salarioFinal;
        this.extras = extras;
    }
}

public class A1G {
    static final double SalarioBase = 2000.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        
        int numero, RA, vendas, percentual;
        double pecas;
        String nome;

        do {
            System.out.println("\n --Folha de pagamento-- ");
            System.out.println("1- registrar funcionario padrão");
            System.out.println("2- registrar funcionario comissionado");
            System.out.println("3- registrar funcionario produtor");
            System.out.println("4- Gerar folha de pagamento");
            System.out.println("0- encerrar");
            System.out.print("Digite um numero: ");
            numero = scanner.nextInt();

            if (numero == 1) {
                System.out.println("Informe nome do funcionario:");
                nome = scanner.next() + scanner.nextLine();
                System.out.println("Informe RA:");
                RA = scanner.nextInt();
                
                
                listaFuncionarios.add(new Funcionario(nome, RA, "Padrão", SalarioBase, 0.0));
                System.out.println("Funcionário padrão " + nome + " registrado com sucesso!");

            } else if (numero == 2) {
                System.out.println("Informe nome do funcionario:");
                nome = scanner.next() + scanner.nextLine();
                System.out.println("Informe seu RA:");
                RA = scanner.nextInt();
                System.out.println("Informe vendas:");
                vendas = scanner.nextInt();
                System.out.println("Informe quanto de percentual:");
                percentual = scanner.nextInt();

                double comissao = (vendas * percentual / 100);
                double salarioFinal = SalarioBase + comissao;

                listaFuncionarios.add(new Funcionario(nome, RA, "Comissionado", salarioFinal, comissao));
                System.out.println("Funcionário comissionado " + nome + " registrado!");

            } else if (numero == 3) {
                System.out.println("Informe nome do funcionario:");
                nome = scanner.next() + scanner.nextLine();
                System.out.println("Informe seu RA:");
                RA = scanner.nextInt();
                System.out.println("Informe quantidade produzida:");
                vendas = scanner.nextInt();
                System.out.println("Informe valor por peca:");
                pecas = scanner.nextDouble();

                double produtividade = vendas * pecas;
                double salarioFinal = SalarioBase + produtividade;

                listaFuncionarios.add(new Funcionario(nome, RA, "Produtor", salarioFinal, produtividade));
                System.out.println("Funcionário produtor " + nome + " registrado!");

            } else if (numero == 4) {
                System.out.println("\n--- Gerando Folha de Pagamento ---");
                if (listaFuncionarios.isEmpty()) {
                    System.out.println("Nenhum funcionário registrado ainda.");
                } else {
                    
                    for (Funcionario f : listaFuncionarios) {
                        System.out.println("\nNome: " + f.nome + " (RA: " + f.ra + ") - Tipo: " + f.tipo);
                        System.out.println("Salário fixo: R$ " + SalarioBase);
                        System.out.println("Extras (" + (f.tipo.equals("Comissionado") ? "Comissão" : "Produtividade") + "): R$ " + f.extras);
                        System.out.println("Salário Final: R$ " + f.salarioFinal);
                        System.out.println("-----------------------------------");
                    }
                }
            } else if (numero != 0) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        } while (numero != 0);

        System.out.println("Programa encerrado com sucesso.");
        scanner.close();
    }
}
