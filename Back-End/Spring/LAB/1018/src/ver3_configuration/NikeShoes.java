package ver3_configuration;

import org.springframework.stereotype.Component;

public class NikeShoes implements Shoes{
	@Override
	public String getShoes() {
		return "나이키";
	}
}
