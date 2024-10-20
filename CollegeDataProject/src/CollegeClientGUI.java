import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class CollegeClientGUI {

    public static void main(String[] args) {

        // color pallete
        Color lightYellowColor = new Color(214, 174, 81);
        Color lightGray = new Color(200, 204, 208);
        Color lightWhite = new Color (252, 253, 255);
        Color lightBlue = new Color(0, 110, 244);    
        Color darkGray = new Color(51, 51, 51);
        // Set up the JFrame (window)
        JFrame frame = new JFrame("UC Admissions Information");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(lightYellowColor);
        frame.setSize(870, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null); 

        // Create the top panel with an image and title
        JPanel topPanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("/Users/brandonlum/Downloads/UCLogo.png");
        JLabel image = new JLabel(imageIcon);
        topPanel.setLayout(null);  
        topPanel.setBackground(lightBlue);
        topPanel.setBounds(0, 0, 870, 82);
        image.setBounds(0, 3, 100, 75);  
        JLabel titleLabel = new JLabel("UC Transfer Admissions Information");
        titleLabel.setHorizontalAlignment(0);
        titleLabel.setFont(new Font("Kievit", Font.BOLD, 30));
        titleLabel.setBounds(0, 0, 850, 100);
        topPanel.add(image);
        topPanel.add(titleLabel);


        // User enters school name
        JLabel labelSchoolName = new JLabel("Enter School Name (e.g., UCD, UCLA):");
        labelSchoolName.setFont(new Font("Kievit", Font.BOLD, 20));
        labelSchoolName.setForeground(darkGray);
        labelSchoolName.setBounds(30, 20, 400, 30); 
        JTextField fieldSchoolName = new JTextField();
        fieldSchoolName.setBounds(450, 20, 300, 30); 
        fieldSchoolName.setBackground(lightGray);
       
        // User enters intended major
        JLabel labelMajor = new JLabel("Enter Intended Major:");
        labelMajor.setFont(new Font("Kievit", Font.BOLD, 20));
        labelMajor.setForeground(darkGray);
        labelMajor.setBounds(30, 75, 300, 30);
        JTextField fieldMajor = new JTextField();
        fieldMajor.setBounds(450, 75, 300, 30); 
        fieldMajor.setBackground(lightGray);

         // Add first-year or transfer applicant option with radio buttons
         JLabel whatAdmission = new JLabel("Select application type:");
         whatAdmission.setFont(new Font("Kievit", Font.BOLD, 20));
         whatAdmission.setBounds(30, 130, 300, 30); 
         JRadioButton rb1 = new JRadioButton("First-year");
         rb1.setBounds(450,130,100,30); 
         JRadioButton rb2 = new JRadioButton("Transfer");
         rb2.setBounds(600,130,300,30);
         ButtonGroup bg = new ButtonGroup();
         bg.add(rb1);
         bg.add(rb2);

        // Submit button
        JButton buttonSubmit = new JButton("Get Info");
        buttonSubmit.setBounds(315, 180, 150, 30);
        buttonSubmit.setForeground(new Color(255, 255, 255));
        buttonSubmit.setOpaque(true);
        buttonSubmit.setBackground(new Color(0, 123, 255));
        buttonSubmit.setBorderPainted(false);

         // Title for first area box
         JLabel generalInfo = new JLabel("General Information");
         generalInfo.setBounds(30,215,750,30);

        // Output area for displaying results
        JPanel outPutAreaPanel = new JPanel();
        outPutAreaPanel.setBounds(30, 245, 725, 180);
        outPutAreaPanel.setBackground(lightGray);
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBackground(lightGray);
        outputArea.setFont(new Font("Kievit", Font.BOLD, 9));
        outPutAreaPanel.add(outputArea);

        //Title for second area box
        JLabel majorInfo = new JLabel("Major Information (Note: trasfer admissions data," + 
            " use as reference if applying as first year)");
        majorInfo.setBounds(30,435,750,30);
  
        // Output area for major results
        JPanel majorArea = new JPanel();
        JTextArea outputArea2 = new JTextArea();
        outputArea2.setEditable(false);
        outputArea2.setBackground(lightGray);
        majorArea.setBounds(30,465,725, 100  );
        majorArea.setBackground(lightGray);
        majorArea.add(outputArea2);
        outputArea2.setFont(new Font("Kievit", Font.BOLD, 15));

        // Create the middle panel for school name and major input
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(null);  
        middlePanel.setBackground(lightWhite);
        middlePanel.setBounds(30, 30, 790, 600);

        // Add everything to middle panel
        middlePanel.add(labelSchoolName);
        middlePanel.add(fieldSchoolName);
        middlePanel.add(labelMajor);
        middlePanel.add(fieldMajor);
        middlePanel.add(whatAdmission);
        middlePanel.add(rb1);
        middlePanel.add(rb2);
        middlePanel.add(buttonSubmit);
        middlePanel.add(generalInfo);
        middlePanel.add(outPutAreaPanel);
        middlePanel.add(majorInfo);
        middlePanel.add(majorArea);

        // Add scroll wheel ability
        JPanel outerPanel = new JPanel();
        outerPanel.setBounds(0, 83, 880, 1000);
        outerPanel.add(middlePanel);
        outerPanel.setLayout(null);
        outerPanel.setBackground(lightYellowColor);
        outerPanel.setPreferredSize(new Dimension(870, 1000));

        JScrollPane scrollPane = new JScrollPane(outerPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 83, 870, 500);
        scrollPane.getVerticalScrollBar().setUnitIncrement(5);
        
        

        // Add components to the JFrame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);


        buttonSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String collegeName = fieldSchoolName.getText();
                String intendedMajor = fieldMajor.getText();

                outputArea.setText("You have selected " + collegeName + " as your campus of interest " +
                intendedMajor + " as your intended major.\n");

                if(rb1.isSelected()){
                    outputArea.append("In order to apply for admission as a first-year applicant,\n" +
                "you must complete a minimum of 15 college-preparatory courses (A-G courses) with a letter grade of C or better.\n" +
                "You must complete at least 11 of these courses prior to the beginning of your last year of high school.\n" +
                "These 15 courses are:\n" +
                "\t- (A) 2 years of History\n" + 
                "\t- (B) 4 years of English\n" +
                "\t- (C) 3 years of Mathematics (4 years recommended)\n" +
                "\t- (D) 2 years of Science (3 years recommended)\n" +
                "\t- (E) 2 years of Language other than English* (3 years recommended)\n" +
                "\t- (F) 1 year of Visual and Performing Arts\n" +
                "\t- (G) 1 year of College-preparatory elective**\n" +
                "\n*or equivalent to the 2nd level of high school instruction" +
                "\n**chosen from the subjects listed above or another course approved by the university"
                );
                }else if(rb2.isSelected()){
                    outputArea.append("In order to apply for admission as a transfer applicant,\n" +
                "you must complete a minimum of 60 semester (90 quarter) units of UC-transferable credit.\n" +
                "No more than 14 semester (21 quarter) units of the 60 semester (90 quarter) units may be taken pass/fail " + 
                "or credit/no credit.\n" +
                "Earn at least a 2.4 GPA in UC-transferable courses (2.8 if you're a nonresident).\n" +
                "However, some campuses and majors may require a higher GPA for admission selection.\n" +
                "Complete the following 7-course pattern by the end of the spring term prior to fall enrollment at UC:\n" +
                "\t- Two transferable courses in English composition;\n" +
                "\t- One transferable course in mathematical concepts and quantitative reasoning;\n" +
                "\t- Four transferable college courses chosen from at least two of the following subject areas:\n" +
                "\t\t> arts and humanities\n" +
                "\t\t> social and behavioral sciences\n" +
                "\t\t> physical and biological sciences\n"
                );
                }else{
                    outputArea.setText("No button selected");
                }
            }
        });

        // Add action listener for the submit button
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String collegeName = fieldSchoolName.getText();
                String intendedMajor = fieldMajor.getText();
                try {
                    // Use the School class logic to get the info
                    School school = new School(collegeName, intendedMajor);
                    outputArea.setText("School Name: " + school.getSchoolName() + "\n" +
                            "Acceptance Rate: " + school.getAdmitRate() + "\n" +
                            "GPA Range: " + school.getAdmitGPaRange());
                } catch (FileNotFoundException ex) {
                    outputArea.setText("Error: School data file not found.");
                } catch (IllegalArgumentException ex) {
                    outputArea.setText(ex.getMessage());  // Display "Major does not exist" error message
                } catch (Exception ex) {
                    outputArea.setText("Error: " + ex.getMessage());
                }
            }
        });

         // Add action listener for the submit button
         buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String collegeName = fieldSchoolName.getText();
                String intendedMajor = fieldMajor.getText();
                try {
                    // Use the School class logic to get the info
                    School school = new School(collegeName, intendedMajor);
                    outputArea2.setText("School Name: " + school.getSchoolName() + "\n" +
                            "Acceptance Rate: " + school.getAdmitRate() + "\n" +
                            "GPA Range: " + school.getAdmitGPaRange());
                } catch (FileNotFoundException ex) {
                    outputArea2.setText("Error: School data file not found.");
                } catch (IllegalArgumentException ex) {
                    outputArea.setText(ex.getMessage());  // Display "Major does not exist" message
                } catch (Exception ex) {
                    outputArea2.setText("Error: " + ex.getMessage());
                }
            }
        });
        

        // Make the frame visible
        frame.setVisible(true);
    }
}

