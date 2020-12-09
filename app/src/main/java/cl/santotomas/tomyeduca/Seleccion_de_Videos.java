package cl.santotomas.tomyeduca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cl.santotomas.tomyeduca.data.BD;
import cl.santotomas.tomyeduca.modelo.Video;

public class Seleccion_de_Videos extends AppCompatActivity {
    private TextView text_titulo,text_descripcion;
    private Button btn_reproducir,btn_retroceder,btn_avanzar;
    private ImageView imagenVideo;
    private int num;
    public static List<Video> listaVideos;
    public static Video videoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_de__videos);

        text_titulo = findViewById(R.id.tv_titulo);
        text_descripcion = findViewById(R.id.tv_Descripcion_Video);

        btn_reproducir = findViewById(R.id.bt_rep);
        btn_retroceder = findViewById(R.id.bt_back);
        btn_avanzar = findViewById(R.id.bt_next);
        BD bd = new BD(getApplicationContext());
        listaVideos = bd.getAllVideos();


        llenarDatos(listaVideos.get(0));
        num = 1;


        btn_retroceder.setBackground(this.getResources().getDrawable(R.drawable.leftarrow));
        btn_retroceder.setEnabled(false);
        init();


    }

    public void init(){
        btn_reproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),YouTube.class);
                startActivity(i);
            }
        });
        btn_retroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num>1) {
                    num--;
                    llenarDatos(listaVideos.get(num-1));
                    btn_retroceder.setBackground(getResources().getDrawable(R.drawable.newleftarrow));
                    btn_retroceder.setEnabled(true);
                    btn_avanzar.setBackground(getResources().getDrawable(R.drawable.newrigtharrow));
                    btn_avanzar.setEnabled(true);
                }
                if(num==1){
                    btn_retroceder.setBackground(getResources().getDrawable(R.drawable.leftarrow));
                    btn_retroceder.setEnabled(false);
                    btn_avanzar.setBackground(getResources().getDrawable(R.drawable.newrigtharrow));
                    btn_avanzar.setEnabled(true);
                }
            }
        });
        btn_avanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num<listaVideos.size()){
                    llenarDatos(listaVideos.get(num));
                    num++;
                    btn_retroceder.setBackground(getResources().getDrawable(R.drawable.newleftarrow));
                    btn_retroceder.setEnabled(true);
                    btn_avanzar.setBackground(getResources().getDrawable(R.drawable.newrigtharrow));
                    btn_avanzar.setEnabled(true);
                }
                if(num == listaVideos.size()){
                    btn_avanzar.setBackground(getResources().getDrawable(R.drawable.rigtharrow));
                    btn_avanzar.setEnabled(false);
                    btn_retroceder.setBackground(getResources().getDrawable(R.drawable.newleftarrow));
                    btn_retroceder.setEnabled(true);
                }
            }
        });

    }
    private void llenarDatos(Video video){
        text_titulo.setText(video.getTitulo());
        text_descripcion.setText(video.getDescripcion());
        videoSeleccionado = video;
        enviarImagenporId(video.getVideo_id());

    }
    private void enviarImagenporId(int id){
        switch(id) {
            case 1:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video);
                break;
            case 2:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video1);
                break;
            case 3:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video2);
                break;
            case 4:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video3);
                break;
            case 5:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video4);
                break;
            case 6:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video5);
                break;
            case 7:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video6);
                break;
            case 8:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video7);
                break;
            case 9:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video8);
                break;
            case 10:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video9);
                break;
            case 11:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video10);
                break;
            case 12:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video11);
                break;
            case 13:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video12);
                break;
            case 14:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video13);
                break;
            case 15:
                imagenVideo = (ImageView) findViewById(R.id.imageView); imagenVideo.setImageResource(R.drawable.video14);
                break;
            default:
                break;
        }
    }
}