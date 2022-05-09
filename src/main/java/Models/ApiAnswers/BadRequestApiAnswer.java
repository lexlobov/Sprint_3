package Models.ApiAnswers;

public class BadRequestApiAnswer {
    private String message;
    private int code;

    public BadRequestApiAnswer(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public BadRequestApiAnswer() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
