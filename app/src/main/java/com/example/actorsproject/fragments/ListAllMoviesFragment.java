package com.example.actorsproject.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.actorsproject.R;
import com.example.actorsproject.model.Filmovi;
import com.example.actorsproject.provider.FilmoviProvider;

import java.util.List;

public class ListAllMoviesFragment extends Fragment {

    private int position = 0;

    public interface OnItemListFilmsClicked{
        void OnListClicked(int position);
    }

    OnItemListFilmsClicked listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (OnItemListFilmsClicked)activity;
        } catch (ClassCastException e) {
            e.toString();
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.list_movies_fragment,container,false);

    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new MoviesAsyncTask().execute();

        final List<String> listaFilmova = FilmoviProvider.getFilmoviToString1();
        ListView listView = getView().findViewById(R.id.listView_moviesFragment);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,listaFilmova);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    listener.OnListClicked(position);
                //   listener.OnListClicked(position); - program brakes because it's calling on a null object reference -


            }
        });

        // dodati da klikom na film otvori glumca koji glumi u tom filmu

    }

    public class MoviesAsyncTask extends AsyncTask<Void, Void, List<Filmovi>> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(ListAllMoviesFragment.this.getActivity());
            progressDialog.setMessage("Loading Movies! . . .");
            progressDialog.show();
        }

        @Override
        protected List<Filmovi> doInBackground(Void... voids) {

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(List<Filmovi> filmovis) {
            super.onPostExecute(filmovis);
            if (progressDialog != null) {
                progressDialog.dismiss();
                Snackbar.make(getActivity().findViewById(R.id.master_view),"All Movies Shown", Snackbar.LENGTH_LONG).show();
            }
        }
}

}
