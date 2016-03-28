/**
 *  {HSV Color Picker/ ick up the color you like, it will be displayed by colorSwatch. }
 *  Jinhong Fan {fan00036@algonquinlive.com}
 */
package com.fan00036algonquincollege.hsvcolorpicker;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // CLASS VARIABLES (by convention, class vars in upper-case)
    private static final String ABOUT_DIALOG_TAG;
    private SeekBar hueBar;
    private SeekBar saturationBar;
    private SeekBar valueBar;
    private TextView colorSwatch;
    private TextView hueText;
    private  TextView saturationText;
    private  TextView valueText;
    private HSV hsv;

    //TODO pro-tip: class vars (i.e. static vars) can be initialized within a static block initializer.
    static {
        ABOUT_DIALOG_TAG = "About Dialog";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        hsv=new HSV();
        linkUI();
        linkListener();

    }

    private void linkListener() {
        hueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                if(fromUser) hueText.setText("HUE: " + progress + "\u00B0");
                hsv.setH(progress);
                showResult();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                hueText.setText("Hue");
            }
        });

        saturationBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                if (fromUser) saturationText.setText("SATURATION: " + progress + "%");
                hsv.setS(progress);
                showResult();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                saturationText.setText("Saturation");
            }
        });

        valueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                if(fromUser) valueText.setText("VALUE/LIGHTNESS: " + progress + "%");
                hsv.setV(progress);
                showResult();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                valueText.setText("Value/Lightness");
            }
        });


        colorSwatch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),hsv.toString(), Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    private void showResult() {
        colorSwatch.setBackgroundColor(hsv.getColor());
    }

    private void linkUI() {
         hueBar = (SeekBar)findViewById(R.id.HueBar);
         saturationBar = (SeekBar)findViewById(R.id.SaturationBar);
         valueBar = (SeekBar)findViewById(R.id.ValueBar);
         colorSwatch = (TextView)findViewById(R.id.ColorSwatch);
        hueText = (TextView)findViewById(R.id.hue);
        saturationText = (TextView)findViewById(R.id.saturation);
        valueText = (TextView)findViewById(R.id.value);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show( getFragmentManager(), ABOUT_DIALOG_TAG );
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void pickColor(View view) {
        ColorDrawable btnColor = (ColorDrawable)view.getBackground();
        int colorValue = btnColor.getColor();
        colorSwatch.setBackgroundColor(colorValue);

        hsv.setHSV(colorValue);
        hueBar.setProgress((int) hsv.getH());
        saturationBar.setProgress((int) hsv.getS());
        valueBar.setProgress((int) hsv.getV());
        Toast.makeText(getApplicationContext(), hsv.toString(), Toast.LENGTH_SHORT).show();


    }





}
