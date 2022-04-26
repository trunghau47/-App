package com.example.appdiemdanh;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SignInFragment extends Fragment {
    EditText username, password;
    //DBHelper DB;
    //DBHelper DB;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sign_in, container, false);
        final Button btnLogin = (Button) root.findViewById(R.id.login);
        //DB = new DBHelper(getActivity());
        username = (EditText) root.findViewById(R.id.username1);
        password = (EditText) root.findViewById(R.id.password1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                Intent intent = new Intent(getActivity(), ClassActivity.class);
                startActivity(intent);
//                if (user.equals("") || pass.equals(""))
//                    Toast.makeText(getActivity().getApplicationContext(), "Nhập tài khoản và mật khẩu", Toast.LENGTH_SHORT).show();
//                else {
//                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
//                    if (checkuserpass == true) {
//                        Toast.makeText(getActivity().getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getActivity(), ClassActivity.class);
//                        startActivity(intent);
//
//                    }
//                    else {
//                        Toast.makeText(getActivity().getApplicationContext(), "Tên đăng nhập hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
//                    }
//                }
            }
        });
        return root;
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sign_in, container, false);
//        final Button btnLogin = (Button) root.findViewById(R.id.login);
//      //  DB = new DBHelper(getActivity());
//        username = (EditText) root.findViewById(R.id.username1);
//        password = (EditText) root.findViewById(R.id.password1);
//
//
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                String user = username.getText().toString();
//                String pass = password.getText().toString();
//                if (user.equals("") || pass.equals(""))
//                    Toast.makeText(getActivity().getApplicationContext(), "Nhập tài khoản và mật khẩu", Toast.LENGTH_SHORT).show();
//                else {
//                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
//                    if (checkuserpass == true) {
//                        Toast.makeText(getActivity().getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getActivity(), ClassActivity.class);
//                        startActivity(intent);
//
//                    }
//                    else {
//                        Toast.makeText(getActivity().getApplicationContext(), "Tên đăng nhập hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
//        return root;
//    }
}
