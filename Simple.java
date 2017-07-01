package chessUtkarsh;

public class Simple {
	public static int BLACK = 1;
	public static int WHITE = 0;
	public static int i;
	public static int j;
	public static boolean f,g,h,t;
	public static int R1,C1,R2,C2,playerturn;
	public static char t1;
	public static int source_row,source_col, target_row, target_col;
    public static char[][] chessBoard={
            {'r','n','b','q','k','b','n','r'},
            {'p','p','p','p','p','p','p','p'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'P','P','P','P','P','P','P','P'},
            {'R','N','B','Q','K','B','N','R'}};
    
    public static void showBoard()
    {	
    	 for(i=0;i<8;i++)
    	 {
    		 for(j=0;j<8;j++)
    		 {
    			 System.out.print(chessBoard[i][j]);
    			 System.out.print(' ');
    		 }
    		 System.out.println();
    	 }
    }

    public static boolean oppPiece(int target_col, int target_row)
    {
     	if(chessBoard[target_row][target_col]<='z' & chessBoard[target_row][target_col]>='a')
     		return true;
     	else
     		return false;
    }

    public static boolean noPiece(int target_col,int target_row)
    {
    	if(chessBoard[target_row][target_col]=='-')
    		return true;
    	else
    		return false;
    }

    public static boolean noPieceR(int source_col,int source_row,int target_col,int target_row)
    {
    	f = true;
    	if(target_col==source_col)
    	{
    		if(source_row<target_row)
    		{  				
    			for(i=(source_row+1);i<target_row;i++)
    			{
    				if(chessBoard[i][source_col]!='-')
    					f = false;
    			}
    		}
    		else if(source_row>target_row)
    		{
    			for(i=(source_row-1);i>target_row;i--)
    			{
    				if(chessBoard[i][source_col]!='-')
    					f = false;
    			}
    		}
        } 
    	else if(target_row==source_row)
    	{
    		if(target_col>source_col)
    		{
    			for(i=(source_col+1);i<target_col;i++)
    			{
    				if(chessBoard[source_row][i]!='-')
    					return false;
    			}
    		}
    		else if(target_col<source_col)
    		{
    			for(i=(source_row-1);i>target_col;i--)
    			{
    				if(chessBoard[source_row][i]!='-')
    					return false;
    			}
    		}
    	}
    	f = f & (oppPiece(target_col,target_row) | noPiece(target_col,target_row));
    	return f;
    }

    public static boolean noPieceB(int source_col,int source_row,int target_col,int target_row)
    {
    	g = true;
    	int diff_row = target_row - source_row;
		int diff_col = target_col - source_col;
		 if(diff_row>0)
		 {
	            if(diff_col>0)
	            {
	                for( i=(source_row+1);i<(target_row);i++)
	                {
	                    for( j=(source_col+1);j<(target_col);j++)
	                    {
	                        if(chessBoard[i][j]!='-')	                      
	                        	return false; 
	                    }
	                }
	            }
	            if(diff_col<0)
	            {
	                for(i=(source_row+1);i<(target_row);i++)
	                {
	                    for( j=(source_col-1);j>(target_col);j--)
	                    {
	                        if(chessBoard[i][j]!='-')	                      
	                        	return false; 
	                    }
	                }
	            }
		 }
		 else if(diff_row<0)
		 {
	            if(diff_col>0)
	            {
	                for( i=(source_row-1);i>(target_row);i--)
	                {
	                    for( j=(source_col+1);j<(target_col);j++)
	                    {
	                        if(chessBoard[i][j]!='-')	                      
	                        	return false; 
	                    }
	                }
	            }
	            if(diff_col<0)
	            {
	                for(i=(source_row-1);i>(target_row);i--)
	                {
	                    for( j=(source_col-1);j>(target_col);j--)
	                    {
	                        if(chessBoard[i][j]!='-')	                      
	                        	return false; 
	                    }
	                }
	            }
		}
		g = g & (oppPiece(target_col,target_row) | noPiece(target_col,target_row));
			
	    return g;
    }
  
    public static boolean validateMove(int p, int q, int r, int s)
    {
    			int a,b,c,d;	
    			source_col = p;
    			source_row = q;
    			target_col = r;
    			target_row = s;
    			a = source_col;
        		b=source_row;
        		c = target_col;
        		d=target_row;
        		f =validate(chessBoard[source_row][source_col],source_col, source_row, target_col, target_row);
        		if(f==true)
        		{
        			chessBoard[d][c] = chessBoard[b][a];
        			chessBoard[b][a] = '-';
        			showBoard();
        		}
        		else
        			System.out.println("Invalid Move");
        		return f;	
    }
    

    public static boolean validate(char p, int source_col,int source_row,int target_col,int target_row)
    {
    	boolean r = false;
    	
    	switch(p)
    	{
    	case 'P':if(((source_row-target_row)==2 )& noPiece(target_col, target_row))
    			  {
    			   		r = true ;
    			  }
    			 else if(((source_row-target_row)==1 )& noPiece(target_col, target_row))
    			 {
 			   		r = true ;
    			 }
    			// else if((Math.abs(target_col-source_col)==1 & target_row-source_row == 1) & oppPiece(target_col, target_row))
    			break;
    	case 'N':if((Math.abs(target_col-source_col)==2 & Math.abs(target_row-source_row)==1)& (noPiece(target_col, target_row) | oppPiece(target_col, target_row)))
    			 {
    				r = true;
    			 }
    			 else if((Math.abs(source_col-target_col)==1 & Math.abs(source_row-target_row)==2)& (noPiece(target_col, target_row) | oppPiece(target_col, target_row)))
    			 {
    				 r = true;
    			 }
    			 break;
    	
    	case 'R':if((target_col==source_col)| (target_row==source_row) )
    			 {
    				if(noPieceR(source_col, source_row,target_col, target_row))
    					r=true;
    			 }
    			 break;
    	case 'B':if(Math.abs(source_row-target_row)==Math.abs(source_col-target_col) & noPieceB(source_col, source_row,target_col, target_row))		
    				r = true;
    			 break;
    	case 'Q':if(Math.abs(source_row-target_row)==Math.abs(source_col-target_col))
    			 {
    				r = noPieceB(source_col, source_row,target_col, target_row);
    			 }
    			 if((target_row==source_row)|(target_col==source_col))
    			 {
    				r = noPieceR(source_col, source_row,target_col, target_row);
    			 }
    			 break;
    	case 'K':{int diff_row = Math.abs(target_row - source_row);
				 int diff_col = Math.abs(target_col - source_col);
    			 if(diff_row==1 | diff_col==1)
    				 if(noPiece(target_col, target_row)|oppPiece(target_col, target_row))
    					 r = true;}
    			 break;
        }
    	return r;
    }

	public static boolean isSelectedPieceMine(int p, int q, int r) {
		R1=q;
		C1=r;
		playerturn=p;
		if(playerturn==1){
			f=checkWhitePiece(chessBoard[R1][C1]);
		}
		else if(playerturn==2){
			f=checkBlackPiece(chessBoard[R1][C1]);
		}
		return f;

	}

	private static boolean checkBlackPiece(char c) {
		t1=c;
		if(t1>='a' & t1<='z')
			return true;
		else 
			System.out.println("This is not your piece");
			return false;
	}

	private static boolean checkWhitePiece(char c) {
		t1=c;
		if(t1>='A' & t1<='Z')
			return true;
		else 
			System.out.println("This is not your piece");
			return false;
	}
}
