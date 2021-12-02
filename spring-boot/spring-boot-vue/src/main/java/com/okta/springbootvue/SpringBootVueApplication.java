package com.okta.springbootvue;


import com.okta.springbootvue.entity.*;
import com.okta.springbootvue.*;
import com.okta.springbootvue.repository.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.time.LocalDate;
@SpringBootApplication
public class SpringBootVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVueApplication.class, args);
	}

	@Bean
	ApplicationRunner init(EmployeeTypeRepository emptypeRepository,
						EmployeeRepository emp) {
		return args -> {
			
			// ------- Baggage Type --------
			Stream.of(
				"พนักงานประจำ","พนักงานชั่วคราว"
			).forEach(emptype-> {
				EmployeeType empltype = new EmployeeType(); 
				empltype.setEmptypename(emptype); 
				emptypeRepository.save(empltype); 
			});
			

			Object[][] empl = new Object[][] { 
				{ "AAA", "AAA", 1 , 50000.00 , 0.00}
			};
			for (int i = 0; i < empl.length; i++) {
				Employee newemp = new Employee();
				newemp.setFirstname((String) empl[i][0]);
				newemp.setLastname((String) empl[i][1]);
				newemp.setSalary((Double) empl[i][3]);
				newemp.setCompentsation((Double) empl[i][4]);
			//	newemp.setEBDate((Date) empl[i][2]);
				
				EmployeeType etype = emptypeRepository.findById((int) empl[i][2]);
				
				newemp.setEmpType(etype);
				

				emp.save(newemp);
			}

		};
	};

		@Bean
		public FilterRegistrationBean simpleCorsFilter() {
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowCredentials(true);
			// *** URL below needs to match the Vue client URL and port ***
			config.setAllowedOrigins(Collections.singletonList("*"));
			config.setAllowedMethods(Collections.singletonList("*"));
			config.setAllowedHeaders(Collections.singletonList("*"));
			source.registerCorsConfiguration("/**", config);
			FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
			bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
			return bean;
		}
}
