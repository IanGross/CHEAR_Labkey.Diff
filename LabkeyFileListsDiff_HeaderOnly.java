import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Collection;
import java.util.*;


public class LabkeyFileListsDiff_HeaderOnly {

	public static void main(String[] args) throws Exception{
		StringTokenizer st ;
		//"ListManager_2016-09-10_19-50-30-production.tsv"
		BufferedReader TSVFile = new BufferedReader(new FileReader(args[1]));
		Collection<String>dataArray = new ArrayList<String>() ;
		
		String dataRow = TSVFile.readLine(); // Read first line.

		while (dataRow != null){
		    st = new StringTokenizer(dataRow,"\n");
		    while(st.hasMoreElements()){
		        dataArray.add(st.nextElement().toString());
		    }
		    for (String item:dataArray) { 
		        //System.out.print(item + "  "); 
		    }
		    //System.out.println(); // Print the data line.
		    dataRow = TSVFile.readLine(); // Read next line of data.
		}
		// Close the file once all data has been read.
		TSVFile.close();





		



		TSVFile = new BufferedReader(new FileReader(args[0]));
		//"ListManager_2016-09-10_19-41-24.tsv"
		Collection<String>dataArrayMAIN = new ArrayList<String>() ;
		
		dataRow = TSVFile.readLine(); // Read first line.

		while (dataRow != null){
		    st = new StringTokenizer(dataRow,"\n");
		    while(st.hasMoreElements()){
		        dataArrayMAIN.add(st.nextElement().toString());
		    }
		    for (String item:dataArrayMAIN) { 
		        //System.out.print(item + "  "); 
		    }
		    //System.out.println(); // Print the data line.
		    dataRow = TSVFile.readLine(); // Read next line of data.
		}
		// Close the file once all data has been read.
		TSVFile.close();



		

		//remove non-useful elements
		for (Iterator<String> iter = dataArrayMAIN.iterator(); iter.hasNext(); ) {
    			String a = iter.next();
    			if (a.contains("org.labkey.list.model.ListManagerSchema")) {
       				iter.remove();
    			}
		}

		for (Iterator<String> iter = dataArray.iterator(); iter.hasNext(); ) {
    			String a = iter.next();
    			if (a.contains("org.labkey.list.model.ListManagerSchema")) {
       				iter.remove();
    			}
		}




		//SECTION ON COMPARING THE HEADERS

		//first main list
		Collection<String> line1Array = new ArrayList<String>() ;
		for (Iterator<String> iter = dataArrayMAIN.iterator(); iter.hasNext(); ) {
    		String a = iter.next();
    		String holder = "";
    		for (int i = 0; i < a.length(); i++) {
			   	//words[i] = words[i].replaceAll("[^\\w]", "");
			   	char tmp = a.charAt(i);
			   	if(tmp == '\t'){
			   		//System.out.println(holder);
			   		line1Array.add(holder);
			   		holder = "";
			   	}
			   	else if(Character.isLetter(tmp)){
			   		holder += Character.toString(tmp);
			   	}
			}
			break;
		}


		//Second Main list
		Collection<String> line2Array = new ArrayList<String>() ;
		for (Iterator<String> iter = dataArray.iterator(); iter.hasNext(); ) {
    		String a = iter.next();
    		String holder = "";
    		for (int i = 0; i < a.length(); i++) {
			   	//words[i] = words[i].replaceAll("[^\\w]", "");
			   	char tmp = a.charAt(i);
			   	if(tmp == '\t'){
			   		//System.out.println(holder);
			   		line2Array.add(holder);
			   		holder = "";
			   	}
			   	else if(Character.isLetter(tmp)){
			   		holder += Character.toString(tmp);
			   	}
			}
			break;
		}




		Collection<String> similar_ = new HashSet<String>( line1Array );
        Collection<String> different_ = new HashSet<String>();
        Collection<String> inMainNotSecond_ = new HashSet<String>();
        Collection<String> inSecondNotMain_ = new HashSet<String>();
        different_.addAll( line1Array );
        different_.addAll( line2Array );

        similar_.retainAll( line2Array );
        different_.removeAll( similar_ );

        inMainNotSecond_.addAll( line1Array );
        inMainNotSecond_.removeAll( line2Array);
        inSecondNotMain_.addAll( line2Array );
        inSecondNotMain_.removeAll( line1Array);



		System.out.printf("Differences:");
		if(different_.isEmpty()){
			System.out.printf("\tThere are no differences between the two headers for the files\n");
		}
		else{
			System.out.printf("\n");
			for (Iterator<String> iter = different_.iterator(); iter.hasNext(); ) {
    			String a = iter.next();
    			System.out.printf("%s\n", a);
			}

			System.out.printf("\n\nAll Lines in %s, but not in %s:\n", args[0], args[1]);
			for (Iterator<String> iter = inMainNotSecond_.iterator(); iter.hasNext(); ) {
	    			String a = iter.next();
	    			System.out.printf("%s\n", a);
			}
			System.out.printf("\n\nAll Lines in %s, but not in %s:\n", args[1], args[0]);
			for (Iterator<String> iter = inSecondNotMain_.iterator(); iter.hasNext(); ) {
	    			String a = iter.next();
	    			System.out.printf("%s\n", a);
			}
		}

		//To Implement
			// What is in the development, and what is not in the production, and revese
			// comparing the headers

		
 	}
}
