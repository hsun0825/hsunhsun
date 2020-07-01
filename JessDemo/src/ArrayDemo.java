
public class ArrayDemo {

	public static void main(String[] args) {
		
		int[] arr= new int[16];//長度給8
//		int[] tmparr = new int[16];
		
		for (int i = 0 ; i < arr.length;i++) {
			//for (i = 0 to n ) 給予arr[i]隨機數
			
			arr[i] = (int)(Math.random()*16);
			
			for (int j = 0 ;j<i;) {
				// for(j=0 to i) arr[j] 與arr[i]之前的數列比較是否相同(第幾位)  
				
				if (arr[j] == arr[i]) {
					
					arr[i] = (int)(Math.random()*16);
					
					j = 0;//從頭開始做
				}
				
				else j++;
				
			}
	
			System.out.printf("%3d",arr[i]);
			
		}
//		System.out.println("");
//		for(int i = 0; i < arr.length; i++) 
//            System.out.printf("group[%d] = %d\n", i, arr[i]);
		System.out.println("");
		int i = 0 ;
		while(true)
		{
			i = arr[i]  ;
			if (i == 0)
				break;
			System.out.print(i + " ");
		}
		
	
//		System.out.println("");
//		int tmpindex = 0;
//		int value= 0 ;
//		for (int i = 0 ; i < arr.length;i++) {
//			value =  arr[tmpindex];
//			System.out.printf("%3d",value);
//			tmpindex = value;
//		}
	}

}
