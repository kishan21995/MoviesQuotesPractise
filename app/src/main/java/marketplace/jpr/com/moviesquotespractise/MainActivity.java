package marketplace.jpr.com.moviesquotespractise;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import marketplace.jpr.com.moviesquotespractise.adapter.MoviesAdapter;
import marketplace.jpr.com.moviesquotespractise.models.MovieData;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity extends AppCompatActivity {
    List<MovieData> moviesQuotesList = new ArrayList<>();
    RecyclerView recyclerView;
    private MoviesAdapter moviesQuotesListAdapter;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        recyclerView = findViewById(R.id.recyclerview);
        View cardView = findViewById(R.id.cardView);
        recyclerViewOperation();

        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        /*Navigation UI*/
        //NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

       /*Navigation UI*/
       // NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*Navigation UI*/
  /*  @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }*/



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


        moviesQuotesListAdapter.setmoviesQuotesListInterface(new MoviesAdapter.MoviesQuotesListInterface() {
            @Override
            public void moviesQuotesListItem(int position) {
                Intent i = new Intent(MainActivity.this,ShareDataActivity.class);
                i.addFlags(FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("Text", moviesQuotesList.get(position).getQuote());
                i.putExtra("Writtername", moviesQuotesList.get(position).getWriter());

                startActivity(i);

            }
        });

    }

}
