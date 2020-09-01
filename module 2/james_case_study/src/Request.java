public class Request {
    String action;
    String params;
    String keyword;

    public String getAction() {
        return action;
    }

    public String getParams() {
        return params;
    }

    public String getKeyword() {
        return keyword;
    }

    public Request(String action, String params, String keyword) {
        this.action = action;
        this.params = params;
        this.keyword = keyword;
    }

    public Request(String action, String keyword) {
        this.action = action;
        this.keyword = keyword;
    }
}
