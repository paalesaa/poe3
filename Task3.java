/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


class Task3 {
    String input = "";
    private List<String> developers = new ArrayList<>();
    private List<String> taskNames = new ArrayList<>();
    private List<String> taskIDs = new ArrayList<>();
    private List<Integer> taskDurations = new ArrayList<>();
    private List<String> taskStatuses = new ArrayList<>();

    public boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() <= 50;
    }

    public String createTaskID(String taskName, int taskNumber, String developerLastName) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerLastName.substring(developerLastName.length() - 3).toUpperCase();
    }

    public String printTaskDetails(String taskStatus, String developerFirstName, String developerLastName, int taskNumber, String taskName, String taskDescription, String taskID, int taskDuration) {
        StringBuilder taskDetails = new StringBuilder();
        taskDetails.append("Task Status: ").append(taskStatus).append("\n");
        taskDetails.append("Developer Details: ").append(developerFirstName).append(" ").append(developerLastName).append("\n");
        taskDetails.append("Task Number: ").append(taskNumber).append("\n");
        taskDetails.append("Task Name: ").append(taskName).append("\n");
        taskDetails.append("Task Description: ").append(taskDescription).append("\n");
        taskDetails.append("Task ID: ").append(taskID).append("\n");
        taskDetails.append("Task Duration: ").append(taskDuration).append(" hours\n");
        return taskDetails.toString();
    }

    public void addTask(String taskName, String taskDescription, String developer, String taskID, int taskDuration, String taskStatus) {
        taskNames.add(taskName);
        developers.add(developer);
        taskIDs.add(taskID);
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);
    }

    public void showTaskReport() {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskNames.size(); i++) {
            report.append("Task Name: ").append(taskNames.get(i)).append("\n");
            report.append("Developer: ").append(developers.get(i)).append("\n");
            report.append("Task ID: ").append(taskIDs.get(i)).append("\n");
            report.append("Task Duration: ").append(taskDurations.get(i)).append(" hours\n");
            report.append("Task Status: ").append(taskStatuses.get(i)).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    public void displayDoneTasks() {
        StringBuilder doneTasks = new StringBuilder();
        doneTasks.append("Tasks with status 'Done':\n");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskStatuses.get(i).equals("Done")) {
                doneTasks.append("Developer: ").append(developers.get(i)).append(", ");
                doneTasks.append("Task Name: ").append(taskNames.get(i)).append(", ");
                doneTasks.append("Task Duration: ").append(taskDurations.get(i)).append(" hours\n");
            }
        }
        JOptionPane.showMessageDialog(null, doneTasks.toString());
    }

    public void displayLongestTask() {
        int maxDuration = 0;
        int maxIndex = 0;
        for (int i = 0; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > maxDuration) {
                maxDuration = taskDurations.get(i);
                maxIndex = i;
            }
        }
        JOptionPane.showMessageDialog(null, "Task with longest duration:\nDeveloper: " + developers.get(maxIndex) + ", Duration: " + maxDuration + " hours");
    }

    public void searchTaskByName(String name) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equals(name)) {
                result.append("Task Name: ").append(taskNames.get(i)).append("\n");
                result.append("Developer: ").append(developers.get(i)).append("\n");
                result.append("Task Status: ").append(taskStatuses.get(i)).append("\n");
                break;
            }
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    public void searchTasksByDeveloper(String developer) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).contains(developer)) {
                result.append("Task Name: ").append(taskNames.get(i)).append(", ");
                result.append("Task Status: ").append(taskStatuses.get(i)).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    public void deleteTask(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equals(taskName)) {
                taskNames.remove(i);
                developers.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' deleted successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task '" + taskName + "' not found.");
    }
}