//package com.uade.ejb.hibernate;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
//
//import com.uade.ejb.entities.EstablishmentEntity;
////import com.uade.ejb.entities.HotelEntity;
////import com.uade.ejb.entities.OfferEntity;
////import com.uade.ejb.entities.OfferServiceEntity;
////import com.uade.ejb.entities.ServiceTypeEntity;
//
//public class HibernateUtil {
//	private static final SessionFactory sessionFactory;
//	static {
//		try {
//			AnnotationConfiguration config = new AnnotationConfiguration();
//			
//			config.addAnnotatedClass(EstablishmentEntity.class);
////			config.addAnnotatedClass(HotelEntity.class);
////			config.addAnnotatedClass(OfferEntity.class);
////			config.addAnnotatedClass(OfferServiceEntity.class);
////			config.addAnnotatedClass(ServiceTypeEntity.class);
//
//			sessionFactory = config.buildSessionFactory();
//		} catch (Throwable ex) {
//			System.err.println("Initial SessionFactory creation failed." + ex);
//			throw new ExceptionInInitializerError(ex);
//		}
//	}
//
//	public static final SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//}
