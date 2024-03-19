/* 1) Fazer uma aplicação que rode 5 Threads que cada uma delas imprima no console o
seu número (TID).
Dica: O número que deve ser impresso é a saída da operação int id = getId() da Thread. */

package testing;

public class exer01 extends Thread {
 public exer01() {
 }

 public void run() {
     long tid = getId(); // Obtém o ID da thread
     System.out.println("Thread #" + tid + " executando.");
 }
}
