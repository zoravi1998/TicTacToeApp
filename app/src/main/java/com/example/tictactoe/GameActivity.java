package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    boolean player1, player2;
    GridView gridView;
    ImageButton button;
    TextView tv;
    String game;
    Context mContext;
    static final int[] col = new int[]{R.color.blank, R.color.blank, R.color.blank, R.color.blank, R.color.blank, R.color.blank, R.color.blank, R.color.blank, R.color.blank};
    char[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_acitvity);
        mContext = this;
        arr = new char[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = '*';
        }
        tv = (TextView) findViewById(R.id.textView2);
        gridView = (GridView) findViewById(R.id.gridView1);
        button = (ImageButton) findViewById(R.id.btn1);
        gridView.setAdapter(new gridAdapter(mContext, col));
        player1 = true;
        player2 = false;
        game = "Game Started";
        msg();
        tv.setText("Player 1 Chance");
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageView box = v.findViewById(R.id.dataItem);
                if (player1 && !player2 && arr[position] == '*') {
                    box.setImageResource(R.drawable.cross);
                    arr[position] = 'x';
                    int ch = check();
                    if (ch == 1) {
                        tv.setText("Player 1 Won \uD83C\uDFC6");
                        player1 = false;
                        player2 = false;
                    } else if (ch == 2) {
                        tv.setText("Game Draw!!");
                        player1 = false;
                        player2 = false;

                    } else {
                        tv.setText("Player 2 Chance");
                        player1 = false;
                        player2 = true;
                    }
                    //Log.d("position",Integer.toString(position)+"");

                } else if (player2 && !player1 && arr[position] == '*') {
                    box.setImageResource(R.drawable.circle);
                    arr[position] = 'o';
                    //Log.d("position",Integer.toString(position)+"");
                    int ch = check();
                    if (ch == 1) {
                        tv.setText("Player 2 Won \uD83C\uDFC6");
                        player1 = false;
                        player2 = false;
                    } else if (ch == 2) {
                        tv.setText("Game Draw!!");
                        player1 = false;
                        player2 = false;

                    } else {
                        tv.setText("Player 1 Chance");
                        player2 = false;
                        player1 = true;
                    }
                } else if (!player1 && !player2) {
                    game = "Please reset the Game";
                    msg();
                } else {
                    game = "Not a Valid Move";
                    msg();
                }

            }

        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridView.setAdapter(new gridAdapter(getApplicationContext(), col));
                for (int i = 0; i < 9; i++)
                    arr[i] = '*';
                tv.setText("Player 1 Chance");
                player1 = true;
                player2 = false;
            }
        });
    }

    public int check() {
        if ((arr[0] == 'x' && arr[1] == 'x' && arr[2] == 'x') || (arr[0] == 'o' && arr[1] == 'o' && arr[2] == 'o'))
            return 1;
        else if ((arr[3] == 'x' && arr[4] == 'x' && arr[5] == 'x') || (arr[3] == 'o' && arr[4] == 'o' && arr[5] == 'o'))
            return 1;
        else if ((arr[6] == 'x' && arr[7] == 'x' && arr[8] == 'x') || (arr[6] == 'o' && arr[7] == 'o' && arr[8] == 'o'))
            return 1;
        else if ((arr[0] == 'x' && arr[3] == 'x' && arr[6] == 'x') || (arr[0] == 'o' && arr[3] == 'o' && arr[6] == 'o'))
            return 1;
        else if ((arr[1] == 'x' && arr[4] == 'x' && arr[7] == 'x') || (arr[1] == 'o' && arr[4] == 'o' && arr[7] == 'o'))
            return 1;
        else if ((arr[2] == 'x' && arr[5] == 'x' && arr[8] == 'x') || (arr[2] == 'o' && arr[5] == 'o' && arr[8] == 'o'))
            return 1;
        else if ((arr[0] == 'x' && arr[4] == 'x' && arr[8] == 'x') || (arr[0] == 'o' && arr[4] == 'o' && arr[8] == 'o'))
            return 1;
        else if ((arr[2] == 'x' && arr[4] == 'x' && arr[6] == 'x') || (arr[2] == 'o' && arr[4] == 'o' && arr[6] == 'o'))
            return 1;
        else {
            for (int i = 0; i < 9; i++)
                if (arr[i] == '*')
                    return 0;
        }
        return 2;
    }

    public void msg() {
        Toast.makeText(getApplicationContext(), game, Toast.LENGTH_SHORT).show();
    }
}