package platform.thymeleaf.extras.shiro.auth;

import org.apache.shiro.subject.Subject;

public final class Authorization {
	
	private static final String AUTH_NAMES_DELIMETER = ",";
	
	public boolean hasRole(String roleName) {
		return AuthUtils.getSubject() != null
				&& AuthUtils.getSubject().hasRole(roleName);
	}
	
	public boolean hasAnyRoles(String roleNames){
		boolean hasAnyRole = false;
        Subject subject = AuthUtils.getSubject();

        if (subject != null) {
            for (String role : roleNames.split(AUTH_NAMES_DELIMETER)) {
                if (subject.hasRole(role.trim())) {
                    hasAnyRole = true;
                    break;
                }
            }
        }
        return hasAnyRole;
	}
	
	public boolean lacksRole(String roleName){
		boolean hasRole = AuthUtils.getSubject() != null && AuthUtils.getSubject().hasRole(roleName);
        return !hasRole;
	}
	
	private boolean isPermitted(String perm) {
		return AuthUtils.getSubject() != null
				&& AuthUtils.getSubject().isPermitted(perm);
    }
	
	public boolean hasPermission(String perm){
		return isPermitted(perm);
	}
	
	public boolean hasAnyPermissions(String permNames){
		boolean hasAnyPermission = false;
        Subject subject = AuthUtils.getSubject();

        if (subject != null) {
            for (String perm : permNames.split(AUTH_NAMES_DELIMETER)) {
                if (subject.isPermitted(perm.trim())) {
                	hasAnyPermission = true;
                    break;
                }
            }
        }
        return hasAnyPermission;
	}
	
	public boolean lacksPermission(String perm){
		return !isPermitted(perm);
	}
}
