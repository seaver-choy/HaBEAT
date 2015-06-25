package com.jtbmilan.habeat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jtbmilan.habeat.contacts.ContactManager;
import com.jtbmilan.habeat.selfhelp.urgesurfing.UrgeSurfingActivity;
import com.jtbmilan.habeat.sms.SmsManager;


public class MainActivity extends AppCompatActivity {
    private ContactManager contactManager;
    private SmsManager smsManager;
    private RadioGroup radioGroup;
    private CravingType selectedCravingType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactManager = new ContactManager();
        smsManager = new SmsManager(this);

        selectedCravingType = CravingType.CIGARETTE;
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.cigaretteRadioBtn: {
                        selectedCravingType = CravingType.CIGARETTE;
                        break;
                    }

                    case R.id.alcoholRadioBtn: {
                        selectedCravingType = CravingType.ALCOHOL;
                        break;
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickCravingBtn(View view) {
        notifySupportGroup();
        Intent intent = new Intent(getApplicationContext(), selectedCravingType.randomActivity());
        startActivity(intent);
    }

    // TODO - detect user's name to be able to use it in the message
    private void notifySupportGroup() {
        //smsManager.sendToAll(contactManager.getContacts(), "<User> is having a craving and needs your help");
        Toast.makeText(getApplicationContext(),
                "Your support group has been notified", Toast.LENGTH_SHORT).show();
    }

}
