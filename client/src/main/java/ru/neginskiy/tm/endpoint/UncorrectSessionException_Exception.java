
package ru.neginskiy.tm.endpoint;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-07T14:17:28.048+03:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "UncorrectSessionException", targetNamespace = "http://endpoint.tm.neginskiy.ru/")
public class UncorrectSessionException_Exception extends Exception {

    private ru.neginskiy.tm.endpoint.UncorrectSessionException uncorrectSessionException;

    public UncorrectSessionException_Exception() {
        super();
    }

    public UncorrectSessionException_Exception(String message) {
        super(message);
    }

    public UncorrectSessionException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public UncorrectSessionException_Exception(String message, ru.neginskiy.tm.endpoint.UncorrectSessionException uncorrectSessionException) {
        super(message);
        this.uncorrectSessionException = uncorrectSessionException;
    }

    public UncorrectSessionException_Exception(String message, ru.neginskiy.tm.endpoint.UncorrectSessionException uncorrectSessionException, java.lang.Throwable cause) {
        super(message, cause);
        this.uncorrectSessionException = uncorrectSessionException;
    }

    public ru.neginskiy.tm.endpoint.UncorrectSessionException getFaultInfo() {
        return this.uncorrectSessionException;
    }
}
