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
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 * @ModifiedBy Tanmay Ghosh
 */
//@Controller
@RestController
class OwnerController {

	@Autowired
	private OwnerRepository ownersRepository;

	private final Logger logger = LoggerFactory.getLogger(OwnerController.class);

//	@GetMapping("/owners/new")
//	public String initCreationForm(Map<String, Object> model) {
//		logger.info("Entered into Controller Layer");
//		Owners owner = new Owners();
//		model.put("owner", owner);
//		return "owners/createOrUpdateOwnerForm";
//	}
//
//	@PostMapping("/owners/new")
//	public String processCreationForm(@Valid Owners owner, BindingResult result) {
//		if (result.hasErrors()) {
//			return "owners/createOrUpdateOwnerForm";
//		} else {
//			ownersRepository.save(owner);
//			return "redirect:/owners";
//		}
//	}
//
//    @GetMapping("/owners")
//    public String getAllOwners(Map<String, Object> model) {
//
//        logger.info("Entered into Controller Layer");
//        Collection<Owners> results = ownersRepository.findAll();
//        logger.info("Number of Records Fetched:" + results.size());
//        model.put("selections", results);
//        return "owners/ownersList";
//        
//    }
//
//	@GetMapping("/owners/{ownerId}")
//	public String findOwnerById(@PathVariable("ownerId") int id, Map<String, Object> model) {
//
//		logger.info("Entered into Controller Layer");
//		Collection<Owners> results = ownersRepository.findById(id);
//		logger.info("Number of Records Fetched:" + results.size());
//		model.put("selections", results);
//		return "owners/ownersList";
//	}
//
//	@GetMapping("/owners/find")
//	public String findOwner(Map<String, Object> model) {
//		model.put("owner", new Owners());
//		return "owners/findOwners";
//	}

	@GetMapping("/owners/new")
	public String initCreationForm(Map<String, Object> model) {
		logger.info("Entered into Controller Layer");
		Owners owner = new Owners();
		model.put("owner", owner);
		return "<html xmlns:th=\"http://www.thymeleaf.org\"\n"
				+ "	th:replace=\"~{fragments/layout :: layout (~{::body},'owners')}\">\n" + "\n" + "<body>\n" + "\n"
				+ "	<h2>Owner</h2>\n"
				+ "	<form th:object=\"${owner}\" class=\"form-horizontal\" id=\"add-owner-form\"\n"
				+ "		method=\"post\">\n" + "		<div class=\"form-group has-feedback\">\n" + "			<input\n"
				+ "				th:replace=\"~{fragments/inputField :: input ('First Name', 'firstName')}\" />\n"
				+ "			<input\n"
				+ "				th:replace=\"~{fragments/inputField :: input ('Last Name', 'lastName')}\" />\n"
				+ "			<input\n"
				+ "				th:replace=\"~{fragments/inputField :: input ('Address', 'address')}\" />\n"
				+ "			<input th:replace=\"~{fragments/inputField :: input ('City', 'city')}\" />\n"
				+ "			<input\n"
				+ "				th:replace=\"~{fragments/inputField :: input ('Telephone', 'telephone')}\" />\n"
				+ "		</div>\n" + "		<div class=\"form-group\">\n"
				+ "			<div class=\"col-sm-offset-2 col-sm-10\">\n" + "				<button\n"
				+ "					th:with=\"text=${owner['new']} ? 'Add Owner' : 'Update Owner'\"\n"
				+ "					class=\"btn btn-default\" type=\"submit\" th:text=\"${text}\">Add\n"
				+ "					Owner</button>\n" + "			</div>\n" + "		</div>\n" + "	</form>\n"
				+ "</body>\n" + "</html>";
	}

	@PostMapping("/owners/new")
	public String processCreationForm(@Valid Owners owner, BindingResult result) {
		if (result.hasErrors()) {
			return "<html xmlns:th=\"http://www.thymeleaf.org\"\n"
					+ "	th:replace=\"~{fragments/layout :: layout (~{::body},'owners')}\">\n" + "\n" + "<body>\n" + "\n"
					+ "	<h2>Owner</h2>\n"
					+ "	<form th:object=\"${owner}\" class=\"form-horizontal\" id=\"add-owner-form\"\n"
					+ "		method=\"post\">\n" + "		<div class=\"form-group has-feedback\">\n"
					+ "			<input\n"
					+ "				th:replace=\"~{fragments/inputField :: input ('First Name', 'firstName')}\" />\n"
					+ "			<input\n"
					+ "				th:replace=\"~{fragments/inputField :: input ('Last Name', 'lastName')}\" />\n"
					+ "			<input\n"
					+ "				th:replace=\"~{fragments/inputField :: input ('Address', 'address')}\" />\n"
					+ "			<input th:replace=\"~{fragments/inputField :: input ('City', 'city')}\" />\n"
					+ "			<input\n"
					+ "				th:replace=\"~{fragments/inputField :: input ('Telephone', 'telephone')}\" />\n"
					+ "		</div>\n" + "		<div class=\"form-group\">\n"
					+ "			<div class=\"col-sm-offset-2 col-sm-10\">\n" + "				<button\n"
					+ "					th:with=\"text=${owner['new']} ? 'Add Owner' : 'Update Owner'\"\n"
					+ "					class=\"btn btn-default\" type=\"submit\" th:text=\"${text}\">Add\n"
					+ "					Owner</button>\n" + "			</div>\n" + "		</div>\n" + "	</form>\n"
					+ "</body>\n" + "</html>";
		} else {
			ownersRepository.save(owner);
			return "redirect:/owners";
		}
	}

