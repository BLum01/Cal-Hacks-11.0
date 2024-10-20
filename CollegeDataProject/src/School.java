import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class School {
    private File inputFile;
    private String schoolName;
    private double admitRate;
    private String admitGpaRange;
    private String intendedMajor;

    public School(String schoolName, String intendedMajor) throws FileNotFoundException {
        //accessTxt returns corresponding txt file with school information
        this.schoolName = schoolName.trim();
        this.inputFile = accessTxt(this.schoolName);
        this.intendedMajor = intendedMajor.trim();
        getInfo();

    }

    public File getFile() {
        return inputFile;
    }

    public String getSchoolName() {
        return schoolName;
    } 

    public String getAdmitRate() {
        double rate = admitRate * 10000.0;
        rate = Math.round(rate);
        rate /= 100.0;
        return rate + "%";
    }

    public String getAdmitGPaRange() {
        return admitGpaRange;
    }
 
    public void printInfo() {
        System.out.println("School Name: " + getSchoolName());
        System.out.println("Acceptance Rate: " + getAdmitRate());
        System.out.println("GPA Range: " + getAdmitGPaRange());
    }
   
    public void getInfo() throws FileNotFoundException {

	    Scanner scnr = new Scanner(this.inputFile);    
	    //goes through first two lines that show categories
        scnr.nextLine();
        scnr.hasNextLine();

        boolean isMajor = false;

        while (scnr.hasNextLine()) {
           String[] arr = scnr.nextLine().split("\t");
        
           for (String s: arr) {
               if (s.equalsIgnoreCase(intendedMajor)) {
                isMajor = true;
                break;
                }
            }   
        
            if (isMajor == true) {
                this.admitGpaRange= arr[3];
                this.admitRate = Double.parseDouble(arr[4]);
                break;
            }
        }
        
        if (!isMajor) {
            throw new IllegalArgumentException("Major \"" + this.intendedMajor + "\" does \nnot exist at " + this.schoolName);
        }

        scnr.close();
    }

   //method to return the corresponding file to the college name
    public static File accessTxt(String schoolName) throws FileNotFoundException {
       File inputFile = new File("UCBData.txt");
       schoolName = schoolName.toUpperCase();
       switch (schoolName) {
             case "UCD":
                inputFile = new File("UCDData.txt");
                break;

            case "UCI":
                inputFile = new File("UCIData.txt");
                 break;

            case "UCLA":
                inputFile = new File("UCLAData.txt");
                break;
          
            case "UCM":
                inputFile = new File("UCMData.txt");
                break;
      
            case "UCR":
                inputFile = new File("UCRData.txt");
                break;
          
            case "UCSB": 
                inputFile = new File("UCSBData.txt");
                break;
          
            case "UCSC":
               inputFile = new File("UCSCData.txt");
                break;
          
            case "UCSD":
                inputFile = new File("UCSD.txt");
                break;

       }

       if (!inputFile.exists()) {
          throw new FileNotFoundException("File not found: " + inputFile.getPath());
       }
      
      return inputFile;
  }
}
