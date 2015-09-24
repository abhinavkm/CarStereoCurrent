package cs301.carstereo;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;


public class CarStereoCurrent extends ActionBarActivity{
    private ToggleButton power;

    private TextView trackNum;
    private TextView vol;
    private ToggleButton am_fm;
    private LinearLayout cd;

    private SeekBar seekBar;
    private TextView radioVal;

    private Button firstPre;
    private Button secondPre;
    private Button thirdPre;
    private Button fourthPre;
    private Button fifthPre;
    private Button sixthPre;

    private Button volUp;
    private Button volDown;
    private TextView volume;
    private int volLevel = 0;

    private int[] amPre = { 20, 70, 120, 170, 220, 270 };
    private int[] fmPre = { 28, 48, 68, 88, 108, 128 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_stereo_current);

        //initialize vars
        power = (ToggleButton) findViewById(R.id.power_button);
        trackNum = (TextView) findViewById(R.id.track_number);
        vol = (TextView) findViewById(R.id.volume_value);
        am_fm = (ToggleButton) findViewById(R.id.am_fm_button);
        cd = (LinearLayout) findViewById(R.id.cd_slot);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        radioVal = (TextView) findViewById(R.id.radio_val);

        firstPre = (Button) findViewById(R.id.first_preset_button);
        secondPre = (Button) findViewById(R.id.second_preset_button);
        thirdPre = (Button) findViewById(R.id.third_preset_button);
        fourthPre = (Button) findViewById(R.id.fourth_preset_button);
        fifthPre = (Button) findViewById(R.id.fifth_preset_button);
        sixthPre = (Button) findViewById(R.id.six_preset_button);

        volUp = (Button) findViewById(R.id.volume_up);
        volDown = (Button) findViewById(R.id.volume_down);
        volume = (TextView) findViewById(R.id.volume_value);

        //set listeners
        power.setOnClickListener(new powerListener());
        am_fm.setOnClickListener(new amFmListener());

        firstPre.setOnClickListener(new firstPreListener());
        firstPre.setOnLongClickListener(new firstLongListener());

        secondPre.setOnClickListener(new secondPreListener());
        secondPre.setOnLongClickListener(new secondLongListener());

        thirdPre.setOnClickListener(new thirdPreListener());
        thirdPre.setOnLongClickListener(new thirdLongListener());

        fourthPre.setOnClickListener(new fourthPreListener());
        fourthPre.setOnLongClickListener(new fourthLongListener());

        fifthPre.setOnClickListener(new fifthPreListener());
        fifthPre.setOnLongClickListener(new fifthLongListener());

        sixthPre.setOnClickListener(new sixthPreListener());
        sixthPre.setOnLongClickListener(new sixthLongListener());

        //seek bar listener
        seekBar.setOnSeekBarChangeListener(new seekListener());

