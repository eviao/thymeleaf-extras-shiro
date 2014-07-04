package platform.thymeleaf.extras.shiro.dialect;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.IContext;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.spring4.dialect.SpringStandardDialect;

import platform.thymeleaf.extras.shiro.auth.Authentication;
import platform.thymeleaf.extras.shiro.auth.Authorization;
import platform.thymeleaf.extras.shiro.auth.Principal;

public class ShiroDialect extends SpringStandardDialect implements
		IExpressionEnhancingDialect {

	public static final String DEFAULT_PREFIX = "sec";

	private static final String AUTHENTICATION_EXPRESSION_OBJECT_NAME = "authc";
	private static final String AUTHORIZATION_EXPRESSION_OBJECT_NAME = "authz";
	private static final String PRINCIPAL_EXPRESSION_OBJECT_NAME = "principal";

	public ShiroDialect() {
		super();
	}

	public String getPrefix() {
		return DEFAULT_PREFIX;
	}

	public boolean isLenient() {
		return false;
	}

	@Override
	public Set<IProcessor> getProcessors() {
		final Set<IProcessor> processors = new LinkedHashSet<IProcessor>();
		return processors;
	}

	public Map<String, Object> getAdditionalExpressionObjects(
			IProcessingContext processingContext) {

		final IContext context = processingContext.getContext();
		final IWebContext webContext = (context instanceof IWebContext ? (IWebContext) context
				: null);

		final Map<String, Object> objects = new HashMap<String, Object>(3, 1.0f);

		/*
		 * Create the #authentication and #authorization expression objects
		 */
		if (webContext != null) {

			final HttpServletRequest request = webContext
					.getHttpServletRequest();
			final HttpServletResponse response = webContext
					.getHttpServletResponse();
			final ServletContext servletContext = webContext
					.getServletContext();

			if (request != null && response != null && servletContext != null) {
				objects.put(AUTHENTICATION_EXPRESSION_OBJECT_NAME,
						new Authentication());
				objects.put(AUTHORIZATION_EXPRESSION_OBJECT_NAME,
						new Authorization());
				objects.put(PRINCIPAL_EXPRESSION_OBJECT_NAME, new Principal());
			}

		}

		return objects;
	}
}