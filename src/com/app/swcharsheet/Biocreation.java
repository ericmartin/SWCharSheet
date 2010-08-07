package com.app.swcharsheet;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Biocreation extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biocreation);
        
        Spinner class_spinner = (Spinner) findViewById(R.id.className);
        ArrayAdapter<CharSequence> class_adapter = ArrayAdapter.createFromResource(
                this, R.array.starting_class_array, android.R.layout.simple_spinner_item);
        class_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        class_spinner.setAdapter(class_adapter);
        
        Spinner species_spinner = (Spinner) findViewById(R.id.species);
        ArrayAdapter<CharSequence> species_adapter = ArrayAdapter.createFromResource(
                this, R.array.species_array, android.R.layout.simple_spinner_item);
        species_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        species_spinner.setAdapter(species_adapter);
        
        Spinner destiny_spinner = (Spinner) findViewById(R.id.destiny);
        ArrayAdapter<CharSequence> destiny_adapter = ArrayAdapter.createFromResource(
                this, R.array.destiny_array, android.R.layout.simple_spinner_item);
        destiny_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destiny_spinner.setAdapter(destiny_adapter);
        
    }
}