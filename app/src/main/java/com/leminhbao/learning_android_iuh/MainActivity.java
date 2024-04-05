package com.leminhbao.learning_android_iuh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewCacheFiles;
    private Button btnDeleteOne;
    private Button btnDeleteAll;
    private ArrayAdapter<String> adapter;
    private List<String> listCacheFiles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_write_external_file);

        listViewCacheFiles = findViewById(R.id.lvCache);
        btnDeleteOne = findViewById(R.id.btnDeleteOne);
        btnDeleteAll = findViewById(R.id.btnDeleteAll);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listCacheFiles);
        listViewCacheFiles.setAdapter(adapter);

        loadCacheFiles();

        btnDeleteOne.setOnClickListener(v -> {
            clearSelectedCache();
        });

        btnDeleteAll.setOnClickListener(v -> {
            clearAllCache();
        });
    }

    private void loadCacheFiles() {
        File cacheDir = getCacheDir();
        File[] files = cacheDir.listFiles();
        listCacheFiles.clear();
        if (files != null) {
            for (File file : files) {
                listCacheFiles.add(file.getName());
            }
            adapter.notifyDataSetChanged();
        }
    }

    private void clearSelectedCache() {
        if (listViewCacheFiles.getSelectedItem() == null) {
            return;
        }

        if (listCacheFiles.size() > 0) {
            String fileName = listViewCacheFiles.getSelectedItem().toString();

            File cacheDir = getCacheDir();
            File file = new File(cacheDir, fileName);
            if (file.exists()) {
                file.delete();
                listCacheFiles.remove(fileName);
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void clearAllCache() {
        File cacheDir = getCacheDir();
        for (String fileName : listCacheFiles) {
            File file = new File(cacheDir, fileName);
            if (file.exists()) {
                file.delete();
            }
        }
        listCacheFiles.clear();
        adapter.notifyDataSetChanged();
    }

}