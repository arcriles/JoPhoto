package id.ac.umn.jophoto;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class CameraActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView imageView;
    private Button button;
    private static final int CAMERA_PIC_REQUEST = 1337;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        imageView = findViewById(R.id.capturedImage);
        button = findViewById(R.id.openCamera);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            }
        });
    }
}