package marketplace.jpr.com.moviesquotespractise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import marketplace.jpr.com.moviesquotespractise.adapter.MoviesAdapter;
import marketplace.jpr.com.moviesquotespractise.models.MovieData;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class ShareDataActivity extends AppCompatActivity {
    List<MovieData> moviesQuotesList = new ArrayList<>();
    RecyclerView recyclerView;
    private TextView quote,writer;
    private MoviesAdapter moviesQuotesListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_data);

        //clickListner
        quote = findViewById(R.id.shared_qutoes);
        writer = findViewById(R.id.shared_writer);


        recyclerView = findViewById(R.id.recyclerView1);
        View cardView = findViewById(R.id.cardView);


        Bundle bundle = getIntent().getExtras();
        final String dialog = bundle.getString("Text");
        String w_nmae = bundle.getString("Writtername");

        quote.setText(dialog);
        writer.setText(w_nmae);

        //method
        recyclerViewOperation();

    }



    public void recyclerViewOperation() {

        //  moviesQuotesListAdapter = new MoviesQuotesListAdapter(moviesQuotesList);

        MoviesAdapter moviesQuotesListAdapter= new MoviesAdapter(moviesQuotesList, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // recyclerView.setAdapter(moviesQuotesListAdapter);
        recyclerView.setAdapter(moviesQuotesListAdapter);


        for (int i =0 ; i<100; i++){
            MovieData movieData = new MovieData();
            movieData.setQuote("This is dummy Quetes This is dummy Quetes This is dummy Quetes This is dummy QuetesThis is dummy Quetes"+i);
            movieData.setWriter(" -- Raj kumar"+i);
            moviesQuotesList.add(movieData);
        }


  /*      moviesQuotesListAdapter.setmoviesQuotesListInterface(new MoviesAdapter.MoviesQuotesListInterface() {
            @Override
            public void moviesQuotesListItem(int position) {
                Intent i = new Intent(MainActivity.this,ShareDataActivity.class);
                i.addFlags(FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("Text", moviesQuotesList.get(position).getQuote());
                i.putExtra("Writtername", moviesQuotesList.get(position).getWriter());

                startActivity(i);

            }
        });*/

    }


}
