package Checkers;
//Justin Stevens

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

public class MouseActivity extends MouseAdapter{
    private checkerBoardPanel tile;

    public MouseActivity(checkerBoardPanel t){
        tile = t;
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(e.getButton() == 1){
            if(tile.getBackground() == Color.GREEN){
                tile.addPiece(tile.game.pieceSelected);
                tile.game.backdrop[tile.game.previousTile].addPiece(0);
                if(tile.location == tile.game.previousTile + 18){
                    tile.game.backdrop[tile.game.previousTile + 9].addPiece(0);
                    tile.game.redPieceCount--;
                } else if(tile.location == tile.game.previousTile + 14){
                    tile.game.backdrop[tile.game.previousTile + 7].addPiece(0);
                    tile.game.redPieceCount--;
                } else if(tile.location == tile.game.previousTile - 18){
                    tile.game.backdrop[tile.game.previousTile - 9].addPiece(0);
                    tile.game.blackPieceCount--;
                } else if(tile.location == tile.game.previousTile - 14){
                    tile.game.backdrop[tile.game.previousTile - 7].addPiece(0);
                    tile.game.blackPieceCount--;
                }
                tile.game.previousTile = 0;
                tile.game.pieceSelected = 0;
                tile.game.turn = !tile.game.turn;
                if(tile.game.redPieceCount > 0 && tile.game.blackPieceCount > 0){
                    if(tile.game.turn){
                        tile.game.setTitle("checkers:\t\t Reds Turn");
                    } else {
                        tile.game.setTitle("checkers:\t\t Blacks Turn");
                    }
                } else{
                    if(tile.game.redPieceCount == 0){
                        tile.game.setTitle("checkers:\t\t Black Wins");
                    } else{
                        tile.game.setTitle("checkers:\t\t Reds Wins");
                    }
                }
                if(tile.Piece == 1 && tile.location >= 56 && tile.location <= 63){
                    tile.addPiece(3);
                }
                if(tile.Piece == 2 && tile.location >= 0 && tile.location <= 7){
                    tile.addPiece(4);
                }
            } else{
                if(tile.game.turn){
                    if(tile.getPiece() == 2 || tile.getPiece() == 4){
                        tile.game.pieceSelected = tile.getPiece();
                        tile.game.previousTile = tile.location;
                    }
                } else{
                    if(tile.getPiece() == 1 || tile.getPiece() == 3){
                        tile.game.pieceSelected = tile.getPiece();
                        tile.game.previousTile = tile.location;
                    }
                }
            }
        }
        if(e.getButton() == 3){
            tile.game.previousTile = 0;
            tile.game.pieceSelected = 0;
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if(tile.getBackground() != Color.GREEN){
            tile.setBackground(tile.getBaseColor());
            tile.hideMoves();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e){
        if(tile.getBackground() != Color.GREEN){
            tile.setBackground(Color.YELLOW);
            tile.showMoves();
        }
    }
}