package com.hrms.karcan.core.dataAccess.abstracts;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.hrms.karcan.core.utilities.result.DataResult;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
	<S extends T> DataResult<S> insert(S entity);
	<S extends T> DataResult<S> update(S entity);
	<S extends T> List<S> insertAll(Iterable<S> entities);
	<S extends T> List<S> updateAll(Iterable<S> entities);
}
