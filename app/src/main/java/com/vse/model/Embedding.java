package com.vse.model;

import ai.djl.ModelException;
import ai.djl.huggingface.translator.TextEmbeddingTranslatorFactory;
import ai.djl.inference.Predictor;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.TranslateException;

import java.io.IOException;

import com.vse.math.Vector;

public class Embedding {
    ZooModel<String, float[]> model;
    Predictor<String, float[]> predictor;

    public Embedding() throws IOException, ModelException {
        Criteria<String, float[]> criteria = Criteria
        .builder()
        .setTypes(String.class, float[].class)
        .optModelUrls("djl://ai.djl.huggingface.pytorch/sentence-transformers/all-MiniLM-L6-v2")
        .optEngine("PyTorch")
        .optTranslatorFactory(new TextEmbeddingTranslatorFactory())
        .optProgress(new ProgressBar())
        .build();

        this.model = criteria.loadModel();
        this.predictor = this.model.newPredictor();
    }

    public Vector generateEmbedding(String text) throws TranslateException {
        float[] arr = this.predictor.predict(text);
        return new Vector(arr);
    }
}