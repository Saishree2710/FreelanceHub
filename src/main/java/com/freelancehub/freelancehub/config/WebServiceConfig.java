package com.freelancehub.freelancehub.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext applicationContext) {

        MessageDispatcherServlet servlet =
                new MessageDispatcherServlet();

        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(
                servlet,
                "/ws/*"
        );
    }

    @Bean(name = "freelancehub")
    public DefaultWsdl11Definition defaultWsdl11Definition(
            XsdSchema freelancehubSchema) {

        DefaultWsdl11Definition wsdl11Definition =
                new DefaultWsdl11Definition();

        wsdl11Definition.setPortTypeName("FreelanceHubPort");

        wsdl11Definition.setLocationUri("/ws");

        wsdl11Definition.setTargetNamespace(
                "http://freelancehub.com/users"
        );

        wsdl11Definition.setSchema(freelancehubSchema);

        return wsdl11Definition;
    }

    @Bean
    public XsdSchema freelancehubSchema() {

        return new SimpleXsdSchema(
                new ClassPathResource("xsd/freelancehub.xsd")
        );
    }
}