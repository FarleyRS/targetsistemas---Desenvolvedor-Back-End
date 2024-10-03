/* Dado um vetor que guarda o valor de faturamento diário de uma distribuidora de todos os dias de um ano, 
faça um programa, na linguagem que desejar, que calcule e retorne:

- O menor valor de faturamento ocorrido em um dia do ano;
- O maior valor de faturamento ocorrido em um dia do ano;
- Número de dias no ano em que o valor de faturamento diário foi superior à média anual.

a) Considerar o vetor já carregado com as informações de valor de faturamento.

b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser 
ignorados no cálculo da média.

c) Utilize o algoritmo mais veloz que puder definir.*/
import java.util.Random;

public class Main {
    public static void main(String[] args) {
         int diasNoAno = 365;
        double[] faturamentoDiario = new double[diasNoAno];

        Random random = new Random();

        // Gerando valores aleatórios para o faturamento diário
        for (int i = 0; i < diasNoAno; i++) {
            // Gere um valor aleatório entre 0 e 10000
            double valorAleatorio = random.nextInt() * 10000;

            // Simulando dias sem faturamento (ajuste o limite conforme necessário)
            if (valorAleatorio > 5000) {
                faturamentoDiario[i] = valorAleatorio;
            } else {
                faturamentoDiario[i] = 0;
            }
        }

        // Inicializando as variáveis
        double menorValor = Double.MAX_VALUE;
        double maiorValor = 0;
        double somaTotal = 0;
        int diasComFaturamento = 0;

        // Calculando a soma total e contando os dias com faturamento
        for (double valor : faturamentoDiario) {
            if (valor > 0) {
                somaTotal += valor;
                diasComFaturamento++;
                if (valor < menorValor) {
                    menorValor = valor;
                }
                if (valor > maiorValor) {
                    maiorValor = valor;
                }
            }
        }

        // Calculando a média anual
        double mediaAnual = somaTotal / diasComFaturamento;

        // Contando os dias acima da média
        int diasAcimaMedia = 0;
        for (double valor : faturamentoDiario) {
            if (valor > mediaAnual) {
                diasAcimaMedia++;
            }
        }

        // Imprimindo os resultados
        System.out.println("Menor valor de faturamento: R$" + menorValor);
        System.out.println("Maior valor de faturamento: R$" + maiorValor);
        System.out.println("Número de dias acima da média: " + diasAcimaMedia);
    }
}