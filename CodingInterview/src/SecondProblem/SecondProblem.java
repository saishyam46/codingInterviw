package SecondProblem;

	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
	import java.util.Scanner;

	public class SecondProblem {

		public static void main(String[] args) throws IOException {

			/* Data in the folders:(TEST is the folder Name)
			 * dof (1).pdf
			 * MRPT__.pdf
			 * dof (1).pdf
			 * ONLYOFFICE Sample Document.docx
			 * dof (1).pdf
			 * SAISHYAM_Resume.pdf
			 * dof (1).pdf
			 * test.docx
			 * dof (1).pdf
			 * test.docx
			 * Transcripts.pdf
			 * test.docx
			 * WhatsApp Image 2020-08-17 at 6.23.20 PM.jpeg 
			 * 
			 * 
			 *Sample INPUT : 
			 *Enter the Monthe Name:
			 *Reader Input: jul
			 *OUTPUT:
			 * MRPT__.pdf
			 *ONLYOFFICE Sample Document.docx
			 *SAISHYAM_Resume.pdf
			 *test.docx
			 *test.docx
			 *test.docx 
			 * 
			 */
				System.out.println("Enter the Monthe Name:");
				Scanner sc=new Scanner(System.in);				
		     	String inputMonth = sc.nextLine();
		     	File file=new File("C:\\TEST");
				File fileList[]=file.listFiles();
				Map<String,String>mp=new HashMap<String,String>(); 
				List<String>al=new ArrayList<>();
				for(int i=0;i<fileList.length;i++)
				{ 
					SimpleDateFormat sdf = new SimpleDateFormat("MMM");				
					mp.put(sdf.format(fileList[i].lastModified()),fileList[i].getName().toString());		      
			     
					for(Map.Entry<String,String> entry:mp.entrySet())
						{
						if(entry.getKey().equalsIgnoreCase(inputMonth)) 
						{
					  al.add(entry.getValue());
						}				 
						}		     
				}		 
				System.out.println(al.size());
		}
	
}
