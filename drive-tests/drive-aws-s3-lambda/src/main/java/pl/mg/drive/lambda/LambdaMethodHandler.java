package pl.mg.drive.lambda;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * Entry point to the lambda.
 */
public class LambdaMethodHandler {

    public String handleRequest(String input, Context context) {
        context.getLogger().log("Input: " + input);
        return "Hello World - " + input;
    }
}
