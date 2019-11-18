package com.koldakov.velocity;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.IOException;
import java.io.StringWriter;

public class VelocityTests {

    public static void main(String[] args) throws IOException {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.addProperty("resource.loader", "class");
        velocityEngine.addProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.init();

        VelocityContext context = new VelocityContext();
        context.put("greeting", "Hello");
        context.put("user", "World");

        try (StringWriter writer = new StringWriter()) {
            velocityEngine.mergeTemplate("greeting.vm", "UTF-8", context, writer);

            System.out.println(writer.toString());
        }
    }
}
