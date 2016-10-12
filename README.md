# CHEAR_Labkey.Diff
## *Contains files for determining differences between lists in CHEAR Labkey List Schema*


**INSTRUCTIONS FOR RUNNING:**

1. Go to CHEAR Labkey and select the desired list
2. Click 'EXPORT' -> 'Text'. Leave seporator as 'Tab'. Click 'EXPORT TO TEXT'.
3. Save the file as tsv in the same directory you are running the java file from
4. Repeat above steps for second list
5. Run the following command in terminal: javac LabkeyFileListsDiff.java
6. Run the following command in terminal: java LabkeyFileListsDiff *filename1*.tsv *filename2*.tsv 

**NOTES:**
- Separate files: one that just gives the difference between the headers, one that gives differences between rows


**Functionality to implement:**
- Current objective: Get the labkey data without having to read physical csv files
- Implement loop to compare the similar matching overall lists


