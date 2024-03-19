/* 2) Fazer uma aplicação que insira números aleatórios em uma matriz 3 x 5 e tenha 3
chamadas de Threads, onde cada uma calcula a soma dos valores de cada linha,
imprimindo a identificação da linha e o resultado da soma.
Dica: A main deve gerar uma matriz com números aleatórios, mas a Thread recebe um vetor
(uma linha da matriz) */

package Exer02;

import java.util.Random;

public class Th02 extends Thread {
 private int[] row;
 private int rowNumber;

 public Th02(int[] row, int rowNumber) {
     this.row = row;
     this.rowNumber = rowNumber;
 }

 public void run() {
     int sum = 0;
     for (int num : row) {
         sum += num;
     }
     System.out.println("Thread #" + rowNumber + " - Soma da linha: " + sum);
 }
}
