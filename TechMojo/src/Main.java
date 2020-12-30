import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

		public static void main(String args[]) throws IOException
		{
			File f=new File("E:\\Input File.txt");
			FileReader fr=new FileReader(f);     
			BufferedReader br=new BufferedReader(fr);   
			StringBuffer sb=new StringBuffer();   
			String line;  
			Map<String,String>startMap=new HashMap<String,String>();
			Map<String,String>endMap=new HashMap<String,String>();
			while((line=br.readLine())!=null)  
			{  
				String data[]=line.split(",");
				if(data[3].equals("start"))
				{
					startMap.put(data[0], data[2]);
				}
				if(data[3].equals("end"))
				{
					endMap.put(data[0], data[2]);
				}
			}  
			List<String>closedTransactionsList=new ArrayList<String>();
			List<String>openTransactionsList=new ArrayList<String>(); 
			float avg = 0;
			for(Map.Entry<String,String> entry1:startMap.entrySet())
			{
				for(Map.Entry<String,String> entry2:endMap.entrySet())
				{
					if(entry1.getKey().equals(entry2.getKey()))
							{
						String startTime =entry1.getValue();
					    String endTime = entry2.getValue();
					    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
					    Date d1 = null;
					    Date d2 = null;
					    
					    try {
					        d1 = sdf.parse(startTime);
					        d2 = sdf.parse(endTime);
					    } catch (ParseException e) {
					        e.printStackTrace();
					    }
					    long diff = d2.getTime() - d1.getTime();
					    long diffMinutes = diff / (60 * 1000) % 60;
					    closedTransactionsList.add(entry1.getKey());
					    avg=avg+diffMinutes;
				System.out.println("Transcation "+entry1.getKey() +" is completed in "+diffMinutes+" minutes!!");
						}
					if(!endMap.containsKey(entry1.getKey()))
							{
					
					if(!openTransactionsList.contains(entry1.getKey()))
					{
						openTransactionsList.add(entry1.getKey());
						System.out.println("Transcation "+entry1.getKey() +" is in progress");
					}
					}
				}
			}
			System.out.println("Average Time for completed Transactions is : "+ (avg/closedTransactionsList.size() +" minutes"));
			fr.close();
						 
		}
}
