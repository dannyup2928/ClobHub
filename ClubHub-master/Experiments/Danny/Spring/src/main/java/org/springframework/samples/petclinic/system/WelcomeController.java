package org.springframework.samples.petclinic.system;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "<!DOCTYPE html>\r\n" + 
        		"<html>\r\n" + 
        		"<head>\r\n" + 
        		"<p style=\"color:red;font-size:50px;\">Welcome Page</p>\r\n" + 
        		"<style>\r\n" + 
        		"body {\r\n" + 
        		"  background-color: black;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"#earth {\r\n" + 
        		"  width: 100px;\r\n" + 
        		"	height: 100px;\r\n" + 
        		"	background: url(http://www.noirextreme.com/digital/Earth-Color4096.jpg);\r\n" + 
        		"	border-radius: 50%;\r\n" + 
        		"	background-size: 210px;\r\n" + 
        		"	box-shadow: inset 16px 0 40px 6px rgb(0, 0, 0),\r\n" + 
        		"		inset -3px 0 6px 2px rgba(255, 255, 255, 0.2);\r\n" + 
        		"	animation-name: rotate;\r\n" + 
        		"	animation-duration: 4s;\r\n" + 
        		"	animation-iteration-count: infinite;\r\n" + 
        		"	animation-timing-function: linear;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"@keyframes rotate {\r\n" + 
        		"  from { background-position-x: 0px; }\r\n" + 
        		"  to { background-position-x: 210px; }\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"</style>\r\n" + 
        		"</head>\r\n" + 
        		"<body>\r\n" + 
        		"<div id=\"earth\"></div>\r\n" + 
        		"\r\n" + 
        		"</body>\r\n" + 
        		"</html>";
    }
}
