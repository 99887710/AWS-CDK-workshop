package com.jw.app;

import com.jw.env.Env;
import com.jw.stack.HelloCdkStack;
import software.amazon.awscdk.core.App;

public class HelloCdkApp {
    public static void main(final String[] args) {
        App app = new App();

        String testAccId = "Your AWS Account Id";
        String testRegion = "Your AWS Region";

        new HelloCdkStack(app, "HelloCdkStack", Env.Init(testAccId, testRegion));

        app.synth();
    }
}
