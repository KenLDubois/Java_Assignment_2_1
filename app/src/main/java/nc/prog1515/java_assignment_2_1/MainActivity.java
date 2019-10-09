package nc.prog1515.java_assignment_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    public int bgR = 223;
    public int bgG = 223;
    public int bgB = 223;

    public String fontFamily = "Sans-Serif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtDisplayText = (TextView) findViewById(R.id.txtDisplayText);
        final View layDisplay = (View) findViewById(R.id.layDisplay);

        txtDisplayText.setTextColor(Color.DKGRAY);

        final TextView txtDisplayInput = (TextView) findViewById(R.id.txtDisplayInput);
        final Button btnUpdateText = (Button) findViewById(R.id.btnUpdateText);
        final Switch swchCaps = (Switch) findViewById(R.id.swchCaps);

        final ToggleButton togBold = (ToggleButton) findViewById(R.id.togBold);
        final ToggleButton togItallic = (ToggleButton) findViewById(R.id.togItallic);

        final RadioGroup radGroupFont = (RadioGroup)findViewById(R.id.radGroupFont);

        final SeekBar seekFontSize = (SeekBar) findViewById(R.id.seekFontSize);
        final TextView txtFontSize = (TextView) findViewById(R.id.txtFontSize);

        final SeekBar seekBgR = (SeekBar) findViewById(R.id.seekBgR);
        final SeekBar seekBgG = (SeekBar) findViewById(R.id.seekBgG);
        final SeekBar seekBgB = (SeekBar) findViewById(R.id.seekBgB);

        final CheckBox chkLightText = (CheckBox) findViewById(R.id.chkLightText);

        final Button btnSaveSettings = (Button) findViewById(R.id.btnSaveSettings);

        radGroupFont.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radGroupFont, int checkedId) {
                if (checkedId != -1) {
                    RadioButton rb = (RadioButton) findViewById(checkedId);


                    if(rb.getText().toString().equals("Sans Serif")){
                        txtDisplayText.setTypeface(Typeface.create("sans-serif",txtDisplayText.getTypeface().getStyle()));
                    }
                    if(rb.getText().toString().equals("Serif")){
                        txtDisplayText.setTypeface(Typeface.create("serif",txtDisplayText.getTypeface().getStyle()));
                    }
                    if(rb.getText().toString().equals("Casual")){
                        txtDisplayText.setTypeface(Typeface.create("casual",txtDisplayText.getTypeface().getStyle()));
                    }
                    if(rb.getText().toString().equals("Cursive")){
                        txtDisplayText.setTypeface(Typeface.create("cursive",txtDisplayText.getTypeface().getStyle()));
                    }

                    fontFamily = rb.getText().toString();
                }
            }
        });

        chkLightText.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(chkLightText.isChecked()){
                    txtDisplayText.setTextColor(Color.LTGRAY);
                }
                else {
                    txtDisplayText.setTextColor(Color.DKGRAY);
                }
            }
        });

        btnUpdateText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtDisplayText.setText(txtDisplayInput.getText());
            }
        });

        btnSaveSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                int txtColor = txtDisplayText.getCurrentTextColor();

                int bgColor = Color.TRANSPARENT;
                Drawable background = layDisplay.getBackground();
                if (background instanceof ColorDrawable)
                    bgColor = ((ColorDrawable) background).getColor();

                Settings settings = new Settings(
                        txtDisplayText.getText().toString(),
                        txtDisplayText.getTypeface(),
                        txtDisplayText.getTextSize(),
                        fontFamily,
                        txtColor,
                        bgColor
                        );

                Toast.makeText(MainActivity.this, "Settings Saved: \n" + settings.toString(), Toast.LENGTH_LONG).show();
            }
        });

        swchCaps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Boolean caps = swchCaps.isChecked() ? true : false;
                txtDisplayText.setAllCaps(caps);
            }
        });

        togBold.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setFontWeight(togBold, togItallic, txtDisplayText);
            }
        });

        togItallic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setFontWeight(togBold, togItallic, txtDisplayText);
            }
        });

        seekFontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int fontSize = progress + 12;
                txtFontSize.setText("Font Size: " + fontSize);
                txtDisplayText.setTextSize((float)fontSize);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBgR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                bgR = progress;
                layDisplay.setBackgroundColor(Color.rgb(bgR,bgG,bgB));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBgG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                bgG = progress;
                layDisplay.setBackgroundColor(Color.rgb(bgR,bgG,bgB));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBgB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                bgB = progress;
                layDisplay.setBackgroundColor(Color.rgb(bgR,bgG,bgB));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setFontWeight(ToggleButton bld, ToggleButton ital, TextView txt){
        if(bld.isChecked() && ital.isChecked()){

            txt.setTypeface(Typeface.create(txt.getTypeface(),Typeface.BOLD_ITALIC));
        }
        else if(!bld.isChecked() && !ital.isChecked()){
            txt.setTypeface(Typeface.create(txt.getTypeface(),Typeface.NORMAL));
        }
        else if(bld.isChecked()){
            txt.setTypeface(Typeface.create(txt.getTypeface(),Typeface.BOLD));
        }
        else if(ital.isChecked()){
            txt.setTypeface(Typeface.create(txt.getTypeface(),Typeface.ITALIC));
        }
    }

}
