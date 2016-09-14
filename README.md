# CHEAR_Labkey.Diff
## *Contains files for determining differences between lists in CHEAR Labkey List Schema*


**INSTRUCTIONS FOR RUNNING:**

1. Go to CHEAR Labkey and select the desired list
2. Click 'EXPORT' -> 'Text'. Leave seporator as 'Tab'. Click 'EXPORT TO TEXT'.
3. Save the file as tsv in the same directory you are running the java file from
4. Repeat above steps for second list
5. Run the following command in terminal: javac LabkeyFileListsDiff.java
6. Run the following command in terminal: java LabkeyFileListsDiff *filename1*.tsv *filename2*.tsv 



**Functionality to implement:**
- More descriptive diff results
- Download the files automatically
- Implement loop to compare the similar matching overall lists
- Combining the two above features
