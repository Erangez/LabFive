package org.erangaz;

public class ActionFailedException extends Exception{
    ActionFailedException(String message, Throwable cause){
        super(message, cause);
    }
}
