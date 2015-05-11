package com.administrator.recyclerview;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    public static String rslt="";
    EditText edtUsername,edtPassword;//edtUserdomain;
    Button btn;
    Spinner deptSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        edtDomainName=(EditText)findViewById(R.id.editText2);
//        edtDomainId=(EditText)findViewById(R.id.editText);






//        Toast.makeText(this,UserId,Toast.LENGTH_LONG).show();
//
        final AlertDialog ad= new AlertDialog.Builder(this).create();
        btn=(Button)findViewById(R.id.btnSignIn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtUsername=(EditText)findViewById(R.id.userName);
                edtPassword=(EditText)findViewById(R.id.password);
                ArrayAdapter<CharSequence> deptAdapter;
                deptSpinner=(Spinner)findViewById(R.id.deptSpinner);
                deptAdapter=ArrayAdapter.createFromResource(MainActivity.this,R.array.deptArray,android.R.layout.simple_spinner_item);
                deptAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                deptSpinner.setAdapter(deptAdapter);
                String dept=deptSpinner.toString();

//               edtUserdomain=(EditText)findViewById(R.id.domain);

                String userName=edtUsername.getText().toString();
                String password=edtPassword.getText().toString();
//                String domain= edtUserdomain.getText().toString();

                String domain = deptSpinner.getSelectedItem().toString();
                //String domainName=deptSpinner.toString();
//                edtDomainId=(EditText)findViewById(R.id.editText);
              // edtDomainName=(EditText)findViewById(R.id.editText2);
                //String UserId;
//                String UserId= edtDomainId.getText().toString();
                //empId=edt.get
               // UserId= String.format("%snull%s", edtDomainName.getText().toString(), edtDomainId.getText().toString());
                try{
                    rslt="START";
                    Caller c= new Caller();
                    c.Username=userName;
                    c.Password=password;
                   c.Userdomain=domain;
                    c.join();c.start();
                    while (rslt=="START"){
                        try
                        {
                            Thread.sleep(10);
                        }
                        catch (Exception ezx){
                                ezx.toString();
                        }
                    }
                    ad.setMessage(rslt);
                }
                catch (Exception ex){
                    ad.setMessage("ERROR");
                }
                ad.show();
            }
        });
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private boolean ValidateUser(String Userdomain, String Username, String Password){
        boolean success=false;
        ManagementObjectSearcher objSearcher = new ManagementObjectSearcher("SELECT * FROM  Win32_NTDomain");
        String DNSForestName = "";


        return success;

    }
}
