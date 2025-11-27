// package com.vse.index;

// import java.io.*;
// import java.nio.file.Path;
// import java.util.*;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;


// public final class VectorHNSW implements VectorIndex {

//     private VectorHNSW(Builder builder) {

//     }

//     public static VectorHNSW load(Path path) throws IOException, ClassNotFoundException {
//         log.info("Loading index from {}", path);
//         try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
//             VectorHNSW index = (VectorHNSW)ois.readObject();
//             log.info("Successfully loaded index with {} items.", index.size());
//             return index;
//         }
//     }



// }
