package com.etnetera.hr;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.data.JavaScriptFrameworkVersion;
import com.etnetera.hr.data.VersionId;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import com.etnetera.hr.repository.JavaScriptFrameworkVersionRepository;

/**
 * Class used for Spring Boot/MVC based tests.
 * 
 * @author Etnetera
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JavaScriptFrameworkTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private JavaScriptFrameworkRepository frameworkRepository;

	@Autowired
	private JavaScriptFrameworkVersionRepository versionRepository;

	@Before
	public void initializeData() throws Exception {
		// JavaScriptFrameworkVersion v1 = new JavaScriptFrameworkVersion(new VersionId(1, 0, 1), "Release notes example 1");
		// JavaScriptFrameworkVersion v2 = new JavaScriptFrameworkVersion(new VersionId(1, 0, 2), "Release notes example 2");
		// versionRepository.save(v1);
		// versionRepository.save(v2);
		//
		// List<JavaScriptFrameworkVersion> versions = new ArrayList<>();
		// versions.add(v1);
		// versions.add(v2);
		//
		// JavaScriptFramework jsf = new JavaScriptFramework("ReactJS");
		// jsf.setVersions(versions);
		// frameworkRepository.save(jsf);
	}

	// @Test
	public void findAllTest() throws Exception {
		mockMvc.perform(get("/findAll")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].id", is(1))).andExpect(jsonPath("$[0].name", is("ReactJS")))
				.andExpect(jsonPath("$[0].versions", hasSize(2))).andExpect(jsonPath("$[0].versions[0].id.major", is(1)))
				.andExpect(jsonPath("$[0].versions[0].id.minor", is(0))).andExpect(jsonPath("$[0].versions[0].id.bugfix", is(1)))
				.andExpect(jsonPath("$[0].versions[1].id.major", is(1))).andExpect(jsonPath("$[0].versions[1].id.minor", is(0)))
				.andExpect(jsonPath("$[0].versions[1].id.bugfix", is(2)));
	}

	@Test
	public void createTest() throws Exception {
		JavaScriptFrameworkVersion v1 = new JavaScriptFrameworkVersion(new VersionId(1, 0, 1), "Release notes example 1");
		JavaScriptFrameworkVersion v2 = new JavaScriptFrameworkVersion(new VersionId(1, 0, 2), "Release notes example 2");
		List<JavaScriptFrameworkVersion> versions = new ArrayList<>();
		versions.add(v1);
		versions.add(v2);
		JavaScriptFramework jsf = new JavaScriptFramework("ReactJS2");
		jsf.setVersions(versions);

		mockMvc.perform(post("/create", jsf).content(jsf.toString())).andExpect(status().isOk());
	}

}
