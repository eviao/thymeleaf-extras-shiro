package platform.thymeleaf.extras.shiro.auth;

public final class Authentication {

	public boolean guest() {
		return AuthUtils.getSubject() == null
				|| AuthUtils.getSubject().getPrincipal() == null;
	}
	
	public boolean user(){
		return AuthUtils.getSubject() != null
				&& AuthUtils.getSubject().getPrincipal() != null;
	}
	
	public boolean authenticated(){
		return AuthUtils.getSubject() != null
				&& AuthUtils.getSubject().isAuthenticated();
	}
	
	public boolean notAuthenticated(){
		return AuthUtils.getSubject() == null 
				|| !AuthUtils.getSubject().isAuthenticated();
	}
	
}
