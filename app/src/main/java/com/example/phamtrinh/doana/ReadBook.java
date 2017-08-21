package com.example.phamtrinh.doana;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.InputStream;
import android.widget.Toast;

/**
 * Created by phamtrinh on 7/31/17.
 */

public class ReadBook extends Fragment implements ResAsyncPDF {
    private FragmentListener listener;
    PDFView pdfViewBook;
    ConnServer connServer = new ConnServer();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.readbook_screen,container,false);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (FragmentListener) activity;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //code
        pdfViewBook = (PDFView)view.findViewById(R.id.pdfViewBook);


        String data = getArguments().getString("databook");

        new GetPDF(this).execute(connServer.host+"books/"+data+".pdf");


    }

    @Override
    public void finish(InputStream inputStream) {
        pdfViewBook.fromStream(inputStream).load();
    }
}
