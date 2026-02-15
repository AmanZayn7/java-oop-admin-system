package oodjaman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkerProfileManager {
    private static final String SALESPERSON_FILE_PATH = "/Users/aman/eclipse-workspace/oodjaman/src/oodjaman/salesperson_profile.txt";
    private static final String OFFICER_FILE_PATH = "/Users/aman/eclipse-workspace/oodjaman/src/oodjaman/officer_profile.txt";

    public static WorkerProfile readWorkerProfile(String workerType, String filepath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath(workerType)))) {
            String name = reader.readLine();
            String position = reader.readLine();
            String email = reader.readLine();
            String phoneNumber = reader.readLine();
            String address = reader.readLine();

            return new WorkerProfile(name, position, email, phoneNumber, address);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeWorkerProfile(WorkerProfile profile, String workerType) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(workerType)))) {
            writer.write(profile.getName());
            writer.newLine();
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

    public static String getFilePath(String workerType) {
        return workerType.equals("SALESPERSON") ? SALESPERSON_FILE_PATH : OFFICER_FILE_PATH;
    }
}
