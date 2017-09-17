package chapter5.config;

public class PasswordEncoder extends org.springframework.security.authentication.encoding.BasePasswordEncoder {
    public String encode(CharSequence rawPassword) {
    	return "";
    }
    public boolean matches(CharSequence rawPassword,String encodedPassword) {
    	return true;
    }
	@Override
	public String encodePassword(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isPasswordValid(String arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		return false;
	}
}