	@GetMapping("/owners")
	public String getAllOwners(Map<String, Object> model) {

		logger.info("Entered into Controller Layer");
		Collection<Owners> results = ownersRepository.findAll();
		logger.info("Number of Records Fetched:" + results.size());
		model.put("selections", results);
		return "<html xmlns:th=\"http://www.thymeleaf.org\" th:replace=\"~{fragments/layout :: layout (~{::body},'owners')}\">\n"
				+ "\n" + "  <body>\n" + "\n" + "    <h2>Owners</h2>\n" + "\n"
				+ "    <table id=\"vets\" class=\"table table-striped\">\n" + "        <thead>\n" + "        <tr>\n"
				+ "            <th style=\"width: 150px;\">Name</th>\n"
				+ "            <th style=\"width: 200px;\">Address</th>\n" + "            <th>City</th>\n"
				+ "            <th style=\"width: 120px\">Telephone</th>\n" + "        </tr>\n" + "        </thead>\n"
				+ "        <tbody>\n" + "          <tr th:each=\"owner : ${selections}\">\n" + "              <td>\n"
				+ "                  <a th:href=\"@{/owners/__${owner.id}__}\" th:text=\"${owner.firstName + ' ' + owner.lastName}\"/></a>\n"
				+ "              </td>\n" + "              <td th:text=\"${owner.address}\"/>\n"
				+ "              <td th:text=\"${owner.city}\"/>\n"
				+ "              <td th:text=\"${owner.telephone}\"/>\n" + "          </tr>\n" + "        </tbody>\n"
				+ "    </table>\n" + "\n" + "  </body>\n" + "</html>";

	}

	@GetMapping("/owners/{ownerId}")
	public String findOwnerById(@PathVariable("ownerId") int id, Map<String, Object> model) {

		logger.info("Entered into Controller Layer");
		Collection<Owners> results = ownersRepository.findById(id);
		logger.info("Number of Records Fetched:" + results.size());
		model.put("selections", results);
		return "<html xmlns:th=\"http://www.thymeleaf.org\" th:replace=\"~{fragments/layout :: layout (~{::body},'owners')}\">\n"
				+ "\n" + "  <body>\n" + "\n" + "    <h2>Owners</h2>\n" + "\n"
				+ "    <table id=\"vets\" class=\"table table-striped\">\n" + "        <thead>\n" + "        <tr>\n"
				+ "            <th style=\"width: 150px;\">Name</th>\n"
				+ "            <th style=\"width: 200px;\">Address</th>\n" + "            <th>City</th>\n"
				+ "            <th style=\"width: 120px\">Telephone</th>\n" + "        </tr>\n" + "        </thead>\n"
				+ "        <tbody>\n" + "          <tr th:each=\"owner : ${selections}\">\n" + "              <td>\n"
				+ "                  <a th:href=\"@{/owners/__${owner.id}__}\" th:text=\"${owner.firstName + ' ' + owner.lastName}\"/></a>\n"
				+ "              </td>\n" + "              <td th:text=\"${owner.address}\"/>\n"
				+ "              <td th:text=\"${owner.city}\"/>\n"
				+ "              <td th:text=\"${owner.telephone}\"/>\n" + "          </tr>\n" + "        </tbody>\n"
				+ "    </table>\n" + "\n" + "  </body>\n" + "</html>";
	}

	@GetMapping("/owners/find")
	public String findOwner(Map<String, Object> model) {
		model.put("owner", new Owners());
		return "<html xmlns:th=\"http://www.thymeleaf.org\"\n"
				+ "  th:replace=\"~{fragments/layout :: layout (~{::body},'owners')}\">\n" + "\n" + "<body>\n" + "\n"
				+ "  <h2>Find Owners</h2>\n" + "\n"
				+ "  <form th:object=\"${owner}\" th:action=\"@{/owners}\" method=\"get\"\n"
				+ "    class=\"form-horizontal\" id=\"search-owner-form\">\n" + "    <div class=\"form-group\">\n"
				+ "      <div class=\"control-group\" id=\"lastNameGroup\">\n"
				+ "        <label class=\"col-sm-2 control-label\">Last name </label>\n"
				+ "        <div class=\"col-sm-10\">\n"
				+ "          <input class=\"form-control\" th:field=\"*{lastName}\" size=\"30\"\n"
				+ "            maxlength=\"80\" /> <span class=\"help-inline\"><div\n"
				+ "              th:if=\"${#fields.hasAnyErrors()}\">\n"
				+ "              <p th:each=\"err : ${#fields.allErrors()}\" th:text=\"${err}\">Error</p>\n"
				+ "            </div></span>\n" + "        </div>\n" + "      </div>\n" + "    </div>\n"
				+ "    <div class=\"form-group\">\n" + "      <div class=\"col-sm-offset-2 col-sm-10\">\n"
				+ "        <button type=\"submit\" class=\"btn btn-default\">Find\n" + "          Owner</button>\n"
				+ "      </div>\n" + "    </div>\n" + "\n" + "  </form>\n" + "\n" + "  <br />\n"
				+ "  <a class=\"btn btn-default\" th:href=\"@{/owners/new}\">Add Owner</a>\n" + "\n" + "</body>\n"
				+ "</html>";
	}

}
