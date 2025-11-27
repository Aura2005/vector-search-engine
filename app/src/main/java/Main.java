

import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import ai.djl.ModelException;
import ai.djl.huggingface.translator.TextEmbeddingTranslatorFactory;
import ai.djl.inference.Predictor;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.TranslateException;
import com.vse.Vector;
import com.vse.store.Persist;
import com.vse.Embedding;
import com.vse.VectorLoader;
import com.vse.VectorSearch;
import com.vse.VectorStore;
import com.vse.VectorExport;

public class Main {
    public static void main(String[] args) throws IOException, TranslateException, ModelException {
        // call vector engine to load the all the arrays
        String hello = "Hello World!";
        System.out.println(hello);

        //Load the store
        
        
        // VectorExport.export();
        
        VectorLoader.loadStore();
        VectorStore.getSize();

        String input = "What is the difference between procedural programming and object-oriented programming (OOP)?";
        Embedding em = new Embedding();
        Vector inputVector = em.generateEmbedding(input);
        int k = 5;
        HashMap<Integer, Integer> map = VectorSearch.topkIndex(k, inputVector);
        System.out.println(map);
        for(int i = k-1; i >= 0; i--) {
            System.out.println(VectorStore.getId(map.get(i)));
        }
        
        
    }
}
