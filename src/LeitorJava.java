import java.io.File;
import java.io.IOException;

public class LeitorJava implements Runnable {

    private Buscador buscador;
    private File arquivo;

    public LeitorJava(Buscador buscador, File arquivo) {
        this.buscador = buscador;
        this.arquivo = arquivo;
    }

    @Override
    public void run() {
        try {
            buscador.buscar(arquivo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
