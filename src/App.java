import java.io.File;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        File diretorio = new File("src/arquivosNomes");

        Buscador buscador = new Buscador("HE", 2);

        ArrayList<Thread> leitores = new ArrayList<Thread>();

        for (File arquivo : diretorio.listFiles()) {
            leitores.add(new Thread(new LeitorJava(buscador, arquivo), arquivo.getName()));
        }

        for (Thread thread : leitores) {
            thread.start();
        }
    }
}