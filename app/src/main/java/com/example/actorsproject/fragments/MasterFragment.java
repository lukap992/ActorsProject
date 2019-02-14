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
import com.example.actorsproject.model.Glumci;
import com.example.actorsproject.provider.GlumciProvider;

import java.util.ArrayList;
import java.util.List;

public class MasterFragment extends Fragment {

    private boolean landscape = false;
    private MasterAsyncTask masterAsyncTask = null;
    private static boolean sync_ing_progress = false;

    public interface OnItemSelected{
        void OnItemClick(int position);
    }
    OnItemSelected listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            listener = (OnItemSelected)activity;
        }catch (ClassCastException e){
            e.toString();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.master_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getActivity().findViewById(R.id.detail_landscape_view) != null){
            landscape = true;
        }else{
            landscape = false;
            if(!sync_ing_progress){
                masterAsyncTask = new MasterAsyncTask();
                masterAsyncTask.execute();
                sync_ing_progress = true;
            }
        }
        final List<String> listaImenaGlumaca = GlumciProvider.getGlumciNames();
        final ListView listView = getActivity().findViewById(R.id.master_fragment_listView);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listaImenaGlumaca);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    listener.OnItemClick(position);
            }
        });
    }
    public class MasterAsyncTask extends AsyncTask<Void, Void, List<Glumci>>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(MasterFragment.this.getActivity());
            progressDialog.setMessage("Loading Actors, please wait.");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }

        @Override
        protected List<Glumci> doInBackground(Void... voids) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
            if(isCancelled()){
                return null;
            }
            return GlumciProvider.getGlumci();
        }

        @Override
        protected void onPostExecute(List<Glumci> glumci) {
            super.onPostExecute(glumci);
            sync_ing_progress = false;
            if(progressDialog != null){
                progressDialog.dismiss();
            }
            if(glumci != null){
                Snackbar.make(getActivity().findViewById(R.id.master_fragment_listView), "Done, Enjoy the App", Snackbar.LENGTH_LONG);
                GlumciProvider.getGlumci();
            }
        }
    }
}
