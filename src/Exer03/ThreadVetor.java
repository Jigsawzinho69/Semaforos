/* 3) Criar em java um projeto com uma Thread chamada ThreadVetor, que receba um
valor numérico e vetor como parâmetros. Caso o valor numérico seja par, a thread deve
percorrer o vetor utilizando uma estrutura for (int i = 0 ; i < vet.length; i++) e contar o
tempo para percorrer o vetor. Caso o valor numérico seja ímpar, a thread deve percorrer
o vetor utilizando uma estrutura foreach e contar o tempo para percorrer o vetor. No
final, ambas as possibilidades devem apresentar o tempo em segundos.
A operação main deve gerar um vetor de 1000 posições com valores aleatórios de 1 a
100. Deve iniciar 2 ThreadVetor e para uma passar o número 1 e o vetor e para a outra,
passar o número 2 e o mesmo vetor. */

package Exer03;

import java.util.Random;

public class ThreadVetor extends Thread {
    private int[] vetor;
    private int valorNumerico;

    public ThreadVetor(int[] vetor, int valorNumerico) {
        this.vetor = vetor;
        this.valorNumerico = valorNumerico;
    }

    public void run() {
        long startTime = System.currentTimeMillis();

        if (valorNumerico % 2 == 0) {
            for (int i = 0; i < vetor.length; i++) {
            }
        } else {
            for (int num : vetor) {
            }
        }

        long endTime = System.currentTimeMillis();
        double tempoSegundos = (endTime - startTime) / 1000.0;
        System.out.println("Tempo para percorrer o vetor: " + tempoSegundos + " segundos");
    }

    public static void main(String[] args) {
        int[] vetor = gerarVetor(1000);

        ThreadVetor thread1 = new ThreadVetor(vetor, 1);
        ThreadVetor thread2 = new ThreadVetor(vetor, 2);

        thread1.start();
        thread2.start();
    }

    private static int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        Random rand = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(100) + 1; // Gera números aleatórios de 1 a 100
        }

        return vetor;
    }
}
