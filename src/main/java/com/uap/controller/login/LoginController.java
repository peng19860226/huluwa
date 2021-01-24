package com.uap.controller.login;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uap.controller.authentication.MyAuthentication;
import com.uap.controller.authentication.MyAuthenticationToken;

@RestController
public class LoginController {

	@Autowired
	private LoginSuccessHandler loginSuccessHandler;

	@Resource(name = "gitHubAuthentication")
	private MyAuthentication gitHubAuthentication;

	@Resource(name = "qQAuthentication")
	private MyAuthentication qQAuthentication;
	@Autowired
	private AuthorizationServerTokenServices authorizationServerTokenServices;

	@Autowired
	private ConsumerTokenServices consumerTokenServices;
	@PostMapping("/authentication/github")
	public OAuth2AccessToken loginForGithHub(HttpServletRequest request, HttpServletResponse response, @RequestParam("code") String code)
			throws IOException {

		return login(request,response,code,gitHubAuthentication);
	}

	@PostMapping("/authentication/qq")
	public OAuth2AccessToken loginForQQ(HttpServletRequest request, HttpServletResponse response, @RequestParam("code") String code)
			throws IOException {

		return login(request,response,code,qQAuthentication);
	}
	@RequestMapping("/exit")
	public String logOut(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		auth.getPrincipal()
		//		OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
	    OAuth2AccessToken accessToken = authorizationServerTokenServices.getAccessToken((OAuth2Authentication) auth);

	    consumerTokenServices.revokeToken(accessToken.getValue());
	    
		return "redirect:/login?logout";
		//You can redirect wherever you want, but generally it's a good practice to show login screen again.
		//return login(request,response,code,qQAuthentication);
	}
	public OAuth2AccessToken login(HttpServletRequest request, HttpServletResponse response,String code,MyAuthentication myAuthentication) throws IOException {
		if (code == null) {
			code = "";
		}

		code = code.trim();

		String id = myAuthentication.getUserId(code);

		MyAuthenticationToken authRequest = new MyAuthenticationToken(id);

		authRequest.setDetails(new OAuth2AuthenticationDetails(request));

		return loginSuccessHandler.getAccessToken(request, response, authRequest);
	}

}
