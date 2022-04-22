package com.example.appdiemdanh;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class ForgotPassFragment extends Fragment {
    EditText txtEmail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_forgot_pass, container, false);
        final Button btnForgotPass = (Button) root.findViewById(R.id.btnForgotPass);
        txtEmail = (EditText) root.findViewById(R.id.txtMail);
        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString();
                if (email.equals(""))
                    Toast.makeText(getActivity().getApplicationContext(), "Nhập email", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(getActivity().getApplicationContext(), "Thư giãn một lát để nhớ lại mật khẩu của bạn", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }
}