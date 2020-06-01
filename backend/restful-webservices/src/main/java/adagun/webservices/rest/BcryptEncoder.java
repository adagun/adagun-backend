package adagun.webservices.rest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


class BcryptEncoder
{
    public static void main(String[] args)
    {
        String password = "";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        System.out.println(encodedPassword);
    }
}
