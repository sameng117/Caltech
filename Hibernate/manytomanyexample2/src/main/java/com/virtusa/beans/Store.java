package com.virtusa.beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Store {
	public static void main(String[] args) {
		
		//Add Readers
		List<ReaderEntity> rlist=new ArrayList<ReaderEntity>();
		
		ReaderEntity readerone=new ReaderEntity();
		readerone.setReaderName("Kanika");
			
		ReaderEntity readertwo=new ReaderEntity();
		readertwo.setReaderName("Monika");
		
		rlist.add(readerone);
		rlist.add(readertwo);
		
		
		//Add Subscriptions
		List<SubscriptionEntity> slist=new ArrayList<SubscriptionEntity>();
	    
		SubscriptionEntity sone=new SubscriptionEntity();
	     sone.setSubsname("primevideo");
	    
	     SubscriptionEntity stwo=new SubscriptionEntity();
	     stwo.setSubsname("hotstar");
	     
	     slist.add(sone);
	     slist.add(stwo);
	     
	     readerone.setSubscriptions(slist);
	     readertwo.setSubscriptions(slist);
	   
	     // sone.setReaders(rlist);
	     //stwo.setReaders(rlist);
	     
	    SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(readerone);
		session.save(readertwo);
		
		session.getTransaction().commit();
	}

}
