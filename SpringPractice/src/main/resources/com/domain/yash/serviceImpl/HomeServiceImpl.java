import org.springframework.stereotype.Service;

@Service("homeServiceImpl")
public class HomeServiceImpl implements IHomeService{
	public int additionOfNumbers(int var1, int var2) {
		System.out.println("Adding values: " + var1 + " + " + var2);
		return var1 + var2;
		}
	
}
