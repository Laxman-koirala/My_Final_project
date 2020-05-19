package com.example.scientificcalculator.storage;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class FirestoreController {
    FirebaseFirestore db;
    public FirestoreController() {
        db=FirebaseFirestore.getInstance();
    }

    public void saveToFirebase(String finalCalculation) {
        HashMap<String, Object> equations = new HashMap<>();
        equations.put("equation", finalCalculation );
        equations.put("timestamp", FieldValue.serverTimestamp());
        db.collection("equations").add(equations);
    }
}
