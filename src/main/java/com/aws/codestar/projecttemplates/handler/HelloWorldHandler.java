package com.aws.codestar.projecttemplates.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.aws.codestar.projecttemplates.GatewayResponse;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * Handler for requests to Lambda function.
 */
public class HelloWorldHandler implements RequestHandler<Object, Object> {

	public Object handleRequest(final Object input, final Context context) {
		context.getLogger().log("Input: " + input);
		System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("CommonPool Size: " + ForkJoinPool.commonPool().getPoolSize());
//        IntStream.rangeClosed(1, 10).parallel().forEach(integer -> {
//            System.out.println("Current Thread: " + Thread.currentThread()
//                + ", " + "CommonPool Size: " + ForkJoinPool.commonPool().getPoolSize());
//            try {
////                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//     
//                e.printStackTrace();
//            }
//        });
   
        
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		return new GatewayResponse(new JSONObject().put("Output", "Hello World!11111").toString(), headers, 200);
	}
}
