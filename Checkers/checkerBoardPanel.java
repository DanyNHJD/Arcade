package Checkers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

@SuppressWarnings("unused")
public class checkerBoardPanel extends JPanel{
    Color baseColor;
    int Piece = 0;
    int location;
    checkers game;
    JLabel img = new JLabel();

    public checkerBoardPanel(checkers gameBoard, int loc){
        add(img);
        location = loc;
        game = gameBoard;
    }

    public void setBaseColor(Color c){
        baseColor = c;
    }

    public Color getBaseColor(){
        return baseColor;
    }

    public void showMoves(){
        if(Piece != 0 && game.pieceSelected == 0){
            if(Piece == 1 || Piece == 3 || Piece == 4){
                if(nextLine(location, location+7,Piece)){
                    if(game.backdrop[location + 7].getPiece() == 0){
                        game.backdrop[location + 7].setBackground(Color.GREEN);
                    } else {
                        if(game.backdrop[location + 14].getPiece() == 0 && game.backdrop[location + 7].getPiece() != Piece){
                            if(next2Line(location, location+14,Piece)){
                                game.backdrop[location + 14].setBackground(Color.GREEN);
                            }
                        }
                    }
                }
                if(nextLine(location, location+9,Piece)){
                    if(game.backdrop[location + 9].getPiece() == 0){
                        game.backdrop[location + 9].setBackground(Color.GREEN);
                    } else {
                        if(game.backdrop[location + 18].getPiece() == 0 && game.backdrop[location + 9].getPiece() != Piece){
                            if(next2Line(location, location+18,Piece)){
                                game.backdrop[location + 18].setBackground(Color.GREEN);
                            }
                        }
                    }
                }
            }
            if(Piece == 2 || Piece == 3 || Piece == 4){
                if(nextLine(location, location-7,Piece)){
                    if(game.backdrop[location - 7].getPiece() == 0){
                        game.backdrop[location - 7].setBackground(Color.GREEN);
                    } else {
                        if(game.backdrop[location - 14].getPiece() == 0 && game.backdrop[location - 7].getPiece() != Piece){
                            if(next2Line(location, location-14,Piece)){
                                game.backdrop[location - 14].setBackground(Color.GREEN);
                            }
                        }
                    }
                }
                if(nextLine(location, location-9,Piece)){
                    if(game.backdrop[location - 9].getPiece() == 0){
                        game.backdrop[location - 9].setBackground(Color.GREEN);
                    } else {
                        if(game.backdrop[location - 18].getPiece() == 0 && game.backdrop[location - 9].getPiece() != Piece){
                            if(next2Line(location, location-18,Piece)){
                                game.backdrop[location - 18].setBackground(Color.GREEN);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean nextLine(int loc, int newLoc, int p/*piece*/){
        if(loc >= 0 && loc <= 7){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 8 && newLoc <= 15){
                return true;
            } else if(p == 2){
                return false;
            }
        } else if(loc >= 8 && loc <= 15){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 16 && newLoc <= 23){
                return true;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 0 && newLoc <= 7){
                return true;
            }
        } else if(loc >= 16 && loc <= 23){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 24 && newLoc <= 31){
                return true;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 8 && newLoc <= 15){
                return true;
            }
        } else if(loc >= 24 && loc <= 31){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 32 && newLoc <= 39){
                return true;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 16 && newLoc <= 23){
                return true;
            }
        } else if(loc >= 32 && loc <= 39){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 40 && newLoc <= 47){
                return true;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 24 && newLoc <= 31){
                return true;
            }
        } else if(loc >= 40 && loc <= 47){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 48 && newLoc <= 55){
                return true;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 32 && newLoc <= 39){
                return true;
            }
        } else if(loc >= 48 && loc <= 55){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 56 && newLoc <= 63){
                return true;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 40 && newLoc <= 47){
                return true;
            }
        } else if(loc >= 56 && loc <= 63){
            if(p == 1){
                return false;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 48 && newLoc <= 55){
                return true;
            }
        }
        return false;
    }

    public boolean next2Line(int loc, int newLoc, int p/*piece*/){
        if(loc >= 0 && loc <= 7){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 16 && newLoc <= 23){
                return true;
            } else if((p == 2 || p == 3 || p == 4)){
                return false;
            }
        } else if(loc >= 8 && loc <= 15){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 24 && newLoc <= 31){
                return true;
            } else if((p == 2 || p == 3 || p == 4)){
                return false;
            }
        } else if(loc >= 16 && loc <= 23){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 32 && newLoc <= 39){
                return true;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 0 && newLoc <= 7){
                return true;
            }
        } else if(loc >= 24 && loc <= 31){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 40 && newLoc <= 47){
                return true;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 8 && newLoc <= 15){
                return true;
            }
        } else if(loc >= 32 && loc <= 39){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 48 && newLoc <= 55){
                return true;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 16 && newLoc <= 23){
                return true;
            }
        } else if(loc >= 40 && loc <= 47){
            if((p == 1 || p == 3 || p == 4) && newLoc >= 56 && newLoc <= 63){
                return true;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 24 && newLoc <= 31){
                return true;
            }
        } else if(loc >= 48 && loc <= 55){
            if(p == 1){
                return false;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 32 && newLoc <= 39){
                return true;
            }
        } else if(loc >= 56 && loc <= 63){
            if(p == 1){
                return false;
            } else if((p == 2 || p == 3 || p == 4) && newLoc >= 40 && newLoc <= 57){
                return true;
            }
        }
        return false;
    }

    public void hideMoves(){
        if(game.pieceSelected == 0){
            for(int i=0; i<64; i++){
                game.backdrop[i].setBackground(game.backdrop[i].getBaseColor());
            }
        }
    }

    public int getPiece(){
        return Piece;
    }

    public void addPiece(int pieceCode){
        Piece = pieceCode;
        if(pieceCode == 0){
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
            img.setIcon(imageIcon);
        }
        if(pieceCode == 1){
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("Checkers/blackPiece.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
            img.setIcon(imageIcon);
        }
        if(pieceCode == 2){
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("Checkers/redPiece.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
            img.setIcon(imageIcon);
        }
        if(pieceCode == 3){
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("Checkers/blackKing.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
            img.setIcon(imageIcon);
        }
        if(pieceCode == 4){
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("Checkers/redKing.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
            img.setIcon(imageIcon);
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawLine(0,0,0,75);
        g.drawLine(0,0,75,0);
        g.drawLine(0,75,75,75);
        g.drawLine(75,0,75,75);
    }
}
