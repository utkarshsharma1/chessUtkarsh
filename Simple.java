package chessUtkarsh;

public class Simple extends ChessUI{
	private static final long serialVersionUID = 1L;
	
	public static boolean isMoveValid ;
	public static int R1,C1,R2,C2,a,b,c,d,whiteRook=1,blackRook=1,whiteKing=1,blackKing=1,u,t;
	public static char t1;
	public static int source_row,source_col, target_row, target_col;
    public static char[][] chessBoard={
            {'r','n','b','k','q','b','n','r'},
            {'p','p','p','p','p','p','p','p'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'P','P','P','P','P','P','P','P'},
            {'R','N','B','K','Q','B','N','R'}};
    
    public static void showBoard()
    {	
    	 for(int i=0;i<8;i++)
    	 {
    		 for(int j=0;j<8;j++)
    		 {
    			 System.out.print(chessBoard[i][j]);
    			 System.out.print(' ');
    		 }
    		 System.out.println();
    	 }
    }

    public static boolean blackPiece(int target_col, int target_row)
    {
     	if(chessBoard[target_row][target_col]<='z' & chessBoard[target_row][target_col]>='a')
     		return true;
     	else
     		return false;
    }
    
    public static boolean whitePiece(int target_col, int target_row)
    {
     	if(chessBoard[target_row][target_col]<='Z' & chessBoard[target_row][target_col]>='A')
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

    public static boolean noPieceRook(int source_col,int source_row,int target_col,int target_row)
    {
  
    	if(target_col==source_col)
    	{
    		if(source_row<target_row)
    		{  				
    			for(int i=(source_row+1);i<target_row;i++)
    			{
    				if(chessBoard[i][source_col]!='-')
    				return false;
    			}
    		}
    		else if(source_row>target_row)
    		{
    			for(int i=(source_row-1);i>target_row;i--)
    			{
    				if(chessBoard[i][source_col]!='-')
    				return false;
    			}
    		}
        } 
    	else if(target_row==source_row)
    	{
    		if(target_col>source_col)
    		{
    			for(int i=(source_col+1);i<target_col;i++)
    			{
    				if(chessBoard[source_row][i]!='-')
    				return false;
    			}
    		}
    		else if(target_col<source_col)
    		{
    			for(int i=(source_row-1);i>target_col;i--)
    			{
    				if(chessBoard[source_row][i]!='-')
    				return false;
    			}
    		}
    	}
    	return true;
    }

    public static boolean noPieceBishop(int R1,int C1, int R2, int C2)
    {
    	
		 if(C1-C2>0){
	        if(R1-R2>0){
	        	for(int i=1;i<Math.abs(R1-R2);i++){
	        		if(chessBoard[C1-i][R1-i]!='-')
	            	   return false;
	                }
	            }
	        if(R1-R2<0){
	        	for(int i=1;i<Math.abs(R1-R2);i++){
	        		if(chessBoard[C1-i][R1+i]!='-')
	                	return false;
	                }
	           }
		 }
		 else if(C1-C2<0){
			if(R1-R2<0){
		       	for(int i=1;i<Math.abs(R1-R2);i++){
		       		if(chessBoard[C1+i][R1+i]!='-')
		           	   return false;
		            }
		        }
		     if(R1-R2>0){
		       	for(int i=1;i<Math.abs(R1-R2);i++){
		     		if(chessBoard[C1+i][R1-i]!='-')
		               	return false;
		            }
		     	}
		 	}
		return true;
    }
  
    public static boolean validateMove(int p, int q, int r, int s)
    {	
    			R1 = p;
    			C1 = q;
    			R2 = r;
    			C2 = s;
    			a = R1; b = C1; c = R2; d = C2;
        		isMoveValid =validate(chessBoard[C1][R1],R1,C1,R2,C2);
        		if(isMoveValid)
        		{
        			
        			if(chessBoard[d][c]=='K'){
        				for(int i=0;i<8;i++){
        					for(int j=0;j<8;j++){
        						chessBoard[i][j]='-';
        					}
        				}
        				System.out.println("Congrats Black won the game !!!");
        			}
        			else if(chessBoard[d][c]=='k'){
        				for(int i=0;i<8;i++){
        					for(int j=0;j<8;j++){
        						chessBoard[i][j]='-';
        					}
        				}
        				System.out.println("Congrats White  won the game !!!");
        			}
        			else if(chessBoard[b][a]=='P' & d==0){
        				chessBoard[d][c]='Q';
        				chessBoard[b][a] = '-';
        				showBoard();
        			}
        			else if(chessBoard[b][a]=='p' & d==7){
        				chessBoard[d][c]='q';
        				chessBoard[b][a] = '-';
        				showBoard();
        			}
        			else if(chessBoard[d][c]=='K'){
        				KR=c;KC=d;
        			}
        			else if(chessBoard[d][c]=='k'){
        				kR=c;kC=d;
        			}
        			else if(a==3 & b==7 & c==1 & d==7 & whiteKing==1 & whiteRook==1){
        				chessBoard[d][c]='K';
        				chessBoard[7][0]='-';
        				chessBoard[b][a]='-';
        				chessBoard[7][2]='R';
        				showBoard();
        			}
        			else if(a==3 & b==0 & c==1 & d==0 & blackKing==1 & blackRook==1){
        				chessBoard[d][c]='k';
        				chessBoard[0][0]='-';
        				chessBoard[b][a]='-';
        				chessBoard[0][2]='r';
        				showBoard();
        			}
        			
        			else{
        				if(chessBoard[b][a]=='K'){
        					KC=d;KR=c;
        				}
        				else if(chessBoard[b][a]=='k'){
        					kC=d;kR=c;
        				}
        				chessBoard[d][c] = chessBoard[b][a];
        				chessBoard[b][a] = '-';
        				showBoard();
        			}
        			System.out.println("White king position is "+KR +" "+KC+" and black king position is "+kR+" "+kC);
        		}
        		else
        			System.out.println("Invalid Move");
        		return isMoveValid ;	
    }
   
    private static boolean validate(char e, int R1, int C1, int R2, int C2) {
		switch(e){
		case 'P' : if(C1==6){
			if( (C1-C2==2 |  C1-C2==1 ) & R1-R2==0 & noPiece(R2,C2))
				return true;
			else if(blackPiece(R2, C2)){
				if(C1-C2==1 & Math.abs(R2-R1)==1)
				return true;
				}
			}
			else if(C1-C2==1 & noPiece(R2,C2) & R1-R2==0 & noPiece(R2,C2))
				return true;
			else if(blackPiece(R2, C2)){
				if(C1-C2==1 & Math.abs(R2-R1)==1)
					return true;
			}
			break;
			
		case 'p' : if(C1==1){
			if( (C1-C2==-2 |  C1-C2==-1 ) & R1-R2==0 & noPiece(R2,C2))
				return true;
			else if(whitePiece(R2, C2)){
				if(C1-C2==-1 & Math.abs(R2-R1)==1)
					return true;
				}
			}
		else if(C1-C2==-1 & noPiece(R2,C2) & R1-R2==0 & noPiece(R2,C2))
			return true;
		else if(whitePiece(R2, C2)){
			if(C1-C2==-1 & Math.abs(R2-R1)==1)
				return true;
			}
			break;
			
		case 'N' : case 'n' : if(Math.abs(R2-R1)*Math.abs(C2-C1)==2)
			return true;
		 	break;
		
		case 'B' : case 'b' : if(Math.abs(C1-C2)==Math.abs(R1-R2)){
				if(noPieceBishop(R1, C1, R2, C2))
					return true;
			}
    		break;
    		
		case 'R' : case 'r' : if(R2==R1 | C1==C2){
				if(noPieceRook(R1, C1, R2,C2)){
					if(R1==0 & C1==7){
						whiteRook++;
						return true;
					}
					else if(R1==0 & C1==0){
						blackRook++;
						return true;
					}
					return true;
				}
			}
			break;
		
		case 'Q' : case 'q' : if(Math.abs(C1-C2)==Math.abs(R1-R2)){
				if(noPieceBishop(R1, C1, R2, C2))
					return true;
			}
			else if(R2==R1 | C1==C2){
				if(noPieceRook(R1, C1, R2,C2))
					return true;
			}
		
		case 'K' : case 'k' : if(Math.abs(C2-C1)*Math.abs(R1-R2)==1 | Math.abs(C2-C1)==1 & R1==R2 | Math.abs(R1-R2)==1 & C1==C2){
				if(R1==3 & C1==7){
					whiteKing++;
					return true;
				}
				else if(R1==3 & C1==0){
					blackKing++;
					return true;
				}
				return true;
			}
			else if(R1==3 & C1==7 & R2==1 & C2==7 & whiteKing==1 & whiteRook==1 & noPiece(R2, C2) & chessBoard[7][2]=='-')
				return true;
			else if(R1==3 & C1==0 & R2==1 & C2==0 & blackKing==1 & blackRook==1 & noPiece(R2, C2) & chessBoard[0][2]=='-')
				return true;
		}
		return false;
	}

}
