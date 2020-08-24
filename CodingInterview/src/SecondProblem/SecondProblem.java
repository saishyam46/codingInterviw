package SecondProblem;

	import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

	public class SecondProblem {

		public static void main(String[] args) throws IOException {

			/* Data in the folders:(TEST is the folder Name)
			 * Sample INPUT :
			 * dof (1).pdf: 2020-08-17
			 * MRPT__.pdf: 2020-07-24
			 * ONLYOFFICE Sample Document.docx: 2020-07-06
			 * SAISHYAM_Resume.pdf: 2020-07-06
			 * test.docx: 2020-07-06
			 * Transcripts.pdf: 2020-08-17
			 * WhatsApp Image 2020-08-17 at 6.23.20 PM.jpeg: 2020-08-17			 * 
			 * 
			 * 
			 * OUTPUT:
			 * jul-4
			 * aug-3
			 * 
			 */
				
				File file=new File("C:\\TEST");
				File fileList[]=file.listFiles();
				Map<String,Integer>mp=new HashMap<String,Integer>(); 
				List<String>al=new ArrayList<>();
				for(int i=0;i<fileList.length;i++)
				{ 
					SimpleDateFormat sdf = new SimpleDateFormat("MMMM");		
					if(mp.containsKey(sdf.format(fileList[i].lastModified())))
					{
					
				mp.put(sdf.format(fileList[i].lastModified()),mp.get(sdf.format(fileList[i].lastModified()))+1);
					}
					else
					{
				mp.put(sdf.format(fileList[i].lastModified()),1);
					}
				}
					for(Map.Entry<String,Integer> entry:mp.entrySet())
						{
						System.out.println("Number of files in the folfer for the month of " + entry.getKey() + " are : " + entry.getValue());				 
						}		     
			}
	
}
