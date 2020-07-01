import java.io.File;

public class testjess {

	
		 public static long getFileSize(File filename) throws Exception{
			 
			 long size = 0;
			 
			 
			 File flist[] = filename.listFiles();
			 
			 for (int i = 0 ; i < flist.length; i++) {
				 
				 if (flist[i].isDirectory()) {
					 size = size + getFileSize(flist[i]);
				 } else {
					 size = size +flist[i].length();
				 }
					 
			 }
			return size;
		 }
		 
		   public static void main(String[] args) {
			   
		      long size = 0;
		      
		      String path ="D:\\testFile1";
		      
		      File ff = new File(path);
		      
				try {
					size = getFileSize(ff);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		      
		      System.out.println("Filesize in bytes: " + size);
	}

}
