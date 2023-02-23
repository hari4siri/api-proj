package common;

import java.util.Base64;

public class CommonHelper {
	
	
public static void main(String[] args) {
	encodedPassword("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG0uaGFyaS5iYWJ1QGF2ZXJ5ZGVubmlzb24uY29tIiwibmFtZSI6IkhhcmkgQmFidSIsImlhdCI6MTY3NjM1OTcxNSwiZXhwIjoxNzA3ODk1NzE1fQ.sc7RP-emJYS7qHIVwWsS7agrK-L5zQVm0IBq_Pj4u-Q");
}
	
	//to encrypt password
	public static void encodedPassword(String password) {
	byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes());
	System.out.println("encodedBytes "+ new String(encodedBytes));
	}

	
	//to decode password
	public void decodedPassword(byte[] encodedBytes) {
	byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
	System.out.println("decodedBytes "+ new String(decodedBytes));
	}

}
