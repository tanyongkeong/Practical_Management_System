/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author NURUL AIMAN
 */
public class Report {
    private String reportId;
    private String reportName;
    private String reportPath;
    private String studentId;

    public Report() {
    }

    public Report(String reportId, String reportName, String reportPath, String studentId) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportPath = reportPath;
        this.studentId = studentId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    
}