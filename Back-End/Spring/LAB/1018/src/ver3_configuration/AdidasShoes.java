package ver3_configuration;

import org.springframework.stereotype.Repository;

@Repository
public class AdidasShoes implements Shoes{
	@Override
	public String getShoes() {
		return "아디다스";
	}
}
