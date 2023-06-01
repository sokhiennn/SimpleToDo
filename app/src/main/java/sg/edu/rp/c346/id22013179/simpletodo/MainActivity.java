package sg.edu.rp.c346.id22013179.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextTask;
    Button buttonAdd;
    Button buttonClear;
    ListView listViewTasks;

    ArrayList<String>alTask = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonClear = findViewById(R.id.buttonClear);
        listViewTasks = findViewById(R.id.ListViewTasks);

        
    }
}