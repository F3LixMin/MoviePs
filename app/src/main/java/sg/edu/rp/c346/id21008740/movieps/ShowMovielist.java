package sg.edu.rp.c346.id21008740.movieps;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowMovielist extends AppCompatActivity {
    Button btnAdd, btnRetrieve,btnShowMovieWithRating;
    TextView tvID;
    EditText etContent;

    Spinner spnYear;
    ListView lv;
    ArrayList<Movies> al;
    ArrayAdapter<Movies> aa;
    Movies data;
    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(ShowMovielist.this);
        al.clear();
        al.addAll(dbh.getAllNotes());
        aa.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showmv);

        Intent i = getIntent();
        data = (Movies) i.getSerializableExtra("data");


        tvID = findViewById(R.id.tvID);
        btnAdd = findViewById(R.id.Insert);
        btnRetrieve = findViewById(R.id.ShwList);
        btnShowMovieWithRating = findViewById(R.id.btnShow);
        spnYear = findViewById(R.id.spn);



        lv = findViewById(R.id.listView);
        al = new ArrayList<Movies>();
        aa = new ArrayAdapter<Movies>(this, android.R.layout.simple_list_item_1, al);
        Customadapter adapter;

        adapter = new Customadapter(this, R.layout.row, al);
        lv.setAdapter(adapter);

        btnShowMovieWithRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String result = spnYear.getSelectedItem().toString();
                Log.d("result",result+"");

                DBHelper dbh = new DBHelper(ShowMovielist.this);
                al.clear();
                if (result.equals("G")) {
                    al.addAll(dbh.getRatedG());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ShowMovielist.this, "Displaying all G rated movies!", Toast.LENGTH_SHORT).show();
                } else if (result.equals("PG")){
                    al.addAll(dbh.getRatedPG());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ShowMovielist.this, "Displaying all PG rated movies!", Toast.LENGTH_SHORT).show();
                } else if (result.equals("PG13")){
                    al.addAll(dbh.getRatedPG13());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ShowMovielist.this, "Displaying all PG13 rated movies!", Toast.LENGTH_SHORT).show();
                } else if (result.equals("NC16")){
                    al.addAll(dbh.getRatedNC16());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ShowMovielist.this, "Displaying all NC16 rated movies!", Toast.LENGTH_SHORT).show();
                } else if (result.equals("M18")){
                    al.addAll(dbh.getRatedM18());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ShowMovielist.this, "Displaying all M18 rated movies!", Toast.LENGTH_SHORT).show();
                } else if (result.equals("R21")){
                    al.addAll(dbh.getRatedR21());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ShowMovielist.this, "Displaying all R21 rated movies!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ShowMovielist.this, "Error in showing movies", Toast.LENGTH_SHORT).show();
                }

            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long identity) {
                Movies data = al.get(position);
                Intent i = new Intent(ShowMovielist.this, ModifyMovie.class);
                i.putExtra("data", data);
                startActivity(i);

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
