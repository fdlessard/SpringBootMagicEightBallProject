package io.fdlessard.codebites.magiceightball;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;

import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.activation.DataSource;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class SpringBootMagicEightBallApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMagicEightBallApplication.class, args);
	}


}
