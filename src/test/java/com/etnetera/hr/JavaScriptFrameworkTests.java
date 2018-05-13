package com.etnetera.hr;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.data.Version;
import com.etnetera.hr.data.VersionId;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import com.etnetera.hr.repository.JavaScriptFrameworkVersionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    //@Before
	public void initializeData() throws Exception {
        // Version v1 = new Version(new VersionId(1, 0, 1), "Release notes example 1");
        // Version v2 = new Version(new VersionId(1, 0, 2), "Release notes example 2");
		// versionRepository.save(v1);
		// versionRepository.save(v2);
		//
        // List<Version> versions = new ArrayList<>();
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
        JavaScriptFramework jsf = new JavaScriptFramework("ReactJSxxxxxxx");

        Version v1 = new Version(new VersionId(1, 0, 1));
        v1.setFramework(jsf);
        v1.setCodeName("shit");
        Version v2 = new Version(new VersionId(1, 0, 2));
        v2.setFramework(jsf);
        v2.setCodeName("crap");
        List<Version> versions = new ArrayList<>();
		versions.add(v1);
		versions.add(v2);
		jsf.setVersions(versions);

        String json = new ObjectMapper().writeValueAsString(jsf);

        mockMvc.perform(post("/create").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());
	}

}
