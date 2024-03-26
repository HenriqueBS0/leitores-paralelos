import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class Buscador {
    private Semaphore semaphore;
    private String termo;

    public Buscador(String termo, Integer maximoThreads) {
        this.semaphore = new Semaphore(maximoThreads);
        this.termo = termo;
    }

    public void buscar(File arquivo) throws IOException {

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String nomeThread = Thread.currentThread().getName();

        System.out.println("Thread começou a busca: " + nomeThread);

        FileReader fileReader = new FileReader(arquivo);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linha;

        while ((linha = bufferedReader.readLine()) != null) {
            if(linha.toLowerCase().contains(this.termo.toLowerCase())) {
                System.out.println("Arquivo " + nomeThread + ": " + linha);
            }
        }

        bufferedReader.close();

        semaphore.release();
    }
}
