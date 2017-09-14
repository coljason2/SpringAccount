package com.web.config;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	/**
	 * 必須在security 之前配置编码
	 */
	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		// encoding
		Dynamic characterEncodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding", "true");
		characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");

		// sitemesh
		insertFilters(servletContext, new SiteMeshFilter());
	}

}
