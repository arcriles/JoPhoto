package id.ac.umn.jophoto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

import id.ac.umn.jophoto.R;

public class TestingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        storageRef.child("children/children_seven.png").getBytes(Long.MAX_VALUE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
        public void onSuccess(byte[] bytes) {
            // Use the bytes to display the image
            Log.d("BERHASIL", "Masuk Bos");
        }
    }).addOnFailureListener(new OnFailureListener() {
        public void onFailure(@NonNull Exception exception) {
            // Handle any errors
            Log.d("GAGAL", "Coba Lagi");
        }
    });


    }



}