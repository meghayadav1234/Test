package com.domain.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.domain.stream.Employee;

/**
 * @author megha.yadav
 *
 */
public class OptionalTest {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(2);
		list.add(5);
		list.add(null);

		list.forEach(x -> {
			Optional<Integer> optional = Optional.ofNullable(x);
			if(optional.isPresent())
			System.out.println(optional.get());
		});
		System.out.println("----------");
	

		List<Integer> list1 = Arrays.asList(2, 4, 6, 8, 10);
		 
		list1.stream().parallel().forEach( System.out::println );        //1
		System.out.println("----------");
		list1.stream().parallel().forEachOrdered( System.out::println );
		System.out.println("--------------");
		
		List<Employee> listEmployee= Arrays.asList(new Employee(1,"A"),new Employee(2, "B"));
		Optional<List<Employee>> companyOptional = Optional.ofNullable(listEmployee);
		/*companyOptional.filter(employee -> "Finance".equals(employee.getEmpName())
					.ifPresent(() -> System.out.println("Finance is present")));
		*/

		/*companyOptional.flatMap(x -> x.stream().filter(employee -> "A".equals(employee.getEmpName())).
				ifPresent(x -> System.out.println("A is Present")));*/
		
		
		Optional<Object> emp = companyOptional.map(x -> x.stream().filter(employee ->"A".equals(employee.getEmpName())).collect(Collectors.toList()));
				//.filter(employee ->"A".equals(employee.getEmpName()).collect(Collectors.toList()));
		/*String a="A";
		Optional<String> optional1 = Optional.ofNullable(a);
		optional1.ifPresent(x ->System.out.println(x));
		System.out.println(optional1.orElse("Default Value")); 
		System.out.println(optional1.orElseGet(() ->  "Default Value B"));

		Optional<String> empty =Optional.empty();
		System.out.println(empty.orElse("Default Value Empty else")); 
		System.out.println(empty.orElseGet(() ->  "Default Value Empty else get"));
		
		System.out.println(optional1.get());
		Optional<String> optional2 = Optional.of(a);//null pointer Exception
		System.out.println(optional2);

		String b="BB";
		Optional<String> optionalB = Optional.of(b);
		System.out.println(optionalB.orElse("Default Value B else")); 
		System.out.println(optionalB.orElseGet(() ->  "Default Value B else get"));*/
	}
}
