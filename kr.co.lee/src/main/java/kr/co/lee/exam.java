package kr.co.lee;


//controller,Service

public class exam implements examinterface{//인터페이스 호출
	
	public static void main(String[] args) {
	    int result = new exam().total();		
	     System.out.println(result);
	}
	//오버라이드 호출 
	@Override
		public int total() {
		    int data[] = {10,20,30};
		    int w =0 ;
		    int sum = 0;
		    while(w<data.length) {
		    	sum+=data[w];
		    	w++;
		    }
			return sum;
		}
	
	
	@Override
		public int avg() {
			int avgs = 500;
			return avgs;
		}
}
