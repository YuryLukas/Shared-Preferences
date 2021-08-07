package jl.tutor.calculatorofdream;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MyPreferences implements Preferences{
    public static final String APP_PREFERENCES = "mysettings";
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
    private SharedPreferences sharedPreferences;
    private RadioGroup radioGroup;
    private int radioGroupValue;

    public MyPreferences() {

    }

    public MyPreferences(RadioGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    @Override
    public void loadPreferences() {
        loadRadioButton();
    }

    @Override
    public void savePreferences() {
        saveRadioButton();
    }

    private void saveRadioButton(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_RADIOBUTTON_INDEX, radioGroupValue);
        editor.apply();
    }

    private void loadRadioButton(){
        int savedRadioIndex = sharedPreferences.getInt(KEY_RADIOBUTTON_INDEX, 0);
        RadioButton savedCheckedRadioButton = (RadioButton) radioGroup.getChildAt(savedRadioIndex);
        savedCheckedRadioButton.setChecked(true);
    }

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    public void setRadioGroup(RadioGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    public int getRadioGroupValue() {
        return radioGroupValue;
    }

    public void setRadioGroupValue(int radioGruppValue) {
        this.radioGroupValue = radioGruppValue;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
}
