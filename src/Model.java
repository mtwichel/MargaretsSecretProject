import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
	private List<String> reasons;
	Random rand = new Random();
	private boolean parentMode;

	public Model(){
		this.reasons = new ArrayList<String>();
		this.parentMode = false;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("resources/reasons.txt"));
			String line = br.readLine();

			while (line != null) {
				reasons.add(line);
				line = br.readLine();
			}
		} catch(IOException e){
			e.printStackTrace();
			
		}
	
	}
	public String getReason(){
		String line = reasons.get(rand.nextInt(reasons.size()));
		//System.out.println(line);
		if(line.charAt(0) == '/'){
			
			if(parentMode){
				System.out.println("Yo");
				return getReason();
			}else{
				return line.substring(1);
			}
		}else{
			return line;
		}
		
	}
	public void activateParentMode(){
		this.parentMode = true;
	}

}
