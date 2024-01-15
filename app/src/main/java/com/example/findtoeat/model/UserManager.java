package com.example.findtoeat.model;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class UserManager {
    FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private CollectionReference collectionReference;

    public UserManager() {
        this.firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        collectionReference = firebaseFirestore.collection("users");
    }
    public boolean logIn(String email, String password) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Query query = collectionReference
                .orderBy("email");
        boolean doesUserExist = new FirestoreRecyclerOptions.Builder<User>()
                .setQuery(query, User.class)
                .build()
                .getSnapshots()
                .stream()
                .parallel()
                .collect(Collectors.toList())
                .stream()
                .anyMatch(user -> user.getEmail().equals(email));
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        atomicBoolean.set(true);
                        if (!doesUserExist) {
                            collectionReference.add(new User(email));
                        }
                    }
                });
        return atomicBoolean.get();
    }
    public void addProductToFavourites(String email,Product product) {
        Query query = collectionReference
                .whereEqualTo("email",email);
        User user = new FirestoreRecyclerOptions.Builder<User>()
                .setQuery(query, User.class)
                .build()
                .getSnapshots()
                .stream()
                .parallel()
                .collect(Collectors.toList()).get(0);
        user.getFavouriteProducts().add(product);
        String id = collectionReference
                .whereEqualTo("email",email)
                .get().getResult()
                .getDocuments()
                .get(0)
                .getId();
        collectionReference.document(id).delete();
        collectionReference.add(user);
    }
    public void removeProductFromFavourites(String email, Product product) {
        Query query = collectionReference
                .whereEqualTo("email",email);
        User user = new FirestoreRecyclerOptions.Builder<User>()
                .setQuery(query, User.class)
                .build()
                .getSnapshots()
                .stream()
                .parallel()
                .collect(Collectors.toList()).get(0);
        user.setFavouriteProducts(user
                .getFavouriteProducts()
                .stream()
                .filter(product1 -> !product1.getName().equals(product1.getName()))
                .collect(Collectors.toList()));
        String id = collectionReference
                .whereEqualTo("email",email)
                .get().getResult()
                .getDocuments()
                .get(0)
                .getId();
        collectionReference.document(id).delete();
        collectionReference.add(user);
    }
}
