package Checkers;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

@SuppressWarnings("unused")
public class checkers extends JFrame{
    public checkerBoardPanel[] backdrop = new checkerBoardPanel[64];
    private boolean colorFlip = false;
    public boolean turn = true;
    //true = red, false = black
    int pieceSelected = 0;
    int previousTile = 0;
    int redPieceCount = 12;
    int blackPieceCount = 12;

    public checkers(){
        setVisible(true);
        setTitle("checkers:\t\t Reds Turn");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8,8));

        for(int i=0; i<64; i++){
            backdrop[i] = new checkerBoardPanel(this, i);
            backdrop[i].addMouseListener(new MouseActivity(backdrop[i]));
            if(i>0 && i%8 == 0){
                colorFlip = !colorFlip;
            }
            if(colorFlip){
                backdrop[i].setBackground(new Color(153,102,0));
                backdrop[i].setBaseColor(new Color(153,102,0));
                colorFlip = !colorFlip;
            } else{
                backdrop[i].setBackground(new Color(219,170,73));
                backdrop[i].setBaseColor(new Color(219,170,73));
                colorFlip = !colorFlip;
            }
            add(backdrop[i]);
        }
        boardSetUp();
        revalidate();
    }

    public void boardSetUp(){
        int j = 0;
        for(int i=0; i<16; i+=2){
            backdrop[i].addPiece(1);
            j++;
            if(j == 4){
                i++;
                j = 0;
            }
        }
        backdrop[16].addPiece(1);
        backdrop[18].addPiece(1);
        backdrop[20].addPiece(1);
        backdrop[22].addPiece(1);
        j = 0;
        for(int i=41; i<56; i+=2){
            backdrop[i].addPiece(2);
            j++;
            if(j == 4){
                i++;
            }
        }
        backdrop[48].addPiece(2);
        backdrop[57].addPiece(2);
        backdrop[59].addPiece(2);
        backdrop[61].addPiece(2);
        backdrop[63].addPiece(2);
    }

    public static void main(String[] args){
        new checkers();
    }
}