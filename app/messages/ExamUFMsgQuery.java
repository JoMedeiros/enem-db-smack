package messages;

public final class ExamUFMsgQuery {

	 private String exam;
	 private String UF;

	 public ExamUFMsgQuery(String exam, String city) {
	 	this.exam = exam;
	 	this.UF = city;
	 }

	public String getExam() {
		return exam;
	}

	public String getUF() {
		return UF;
	}
}
