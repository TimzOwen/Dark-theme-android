package com.owen.darkmode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    //fetch the ID
    private Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
        {
            //set the dark mode
            setTheme(R.style.darkMode);
        }
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
             mySwitch = (Switch) findViewById(R.id.switchMode);

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
        {
            mySwitch.setEnabled(true);
        }
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if (isChangingConfigurations())
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();
                }
                else
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    
                    restartApp();
                }

            }
        });
    }
    
    public void restartApp()
    {
        //refresh app for changes
        Intent i = new Intent(this.SettingsActivity, Home.class);
        i.startActivity();
        i.finish();
    }
    }

