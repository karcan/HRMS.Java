package com.hrms.karcan.core.dataAccess.concretes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.Assert;

import com.hrms.karcan.core.dataAccess.abstracts.BaseRepository;
import com.hrms.karcan.core.utilities.constants.RepositoryMessages;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorDataResult;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements BaseRepository<T, ID> {

	private final EntityManager em;
	private final JpaEntityInformation<T, ID> entityInformation;

	public BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
		this.em = entityManager;
	}

	@Transactional
	@Override
	public <S extends T> DataResult<S> insert(S entity) {
		Assert.notNull(entity, RepositoryMessages.ENTITY_MUST_NOT_BE_NULL);
		
		if (entityInformation.isNew(entity)) {
			em.persist(entity);
			return new SuccessDataResult<S>(RepositoryMessages.ENTITY_IS_SUCCESSFULLY_INSERTED, entity);
		}
		
		return new ErrorDataResult<S>(RepositoryMessages.ENTITY_HAS_ALREADY_BEEN_INSERTED, entity);
		
	}

	@Transactional
	@Override
	public <S extends T> DataResult<S> update(S entity) {
		Assert.notNull(entity, RepositoryMessages.ENTITY_MUST_NOT_BE_NULL);
		
		if (!entityInformation.isNew(entity)) {
			em.merge(entity);
			return new SuccessDataResult<S>(RepositoryMessages.ENTITY_IS_SUCCESSFULLY_UPDATED, entity);
		}
		
		return new ErrorDataResult<S>(RepositoryMessages.ENTITY_NOT_FOUND, entity);
	}
	
	@Transactional
	@Override
	public <S extends T> List<S> insertAll(Iterable<S> entities) {
		Assert.notNull(entities, RepositoryMessages.ENTITIES_MUST_NOT_BE_NULL);
		List<S> result = new ArrayList<S>();
		
		for (S entity : entities) {
			result.add(insert(entity).getData());
		}

		return result;
	}
	
	@Transactional
	@Override
	public <S extends T> List<S> updateAll(Iterable<S> entities) {
		Assert.notNull(entities, RepositoryMessages.ENTITIES_MUST_NOT_BE_NULL);
		List<S> result = new ArrayList<S>();
		
		for (S entity : entities) {
			result.add(update(entity).getData());
		}

		return result;
	}

}
