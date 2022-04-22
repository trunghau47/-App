package com.example.appdiemdanh;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

//public class OpenJoinDialog extends AppCompatActivity {
//    public static final String TAG = OpenJoinDialog.class.getSimpleName();
//    private Button btnOpenJoinDialog;
//    Dialog dialog;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_bottom_sheet);
//
//        dialog = new Dialog(OpenJoinDialog.this);
//        dialog.setContentView(R.layout.layout_join_class);
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.setCancelable(false);
//        btnOpenJoinDialog = findViewById(R.id.btnThamGiaLopHoc);
//        btnOpenJoinDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                dialog.show();
//            }
//        });
//    }


//}
public class OpenJoinDialog extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_bottom_sheet, container, false);
        final Button btnJoinClass = (Button) root.findViewById(R.id.btnThamGiaLopHoc);
        btnJoinClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), JoinClass.class);
                startActivity(intent);
            }
        });
        return root;
    }
//    private void openJoinDialog(int gravity) {
//        final Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.layout_join_class);
//
//        Window window = dialog.getWindow();
//        if(window == null){
//            return;
//        }
//
//        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        WindowManager.LayoutParams windowAttributes = window.getAttributes();
//        windowAttributes.gravity = gravity;
//        window.setAttributes(windowAttributes);
//
//        dialog.show();
//    }
}
