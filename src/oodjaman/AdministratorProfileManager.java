package oodjaman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdministratorProfileManager {
    private static final String FILE_PATH = "/Users/aman/eclipse-workspace/oodjaman/src/oodjaman/user_profile.txt";
    private static final String STUDENT_FILE_PATH = "/Users/aman/eclipse-workspace/oodjaman/src/oodjaman/student.txt";

    public static AdministratorProfile readProfile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
             BufferedReader studentReader = new BufferedReader(new FileReader(STUDENT_FILE_PATH))) {

            // Read the name from the last line of the student.txt file
            String lastLine;
            String name = null;

            while ((lastLine = studentReader.readLine()) != null) {
                name = lastLine.split(",")[0]; // Assuming the name is the first value in each line
            }

            // Read other details from the user_profile.txt file
            String position = reader.readLine();
            String email = reader.readLine();
            String phoneNumber = reader.readLine();
            String address = reader.readLine();

            return new AdministratorProfile(name, position, email, phoneNumber, address);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeProfile(AdministratorProfile profile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(profile.getPosition());
            writer.newLine();
            writer.write(profile.getEmail());
            writer.newLine();
            writer.write(profile.getPhoneNumber());
            writer.newLine();
            writer.write(profile.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}