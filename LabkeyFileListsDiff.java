import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Collection;
import java.util.*;


public class LabkeyFileListsDiff {

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

		Collection<String> similar = new HashSet<String>( dataArrayMAIN );
        Collection<String> different = new HashSet<String>();
        Collection<String> inMainNotSecond = new HashSet<String>();
        Collection<String> inSecondNotMain = new HashSet<String>();
        different.addAll( dataArrayMAIN );
        different.addAll( dataArray );

        similar.retainAll( dataArray );
        different.removeAll( similar );

        inMainNotSecond.addAll( dataArrayMAIN );
        inMainNotSecond.removeAll( dataArray);
        inSecondNotMain.addAll( dataArray );
        inSecondNotMain.removeAll( dataArrayMAIN);

		//List<String>similarr = (List)similar;

		//similar.sort((left, right) -> left.getId() - right.getId());
		//Collections.sort( similar );

          	//System.out.printf("One:%s\nTwo:%s\n\n", dataArrayMAIN, dataArray);


        /*
		System.out.printf("\n\nSimilar:");
		if(similar.isEmpty()){
			System.out.printf("There are no Similarities between the two files\n");
		}
		else{
			System.out.printf("\n");
			for (Iterator<String> iter = similar.iterator(); iter.hasNext(); ) {
    			String a = iter.next();
    			System.out.printf("%s\n", a);
			}
		}*/


		System.out.printf("Differences:");
		if(different.isEmpty()){
			System.out.printf("\tThere are no differences between the two files\n");
		}
		else{
			System.out.printf("\n");
			for (Iterator<String> iter = different.iterator(); iter.hasNext(); ) {
    			String a = iter.next();
    			System.out.printf("%s\n", a);
			}

			System.out.printf("\n\nAll Lines in %s, but not in %s:\n", args[0], args[1]);
			for (Iterator<String> iter = inMainNotSecond.iterator(); iter.hasNext(); ) {
	    			String a = iter.next();
	    			System.out.printf("%s\n", a);
			}
			System.out.printf("\n\nAll Lines in %s, but not in %s:\n", args[1], args[0]);
			for (Iterator<String> iter = inSecondNotMain.iterator(); iter.hasNext(); ) {
	    			String a = iter.next();
	    			System.out.printf("%s\n", a);
			}
		}
		
		



		//To Implement
			// What is in the development, and what is not in the production, and revese
			// comparing the headers

		
 	}
}
