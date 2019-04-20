package com.example.aidlclient;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aidlservice.aidl.IStudent;
import com.example.aidlservice.aidl.StudtInfo;

public class MainActivity extends AppCompatActivity {

    private IStudent student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        intent.setAction("com.example.aidlserce.studentservice");
        intent.setPackage("com.example.aidlservice");
        bindService(intent, connection, BIND_AUTO_CREATE);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                StudtInfo studtInfo = new StudtInfo();
                studtInfo.setName("小明");
                studtInfo.setMathScore(50);
                studtInfo.setEnglishScore(30);
                try {
                    student.addStudentInfoReq(studtInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            student = IStudent.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            unbindService(connection);
        }
    };
}
