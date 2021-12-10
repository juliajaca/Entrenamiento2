package com.example.entrenamiento2;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

public class DetailsFragment extends Fragment {

    public static DetailsFragment newInstance(int index) {
        DetailsFragment f = new DetailsFragment();

        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        FrameLayout scroller = new FrameLayout(getActivity());
        TextView text = new TextView(getActivity());
        ImageView imagen = new ImageView(getActivity());

        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                4, getActivity().getResources().getDisplayMetrics());
        text.setPadding(100, padding, padding, padding);

        Entrenamiento[] entrenaments = Entrenamiento.entrenaments;

        List<String> descripciones = new ArrayList<>();
        for (int i= 0; i< entrenaments.length; i++){
            descripciones.add(entrenaments[i].getDescripcio());
        }

        text.setText(descripciones.get(getShownIndex()));


        int[] imagenes = new int[entrenaments.length];
        for (int i= 0; i< entrenaments.length; i++){
            imagenes[i] = entrenaments[i].getImagen();
        }

        imagen.setImageResource(imagenes[getShownIndex()]);

        scroller.addView(imagen);
        imagen.getLayoutParams().height = 100;
        imagen.getLayoutParams().width = 100;

        scroller.addView(text);
        return scroller;
    }
}
