package platform.thymeleaf.extras.shiro.auth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public final class AuthUtils {
	
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}
	
}
