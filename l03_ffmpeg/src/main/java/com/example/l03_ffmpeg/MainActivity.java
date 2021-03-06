package com.example.l03_ffmpeg;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;

import com.example.l03_ffmpeg.player.Player;

import java.io.File;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
//fasfa
    SurfaceView surfaceView;
    Player wangyiPlayer;
    private SeekBar seekBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,};
            if (checkSelfPermission(perms[0]) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(perms, 200);
            }
        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager
                .LayoutParams.FLAG_KEEP_SCREEN_ON);
        seekBar=findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        surfaceView = findViewById(R.id.surfaceView);
        wangyiPlayer = new Player();
        wangyiPlayer.setSurfaceView(surfaceView);
        File file = new File(Environment.getExternalStorageDirectory(), "input.mp4");
        wangyiPlayer.setDataSource(file.getAbsolutePath());

        wangyiPlayer.setOnPrepareListener(new Player.OnPrepareListener() {
            @Override
            public void onPrepare() {
                wangyiPlayer.start();
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public void open(View view) {
//        File file = new File(Environment.getExternalStorageDirectory(), "input.mp4");
//        wangyiPlayer.start(file.getAbsolutePath());
    }
    public void play(View view) {
//        String input = new File(Environment.getExternalStorageDirectory(),"input.mp3").getAbsolutePath();
//        String output = new File(Environment.getExternalStorageDirectory(),"output.pcm").getAbsolutePath();
//        wangyiPlayer.sound(input, output);



        wangyiPlayer.prepare();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
