package com.example.findtoeat.model;


import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductManager {
    private FirebaseFirestore firebaseFirestore;
    private CollectionReference collectionReference;

    public ProductManager() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        collectionReference = firebaseFirestore.collection("products");
    }

    public List<Product> findAllProducts() {
        Query query = collectionReference
                .orderBy("kiloCalories");
        FirestoreRecyclerOptions<Product> options = new FirestoreRecyclerOptions.Builder<Product>()
                .setQuery(query, Product.class)
                .build();
        return options.getSnapshots().stream().parallel().collect(Collectors.toList());
    }
}
