package sg.edu.rp.c346.id22013179.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextTask;
    Button buttonAdd;
    Button buttonClear;
    ListView listViewTasks;
    Button buttonDelete;
    Spinner spinner;

    ArrayList<String>alTask = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonClear = findViewById(R.id.buttonClear);
        listViewTasks = findViewById(R.id.ListViewTasks);
        buttonDelete = findViewById(R.id.buttonDelete);
        spinner = findViewById(R.id.spinner);

        alTask.add("Watch movie with Jenny");

        ArrayAdapter aaTask = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alTask);
        listViewTasks.setAdapter(aaTask);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                switch (i){
                    case 0:
                        editTextTask.setHint("Type in a new task here:");
                        buttonAdd.setEnabled(true);
                        buttonDelete.setEnabled(false);
                        break;
                    case 1:
                        editTextTask.setHint("Type in the index of the task to be removed:");
                        buttonAdd.setEnabled(false);
                        buttonDelete.setEnabled(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editTextTask.getText().toString();
                alTask.add(task);
                aaTask.notifyDataSetChanged();
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editTextTask.getText().toString();
                alTask.remove(task);
                aaTask.notifyDataSetChanged();
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editTextTask.getText().toString();
                int indexPos = Integer.parseInt(task);
                boolean compareIndex = indexPos >=0;
                boolean indexCompare = indexPos<alTask.size();
                if (compareIndex == true && indexCompare == true){
                    alTask.remove(indexPos);
                    aaTask.notifyDataSetChanged();
                }
            }
        });
    }
}
