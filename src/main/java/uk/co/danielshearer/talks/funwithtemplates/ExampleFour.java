package uk.co.danielshearer.talks.funwithtemplates;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.generic.ClassTool;

import java.io.StringWriter;

public class ExampleFour {
    public static void main(String[] args) {
        Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        Velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        Velocity.init();

        VelocityContext context = new VelocityContext();
        context.put("class", new ClassTool());


        Template template = Velocity.getTemplate("example4.vm");

        StringWriter sw = new StringWriter();
        template.merge(context, sw);

        System.out.println(sw.toString());
    }
}
