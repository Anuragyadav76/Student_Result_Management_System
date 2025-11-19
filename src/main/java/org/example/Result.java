
package org.example;


public class Result {
    private int studentId;
    private int marks;
    private String grade;

    public Result() {}

    public Result(int studentId, int marks) {
        this.studentId = studentId;
        this.marks = marks;
        calculateGrade();
    }

    private void calculateGrade() {
        if (marks >= 90) grade = "A";
        else if (marks >= 75) grade = "B";
        else if (marks >= 50) grade = "C";
        else grade = "D";
    }

    public int getStudentId() {
        return studentId;
    }

    public int getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Marks: " + marks + ", Grade: " + grade;
    }
}