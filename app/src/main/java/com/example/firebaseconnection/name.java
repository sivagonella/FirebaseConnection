package com.example.firebaseconnection;

import com.google.firebase.auth.FirebaseUser;

public class name {
    private String n;
  //  private FirebaseUser user;
    public name(){}
    public name(String n/*, FirebaseUser user*/){
        this.n = n;
    //    this.user = user;
    }

    //public FirebaseUser getUser(){
      //  return this.user;
    //}

    public String getN() {
        return n;
    }
}
