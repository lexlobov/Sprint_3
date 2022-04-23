package Models.ApiAnswers;

public class BadRequestApiAnswer {
    private String message;

    public BadRequestApiAnswer(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
