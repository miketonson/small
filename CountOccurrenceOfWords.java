import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class CountOccurrenceOfWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File docFile = null;
		try{
			docFile = new File(args[0]);
			if(!docFile.isFile()){
				System.out.println("There is no readable file in this dirctory!");
				return;
			}
		}catch(Exception ex){
			System.out.println("Input a directory after the class!");
			return;
		}
		Scanner input = null;
		try {
			input = new Scanner(docFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		while(input.hasNext()){
			String thisLine = input.nextLine();
			String[] words = thisLine.split("[ \n\t\r\"\'”“‘’.,;:!?(){}]");
			for(int i = 0;i < words.length; i++){
				String key = words[i].toLowerCase();
				if(key.length()>0){
					if(!Character.isLetter(key.charAt(0)))
							continue;
					if(map.get(key) == null){
						map.put(key, 1);
					}
					else{
						int value = map.get(key).intValue();
						value++;
						map.put(key, value);
					}
				}
			}
		}
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for(Map.Entry<String, Integer> entry: entrySet){
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}

}
