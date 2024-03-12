package org.example.conf;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
@ComponentScan({"org.example.aspect","org.example.components"})
@Configuration
public class AppCtx {
}
