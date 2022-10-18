package ver2_annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class AdidasShoes implements Shoes{
	@Override
	public String getShoes() {
		// TODO Auto-generated method stub
		return "아디다스";
	}
}
