package id.ryandzhunter.tescatur;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

import id.ryandzhunter.tescatur.Model.Chess;
import id.ryandzhunter.tescatur.adapter.ChessAdapter;
import id.ryandzhunter.tescatur.tcpconnect.TCPClient;

public class MainActivity extends AppCompatActivity {

    private TCPClient mTcpClient;
    private ChessAdapter chessAdapter;
    private ArrayList<Chess> list_pieces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createBoard();

        new connectTask().execute("");

    }

    // create empty chessboard
    private void createBoard() {
        GridView chessboard = (GridView) findViewById(R.id.chessboard);

        list_pieces = new ArrayList<>();

        for (int i = 0; i < 64; i++) {
            list_pieces.add(new Chess(i));
        }

        chessAdapter = new ChessAdapter(this, list_pieces);
        chessboard.setAdapter(chessAdapter);
    }

    public class connectTask extends AsyncTask<String, String, TCPClient> {

        @Override
        protected TCPClient doInBackground(String... message) {

            //we create a TCPClient object and
            mTcpClient = new TCPClient(new TCPClient.OnMessageReceived() {
                @Override
                //here the messageReceived method is implemented
                public void messageReceived(String message) {
                    //this method calls the onProgressUpdate
                    publishProgress(message);
                }
            });
            mTcpClient.run();

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            Log.i("result server", values[0]);

            final StringBuffer buff = new StringBuffer();
            String[] chess = values[0].split(" ");

            chessAdapter.changeView(chess);

        }
    }
}
