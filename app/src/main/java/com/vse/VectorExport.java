package com.vse;

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

public class VectorExport {

    public static void export() throws IOException, ModelException, TranslateException {

        String path = "C:/Users/ericb/OneDrive/Documents/Project-2/vector-search-engine/app/src/main/java/com/vse/questions.txt";
        List<StringBuilder> s = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    StringBuilder question = new StringBuilder(line);
                    s.add(question);
                }
            }
            reader.close();
            for (StringBuilder i : s) {
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Embedding em = new Embedding();
        List<Vector> lst = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            lst.add(em.generateEmbedding(s.get(i).toString()));
        }

        Persist.Data.Builder dataBuilder = Persist.Data.newBuilder();

        for (int i = 0; i < s.size(); i++) {
            Persist.KeyedVector.Builder vectorBuilder = Persist.KeyedVector.newBuilder();
            for (float a : lst.get(i).coordinates()) {
                vectorBuilder.addCoordinates(a);
            }
            vectorBuilder.setStrings(s.get(i).toString());
            dataBuilder.addKeyedVectors(vectorBuilder.build());
        }

        Persist.Data data = dataBuilder.build();

        try (FileOutputStream output = new FileOutputStream("data.pb")) {
            data.writeTo(output);
        }

        System.out.println("Data exported successfully.");
    }
}
