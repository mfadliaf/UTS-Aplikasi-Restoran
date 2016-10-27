package com.example.zombie90.aplikasirestoran;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.country;
import static android.R.attr.name;

/**
 * Created by ZOMBIE90 on 10/27/2016.
 */

public class MakananAdapter extends BaseAdapter {

    private Activity activity;
    private List<Makanan> makananList;
    private LayoutInflater inflater;

    public MakananAdapter(Activity activity, List<Makanan> countryList){
        this.activity = activity;
        this.makananList = makananList;
    }

    @Override
    public int getCount() {
        return makananList.size();
    }

    @Override
    public Object getItem(int position) {
        return makananList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null){
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item, null);
        }
        ImageView gambar = (ImageView) convertView.findViewById(R.id.Gambar_list);
        TextView namamakanan  = (TextView) convertView.findViewById(R.id.Nama_list);
        TextView harga = (TextView) convertView.findViewById(R.id.Harga_list);

        Makanan makanan = makananList.get(position);
        gambar.setImageResource(makanan.getGambar_makanan());
        namamakanan.setText(makanan.getNama_makanan());
        harga.setText(makanan.getHarga());
        return convertView;
    }
}
