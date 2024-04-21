package org.dnyanyog;

import org.dnyanyog.config.DroolsBeanFactory;
import org.dnyanyog.dto.Customer;
import org.kie.api.runtime.KieSession;

public class RuleEngineMain {

	public static void main(String[] args) {

		KieSession kSession = new DroolsBeanFactory().getKieSession();

		if (kSession != null) {
			Customer customer = new Customer();
			customer.setAge(20);
			customer.setGender("F");

			System.out.println("Befor rule fire customer discount: " + customer.getDiscount());

			kSession.insert(customer);
			kSession.fireAllRules();
			kSession.dispose();
			System.out.println("Customer Discount: " + customer.getDiscount());

		} else {
			System.err.println("failed to crate kiesession");
		}
	}
}
