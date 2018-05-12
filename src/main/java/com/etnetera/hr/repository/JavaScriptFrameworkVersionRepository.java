package com.etnetera.hr.repository;

import org.springframework.data.repository.CrudRepository;

import com.etnetera.hr.data.JavaScriptFrameworkVersion;
import com.etnetera.hr.data.VersionId;

/**
 * Spring data repository interface used for accessing the data in database.
 * 
 * @author Etnetera
 *
 */
public interface JavaScriptFrameworkVersionRepository extends CrudRepository<JavaScriptFrameworkVersion, VersionId> {

}
