package com.ppal007.nestedrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.ppal007.nestedrecyclerview.Adapter.ParendRVAdapter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewParent;
    private ParendRVAdapter parendRVAdapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<String> groupList;

    private String[] teamName;
    private int[] teamLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        finding xml..............................................................
        recyclerViewParent = findViewById(R.id.recyclerViewParent_id);

//        prepare resource data.........................................................
        teamName = getResources().getStringArray(R.array.team_list);
        teamLogo = new int[]{
                R.drawable.afganisthan,
                R.drawable.australia,
                R.drawable.bangladesh,
                R.drawable.england,
                R.drawable.india,
                R.drawable.pakistan,
                R.drawable.sauth_africa,
                R.drawable.srilanka,
                R.drawable.zimbabua,
                R.drawable.westindis
        };


//        initialize parent recycler view.................................................
        groupList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            groupList.add("Group " + i);
        }
        parendRVAdapter = new ParendRVAdapter(MainActivity.this, groupList, teamName, teamLogo);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerViewParent.setLayoutManager(layoutManager);
        recyclerViewParent.setHasFixedSize(true);
        recyclerViewParent.setAdapter(parendRVAdapter);

    }
}
