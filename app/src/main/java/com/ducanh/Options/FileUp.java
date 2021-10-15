package com.ducanh.Options;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class FileUp {
    public DatabaseReference databaseReference;
    public String name,link,data;

    public FileUp(DatabaseReference databaseReference) {
        this.databaseReference = databaseReference;
    }
    public void Up(String name,String link){
        if(name!=null&&link!=null){
            this.name = name;
            this.link = link;
            HashMap<String,Object> hashMap = new HashMap<> ();
            hashMap.put (this.name,this.link);
            databaseReference.updateChildren (hashMap);
        }else{
            //To do some things
        }
    }
//    public String getData(String chill){
//        final String[] a = {new String ()};
//      databaseReference.child (chill).addValueEventListener (new ValueEventListener () {
//          @Override
//          public void onDataChange(@NonNull DataSnapshot snapshot) {
//             a[0] = snapshot.getValue ().toString ().trim ().intern ();
//          }
//
//          @Override
//          public void onCancelled(@NonNull DatabaseError error) {
//
//          }
//      });
//      return a[0];
//    }
}
