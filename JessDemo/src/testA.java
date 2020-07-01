import java.io.File;

public class testA {

		public static void Name(String directory){
			File f = new File(directory);
			File[] files = f.listFiles();
			for (int i = 0 ; i < 2 ; i ++) {
				if (files[i].isFile()) {
					String fileName = "";
					fileName = files[i].getName();
					System.out.println("file Name:"+fileName);
				}
				
			}

	}

}
