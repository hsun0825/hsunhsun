
public class ArrayDemo {

	public static void main(String[] args) {
		
		int[] arr= new int[16];//���׵�8
//		int[] tmparr = new int[16];
		
		for (int i = 0 ; i < arr.length;i++) {
			//for (i = 0 to n ) ����arr[i]�H����
			
			arr[i] = (int)(Math.random()*16);
			
			for (int j = 0 ;j<i;) {
				// for(j=0 to i) arr[j] �Parr[i]���e���ƦC����O�_�ۦP(�ĴX��)  
				
				if (arr[j] == arr[i]) {
					
					arr[i] = (int)(Math.random()*16);
					
					j = 0;//�q�Y�}�l��
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
