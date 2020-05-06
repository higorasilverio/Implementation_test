package br.inatel.dm112.model;

public class BilletGenResponse {

	private byte[] pdfContent;
	private String message;
	private Integer status;

	public byte[] getPdfContent() {
		return pdfContent;
	}

	public void setPdfContent(byte[] pdfContent) {
		this.pdfContent = pdfContent;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BilletGenResponse [message=" + message + ", status=" + status + "]";
	}

}
