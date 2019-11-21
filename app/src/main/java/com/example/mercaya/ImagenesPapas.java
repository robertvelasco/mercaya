package com.example.mercaya;



import androidx.appcompat.app.ActionBar;
import android.os.Bundle;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class ImagenesPapas extends AppCompatActivity {

    ImageSwitcher imagenPapas;
    Button buttonNext, buttonPreviouss;

    int [] images = {
            R.drawable.carne,
            R.drawable.frutas_variadas,
            R.drawable.condimentos,
            R.drawable.productos_lacteos,
    };

    int position =-1;


    List<Productos> listaFrutas = new ArrayList<>();

    ProductoAdapter adapter = new ProductoAdapter(listaFrutas,this);


   @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prod_papas);

        imagenPapas = findViewById(R.id.ImagPapas);
        buttonNext = findViewById(R.id.BSiguiente);
        buttonPreviouss =findViewById(R.id.Banterior);


      imagenPapas.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
	            public View makeView() {
	                ImageView imageView=new ImageView(getApplicationContext());
	                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
	                        ActionBar.LayoutParams.WRAP_CONTENT));

	                return imageView;
	            }
	        });

	        buttonNext.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                if(position<images.length-1){
	                    position=position+1;
	                    imagenPapas.setBackgroundResource(images[position]);
	                }
	            }
	        });

	        buttonPreviouss.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                if(position>0){
	                    position=position-1;
	                    imagenPapas.setBackgroundResource(images[position]);
	                }
	            }
});
}
}
