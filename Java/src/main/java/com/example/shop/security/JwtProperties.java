package com.example.shop.security;

public class JwtProperties {
    public static final String SECRET = "SzymonLipiec123";
    public static final int EXPIRATION_TIME = 86400000; //10 days
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
}
