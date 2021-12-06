package id.ac.umn.jophoto;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import id.ac.umn.jophoto.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding bind;
    private SharedPreferences sharedPrefs;

    static String PROFILE = "profile";
    static String FIRST_NAME = "firstname";
    static String LAST_NAME = "lastname";
    static String PHOTO = "photo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        sharedPrefs = this.getSharedPreferences(PROFILE, Context.MODE_PRIVATE);

        bind.firstName.setText(sharedPrefs.getString(FIRST_NAME, ""));
        bind.lastName.setText(sharedPrefs.getString(LAST_NAME, ""));
        String path = sharedPrefs.getString(PHOTO, "");
        loadImageFromStorage(path);

        setSupportActionBar(bind.profileIncludeToolbar.mainToolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        bind.ivCircleImage.setOnClickListener(view -> {
            mGetContent.launch("image/*");
        });

        bind.btnSave.setOnClickListener( v -> {

            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putString(FIRST_NAME, String.valueOf(bind.firstName.getText()));
            editor.putString(LAST_NAME, String.valueOf(bind.lastName.getText()));
            editor.apply();
            Toast.makeText(this, "Profile Saved", Toast.LENGTH_SHORT);
//            if(bind.firstName.getText().toString().isEmpty() || bind.lastName.getText().toString().isEmpty()){
//                Toast.makeText(this, "Profile Cannot be Empty", Toast.LENGTH_SHORT);
//            }
        });
    }

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
//                        bind.ivCircleImage.setImageBitmap(bitmap);
                        String path = saveImage(bitmap);
                        if(!path.isEmpty()){
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putString(PHOTO, path);
                            editor.apply();
                            loadImageFromStorage(path);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

    // https://stackoverflow.com/questions/17674634/saving-and-reading-bitmaps-images-from-internal-memory-in-android
    private String saveImage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        File myPath = new File(directory, "profile.jpg");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(myPath);
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            Toast.makeText(this, "Profile Photo saved", Toast.LENGTH_SHORT);
        } catch (Exception ignored){}
        finally {
            try{
                fos.close();
            } catch (IOException ignored){ }
        }
        return directory.getAbsolutePath();
    }

    private void loadImageFromStorage(String path){
        try {
            File f = new File(path, "profile.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            bind.ivCircleImage.setImageBitmap(b);
        }
        catch (FileNotFoundException e){
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}