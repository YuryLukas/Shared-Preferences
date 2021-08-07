package jl.tutor.calculatorofdream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Integer radioButtonSaved=0;
    MyPreferences preferences;
    // это будет именем файла настроек


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(radioGroupOnCheckedChangeListener);
        preferences = new MyPreferences(radioGroup);
        preferences.setSharedPreferences(this.getSharedPreferences("jl.tutor.calculatorofdream", Context.MODE_PRIVATE));
        preferences.loadPreferences();
        radioButtonSaved = preferences.getRadioGroupValue();
    }


    RadioGroup.OnCheckedChangeListener radioGroupOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(checkedId);
            int checkedIndex = radioGroup.indexOfChild(checkedRadioButton);
            preferences.setRadioGroupValue(checkedIndex);
            preferences.savePreferences();

        }
    };
}