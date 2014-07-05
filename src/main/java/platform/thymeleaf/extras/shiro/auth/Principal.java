package platform.thymeleaf.extras.shiro.auth;

import org.apache.shiro.subject.Subject;

public final class Principal {
	
	public Object getPrincipal() {
		
		Subject subject = AuthUtils.getSubject();
		
		if(subject != null){
			return subject.getPrincipal();
		}
		
		return null;
	}
	
}
