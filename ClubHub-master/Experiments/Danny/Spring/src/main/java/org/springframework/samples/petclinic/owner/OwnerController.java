/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.owner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 * @ModifiedBy Tanmay Ghosh
 */
@RestController
class OwnerController {

	
    @Autowired
    OwnerRepository ownersRepository;

    private final Logger logger = LoggerFactory.getLogger(OwnerController.class);
    


//    @RequestMapping(method = RequestMethod.POST, path = "/owners/new")
//    public String saveOwner(Owners owner) {
//        ownersRepository.save(owner);
//        return "New Owner "+ owner.getFirstName() + " Saved";
//    }
//
//    @RequestMapping(method = RequestMethod.GET, path = "/owners")
//    public List<Owners> getAllOwners() {
//        logger.info("Entered into Controller Layer");
//        List<Owners> results = ownersRepository.findAll();
//        logger.info("Number of Records Fetched:" + results.size());
//        return results;
//    }
//
//    @RequestMapping(method = RequestMethod.GET, path = "/owners/{ownerId}")
//    public Optional<Owners> findOwnerById(@PathVariable("ownerId") int id) {
//        logger.info("Entered into Controller Layer");
//        Optional<Owners> results = ownersRepository.findById(id);
//        return results;
//    }
//    
//    
//    
//    
//    
    


    @GetMapping("/owners/change")
    public String createOrUpdateOwnerForm() {
        return "<html xmlns:th=\"http://www.thymeleaf.org\"\r\n" + 
        		"  th:replace=\"~{fragments/layout :: layout (~{::body},'owners')}\">\r\n" + 
        		"\r\n" + 
        		"<body>\r\n" + 
        		"\r\n" + 
        		"  <h2>Owner</h2>\r\n" + 
        		"  <form th:object=\"${owner}\" class=\"form-horizontal\" id=\"add-owner-form\" method=\"post\">\r\n" + 
        		"    <div class=\"form-group has-feedback\">\r\n" + 
        		"      <input\r\n" + 
        		"        th:replace=\"~{fragments/inputField :: input ('First Name', 'first_name')}\" />\r\n" + 
        		"      <input\r\n" + 
        		"        th:replace=\"~{fragments/inputField :: input ('Last Name', 'last_name')}\" />\r\n" + 
        		"      <input\r\n" + 
        		"        th:replace=\"~{fragments/inputField :: input ('Address', 'address')}\" />\r\n" + 
        		"      <input\r\n" + 
        		"        th:replace=\"~{fragments/inputField :: input ('Id', 'id')}\" />\r\n" + 
        		"      <input\r\n" + 
        		"        th:replace=\"~{fragments/inputField :: input ('Telephone', 'telephone')}\" />\r\n" + 
        		"    </div>\r\n" + 
        		"    <div class=\"form-group\">\r\n" + 
        		"      <div class=\"col-sm-offset-2 col-sm-10\">\r\n" + 
        		"        <button\r\n" + 
        		"          th:with=\"text=${owner['new']} ? 'Add Owner' : 'Update Owner'\"\r\n" + 
        		"          class=\"btn btn-default\" type=\"submit\" th:text=\"${text}\">Add\r\n" + 
        		"          Owner</button>\r\n" + 
        		"      </div>\r\n" + 
        		"    </div>\r\n" + 
        		"  </form>\r\n" + 
        		"</body>\r\n" + 
        		"</html>\r\n" + 
        		"";
    }
    
    
    @GetMapping("/owners/find")
    public String findOwners() {
        return "<html xmlns:th=\"http://www.thymeleaf.org\"\r\n" + 
        		"  th:replace=\"~{fragments/layout :: layout (~{::body},'owners')}\">\r\n" + 
        		"\r\n" + 
        		"<body>\r\n" + 
        		"\r\n" + 
        		"  <h2>Find Owners</h2>\r\n" + 
        		"\r\n" + 
        		"  <form th:object=\"${owner}\" th:action=\"@{/owners}\" method=\"get\"\r\n" + 
        		"    class=\"form-horizontal\" id=\"search-owner-form\">\r\n" + 
        		"    <div class=\"form-group\">\r\n" + 
        		"      <div class=\"control-group\" id=\"lastNameGroup\">\r\n" + 
        		"        <label class=\"col-sm-2 control-label\">Last name </label>\r\n" + 
        		"        <div class=\"col-sm-10\">\r\n" + 
        		"          <input class=\"form-control\" th:field=\"*{lastName}\" size=\"30\"\r\n" + 
        		"            maxlength=\"80\" /> <span class=\"help-inline\"><div\r\n" + 
        		"              th:if=\"${#fields.hasAnyErrors()}\">\r\n" + 
        		"              <p th:each=\"err : ${#fields.allErrors()}\" th:text=\"${err}\">Error</p>\r\n" + 
        		"            </div></span>\r\n" + 
        		"        </div>\r\n" + 
        		"      </div>\r\n" + 
        		"    </div>\r\n" + 
        		"    <div class=\"form-group\">\r\n" + 
        		"      <div class=\"col-sm-offset-2 col-sm-10\">\r\n" + 
        		"        <button type=\"submit\" class=\"btn btn-default\">Find\r\n" + 
        		"          Owner</button>\r\n" + 
        		"      </div>\r\n" + 
        		"    </div>\r\n" + 
        		"\r\n" + 
        		"  </form>\r\n" + 
        		"\r\n" + 
        		"  <br />\r\n" + 
        		"  <a class=\"btn btn-default\" th:href=\"@{/owners/new}\">Add Owner</a>\r\n" + 
        		"\r\n" + 
        		"</body>\r\n" + 
        		"</html>\r\n" + 
        		"";
    }
    
