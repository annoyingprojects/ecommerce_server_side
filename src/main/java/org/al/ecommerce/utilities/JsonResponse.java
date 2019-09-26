package org.al.ecommerce.utilities;

public class JsonResponse {
    private String responseCode;
    private String responseData;
    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public void setReponseMessageAndCode(String responseMessage, String responseCode){
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }
}
