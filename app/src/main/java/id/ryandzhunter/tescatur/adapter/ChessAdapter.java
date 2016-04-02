package id.ryandzhunter.tescatur.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import id.ryandzhunter.tescatur.Model.Chess;
import id.ryandzhunter.tescatur.R;

/**
 * Created by ryandzhunter on 4/2/16.
 */

public class ChessAdapter extends BaseAdapter {
    private ArrayList<Chess> list_pieces;
    private Context context;
    private ImageView pieceContent;

    public ChessAdapter( Context context, ArrayList<Chess> pieces) {
        this.context = context;
        this.list_pieces = pieces;
    }

    @Override
    public int getCount() {
        return list_pieces.size();
    }

    @Override
    public Object getItem(int position) {
        return list_pieces.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list_pieces.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater l = LayoutInflater.from(context);
        View v = l.inflate(R.layout.square, parent, false);
        ImageView background = (ImageView)v.findViewById(R.id.square_background);
        ImageView piece = (ImageView) v.findViewById(R.id.piece);

        if (list_pieces.get(position).isBlack()) {
            background.setBackgroundColor(ContextCompat.getColor(context,android.R.color.white));
        } else {
            background.setBackgroundColor(ContextCompat.getColor(context,R.color.grey));
        }

        piece.setImageResource(list_pieces.get(position).getImageResouce());

        return v;
    }

    public void changeView(String[] chess){

        // reset all list_pieces
        list_pieces = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            list_pieces.add(new Chess(i));
        }

        String name;
        char col ;
        char row ;

        // add pieces to chessboard
        for (int i = 0; i < chess.length ; i++) {
            name = String.valueOf(chess[i].charAt(0));
            col = chess[i].charAt(1);
            row = chess[i].charAt(2);

            int position = getIdbyRownCol(row, col);

            list_pieces.get(position).setName(name);
        }

        notifyDataSetChanged();

    }

    public int getIdbyRownCol(char row, char col){

        int id = calculateRow(row) + calculateCol(col);

        return id;
    }

    public int calculateRow(char row){

        int id = 0;
        switch (row){
            case '8' : id = 0; break;
            case '7' : id = 8; break;
            case '6' : id = 16; break;
            case '5' : id = 24; break;
            case '4' : id = 32; break;
            case '3' : id = 40; break;
            case '2' : id = 48; break;
            case '1' : id = 56; break;
            default: id = 0;
        }

        return id;
    }

    public int calculateCol(char col){

        int id = 0;
        switch (col){
            case 'a' : id = 0; break;
            case 'b' : id = 1; break;
            case 'c' : id = 2; break;
            case 'd' : id = 3; break;
            case 'e' : id = 4; break;
            case 'f' : id = 5; break;
            case 'g' : id = 6; break;
            case 'h' : id = 7; break;
            default: id = 0;
        }

        return id;
    }

}
