// Place your Spring DSL code here
beans = {
    pm4wHibernateEventListener(hibernateeventstest.DefaultHibernateEventListener){
    }

    hibernateEventListeners(org.grails.orm.hibernate.HibernateEventListeners) {
        listenerMap = [
                'save-update': ref('pm4wHibernateEventListener'),
                'post-update': ref('pm4wHibernateEventListener'),
        ]
    }
}