        volDown.setOnClickListener(new volDownListener());
        volUp.setOnClickListener(new volUpListener());
    }

    //each listener needs a class that implements listener and overrides methods (left click red)
    public class volDownListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(Integer.parseInt(volume.getText().toString()) > 0) {
                volume.setText("" + --volLevel);
            }
        }
    }

    public class volUpListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(Integer.parseInt(volume.getText().toString()) < 15) {
                volume.setText("" + ++volLevel);
            }
        }
    }

    public class firstLongListener implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {

            if(am_fm.getText().equals("AM")) {
                amPre[0] =  seekBar.getProgress();
            }
            else {
                fmPre[0] = seekBar.getProgress();
            }

            return true;
        }
    }

    public class secondLongListener implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {

            if(am_fm.getText().equals("AM")) {
                amPre[1] =  seekBar.getProgress();
            }
            else {
                fmPre[1] = seekBar.getProgress();
            }

            return true;
        }
    }
    public class thirdLongListener implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {

            if(am_fm.getText().equals("AM")) {
                amPre[2] =  seekBar.getProgress();
            }
            else {
                fmPre[2] = seekBar.getProgress();
            }

            return true;
        }
    }
    public class fourthLongListener implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {

            if(am_fm.getText().equals("AM")) {
                amPre[3] =  seekBar.getProgress();
            }
            else {
                fmPre[3] = seekBar.getProgress();
            }

            return true;
        }
    }
    public class fifthLongListener implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {

            if(am_fm.getText().equals("AM")) {
                amPre[4] =  seekBar.getProgress();
            }
            else {
                fmPre[4] = seekBar.getProgress();
            }

            return true;
        }
    }

    public class sixthLongListener implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {

            if(am_fm.getText().equals("AM")) {
                amPre[5] =  seekBar.getProgress();
            }
            else {
                fmPre[5] = seekBar.getProgress();
            }

            return true;
        }
    }

    public class sixthPreListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(am_fm.getText().equals("AM")) {
                seekBar.setProgress(amPre[5]);
            }
            else {
                seekBar.setProgress(fmPre[5]);
            }
        }
    }

    public class fifthPreListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(am_fm.getText().equals("AM")) {
                seekBar.setProgress(amPre[4]);
            }
            else {
                seekBar.setProgress(fmPre[4]);
            }
        }
    }

    public class fourthPreListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(am_fm.getText().equals("AM")) {
                seekBar.setProgress(amPre[3]);
            }
            else {
                seekBar.setProgress(fmPre[3]);
            }
        }
    }

    public class thirdPreListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(am_fm.getText().equals("AM")) {
                seekBar.setProgress(amPre[2]);
            }
            else {
                seekBar.setProgress(fmPre[2]);
            }
        }
    }

    public class secondPreListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(am_fm.getText().equals("AM")) {
                seekBar.setProgress(amPre[1]);
            }
            else {
                seekBar.setProgress(fmPre[1]);
            }
        }
    }

    public class firstPreListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(am_fm.getText().equals("AM")) {
                seekBar.setProgress(amPre[0]);
            }
            else {
                seekBar.setProgress(fmPre[0]);
            }
        }
    }

    public  class seekListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            if(am_fm.getText().equals("AM")) {
                seekBar.setMax(1700 - 530);
                radioVal.setText(String.valueOf(progress + 530)); //show progress
            }
            else {
                seekBar.setMax(1079 - 881);
                radioVal.setText(String.valueOf((progress + 881)/ 10.0)); //show progress
            }


        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
    public class amFmListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if( am_fm.isChecked() ) {
                am_fm.setText("AM");
            }
            else {
                am_fm.setText("FM");
            }
        }
    }

    public class powerListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(power.isChecked()) {
                trackNum.setBackgroundColor(Color.BLUE);
                vol.setTextColor(Color.RED);
                am_fm.setTextColor(Color.GREEN);
                cd.setBackgroundColor(Color.YELLOW);


                am_fm.setEnabled(true);
                seekBar.setEnabled(true);
                firstPre.setEnabled(true);
                secondPre.setEnabled(true);
                thirdPre.setEnabled(true);
                fourthPre.setEnabled(true);
                fifthPre.setEnabled(true);
                sixthPre.setEnabled(true);
                volDown.setEnabled(true);
                volUp.setEnabled(true);
            }
            else {
                trackNum.setBackgroundColor(Color.BLACK);
                vol.setTextColor(Color.BLACK);
                am_fm.setTextColor(Color.BLACK);
                cd.setBackgroundColor(Color.BLACK);
                
                am_fm.setEnabled(false);
                seekBar.setEnabled(false);
                firstPre.setEnabled(false);
                secondPre.setEnabled(false);
                thirdPre.setEnabled(false);
                fourthPre.setEnabled(false);
                fifthPre.setEnabled(false);
                sixthPre.setEnabled(false);
                volDown.setEnabled(false);
                volUp.setEnabled(false);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_car_stereo_current, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
