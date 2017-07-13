package chessUtkarsh;

public class king extends Simple{

	private static final long serialVersionUID = 1L;

	public static void Check(int playerTurn, int R2, int C2) {
		switch(chessBoard[C2][R2]){
		case 'P' : if(chessBoard[C2-1][R2-1]=='k' | chessBoard[C2-1][R2+1]=='k')
				System.out.println("Wow white pawn you just checked black king");break;
		case 'p' : if(chessBoard[C2-1][R2-1]=='K' | chessBoard[C2-1][R2+1]=='K')
				System.out.println("Wow black pawn you just checked white king");break;
		case 'N' : if(Math.abs(kC-C2)*Math.abs(kR-R2)==2)
				System.out.println("Wow white Knight you just checked black king");break;
		
		case 'n' : if(Math.abs(kC-C2)*Math.abs(kR-R2)==2)
				System.out.println("Wow black Knight you just checked white king");break;
		case 'R' : if(R2==kR | kC==C2){
				if(noPieceRook(R2,C2,kR,kC))
					System.out.println("Wow white Rook you just checked black king");
				}break;
		
		case 'r' : if(R2==kR | KC==C2){
				if(noPieceRook(R2,C2,KR,KC))
					System.out.println("Wow black Rook you just checked white king");
				}break;
			
		case 'B' : if(Math.abs(C2-kC)==Math.abs(R2-kR)){
				if(noPieceBishop(R2, C2, kR, kC))
					System.out.println("Wow white Bishop you just checked black king");
				}break;
		case 'b' :	if(Math.abs(C2-KC)==Math.abs(R2-KR)){
				if(noPieceBishop(R2, C2, KR, KC))
					System.out.println("Wow black Bishop you just checked white king");
				}break;
		
		case 'Q' : if(Math.abs(kC-C2)==Math.abs(kR-R2)){
				if(noPieceBishop(R2, C2 , kR, kC))
					System.out.println("Wow white Queen you just checked black king");
				}
				else if(R2==kR | kC==C2){
					if(noPieceRook( R2,C2, kR, kC ))
						System.out.println("Wow white Queen you just checked black king");
				}break;
				
		case 'q' : if(Math.abs(KC-C2)==Math.abs(KR-R2)){
				if(noPieceBishop(R2, C2 , KR, KC))
					System.out.println("Wow black Queen you just checked white king");
				}
				else if(R2==KR | KC==C2){
					if(noPieceRook( R2,C2, KR, KC ))
						System.out.println("Wow black Queen you just checked white king");
				}break;
		}
	}

	
}


