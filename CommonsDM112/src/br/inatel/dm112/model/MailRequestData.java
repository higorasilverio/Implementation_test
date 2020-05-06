package br.inatel.dm112.model;

public class MailRequestData {

	private String from;
	private String password;
	private String to;

	public MailRequestData() {
	}

	public MailRequestData(String from, String password, String to) {
		super();
		this.from = from;
		this.password = password;
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "MailRequestData [from=" + from + ", password=" + password + ", to=" + to + "]";
	}

}
