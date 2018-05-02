package com.example.william.asynchw;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class UnoFragmento extends Fragment {

    ArrayList<GameUsers> users = new ArrayList<>();
    RecyclerView rvUsers;
    TextView tvAvg;
    Button btnCalc;
    UserAdapter userAdapter;

    public UnoFragmento() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_uno_fragmento, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fillData();
        rvUsers = view.findViewById(R.id.rvUsers);
        tvAvg = view.findViewById(R.id.tvAvg);
        btnCalc = view.findViewById(R.id.btCalc);
        userAdapter = new UserAdapter(users);

        RecyclerView.LayoutManager rvLayoutManager = new LinearLayoutManager(getContext());
        rvUsers.setLayoutManager(rvLayoutManager);
        rvUsers.setAdapter(userAdapter);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Average().execute();
            }
        });
    }

    private void fillData() {

        GameUsers user = new GameUsers(getString(R.string.username), 100, getString(R.string.time));
        users.add(user);

        GameUsers user2 = new GameUsers(getString(R.string.username2), 100, getString(R.string.time1));
        users.add(user2);

        GameUsers user3 = new GameUsers(getString(R.string.username3), 100, getString(R.string.time3));
        users.add(user3);

        GameUsers user4 = new GameUsers(getString(R.string.username4), 100, getString(R.string.time4));
        users.add(user4);

        GameUsers user5 = new GameUsers(getString(R.string.username5), 100, getString(R.string.time5));
        users.add(user5);

        GameUsers user6 = new GameUsers(getString(R.string.username6), 100, getString(R.string.time6));
        users.add(user6);

        GameUsers user7 = new GameUsers(getString(R.string.username7), 100, getString(R.string.time7));
        users.add(user7);

    }

    private class Average extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {

            int avgSum = 0;
            int avgRes;

            for (int i = 1; i <= 10000; i++) {

                avgSum += i;

            }

            avgRes = Math.round(avgSum / 10000);

            return avgRes;
        }

        @Override
        protected void onPostExecute(Integer d) {
            super.onPostExecute(d);

            tvAvg.setText(getString(R.string.average)+d.toString());

        }
    }
}
