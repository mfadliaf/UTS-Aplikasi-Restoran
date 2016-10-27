package com.example.zombie90.aplikasirestoran;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PesanMakanan.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PesanMakanan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PesanMakanan extends Fragment {


    private List<Makanan> makananList = new ArrayList<>();
    private MakananAdapter makananAdapter;

    private ListView listView;

    String[] namaMakanan = new String[]{
            "Kerak Telor", "Tahu Gimbal","Mi Lendir", "Nasi Gandul", "Rawon Setan"
    };
    int[] gambarId = new int[]{
            R.drawable.kerak_telor, R.drawable.tahu_gimbal,R.drawable.mi_lendir,R.drawable.nasi_gandul,
            R.drawable.rawon_setan
    };
    String[] harga = new String[]{
            "10.000", "15.000","15.000", "18.000", "12.000"
    };



    int[] details = new int[]{
            R.string.details_keraktelor,R.string.details_tahugimbal,R.string.details_milendir,
            R.string.details_nasigandul,R.string.details_rawonsetan
    };
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PesanMakanan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PesanMakanan.
     */
    // TODO: Rename and change types and number of parameters
    public static PesanMakanan newInstance(String param1, String param2) {
        PesanMakanan fragment = new PesanMakanan();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listView = (ListView)findViewById(R.id.list_makanan);
        //Custom ListAdapter
        makananAdapter = new MakananAdapter(this, makananList);
        //Setting ListView's adapter to the custom list adapter we've created
        listView.setAdapter(makananAdapter);



        for (int i = 0;i<namaMakanan.length;i++){
            Makanan makanan = new Makanan();
            makanan.setNama_makanan(namaMakanan[i]);
            makanan.setHarga(harga[i]);
            makanan.setGambar_makanan(gambarId[i]);
            makananList.add(makanan);
        }

        //Open a new activity when a list item is clicked.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Declaring Intent
                Intent i = new Intent(PesanMakanan.this, DetailMakanan.class);
                //Putting required data in intent
                i.putExtra("flag",gambarId[position]);
                i.putExtra("details", details[position]);
                startActivity(i);
            }
        });

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pesan_makanan, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
