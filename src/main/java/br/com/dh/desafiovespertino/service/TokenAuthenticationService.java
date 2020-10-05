package br.com.dh.desafiovespertino.service;

public class TokenAuthenticationService {
	static final long EXPIRATION_TIME = 36000000;
	static final String SECRET = "sorvete_de_limao";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_PREFIX = "Authorization";
}
