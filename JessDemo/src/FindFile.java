import java.io.File;

public class FindFile {
	public static void main(String[] args) {

		File file = new File("D:\\");

		String[] filenames;

		String fullpath = file.getAbsolutePath();// ���o���|
		{

			if (file.isDirectory())

			{
				
				filenames = file.list();

				for (int i = 0; i < filenames.length; i++)

				{

					File tempFile = new File(fullpath + "\\" + filenames[i]);

					if (tempFile.isDirectory())

					{

						System.out.println("�ؿ�:" + filenames[i]);

					}

					else

						System.out.println("�ɮ�:" + filenames[i]);

				}

			}

			else

				System.out.println("[" + file + "]���O�ؿ�");

	
	/*

	public static void main(String[] args) {
		File file = new File("D:\\test2");
		System.out.println(file.getName());
		print(file, 1);
	}

	private static void print(File file, int i) {
		String perLevel = "";
        for(int i1=0; i1<i1; i1++){
            perLevel += "  ";
        }
        File[] child = file.listFiles();
        for (int i1=0; i1<child.length; i1++){
            System.out.println(perLevel + child[i1].getName());
            if(child[i1].isDirectory()){
                print(child[i1], i1 + 1);
            }
	}

	
		
	}
*/
		}
	}
}