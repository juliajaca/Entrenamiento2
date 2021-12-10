package com.example.entrenamiento2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

public class TitlesFragment extends ListFragment {
    boolean dualPane;
    int curCheckPosition = 0;
    private Adapter mAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState)  {
        super.onActivityCreated(savedInstanceState);

        Entrenamiento[] entrenaments = Entrenamiento.entrenaments;
        List<String> nombres = new ArrayList<>();
        for (int i= 0; i< entrenaments.length; i++){
            nombres.add(entrenaments[i].getNom());
        }


        ArrayList<Model> data=new ArrayList<Model>();

        for(int i=0;i<entrenaments.length;i++){
            data.add(new Model(entrenaments[i].getNom(), entrenaments[i].getImagen()));
        }

        mAdapter = new Adapter(getActivity(),data);
        setListAdapter(mAdapter);


        // Check to see if we have a frame in which to embed the details fragment directly in the containing UI.
        View detailsFrame = getActivity().findViewById(R.id.details);
        dualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            // Restore last state for checked position.
            curCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

        if (dualPane) {
            // In dual-pane mode, the list view highlights the selected item.
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            // Make sure our UI is in the correct state.
            showDetails(curCheckPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", curCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    void showDetails(int index) {
        curCheckPosition = index;

        if (dualPane) {
            // We can display everything in-place with fragments, so update the list to highlight the selected item and show the data.
            getListView().setItemChecked(index, true);

            // Check what fragment is currently shown, replace if needed.
            DetailsFragment details = (DetailsFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.details);
            if (details == null || details.getShownIndex() != index) {
                // Make new fragment to show this selection.
                details = DetailsFragment.newInstance(index);

                // Execute a transaction, replacing any existing fragment with this one inside the frame.
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.details, details);

                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        } else {
            // Otherwise we need to launch a new activity to display the dialog fragment with selected text.
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }
}
