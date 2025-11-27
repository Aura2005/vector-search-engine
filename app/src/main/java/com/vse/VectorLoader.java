package com.vse;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.vse.store.Persist;


public class VectorLoader {

    public static void loadStore() {
        try (FileInputStream input = new FileInputStream("data.pb")) {
            Persist.Data data2 = Persist.Data.parseFrom(input);

            List<Persist.KeyedVector> vectors = data2.getKeyedVectorsList();

            if (vectors.isEmpty()) {
                System.out.println("No vectors found in the file.");
                return;
            }

            for (Persist.KeyedVector item : vectors) {
                float[] coordinates = new float[item.getCoordinatesCount()];
                for (int i = 0; i < coordinates.length; i++) coordinates[i] = item.getCoordinates(i);
                VectorStore.append(item.getStrings(), new Vector(coordinates));
            }

            System.out.println(VectorStore.getSize());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading data from file.");
        }
    }
}
