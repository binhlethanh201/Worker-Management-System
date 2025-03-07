import java.util.*;
public class SalaryHistory{
	private String workerId;
	private double amount;
	private SalaryStatus status;
	private Date date;
	
	public SalaryHistory() {
	}
	public SalaryHistory(String workerId, double amount, SalaryStatus status) {
		super();
		this.workerId = workerId;
		this.amount = amount;
		this.status = status;
		this.date = new Date();
	}
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public SalaryStatus getStatus() {
		return status;
	}
	public void setStatus(SalaryStatus status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
