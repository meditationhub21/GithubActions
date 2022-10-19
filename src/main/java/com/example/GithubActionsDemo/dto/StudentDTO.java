package com.example.GithubActionsDemo.dto;

public class StudentDTO extends AbstractDTO<Integer> {
    private Integer id;
    private String studentName;
    private String studentContactNo;
    private String studentEmailId;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String studentName, String studentContactNo, String studentEmailId) {
        this.id = id;
        this.studentName = studentName;
        this.studentContactNo = studentContactNo;
        this.studentEmailId = studentEmailId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentContactNo(String studentContactNo) {
        this.studentContactNo = studentContactNo;
    }

    public String getStudentContactNo() {
        return this.studentContactNo;
    }

    public void setStudentEmailId(String studentEmailId) {
        this.studentEmailId = studentEmailId;
    }

    public String getStudentEmailId() {
        return this.studentEmailId;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentContactNo='" + studentContactNo + '\'' +
                ", studentEmailId='" + studentEmailId + '\'' +
                '}';
    }
}