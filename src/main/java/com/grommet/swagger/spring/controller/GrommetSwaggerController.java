package com.grommet.swagger.spring.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GrommetSwaggerController {
	
	private static final String V3_API_DOCS = "/v3/api-docs";
	private static final String GROMMET_SWAGGER_OPEN_API_URL_PATH = "grommet-swagger.open-api-url-path";
	private static final String GROMMET_SWAGGER = "grommet-swagger";
	private static final String GROMMET_SWAGGER_THEME = "grommet-swagger.theme";
	private static final String GROMMET_SWAGGER_ROUTE_PREFIX = "grommet-swagger.route-prefix";
	private static final String GROMMET_SWAGGER_APP_URL = "grommet-swagger.app-url";
	
	@Autowired
	Environment environment;
	
	@GetMapping("/grommet-swagger")
	public String grommetSwagger(HttpServletRequest request) throws UnknownHostException {
		String contextPath = request.getContextPath();
		String baseUrl = environment.getProperty(GROMMET_SWAGGER_APP_URL,"");
		if("".equals(baseUrl)) {
			baseUrl = request.getScheme()+"://"+InetAddress.getLocalHost().getHostName()+":"
	                +request.getServerPort();
		}
        String appUrl = baseUrl+contextPath;
        String theme = environment.getProperty(GROMMET_SWAGGER_THEME,"");
		String routePrefix = environment.getProperty(GROMMET_SWAGGER_ROUTE_PREFIX,"");
		if("".equals(routePrefix)) {
			routePrefix = GROMMET_SWAGGER;
		}
		routePrefix = contextPath + routePrefix;
		String openApiDocPath = environment.getProperty(GROMMET_SWAGGER_OPEN_API_URL_PATH,"");
		if("".equals(openApiDocPath)) {
			openApiDocPath = V3_API_DOCS;
		}
        String openApiDocPathUrl = appUrl+openApiDocPath;
		return "redirect:"+appUrl+"/grommet-swagger.html?url="+openApiDocPathUrl+"&theme="+theme+"&routePrefix="+routePrefix;
	}
}
