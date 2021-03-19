package org.springframework.samples.petclinic.system;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "<html xmlns:th=\"http://www.thymeleaf.org\"\n" + 
        		"	th:replace=\"~{fragments/layout :: layout (~{::body},'home')}\">\n" + 
        		"\n" + 
        		"<body>\n" + 
        		"\n" + 
        		"	<h2 th:text=\"#{welcome}\">Welcome</h2>\n" + 
        		"	<div class=\"row\">\n" + 
        		"		<div class=\"col-md-12\">\n" + 
        		"			<img class=\"img-responsive\" src=\"../static/resources/images/pets.png\"\n" + 
        		"				th:src=\"@{/resources/images/pets.png}\" />\n" + 
        		"		</div>\n" + 
        		"	</div>\n" + 
        		"\n" + 
        		"</body>\n" + 
        		"\n" + 
        		"</html>\n" + 
        		"";
    }
}
