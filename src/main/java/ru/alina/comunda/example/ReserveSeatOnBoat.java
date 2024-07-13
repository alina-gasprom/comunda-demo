package ru.alina.comunda.example;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ReserveSeatOnBoat implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String money = "0.0";
        String ticketType = "Coach";

        money = (String)delegateExecution.getVariable("money");
        double moneyDouble = Double.parseDouble(money);

        if (moneyDouble >= 10000.0) {
            ticketType = "First class";
        }
        else if (moneyDouble >= 5000.00) {
            ticketType = "Business class";
        }

        delegateExecution.setVariable("ticketType", ticketType);
    }
}
