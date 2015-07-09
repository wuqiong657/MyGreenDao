package com.lwq.generator;

import java.util.List;
import com.lwq.generator.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table PERSON.
 */
public class Person {

    private Long id;
    private String name;
    private Integer age;
    private Boolean isGraduated;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient PersonDao myDao;

    private List<Lease> leaseList;

    public Person() {
    }

    public Person(Long id) {
        this.id = id;
    }

    public Person(Long id, String name, Integer age, Boolean isGraduated) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isGraduated = isGraduated;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPersonDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIsGraduated() {
        return isGraduated;
    }

    public void setIsGraduated(Boolean isGraduated) {
        this.isGraduated = isGraduated;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Lease> getLeaseList() {
        if (leaseList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LeaseDao targetDao = daoSession.getLeaseDao();
            List<Lease> leaseListNew = targetDao._queryPerson_LeaseList(id);
            synchronized (this) {
                if(leaseList == null) {
                    leaseList = leaseListNew;
                }
            }
        }
        return leaseList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetLeaseList() {
        leaseList = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
