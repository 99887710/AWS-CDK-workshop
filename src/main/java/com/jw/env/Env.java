package com.jw.env;

import software.amazon.awscdk.core.Environment;
import software.amazon.awscdk.core.StackProps;

public class Env {

    public static StackProps Init(String accountId, String region) {
        return StackProps.builder().env(
                Environment.builder()
                .account(accountId)
                .region(region)
                .build()).build();
    }
}
