package org.example;

import org.example.components.Calculator;
import org.example.conf.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator calculator = context.getBean(Calculator.class);
        calculator.doPrint();

        context.close();

    }
}