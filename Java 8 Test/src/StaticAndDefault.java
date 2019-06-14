import com.domain.lambdaExpression.MyInterface;

public class StaticAndDefault{

	public static void main(String[] args) {

		MyInterface my = () -> {
			return "Hi";
		};
		
		my.sayHello();
	}

}
