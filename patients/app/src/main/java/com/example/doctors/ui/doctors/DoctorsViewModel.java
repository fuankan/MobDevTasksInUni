package com.example.doctors.ui.doctors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.doctors.R;
import com.example.doctors.models.Doctor;

import java.util.ArrayList;

public class DoctorsViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<Doctor>> persons;
    private ArrayList<Doctor> docs;

    public void setList(ArrayList<Doctor> doctors) {
        docs = doctors;
        init();
    }

    public DoctorsViewModel() {
        persons = new MutableLiveData<>();
        init();
    }

    private void init(){
        populateList();
        persons.setValue(docs);
    }

    private void populateList(){
        docs = new ArrayList<>();

        docs.add(new Doctor("Johnny", "+996708166524","Окулист", R.drawable.doc_default));
        docs.add(new Doctor("John", "+996707381514","Невропатолог", R.drawable.doc_default));
        docs.add(new Doctor("Max", "+996999888666","Хирург", R.drawable.doc_default));
        docs.add(new Doctor("Keanu", "+996505133399","Психиатр", R.drawable.doc_default));
        docs.add(new Doctor("Brad", "+996708655564","Лор", R.drawable.doc_default));
        docs.add(new Doctor("Maxim", "0700885544","Гинеколог", R.drawable.doc_default));
        docs.add(new Doctor("Akmaral", "0555996633","Невропатолог", R.drawable.doc_default));
        docs.add(new Doctor("Malik", "+996777888999","Кардиолог", R.drawable.doc_default));
        docs.add(new Doctor("Vlad", "+996708655564","Глав врач", R.drawable.doc_default));
        docs.add(new Doctor("Smith", "+996708655564","Травматолог", R.drawable.doc_default));
        docs.add(new Doctor("Leila", "+996708655564","Медсестра", R.drawable.doc_default));

    }

    public LiveData<ArrayList<Doctor>> getMutableLiveData() {
        return persons;
    }
}