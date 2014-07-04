package platform.thymeleaf.extras.shiro.auth;

public final class Authentication {

	public boolean isGuest() {
		return AuthUtils.getSubject() == null
				|| AuthUtils.getSubject().getPrincipal() == null;
	}
	
	public boolean isUser(){
		return AuthUtils.getSubject() != null
				&& AuthUtils.getSubject().getPrincipal() != null;
	}
	
	public boolean isAuthenticated(){
		return AuthUtils.getSubject() != null
				&& AuthUtils.getSubject().isAuthenticated();
	}
	
	public boolean isNotAuthenticated(){
		return AuthUtils.getSubject() == null 
				|| !AuthUtils.getSubject().isAuthenticated();
	}
	
}