    @GetMapping("/owners/list")
    public String ownersList() {
        return " <!DOCTYPE html>\r\n" + 
        		"\r\n" + 
        		"<html xmlns:th=\"http://www.thymeleaf.org\" th:replace=\"~{fragments/layout :: layout (~{::body},'owners')}\">\r\n" + 
        		"\r\n" + 
        		"  <body>\r\n" + 
        		"\r\n" + 
        		"    <h2>Owners</h2>\r\n" + 
        		"\r\n" + 
        		"    <table id=\"vets\" class=\"table table-striped\">\r\n" + 
        		"        <thead>\r\n" + 
        		"        <tr>\r\n" + 
        		"            <th style=\"width: 150px;\">Name</th>\r\n" + 
        		"            <th style=\"width: 200px;\">Address</th>\r\n" + 
        		"            <th>City</th>\r\n" + 
        		"            <th style=\"width: 120px\">Telephone</th>\r\n" + 
        		"        </tr>\r\n" + 
        		"        </thead>\r\n" + 
        		"        <tbody>\r\n" + 
        		"          <tr th:each=\"owner : ${selections}\">\r\n" + 
        		"              <td>\r\n" + 
        		"                  <a th:href=\"@{/owners/__${owner.id}__}\" th:text=\"${owner.firstName + ' ' + owner.lastName}\"/></a>\r\n" + 
        		"              </td>\r\n" + 
        		"              <td th:text=\"${owner.address}\"/>\r\n" + 
        		"              <td th:text=\"${owner.city}\"/>\r\n" + 
        		"              <td th:text=\"${owner.telephone}\"/>\r\n" + 
        		"          </tr>\r\n" + 
        		"        </tbody>\r\n" + 
        		"    </table>\r\n" + 
        		"\r\n" + 
        		"  </body>\r\n" + 
        		"</html>\r\n" + 
        		"";
    }

    @GetMapping("/owners")
    public String googleOwners() {
        return "<html xmlns:th=\"http://www.thymeleaf.org\"\r\n" + 
        		"  th:replace=\"~{fragments/layout :: layout (~{::body},'owners')}\">\r\n" + 
        		"\r\n" + 
        		"<body>\r\n" + 
        		"\r\n" + 
        		"  <h2>Google and find your owners here</h2>\r\n" + 
        		"\r\n" + 
        		"    </div>\r\n" + 
        		"     <div style=\"border: 1px solid blue;\">\r\n" + 
        		"    Search here \r\n" + 
        		"    <form method=\"get\" action=\"http://www.google.com/search\">\r\n" + 
        		"\r\n" + 
        		"<div style=\"border:2px dotted black;padding:4px;width:15em;\">\r\n" + 
        		"<table border=\"0\" align=\"center\" cellpadding=\"0\">\r\n" + 
        		"<tr><td>\r\n" + 
        		"<input type=\"text\"   name=\"q\" size=\"25\" style=\"color:#808080;\"\r\n" + 
        		"maxlength=\"255\" value=\"Google site search\"\r\n" + 
        		"onfocus=\"if(this.value==this.defaultValue)this.value=''; this.style.color='black';\" onblur=\"if(this.value=='')this.value=this.defaultValue; \"/>\r\n" + 
        		"<input type=\"submit\" value=\"Go!\" />\r\n" + 
        		"<input type=\"hidden\" name=\"sitesearch\" value=\"yoursite.com\" /></td></tr>\r\n" + 
        		"</table>\r\n" + 
        		"</div>\r\n" + 
        		"\r\n" + 
        		"</form>" + 
        		"</div>" + 
        		"    </div>\r\n" + 
        		"\r\n" + 
        		"  </form>\r\n" + 
        		"\r\n" + 
        		"</body>\r\n" + 
        		"</html>\r\n" + 
        		"";
    }
    
    
    
}













