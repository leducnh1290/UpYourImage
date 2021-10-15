package com.ducanh.cachua;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ducanh.Options.FileUp;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.HashMap;

public class Download extends Fragment  {
    TextInputEditText textInputEditText;
    private DatabaseReference databaseReference =
            FirebaseDatabase.getInstance ("https://ca-chua-it-default-rtdb.firebaseio.com/").getReference ();
    FileUp fileUp = new FileUp (databaseReference);
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.download,container,false);
        initView(view);
        textInputEditText.setOnEditorActionListener (new TextView.OnEditorActionListener () {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                fileUp.Up ("name",textInputEditText.getText ().toString ());
                return false;
            }
        });
        return view;
    }
    private void initView(View view) {
      textInputEditText= view.findViewById (R.id.password);
    }
}
