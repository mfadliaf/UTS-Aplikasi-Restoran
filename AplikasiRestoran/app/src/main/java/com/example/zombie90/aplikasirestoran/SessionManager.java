package com.example.zombie90.aplikasirestoran;

/**
 * Created by ZOMBIE90 on 10/31/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;



public class SessionManager {    // Shared Preferences
    SharedPreferences pref;

    // Editor untuk Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "BelajarPref";
    // Semua Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    // Nama User (buat dengan variable public agar dapat di akses dari luar)
    public static final String KEY_NAME = "name";

    // Alamat Email address (buat dengan variable public agar dapat di akses dari luar)
    public static final String KEY_EMAIL = "email";

    // Constructor
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    /**
     * Membuat login session
     */
    public void createLoginSession(String nama, String email) {
        // menyimpan login dengan nilai TRUE
        editor.putBoolean(IS_LOGIN, true);

        // menyimpan nama di pref
        editor.putString(KEY_NAME, nama);

        // menyimpan email di pref
        editor.putString(KEY_EMAIL, email);
        // Simpan Perubahan
        editor.commit();
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        // nama user
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        // user email id
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        // return user
        return user;


    }

    public void checkLogin() {         // Cek login status
        if (!this.isLoggedIn()) {
            // jika user tidak login maka akan d arahakan ke Login Activity
            Intent i = new Intent(_context, LoginActivity.class);
            // tutup semua Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // tambahkan Flag baru untuk memulai Activity baru
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // membuka Activity Login
            _context.startActivity(i);
            // }
        }
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void logoutUser() {
        // menghapus semua data dari Shared Preferences
        editor.clear();
        editor.commit();
        // setelah logout user diarahkan ke LoginActivity
        Intent i = new Intent(_context, LoginActivity.class);
        // tutup semua Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // tambahkan Flag baru untuk memulai Activity baru
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // membuka Activity Login
        _context.startActivity(i);
    }
}