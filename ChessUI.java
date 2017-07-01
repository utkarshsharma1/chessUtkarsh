package chessUtkarsh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.Graphics;
import java.awt.Image;


public class ChessUI extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	public static int x=0,y=0,k=0,counter=1,playerTurn=1,temp1,temp2,R1,C1,R2,C2;
	public Image img;
	public static Color brown = new Color(150,76,0);
	public static Color yellow = new Color(255,217,23);
	Simple s;
	public static boolean valid1,valid2,valid3 ;
	
	
	@Override
    public void paint(Graphics g) 
	{
        super.paintComponent(g);
        this.setBackground(Color.LIGHT_GRAY);
        printBoard(g);
        printPieces(g,s);
        this.addMouseListener(this);	
       
        if((x<=450 && x>=50)&&(y<=450 && y>=50))
        {
        	x/=50;
			x*=50;
			y/=50;
			y*=50;
			 
   			if(playerTurn%2==1)
   				playerTurn=1;
   			else
   				playerTurn=2;
   			
   			if(counter%2==1)
   				counter=1;
   			else
   				counter=2;
   			
   			if(playerTurn==1){
   				if(counter==1){
   					R1=(x-50)/50;
   	   				C1=(y-50)/50;
   	   				System.out.println(counter+" "+R1+C1+" "+"pla 1 cou1");
   	   				valid1=Simple.isSelectedPieceMine(playerTurn, R1, C1);
   	   				if(valid1)
   	   	   				counter++;
   				}
   				else if(counter==2){
   					R2=(x-50)/50;
   	   				C2=(y-50)/50;
   	   				System.out.println(counter+" "+R1+C1+" "+"pla 1 cou1");
   	   				System.out.println(counter+" "+R2+C2+" "+"pla 1 cou2");
   	   				counter++;
   	   				playerTurn++;
   				}
   			}
   			
   			if(playerTurn==2){
   				if(counter==1){
   					R1=(x-50)/50;
   	   				C1=(y-50)/50;
   	   				System.out.println(counter+" "+R1+C1+" "+"pla 1 cou1");
   	   				counter++;
   				}
   				else if(counter==2){
   					R2=(x-50)/50;
   	   				C2=(y-50)/50;
   	   				System.out.println(counter+" "+R1+C1+" "+"pla 1 cou1");
   	   				System.out.println(counter+" "+R2+C2+" "+"pla 1 cou2");
   	   				counter++;
   	   				playerTurn++;
   				}
   			}
   			
 /*       	if(counter%2==1)
        	{
        			 
       			prevLocX = (x-50)/50;
       			prevLocY = (y-50)/50;
       			
       		}
       		if(counter%2==0 && counter!=0)
       		{
       			
       			currLocX = (x-50)/50;
       			currLocY = (y-50)/50;
       			valid = s.validateMove(prevLocX,prevLocY,currLocX,currLocY);
       			//System.out.println("Second");
       			
       			//if(valid) 
       			repaint();
        		
        		printPieces(g,s);
        		
        	}	*/
       // 	counter++;
       		System.out.println();
        		
       	}
    }
  
    @Override
    public void mousePressed(MouseEvent e) 
    {
    	
    }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {
    	  x=e.getX();
          y=e.getY();
         //if(counter==0)counter++;
          repaint();
          
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
   
    void printBoard(Graphics g)
    {
        g.setColor(yellow);
        for(int i = 50; i <= 400; i+=100){
            for(int j = 50; j <= 400; j+=100){
                g.fillRect(i, j, 50, 50);
            }
        }
        for(int i = 100; i <= 450; i+=100){
            for(int j = 100; j <= 450; j+=100){
                g.fillRect(i, j, 50, 50);
            }
        
        }
        g.setColor(brown);
        for(int i = 100; i <= 400; i+=100){
            for(int j = 50; j <= 400; j+=100){
                g.fillRect(i, j, 50, 50);
            }
        }
        for(int i = 50; i <= 400; i+=100){
            for(int j = 100; j <= 450; j+=100){
                g.fillRect(i, j, 50, 50);
            }
        
        }
    }
    
    
    void printPieces(Graphics g,Simple s)
    {
    	for(int i=0;i<8;i++){
    		for(int j=0;j<8;j++)
    		{
    			if(Simple.chessBoard[i][j]<='z' && Simple.chessBoard[i][j]>='a')
    			{
    				img = new ImageIcon("b"+Simple.chessBoard[i][j]+".png").getImage();
    				g.drawImage(img, 50+(50*j),50+(50*i), 50,50, this);
    			}
    			if(Simple.chessBoard[i][j]<='Z' && Simple.chessBoard[i][j]>='A')
    			{
    				img = new ImageIcon("w"+Simple.chessBoard[i][j]+".png").getImage();
    				g.drawImage(img, 50+(50*j),50+(50*i), 50,50, this);
    			}
    				
    		}
    	}
    }
	
	
	
	
	public static void main(String[] args) {
		JFrame f=new JFrame("CHESS GAME");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChessUI ui=new ChessUI();
        f.add(ui);
        f.setSize(500, 500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
   
	}

}
