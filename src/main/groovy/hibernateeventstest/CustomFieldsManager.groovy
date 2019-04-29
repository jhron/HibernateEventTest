package hibernateeventstest

import org.grails.orm.hibernate.cfg.GrailsHibernateUtil

class CustomFieldsManager {

    public static void saveFields(domain, Class klass, Boolean created) {
        if (null == klass) {
            klass = GrailsHibernateUtil.unwrapIfProxy(domain).class
        }
        String klassName = klass.name
        def currValues = domain.customFields
        //saving custom fields based on its definition.. here just hardcoded example
        if ( currValues.age ) {
            def pcf = new PersonCustomFields(long: currValues.age)
            pcf.owner = domain
            pcf.save()
        }
    }

    public static void loadFields(domain, Class klass) {
        if (null == domain.id) { // unsaved domain instance => nothing to load
            return
        }
        if (null == klass) {
            klass = GrailsHibernateUtil.unwrapIfProxy(domain).class
        }
        // fill transient customFields....
    }
}
