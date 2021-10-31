package util;

public class ErrorMessages {

	private String noEmpty="";
	private String errorFormatName="";
	
	public String getNoEmpty() {
		return noEmpty;
	}

	public String getErrorFormatName() {
		return errorFormatName;
	}

	public void setErrorFormatName(String errorFormatName) {
		this.errorFormatName = errorFormatName;
	}

	public void setNoEmpty(String noEmpty) {
		this.noEmpty = noEmpty;
	}

	public ErrorMessages() {}
}
