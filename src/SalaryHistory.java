import java.util.*;
public class SalaryHistory {
	private String workerId;
	private double oldSalary, newSalary;
	private Date date;
	
	public SalaryHistory() {
	}
	
	public SalaryHistory(String workerId, double oldSalary, double newSalary, Date date) {
		this.workerId = workerId;
		this.oldSalary = oldSalary;
		this.newSalary = newSalary;
		this.date = date;
	}
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	public double getOldSalary() {
		return oldSalary;
	}
	public void setOldSalary(double oldSalary) {
		this.oldSalary = oldSalary;
	}
	public double getNewSalary() {
		return newSalary;
	}
	public void setNewSalary(double newSalary) {
		this.newSalary = newSalary;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
