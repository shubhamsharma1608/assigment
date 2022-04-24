package com.example.android_assign;

import android.graphics.Bitmap;

public class model {
    int id;
    String name;
    String subjects;
    String qualification;


    public model(int id, String name, String subjects, String qualification,String profileImage) {
        this.id = id;
        this.name = name;
        this.subjects=subjects;
        this.qualification=qualification;
    }

    public int getid() {
        return id;
    }

    public void setid(int userid) {
        this.id = userid;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getprofileImage(String profileImage) {
        return profileImage;
    }

    public Bitmap getprofileImage() {
        return null;
    }
}
