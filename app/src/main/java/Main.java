
import com.vse.model.Embedding;
import java.util.Arrays;
import java.io.IOException;
import ai.djl.ModelException;
import ai.djl.translate.TranslateException;

public class Main {
    public static void main(String[] args) throws IOException, ModelException, TranslateException {
        Embedding embed = new Embedding();
        String hello = "Hello World!";
        System.out.println(hello);
        System.out.println(Arrays.toString(embed.generateEmbedding(hello).getCoordinates()));     

    }
}
