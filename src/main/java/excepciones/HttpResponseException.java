package excepciones;

import java.io.IOException;

public class HttpResponseException extends IOException {
    private int statusCode;

    public HttpResponseException(String message) {
        super(message);
        extractStatusCode(message);
    }
    
    public HttpResponseException(String message, boolean conneccion) {
    	super(message);
    	if(conneccion) {
    		this.statusCode = 200;
    	}
    }

    private void extractStatusCode(String message) {
        int statusCodeIndex = message.indexOf("Server returned HTTP response code: ") + "Server returned HTTP response code: ".length();
        String statusCodeStr = message.substring(statusCodeIndex, statusCodeIndex + 3);
        this.statusCode = Integer.parseInt(statusCodeStr);
    }

    public int getStatusCode() {
        return statusCode;
    }
}
