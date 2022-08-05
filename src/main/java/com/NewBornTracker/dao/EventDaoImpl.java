package com.NewBornTracker.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.NewBornTracker.model.Event;
import com.NewBornTracker.model.User;
import com.NewBornTracker.model.abstracts.EventType;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Repository
@Transactional
public class EventDaoImpl implements EventDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UserDao userDao;

	@Override
	public Event findById(Long id) {

		String hql = "FROM Event e WHERE e.Id = :id";
		Query<?> q = sessionFactory.openSession().createQuery(hql);
		q.setParameter("id", id);

		return (Event) q.uniqueResult();
	}
	
	@Override
	public EventType findEventTypeById(Long id) {

		String hql = "FROM EventType et WHERE et.Id = :id";
		Query<?> q = sessionFactory.openSession().createQuery(hql);
		q.setParameter("id", id);
		
		return (EventType) q.uniqueResult();
	}


	@Override
	public void delete(Long id) {
		Event e = findById(id);
		sessionFactory.getCurrentSession().delete(e);
	}

	@Override
	public List<Event> findAllEvents() {
		
		CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<Event> cq = cb.createQuery(Event.class);
		Root<Event> r = cq.from(Event.class);
		cq.select(r);
		Query<Event> q = sessionFactory.getCurrentSession().createQuery(cq);
		return q.getResultList();

	}

	@Override
	public EventType saveEventType(EventType type) {
		sessionFactory.getCurrentSession().save(type);
		EventType et = sessionFactory.getCurrentSession().get(EventType.class, type.getId());
		if (et != null) {
			return et;
		}
		return null;
		
	}

	@Override
	public void save(long id, Event event, EventType et) {
		User u = userDao.findById(id);
		event.setUserId(u);
		event.setType(et);
		sessionFactory.getCurrentSession().save(event);
	}

	@Override
	public void update(Event event) {
		sessionFactory.getCurrentSession().update(event);
	}

	@Override
	public void updateEventType(EventType et) {
		sessionFactory.getCurrentSession().update(et);
	}
}
