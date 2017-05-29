package com.audit.app;

import org.springframework.stereotype.Controller;

/**
 * Created by Infocepts India in 2017.
 */
@Controller
public class StartPage
{
    public String index ()
    {
        return "index";
    }
}
