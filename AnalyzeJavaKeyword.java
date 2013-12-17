import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class AnalyzeJavaKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File javaFile = null;
		try{
			javaFile = new File(args[0]);
			if(!javaFile.isFile()){
				System.out.println("There is no readable Java file in this dirctory!");
				return;
			}
		}catch(Exception ex){
			System.out.println("Input a directory after the class!");
			return;
		}
		Set<String> set = new HashSet<String>();
		set.add("null");
		set.add("true");
		set.add("false");
		//System.out.println(set.contains("null"));
		Scanner input = null;
		try {
			input = new Scanner(javaFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int num = 0;
		while(input.hasNext()){
			String thisLine = input.nextLine();
			String[] words = thisLine.split("[ \n\t\r.;{}()!]");
			for(int i = 0;i < words.length; i++){
				if(set.contains(words[i]))
					num++;
			}
		}
		System.out.println("The number of the three keyword is " + num);
	}

}
