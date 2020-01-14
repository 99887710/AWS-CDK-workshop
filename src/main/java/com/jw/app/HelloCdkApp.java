package com.jw.app;

import com.jw.BootStrapping;
import com.jw.Configuration;
import com.jw.env.Env;
import com.jw.stack.HelloCdkStack;
import software.amazon.awscdk.core.App;

import java.io.IOException;
import java.util.Map;

@Configuration
public class HelloCdkApp {

    private static App app;
    private static Map<String, Object> configMap;

    private static HelloCdkStack makeMyStack(final String name, final String account, final String region){
            return new HelloCdkStack(app, name, Env.Init(account, region));
    }

    public static void main(final String[] args) {
        try {
            configMap = BootStrapping.load(HelloCdkApp.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something wrong...");
            return;
        }

        Map<String, Object> provider = (Map<String, Object>)configMap.get("provider");
        String deploymentName = (String) provider.get("name");
        String accountId = String.valueOf(provider.get("accountId"));
        String region = (String) provider.get("region");

        app = new App();
        makeMyStack(deploymentName, accountId, region);
        app.synth();
    }
}
